package pm.projetofinal.pm_project.Service;

import org.w3c.dom.*;

import pm.projetofinal.pm_project.Model.Municipio;

public class MunicipioService {

	static BoundingBoxService boundingBoxGenerator = new BoundingBoxService();

	private static final String DATA_TAG = "SimpleData";

	public Municipio getMunicipio(Node node) {
		Municipio municipio = new Municipio();
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			Element element = (Element) node;
			String coordinates = boundingBoxGenerator.getCoordinatesString(element);

			municipio.setNome(element.getElementsByTagName(DATA_TAG).item(0).getTextContent());
			municipio.setCodigo(element.getElementsByTagName(DATA_TAG).item(1).getTextContent());
			municipio.setBoundingBox(boundingBoxGenerator.generateBoundingBox(coordinates));
		}

		return municipio;
	}

	public Municipio getMunicipioFromNodeList(NodeList nodeList, String municipio, boolean isCode) {
		
		String nomeMunicipio = "";

		if (!isCode) {
			nomeMunicipio = municipio.split("-")[0];
		}

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			Element element = (Element) node;

			String nome = element.getElementsByTagName(DATA_TAG).item(0).getTextContent();
			String codigo = element.getElementsByTagName(DATA_TAG).item(1).getTextContent();

			if (node.getNodeType() == Node.ELEMENT_NODE) {
				if (isCode) {
					if (codigo.equals(municipio))
						return this.getMunicipio(node);
				} else {
					if (nome.equals(nomeMunicipio))
						return this.getMunicipio(node);
				}
			}
		}
		return null;
	}
}
