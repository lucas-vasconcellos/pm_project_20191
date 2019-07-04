package pm.projetofinal.pm_project.Service;

import java.util.ArrayList;
import java.util.Collections;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import pm.projetofinal.pm_project.Model.BoundingBox;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class BoundingBoxService
{

	/**
	 * <p>
	 * Tag utilizada para buscar as coordenadas de um polígno num arquivo .kml Field
	 * <code>COORDINATES_TAG</code>
	 * </p>
	 */
	public static final String COORDINATES_TAG = "coordinates";

	/**
	 * <p>
	 * Tag utilizada para buscar um polígno num arquivo .kml Field <code>POLYGON_TAG</code>
	 * </p>
	 */
	public static final String POLYGON_TAG = "polygon";

	/**
	 * <p>
	 * Gera a Bounding Box baseado num conjunto de corrdenadas obtidas de um arquivo .kml
	 * </p>
	 *
	 * @param coordString
	 * @return
	 */
	public BoundingBox generateBoundingBox( final String coordString )
	{

		final String[] arrayLatLong = coordString.split( ",0 " );

		final ArrayList<Double> latitudes = new ArrayList<Double>();
		final ArrayList<Double> longitudes = new ArrayList<Double>();

		for ( final String latLong : arrayLatLong )
		{

			final String[] positions = latLong.split( "," );

			if ( positions.length == 2 )
			{
				final String latitude = positions[0].trim();
				final String longitude = positions[1].trim();

				latitudes.add( Double.parseDouble( latitude ) );
				longitudes.add( Double.parseDouble( longitude ) );
			}

		}

		Collections.sort( latitudes );
		Collections.sort( longitudes );

		final int qtdLatitudesForArray = latitudes.size() - 1;
		final int qtdLongitudesForArray = longitudes.size() - 1;

		final BoundingBox boundingBox = new BoundingBox(
			latitudes.get( qtdLatitudesForArray ),
			longitudes.get( qtdLongitudesForArray ),
			latitudes.get( 0 ),
			longitudes.get( 0 ) );

		return boundingBox;
	}

	/**
	 * <p>
	 * Obtem uma string com as coordenadas de um polígono de um arquivo .kml
	 * </p>
	 * 
	 * @param placemark
	 * @return
	 */
	public String getCoordinatesString( final Element placemark )
	{
		final NodeList polygonList = placemark.getElementsByTagName( POLYGON_TAG );
		String coordinates = "";

		for ( int i = 0; i < polygonList.getLength(); i++ )
		{
			final Element polygon = ( Element ) polygonList.item( i );
			final String coord = polygon.getElementsByTagName( COORDINATES_TAG ).item( 0 ).getTextContent();
			coordinates = coordinates + coord;
		}

		return coordinates;
	}
}
