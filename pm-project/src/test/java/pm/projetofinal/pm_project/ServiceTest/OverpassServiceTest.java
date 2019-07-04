package pm.projetofinal.pm_project.ServiceTest;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.junit.*;
import pm.projetofinal.pm_project.Model.BoundingBox;
import pm.projetofinal.pm_project.Model.Municipio;
import pm.projetofinal.pm_project.Service.DomService;
import pm.projetofinal.pm_project.Service.MunicipioService;
import pm.projetofinal.pm_project.Service.OverpassService;

public class OverpassServiceTest {

	DomService domService = new DomService();
	MunicipioService municipioService = new MunicipioService();
	OverpassService overpassService = new OverpassService();

	/**
	 * Teste que verifica se o Document retornado da chamada da api do Overpass
	 * é valido
	 * 
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	@Test
	public void testGetOverpassDocument() throws ParserConfigurationException, SAXException, IOException {
		final String MUNICIPIO_CODIGO = "3300704";
		final boolean isCode = true;
		final String MUNICIPIO_KML_TAG = "Placemark";
		final String filePath = String.format("src\\kml\\RJ.kml");
		final File xmlFile = new File(filePath);

		NodeList nodeList = domService.getNodeListFromFile(xmlFile, MUNICIPIO_KML_TAG);
		Municipio municipio = municipioService.getMunicipioFromNodeList(nodeList, MUNICIPIO_CODIGO, isCode);

		BoundingBox output = municipio.getBoundingBox();

		Document document = overpassService.getOverpassDocument(output);

		boolean isInstanceOfDocument = document instanceof Document;
		boolean resultadoEsperado = true;
		Assert.assertEquals(resultadoEsperado, isInstanceOfDocument);
	}

}
