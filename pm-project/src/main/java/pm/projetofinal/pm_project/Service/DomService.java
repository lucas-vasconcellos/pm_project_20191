package pm.projetofinal.pm_project.Service;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class DomService {

	/**
	 * <p>
	 * Gera um Document a partir de um File
	 * </p>
	 *
	 * @param file
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public Document getDocumentFromFile(final File file)
			throws ParserConfigurationException, SAXException, IOException {

		final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		dBuilder = dbFactory.newDocumentBuilder();
		final Document document = dBuilder.parse(file);
		document.getDocumentElement().normalize();

		return document;
	}

	/**
	 * <p>
	 * Gera uma NodeList baseada numa tag a partir de um File
	 * </p>
	 *
	 * @param file
	 * @param tag
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public NodeList getNodeListFromFile(final File file, final String tag)
			throws ParserConfigurationException, SAXException, IOException {

		final Document document = getDocumentFromFile(file);
		final NodeList nodeList = document.getElementsByTagName(tag);

		return nodeList;
	}

}
