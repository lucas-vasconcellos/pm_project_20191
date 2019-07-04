package pm.projetofinal.pm_project.ControllerTest;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pm.projetofinal.pm_project.Controller.OverpassApiController;
import org.junit.*;

public class OverpassApiControllerTest {
	
	@Test
	public void testGetOverpassApiXmlSuccess() throws IOException, SAXException, ParserConfigurationException
    {
        final String parametroTest = "-42.18248958899994,-22.93313082199995,-41.88901108899994,-22.54012577499998";
        
        Document output = OverpassApiController.getOverpassApiXml(parametroTest);
        
        boolean isInstanceOfDocument = output instanceof Document;
        boolean resultadoEsperado = true;    
        Assert.assertEquals(isInstanceOfDocument, resultadoEsperado);    
    }
	
	@Test(expected = IOException.class)
	public void testGetOverpassApiXmlFailure() throws IOException, SAXException, ParserConfigurationException
    {
		final String parametroTest = "abcde";
		Document output = OverpassApiController.getOverpassApiXml(parametroTest);
    }
}
