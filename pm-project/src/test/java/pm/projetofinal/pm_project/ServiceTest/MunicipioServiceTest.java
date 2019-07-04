package pm.projetofinal.pm_project.ServiceTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pm.projetofinal.pm_project.Model.BoundingBox;
import pm.projetofinal.pm_project.Model.Municipio;
import pm.projetofinal.pm_project.Model.MunicipioData;
import pm.projetofinal.pm_project.Service.DomService;
import pm.projetofinal.pm_project.Service.MunicipioService;
import pm.projetofinal.pm_project.Service.OverpassService;

public class MunicipioServiceTest
{

	public boolean elementExistsOnList( final String element, final ArrayList<String> list )
	{
		boolean exists = false;
		for ( final String elementOfList : list )
		{
			if ( elementOfList.equals( element ) )
			{
				exists = true;
				return exists;
			}
		}
		return exists;
	}

	@Before
	public void setUp()
	{
		this.municipioService = Mockito.spy( new MunicipioService() );
	}

	@Test
	public void testGetMunicipio()
		throws Exception
	{

		PowerMockito.whenNew( MunicipioService.class ).withNoArguments().thenReturn( this.municipioService );
		final NodeList nodeList = this.domService.getNodeListFromFile( this.xmlFile, this.MUNICIPIO_KML_TAG );
		final Municipio output = this.municipioService.getMunicipioFromNodeList(
			nodeList,
			this.MUNICIPIO_CODIGO,
			this.isCode );
		final Node node = nodeList.item( 10 );
		verify( this.municipioService, times( 1 ) ).getMunicipio( node );
	}

	@Test
	public void testGetMunicipioDataFromDocument()
		throws ParserConfigurationException,
			SAXException,
			IOException
	{
		final NodeList nodeList = this.domService.getNodeListFromFile( this.xmlFile, this.MUNICIPIO_KML_TAG );
		final Municipio municipio = this.municipioService.getMunicipioFromNodeList(
			nodeList,
			this.MUNICIPIO_CODIGO,
			this.isCode );

		final BoundingBox boundingBox = municipio.getBoundingBox();
		final Document overPassResponse = this.overpassService.getOverpassDocument( boundingBox );
		final MunicipioData municipioData = this.municipioService.getMunicipioDataFromDocument( overPassResponse );

		final boolean isInstanceOfMunicipioData = municipioData instanceof MunicipioData;
		final boolean resultadoEsperado = true;
		Assert.assertEquals( resultadoEsperado, isInstanceOfMunicipioData );
	}

	@Test
	public void testGetMunicipioDataFromDocumentFalseData()
		throws ParserConfigurationException,
			SAXException,
			IOException
	{
		final NodeList nodeList = this.domService.getNodeListFromFile( this.xmlFile, this.MUNICIPIO_KML_TAG );
		final Municipio municipio = this.municipioService.getMunicipioFromNodeList(
			nodeList,
			this.MUNICIPIO_CODIGO,
			this.isCode );

		final BoundingBox boundingBox = municipio.getBoundingBox();
		final Document overPassResponse = this.overpassService.getOverpassDocument( boundingBox );
		final MunicipioData municipioData = this.municipioService.getMunicipioDataFromDocument( overPassResponse );

		final ArrayList<String> portos = municipioData.aeroways;
		final boolean containsPortoSantos = portos.contains( "Aeroporto Internacional Tom Jobim" );
		final boolean resultadoEsperado = false;
		Assert.assertEquals( resultadoEsperado, containsPortoSantos );
	}

	@Test
	public void testGetMunicipioDataFromDocumentTrueData()
		throws ParserConfigurationException,
			SAXException,
			IOException
	{
		final NodeList nodeList = this.domService.getNodeListFromFile( this.xmlFile, this.MUNICIPIO_KML_TAG );
		final Municipio municipio = this.municipioService.getMunicipioFromNodeList(
			nodeList,
			this.MUNICIPIO_CODIGO,
			this.isCode );

		final BoundingBox boundingBox = municipio.getBoundingBox();
		final Document overPassResponse = this.overpassService.getOverpassDocument( boundingBox );
		final MunicipioData municipioData = this.municipioService.getMunicipioDataFromDocument( overPassResponse );

		final ArrayList<String> portos = municipioData.ports;
		final ArrayList<String> aeroportos = municipioData.aeroways;
		final ArrayList<String> rodovias = municipioData.highways;

		final boolean containsPorto = elementExistsOnList( "porto", portos );
		final boolean containsAeroporto = elementExistsOnList( "aeroporto", aeroportos );
		final boolean containsRodovia = elementExistsOnList( "rodovia", rodovias );

		final boolean resultadoEsperado = true;
		Assert.assertEquals( resultadoEsperado, containsPorto );
		Assert.assertEquals( resultadoEsperado, containsAeroporto );
		Assert.assertEquals( resultadoEsperado, containsRodovia );
	}

	@Test
	public void testGetMunicipioFromNodeListExists()
		throws ParserConfigurationException,
			SAXException,
			IOException
	{
		final NodeList nodeList = this.domService.getNodeListFromFile( this.xmlFile, this.MUNICIPIO_KML_TAG );
		final Municipio output = this.municipioService.getMunicipioFromNodeList(
			nodeList,
			this.MUNICIPIO_CODIGO,
			this.isCode );

		final boolean isInstanceOfMunicipio = output instanceof Municipio;
		final boolean resultadoEsperado = true;
		Assert.assertEquals( resultadoEsperado, isInstanceOfMunicipio );
	}

	DomService domService = new DomService();

	final String filePath = String.format( "src\\kml\\RJ.kml" );

	final boolean isCode = true;

	final String MUNICIPIO_CODIGO = "3300605";

	final String MUNICIPIO_KML_TAG = "Placemark";

	@Mock
	MunicipioService municipioService;

	OverpassService overpassService = new OverpassService();

	final File xmlFile = new File( this.filePath );
}
