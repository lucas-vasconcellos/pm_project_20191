package pm.projetofinal.pm_project;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pm.projetofinal.pm_project.Model.Municipio;
import pm.projetofinal.pm_project.Utils.XmlUtils;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		String filePath = "C:\\Users\\Brouck\\Desktop\\51MUE250GC_SIR.shp.kml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("Placemark");
			// now XML is loaded as Document in memory, lets convert it to
			// Object List
			List<Municipio> listaMunicipio = new ArrayList<Municipio>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				listaMunicipio.add(getMunicipio(nodeList.item(i)));
			}
			// lets print Employee list information
			for (Municipio municipio : listaMunicipio) {
				System.out.println(municipio.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Municipio getMunicipio(Node node) {
		// XMLReaderDOM domReader = new XMLReaderDOM();
		Municipio municipio = new Municipio();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			List<Element> list = XmlUtils.getElements(element, "ExtendedData");
			String obj =  getTagValue("ExtendedData", element).toString();
			municipio.setNome(getTagValue("SimpleData name=\"", element));
			System.out.println(obj);

			//municipio.setCodigo(Integer.parseInt((getTagValue("CD_GEOCMU", element))));
			// municipio.setPoligonos(getTagValue("Polygon", element));
		}

		return municipio;
	}

	private static String getTagValue(String tag, Element element) {
		NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodeList.item(0);
		return node.getNodeValue();
	}
}
