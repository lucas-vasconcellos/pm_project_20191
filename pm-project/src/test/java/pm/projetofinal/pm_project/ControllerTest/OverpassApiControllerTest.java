package pm.projetofinal.pm_project.ControllerTest;
import junit.framework.*;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import pm.projetofinal.pm_project.Controller.OverpassApiController;

public class OverpassApiControllerTest extends TestCase{
	
	public void testGetOverpassApiXml() throws IOException, SAXException, ParserConfigurationException
    {
        String parametroTest = "-42.18248958899994,-22.93313082199995,-41.88901108899994,-22.54012577499998";
        Document output = OverpassApiController.getOverpassApiXml(parametroTest);
        boolean isInstanceOfDocument = output instanceof Document;
        
        assertEquals(isInstanceOfDocument, true);    
    }
}
