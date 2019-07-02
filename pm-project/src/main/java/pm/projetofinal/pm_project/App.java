package pm.projetofinal.pm_project;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import pm.projetofinal.pm_project.Model.*;
import pm.projetofinal.pm_project.Service.*;
import pm.projetofinal.pm_project.Utils.Utils;
import pm.projetofinal.pm_project.Controller.*;

import com.opencsv.*;

public class App {
	static BoundingBoxService boundingBoxService = new BoundingBoxService();
	static MunicipioService municipioService = new MunicipioService();
	static DomService domService = new DomService();
	static OverpassService overpassService =  new OverpassService();

	public static final String MUNICIPIO_KML_TAG = "Placemark";

	public static void main(String[] args) throws ParserConfigurationException, SAXException {

		String uf = "";
		boolean isCode = true;
		String entryMunicipio = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			entryMunicipio = reader.readLine().toString().toUpperCase();

			if (Utils.isIntegerParseInt(entryMunicipio)) {
				uf = entryMunicipio.substring(0, 2);
				uf = Utils.mapaUF.get(entryMunicipio.substring(0, 2));
			} else {
				uf = entryMunicipio.split("-")[1];
				isCode = false;
			}
		} catch (IOException e1) {
			System.out.println("Informação inválida foi inserida.");
		}

		String filePath = String.format("src\\kml\\%s.kml", uf);
		File xmlFile = new File(filePath);

		try {
			NodeList nodeList = domService.getNodeListFromFile(xmlFile, MUNICIPIO_KML_TAG);
			Municipio municipio = municipioService.getMunicipioFromNodeList(nodeList, entryMunicipio, isCode);
			BoundingBox boundingBox = municipio.getBoundingBox();
			Document overPassResponse = overpassService.getOverpassDocument(boundingBox);

			//TODO utilizar o document para buscar os dados e montar a exibição.
			// NodeList nodeList2 = is.getElementsByTagName("way");
			// System.out.println(nodeList2.getLength());

		} catch (IOException e) {
			System.out.println("Houve um problema com a requisição.");
		}

	}
}
