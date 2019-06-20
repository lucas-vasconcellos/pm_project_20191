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
		String filePath = "C:\\Users\\Brouck\\Desktop\\12MUE250GC_SIR.kml";
		File xmlFile = new File(filePath);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			NodeList nodeList = doc.getElementsByTagName("Placemark");
			System.out.println(nodeList.getLength());

			List<Municipio> listaMunicipio = new ArrayList<Municipio>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				listaMunicipio.add(getMunicipio(nodeList.item(i)));
			}
			for (Municipio municipio : listaMunicipio) {
				System.out.println("Nome:" + municipio.getNome() + "\n Codigo:" + municipio.getCodigo() + "\n Coordenadas:" + municipio.getPoligonos() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Municipio getMunicipio(Node node) {
		Municipio municipio = new Municipio();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			
			municipio.setNome(element.getElementsByTagName("SimpleData").item(0).getTextContent());
			municipio.setCodigo(element.getElementsByTagName("SimpleData").item(1).getTextContent());
			municipio.setPoligonos(element.getElementsByTagName("coordinates").item(0).getTextContent());
		}

		return municipio;
	}
}
