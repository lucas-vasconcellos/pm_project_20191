package pm.projetofinal.pm_project.ServiceTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pm.projetofinal.pm_project.Service.DomService;


public class DomServiceTest {
	/**
	 * Teste do método que fera um Document a partir de um File no caso de sucesso
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@Test
	public void testGetDocumentFromFileSuccess() throws ParserConfigurationException, SAXException, IOException
	{
		final String filePath = String.format( "src\\kml\\ES.kml");
		final File xmlFile = new File(filePath);
		DomService domService = new DomService();
		
		Document output = domService.getDocumentFromFile(xmlFile);
		
		boolean isInstanceOfDocument = output instanceof Document;
        boolean resultadoEsperado = true;    
        Assert.assertEquals(isInstanceOfDocument, resultadoEsperado); 
	}
	
	/**
	 * Teste do método que fera um Document a partir de um File no caso de falha
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@Test(expected = FileNotFoundException.class)
	public void testGetDocumentFromFileFailure() throws ParserConfigurationException, SAXException, IOException
	{
		DomService domService = new DomService();
		final String filePath = String.format( "src\\kml\\lakshjd.kml");
		final File xmlFile = new File(filePath);
		
		Document output = domService.getDocumentFromFile(xmlFile);
	}
	
	/**
	 * Teste que faz a verificação da quantidade de nós de municípios retornados de um arquivo .kml
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@Test
	public void testGetNodeListFromFileSuccess() throws ParserConfigurationException, SAXException, IOException
	{
		final String MUNICIPIO_KML_TAG = "Placemark";
		final String filePath = String.format( "src\\kml\\ES.kml");
		final File xmlFile = new File(filePath);
		DomService domService = new DomService();
		
		NodeList output = domService.getNodeListFromFile(xmlFile, MUNICIPIO_KML_TAG);
		
		boolean isInstanceOfNodeList = output instanceof NodeList;
        boolean resultadoTipoEsperado = true;
        
		int outputlength = output.getLength();
		int resultadoLengthEsperado = 78;
		
        Assert.assertEquals(resultadoTipoEsperado, isInstanceOfNodeList);
        Assert.assertEquals(resultadoLengthEsperado, outputlength);
	}
	
	/**
	 * Teste na falha da verificação da quantidade de nós de municípios retornados de um arquivo .kml
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@Test
	public void testGetNodeListFromFileFailure() throws ParserConfigurationException, SAXException, IOException
	{
		final String MUNICIPIO_KML_TAG = "PM2019_ace4";
		final String filePath = String.format( "src\\kml\\ES.kml");
		final File xmlFile = new File(filePath);
		DomService domService = new DomService();
		
		NodeList output = domService.getNodeListFromFile(xmlFile, MUNICIPIO_KML_TAG);
		
		int outputlength = output.getLength();
		int resultadoEsperado = 0;
		Assert.assertEquals(resultadoEsperado, outputlength);
	}
}
