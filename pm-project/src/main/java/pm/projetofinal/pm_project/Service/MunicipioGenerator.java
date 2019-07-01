package pm.projetofinal.pm_project.Service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import pm.projetofinal.pm_project.Model.Municipio;

public class MunicipioGenerator {

	static BoundingBoxGenerator boundingBoxGenerator = new BoundingBoxGenerator();

	public Municipio getMunicipio(Node node) {
		Municipio municipio = new Municipio();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			String coordinates = boundingBoxGenerator.getCoordinatesString(element);

			municipio.setNome(element.getElementsByTagName("SimpleData").item(0).getTextContent());
			municipio.setCodigo(element.getElementsByTagName("SimpleData").item(1).getTextContent());
			municipio.setBoundingBox(boundingBoxGenerator.generateBoundingBox(coordinates));
		}

		return municipio;
	}
}
