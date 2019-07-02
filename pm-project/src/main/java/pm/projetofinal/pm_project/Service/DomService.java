package pm.projetofinal.pm_project.Service;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomService {

	public Document getDocumentFromFile(File file) throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		Document document = dBuilder.parse(file);
		document.getDocumentElement().normalize();

		return document;
	}

	public NodeList getNodeListFromFile(File file, String tag)
			throws ParserConfigurationException, SAXException, IOException {

		Document document = this.getDocumentFromFile(file);
		NodeList nodeList = document.getElementsByTagName(tag);

		return nodeList;
	}

}
