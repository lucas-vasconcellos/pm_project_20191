package pm.projetofinal.pm_project.Controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class OverpassApiController {

	private static final String OVERPASS_API = "https://overpass-api.de/api/map?bbox=";

	public Document getOverpassApiXml(String parameters)
			throws IOException, SAXException, ParserConfigurationException {

		String finalUrlString = OVERPASS_API + parameters;
		URL apiUrl = new URL(finalUrlString);

		final HttpURLConnection apiConn = (HttpURLConnection) apiUrl.openConnection();

		DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
		Document response = docBuilder.parse(apiConn.getInputStream());

		return response;
	}
}