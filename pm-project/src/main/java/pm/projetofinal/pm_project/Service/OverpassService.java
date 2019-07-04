package pm.projetofinal.pm_project.Service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pm.projetofinal.pm_project.Controller.OverpassApiController;
import pm.projetofinal.pm_project.Model.BoundingBox;

public class OverpassService {

	public Document getOverpassDocument(BoundingBox boundingBox) throws IOException, SAXException, ParserConfigurationException{
		
		Document document = OverpassApiController.getOverpassApiXml(boundingBox.getStringForOverpass());
		document.getDocumentElement().normalize();
		
		return document;
	}
	
}
