package pm.projetofinal.pm_project.Service;

import java.util.ArrayList;
import java.util.Collections;

import pm.projetofinal.pm_project.Model.BoundingBox;

public class BoundingBoxGenerator {

	public BoundingBox generateBoundingBox(String coordString) {

		String[] arrayLatLong = coordString.split(",0");

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
		boundingBox.setMinLat(latitudes.get(qtdLatitudesForArray));
		boundingBox.setMinLong(longitudes.get(qtdLongitudesForArray));
		boundingBox.setMaxLat(latitudes.get(0));
		boundingBox.setMaxLong(longitudes.get(0));

		return boundingBox;
	}
}
