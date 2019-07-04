package pm.projetofinal.pm_project.ServiceTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pm.projetofinal.pm_project.Service.DomService;


public class DomServiceTest {

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
	
	@Test(expected = FileNotFoundException.class)
	public void testGetDocumentFromFileFailure() throws ParserConfigurationException, SAXException, IOException
	{
		DomService domService = new DomService();
		final String filePath = String.format( "src\\kml\\lakshjd.kml");
		final File xmlFile = new File(filePath);
		
		Document output = domService.getDocumentFromFile(xmlFile);
	}
}
