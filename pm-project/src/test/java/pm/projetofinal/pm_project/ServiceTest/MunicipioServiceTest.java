package pm.projetofinal.pm_project.ServiceTest;

import static org.mockito.Mockito.*;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;



public class MunicipioServiceTest {

	OverpassService overpassService = new OverpassService();
	DomService domService = new DomService();
	
	@Mock
	MunicipioService municipioService;
	
	final String MUNICIPIO_CODIGO = "3300605";
	final boolean isCode = true;
	final String MUNICIPIO_KML_TAG = "Placemark";
	final String filePath = String.format( "src\\kml\\RJ.kml");
	final File xmlFile = new File(filePath);
	
	@Before
	public void setUp()
	{
		this.municipioService = Mockito.spy(new MunicipioService());
	}

	@Test
	public void testGetMunicipioFromNodeListExists() throws ParserConfigurationException, SAXException, IOException
	{		
		NodeList nodeList = domService.getNodeListFromFile( xmlFile, MUNICIPIO_KML_TAG );
		Municipio output = municipioService.getMunicipioFromNodeList(nodeList, MUNICIPIO_CODIGO, isCode);
		
		boolean isInstanceOfMunicipio = output instanceof Municipio;
        boolean resultadoEsperado = true;    
        Assert.assertEquals(resultadoEsperado, isInstanceOfMunicipio); 
	}
	
	@Test
	public void testGetMunicipio() throws Exception
	{
		
		PowerMockito.whenNew(MunicipioService.class).withNoArguments().thenReturn(this.municipioService);
		NodeList nodeList = domService.getNodeListFromFile( xmlFile, MUNICIPIO_KML_TAG );
		Municipio output = municipioService.getMunicipioFromNodeList(nodeList, MUNICIPIO_CODIGO, isCode);
		Node node = nodeList.item(10);
		verify(this.municipioService, times(1)).getMunicipio(node);
	}
	
	@Test
	public void testGetMunicipioDataFromDocument() throws ParserConfigurationException, SAXException, IOException
	{
		NodeList nodeList = domService.getNodeListFromFile( xmlFile, MUNICIPIO_KML_TAG );
		Municipio municipio = municipioService.getMunicipioFromNodeList(nodeList, MUNICIPIO_CODIGO, isCode);
		
		final BoundingBox boundingBox = municipio.getBoundingBox();
		final Document overPassResponse = overpassService.getOverpassDocument( boundingBox );
		final MunicipioData municipioData = municipioService.getMunicipioDataFromDocument( overPassResponse );
		
		boolean isInstanceOfMunicipioData = municipioData instanceof MunicipioData;
		boolean resultadoEsperado = true;
		Assert.assertEquals(resultadoEsperado, isInstanceOfMunicipioData);
	}
	
	@Test
	public void testPrintMunicipioData() throws ParserConfigurationException, SAXException, IOException
	{
		NodeList nodeList = domService.getNodeListFromFile( xmlFile, MUNICIPIO_KML_TAG );
		Municipio municipio = municipioService.getMunicipioFromNodeList(nodeList, MUNICIPIO_CODIGO, isCode);
		
		final BoundingBox boundingBox = municipio.getBoundingBox();
		final Document overPassResponse = overpassService.getOverpassDocument( boundingBox );
		final MunicipioData municipioData = municipioService.getMunicipioDataFromDocument( overPassResponse );
		
		municipioService.printMunicipioData(municipioData, municipio.getNome());
	}
}
