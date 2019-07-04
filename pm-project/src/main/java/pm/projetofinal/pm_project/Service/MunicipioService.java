package pm.projetofinal.pm_project.Service;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import pm.projetofinal.pm_project.Model.Municipio;

public class MunicipioService
{

	static BoundingBoxService boundingBoxGenerator = new BoundingBoxService();

	private static final String DATA_TAG = "SimpleData";

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
