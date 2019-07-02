package pm.projetofinal.pm_project.Service;

import java.util.ArrayList;
import java.util.Collections;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import pm.projetofinal.pm_project.Model.BoundingBox;

public class BoundingBoxService {

	public BoundingBox generateBoundingBox(String coordString) {

		String[] arrayLatLong = coordString.split(",0 ");

		ArrayList<Double> latitudes = new ArrayList<Double>();
		ArrayList<Double> longitudes = new ArrayList<Double>();

		for (String latLong : arrayLatLong) {

			String[] positions = latLong.split(",");

			if (positions.length == 2) {
				String latitude = positions[0].trim();
				String longitude = positions[1].trim();

				latitudes.add(Double.parseDouble(latitude));
				longitudes.add(Double.parseDouble(longitude));
			}

		}

		Collections.sort(latitudes);
		Collections.sort(longitudes);

		int qtdLatitudesForArray = latitudes.size() - 1;
		int qtdLongitudesForArray = longitudes.size() - 1;

		BoundingBox boundingBox = new BoundingBox();
		boundingBox.setMaxLat(latitudes.get(qtdLatitudesForArray));
		boundingBox.setMaxLong(longitudes.get(qtdLongitudesForArray));
		boundingBox.setMinLat(latitudes.get(0));
		boundingBox.setMinLong(longitudes.get(0));

		return boundingBox;
	}

	public String getCoordinatesString(Element placemark) {
		NodeList polygonList = placemark.getElementsByTagName("Polygon");
		String coordinates = "";

		for (int i = 0; i < polygonList.getLength(); i++) {
			Element polygon = (Element) polygonList.item(i);
			String coord = polygon.getElementsByTagName("coordinates").item(0).getTextContent();
			coordinates = coordinates + coord;
		}

		return coordinates;
	}
	
	public BoundingBox getBoundingBox(String municipio, boolean isCode){
		
		
		
		
		return new BoundingBox();
	}
}
