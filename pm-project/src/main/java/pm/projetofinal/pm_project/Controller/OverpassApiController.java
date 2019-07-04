package pm.projetofinal.pm_project.Controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class OverpassApiController {

	/**
	 * <p>
	 * URL de conexão com a API do Overpass Field <code>OVERPASS_API</code>
	 * </p>
	 */
	private static final String OVERPASS_API = "http://overpass-api.de/api/map?bbox=";

	/**
	 * <p>
	 * Faz a requisição GET para a API do Overpass
	 * </p>
	 * 
	 * @param parameters
	 * @return
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public static Document getOverpassApiXml(final String parameters)
			throws IOException, SAXException, ParserConfigurationException {

		final String finalUrlString = OVERPASS_API + parameters;
		final URL apiUrl = new URL(finalUrlString);

		final HttpURLConnection apiConn = (HttpURLConnection) apiUrl.openConnection();

		final DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		final DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
		final Document response = docBuilder.parse(apiConn.getInputStream());

		return response;
	}
}
