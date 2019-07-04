package pm.projetofinal.pm_project.Service;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pm.projetofinal.pm_project.Model.BoundingBox;
import pm.projetofinal.pm_project.Model.Municipio;
import pm.projetofinal.pm_project.Model.MunicipioData;
import pm.projetofinal.pm_project.Utils.Utils;
import pm.projetofinal.pm_project.Utils.XmlUtils;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class MunicipioService
{

	private static final String[] AEROWAY_KEY = {	"aeroway",
													"aerodrome"};

	static BoundingBoxService boundingBoxGenerator = new BoundingBoxService();

	private static final String DATA_TAG = "SimpleData";

	private static final String[] HIGHWAY_KEY = {	"highway",
													"primary"};

	private static final String NAME_VALUE = "name";

	private static final String OSM_TAG = "tag";

	private static final String[] PORT_KEY = {	"industrial",
												"port"};

	private static final String[] RAILWAY_KEY = {	"railway",
													"rail"};

	private static final String WAY_TAG = "way";

	public Municipio getMunicipio( final Node node )
	{

		if ( node.getNodeType() == Node.ELEMENT_NODE )
		{
			final Element element = ( Element ) node;
			final String coordinates = boundingBoxGenerator.getCoordinatesString( element );
			final String name = element.getElementsByTagName( DATA_TAG ).item( 0 ).getTextContent();
			final String code = element.getElementsByTagName( DATA_TAG ).item( 0 ).getTextContent();
			final BoundingBox BoundingBox = boundingBoxGenerator.generateBoundingBox( coordinates );

			final Municipio municipio = new Municipio( BoundingBox, code, name );

			return municipio;
		}

		return null;
	}

	public MunicipioData getMunicipioDataFromDocument( final Document document )
	{
		final ArrayList<String> highways = new ArrayList<String>();
		final ArrayList<String> ports = new ArrayList<String>();
		final ArrayList<String> railways = new ArrayList<String>();
		final ArrayList<String> aeroways = new ArrayList<String>();

		final NodeList waysNodeList = document.getElementsByTagName( WAY_TAG );

		for ( int i = 0; i < waysNodeList.getLength(); i++ )
		{
			final Node node = waysNodeList.item( i );
			final Element element = ( Element ) node;
			final List<Element> elements = XmlUtils.getElements( element, OSM_TAG );
			boolean isPrimaryHighway = false;
			boolean isPort = false;
			boolean isRailway = false;
			boolean isAeroway = false;

			String key = "";
			String value = "";

			for ( final Element e : elements )
			{
				key = XmlUtils.getStringAttribute( e, "k" );
				value = XmlUtils.getStringAttribute( e, "v" );
				// Verificando Estradas principais
				if ( key.equals( HIGHWAY_KEY[0] ) && value.equals( HIGHWAY_KEY[1] ) )
				{
					isPrimaryHighway = true;
				}
				if ( isPrimaryHighway && key.equals( NAME_VALUE ) )
				{
					highways.add( value );
					break;
				}

				// Verificando portos
				if ( key.equals( PORT_KEY[0] ) && value.equals( PORT_KEY[1] ) )
				{
					isPort = true;
				}
				if ( isPort && key.equals( NAME_VALUE ) )
				{
					ports.add( value );
					break;
				}

				// Verificando aeroportos
				if ( key.equals( AEROWAY_KEY[0] ) && value.equals( AEROWAY_KEY[1] ) )
				{
					isAeroway = true;
				}
				if ( isAeroway && key.equals( NAME_VALUE ) )
				{
					aeroways.add( value );
					break;
				}

				// Verificando ferrovia
				if ( key.equals( RAILWAY_KEY[0] ) && value.equals( RAILWAY_KEY[1] ) )
				{
					isRailway = true;
				}
				if ( isRailway && key.equals( NAME_VALUE ) )
				{
					railways.add( value );
					break;
				}
			}
		}
		final MunicipioData municipioData = new MunicipioData(
			aeroways,
			Utils.removeDuplicates( highways ),
			ports,
			railways );
		return municipioData;

	}

	public Municipio getMunicipioFromNodeList( final NodeList nodeList, final String municipio, final boolean isCode )
	{

		String nomeMunicipio = "";

		if ( !isCode )
		{
			nomeMunicipio = municipio.split( "-" )[0];
		}

		for ( int i = 0; i < nodeList.getLength(); i++ )
		{
			final Node node = nodeList.item( i );
			final Element element = ( Element ) node;

			final String nome = element.getElementsByTagName( DATA_TAG ).item( 0 ).getTextContent();
			final String codigo = element.getElementsByTagName( DATA_TAG ).item( 1 ).getTextContent();

			if ( node.getNodeType() == Node.ELEMENT_NODE )
			{
				if ( isCode )
				{
					if ( codigo.equals( municipio ) )
					{
						return getMunicipio( node );
					}
				}
				else
				{
					if ( nome.equals( nomeMunicipio ) )
					{
						return getMunicipio( node );
					}
				}
			}
		}
		System.out.println( "Município não encontrado" );
		System.exit( 0 );
		return new Municipio();
	}

	public void printMunicipioData( final MunicipioData municipioData, final String nomeMunicipio )
	{
		final List<String> highways = municipioData.getHighways();
		final List<String> railways = municipioData.getRailways();
		final List<String> aeroways = municipioData.getAeroways();
		final List<String> ports = municipioData.getPorts();

		System.out.println( nomeMunicipio.toUpperCase() + "\nRodovias: \n" );
		for ( final String highway : highways )
		{
			System.out.println( highway );
		}
		System.out.println( "\nFerrovias: \n" );
		for ( final String railway : railways )
		{
			System.out.println( railway );
		}
		System.out.println( "\nAeroportos: \n" );
		for ( final String aeroway : aeroways )
		{
			System.out.println( aeroway );
		}
		System.out.println( "\nPortos: \n" );
		for ( final String port : ports )
		{
			System.out.println( port );
		}
	}
}
