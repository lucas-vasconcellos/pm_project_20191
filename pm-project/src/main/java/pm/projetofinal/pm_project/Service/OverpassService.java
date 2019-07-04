package pm.projetofinal.pm_project.Service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import pm.projetofinal.pm_project.Controller.OverpassApiController;
import pm.projetofinal.pm_project.Model.BoundingBox;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class OverpassService {

	/**
	 * <p>
	 * Faz a requisição para a Api do Overpass e recebe o .osmn
	 * </p>
	 * 
	 * @param boundingBox
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public Document getOverpassDocument(final BoundingBox boundingBox)
			throws IOException, SAXException, ParserConfigurationException {

		final Document document = OverpassApiController.getOverpassApiXml(boundingBox.getStringForOverpass());
		document.getDocumentElement().normalize();

		return document;
	}

}
