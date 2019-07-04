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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pm.projetofinal.pm_project.Model.Municipio;
import pm.projetofinal.pm_project.Service.DomService;
import pm.projetofinal.pm_project.Service.MunicipioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



public class MunicipioServiceTest {

	
	MunicipioService municipioService = new MunicipioService();
	DomService domService = new DomService();
	@Mock
	MunicipioService municipioService1;
	
	final String MUNICIPIO_CODIGO = "3300605";
	final boolean isCode = true;
	final String MUNICIPIO_KML_TAG = "Placemark";
	final String filePath = String.format( "src\\kml\\RJ.kml");
	final File xmlFile = new File(filePath);

	@Test
	public void testGetMunicipioFromNodeListExists() throws ParserConfigurationException, SAXException, IOException
	{		
		NodeList nodeList = domService.getNodeListFromFile( xmlFile, MUNICIPIO_KML_TAG );
		Municipio output = municipioService.getMunicipioFromNodeList(nodeList, MUNICIPIO_CODIGO, isCode);
		
		boolean isInstanceOfMunicipio = output instanceof Municipio;
        boolean resultadoEsperado = true;    
        Assert.assertEquals(resultadoEsperado, isInstanceOfMunicipio); 
	}
	
	//@PrepareForTest(System.class)
	//@Test
	//public void testGetMunicipioFromNodeListNotExists() throws ParserConfigurationException, SAXException, IOException
	//{
		//MunicipioService municipioService = new MunicipioService();
		//DomService domService = new DomService();
		
		//final String MUNICIPIO_CODIGO = "3300605";
		//final boolean isCode = true;
		//final String MUNICIPIO_KML_TAG = "Placemark";
		//final String filePath = String.format( "src\\kml\\ES.kml");
		//final File xmlFile = new File(filePath);
		
		//NodeList nodeList = domService.getNodeListFromFile( xmlFile, MUNICIPIO_KML_TAG );
		
		//PowerMockito.mockStatic(System.class);
		//String mockReturn = PowerMockito.when(System.out.println()).thenReturn("System.exit(0) was called!");
		
		//boolean resultadoEsperado = true;
		//Assert.assertEquals(resultadoEsperado, municipioService.getMunicipioFromNodeList(nodeList, MUNICIPIO_CODIGO, isCode));;
	//}
	
	@Test
	public void testGetMunicipio() throws ParserConfigurationException, SAXException, IOException
	{
		
		municipioService1 = new MunicipioService();
		NodeList nodeList = domService.getNodeListFromFile( xmlFile, MUNICIPIO_KML_TAG );
		Municipio output = municipioService.getMunicipioFromNodeList(nodeList, MUNICIPIO_CODIGO, isCode);
	}
}
