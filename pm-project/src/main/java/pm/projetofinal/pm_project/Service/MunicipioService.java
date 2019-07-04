package pm.projetofinal.pm_project.Service;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pm.projetofinal.pm_project.Model.Municipio;
import pm.projetofinal.pm_project.Model.MunicipioData;
import pm.projetofinal.pm_project.Utils.Utils;
import pm.projetofinal.pm_project.Utils.XmlUtils;

public class MunicipioService
{

	static BoundingBoxService boundingBoxGenerator = new BoundingBoxService();

	private static final String DATA_TAG = "SimpleData";

	private static final String WAY_TAG = "way";

	public Municipio getMunicipio( final Node node )
	{
		final Municipio municipio = new Municipio();
		if ( node.getNodeType() == Node.ELEMENT_NODE )
		{
			final Element element = ( Element ) node;
			final String coordinates = boundingBoxGenerator.getCoordinatesString( element );

			municipio.setNome( element.getElementsByTagName( DATA_TAG ).item( 0 ).getTextContent() );
			municipio.setCodigo( element.getElementsByTagName( DATA_TAG ).item( 1 ).getTextContent() );
			municipio.setBoundingBox( boundingBoxGenerator.generateBoundingBox( coordinates ) );
		}

		return municipio;
	}

	public MunicipioData getMunicipioDataFromDocument( final Document document )
	{
		final ArrayList<String> highways = new ArrayList<String>();
		final ArrayList<String> ports = new ArrayList<String>();
		final ArrayList<String> railways = new ArrayList<String>();
		final ArrayList<String> aeroways = new ArrayList<String>();

		final MunicipioData municipioData = new MunicipioData();

		final NodeList waysNodeList = document.getElementsByTagName( WAY_TAG );

		for ( int i = 0; i < waysNodeList.getLength(); i++ )
		{
			final Node node = waysNodeList.item( i );
			final Element element = ( Element ) node;
			final List<Element> elements = XmlUtils.getElements( element, "tag" );
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
				if ( key.equals( "highway" ) && value.equals( "primary" ) )
				{
					isPrimaryHighway = true;
				}
				if ( isPrimaryHighway && key.equals( "name" ) )
				{
					highways.add( value );
					break;
				}

				// Verificando portos
				if ( key.equals( "industrial" ) && value.equals( "port" ) )
				{
					isPort = true;
				}
				if ( isPort && key.equals( "name" ) )
				{
					ports.add( value );
					break;
				}

				// Verificando aeroportos
				if ( key.equals( "aeroway" ) && value.equals( "aerodrome" ) )
				{
					isAeroway = true;
				}
				if ( isAeroway && key.equals( "name" ) )
				{
					aeroways.add( value );
					break;
				}

				// Verificando ferrovia
				if ( key.equals( "railway" ) && value.equals( "rail" ) )
				{
					isRailway = true;
				}
				if ( isRailway && key.equals( "name" ) )
				{
					railways.add( value );
					break;
				}
			}
		}
		municipioData.setHighways( Utils.removeDuplicates( highways ) );
		municipioData.setAeroways( aeroways );
		municipioData.setPorts( ports );
		municipioData.setRailways( railways );

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
}
