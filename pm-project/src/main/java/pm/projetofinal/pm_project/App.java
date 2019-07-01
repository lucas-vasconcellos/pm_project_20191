package pm.projetofinal.pm_project;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pm.projetofinal.pm_project.Model.*;
import pm.projetofinal.pm_project.Service.*;
import pm.projetofinal.pm_project.Controller.*;

import com.opencsv.*;

public class App {
	static BoundingBoxGenerator boundingBoxGenerator = new BoundingBoxGenerator();
	static MunicipioGenerator municipioGenerator = new MunicipioGenerator();
	static OverpassApiController overpassApiController = new OverpassApiController();


	public static void main(String[] args) throws ParserConfigurationException, SAXException {
		String uf = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			uf = reader.readLine().toString().toUpperCase();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String filePath = String.format("C:\\Users\\Brouck\\Desktop\\%s.kml", uf);
		File xmlFile = new File(filePath);
		// Printing the read line
		System.out.println(uf);

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
			List<BoundingBox> listaBoundingBoxes = new ArrayList<BoundingBox>();

			for (int i = 0; i < nodeList.getLength(); i++) {
				Municipio municipioToAdd = municipioGenerator.getMunicipio(nodeList.item(i));
				listaMunicipio.add(municipioToAdd);
			}
			for (Municipio municipio : listaMunicipio) {
				System.out.println("Nome:" + municipio.getNome() + "\n Codigo:" + municipio.getCodigo() + "\n "
						+ municipio.getBoundingBox().toString() + "\n");
				listaBoundingBoxes.add(municipio.getBoundingBox());
			}
			
			Document is = overpassApiController.getOverpassApiXml(listaBoundingBoxes.get(9).getStringForOverpass());
			is.getDocumentElement().normalize();
			System.out.println("Root element :" + is.getDocumentElement().getNodeName());
			NodeList nodeList2 = is.getElementsByTagName("way");
			System.out.println(nodeList2.getLength());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void generateCsv(List<BoundingBox> boundingBoxes, String filePath) {

		File file = new File(filePath);
		try {
			if (file.exists()) {
				boolean existe = true;
			}
			ArrayList<String[]> csvData = new ArrayList<String[]>();
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			// adding header to csv
			String[] header = { "Name", "Class", "Marks" };
			writer.writeNext(header);

			// add data to csv
			for (BoundingBox boundingBox : boundingBoxes) {
				// String.format("", );
			}
			String[] data1 = { "Aman", "10", "620" };
			writer.writeNext(data1);
			String[] data2 = { "Suraj", "10", "630" };
			writer.writeNext(data2);

			// closing writer connection
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
