package pm.projetofinal.pm_project;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import pm.projetofinal.pm_project.Model.BoundingBox;
import pm.projetofinal.pm_project.Model.Municipio;
import pm.projetofinal.pm_project.Model.MunicipioData;
import pm.projetofinal.pm_project.Service.BoundingBoxService;
import pm.projetofinal.pm_project.Service.DomService;
import pm.projetofinal.pm_project.Service.MunicipioService;
import pm.projetofinal.pm_project.Service.OverpassService;
import pm.projetofinal.pm_project.Utils.Utils;

public class App
{

	static BoundingBoxService boundingBoxService = new BoundingBoxService();

	static DomService domService = new DomService();

	public static final String MUNICIPIO_KML_TAG = "Placemark";

	static MunicipioService municipioService = new MunicipioService();

	static OverpassService overpassService = new OverpassService();

	public static void main( final String[] args )
		throws Exception
	{

		String uf = "";
		boolean isCode = true;
		String entryMunicipio = "";
		final BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );

		try
		{

			entryMunicipio = reader.readLine().toString().toUpperCase();

			if ( Utils.isIntegerParseInt( entryMunicipio ) )
			{
				uf = entryMunicipio.substring( 0, 2 );
				uf = Utils.UF_MAP.get( entryMunicipio.substring( 0, 2 ) );
			}
			else
			{
				uf = entryMunicipio.split( "-" )[1];

				isCode = false;
			}
		}
		catch ( final Exception e )
		{
			System.out.println( "Informação inválida foi inserida. O formato correto é municipio-UF ou o código." );
			System.exit( 0 );
		}

		final String filePath = String.format( "src\\kml\\%s.kml", uf );
		final File xmlFile = new File( filePath );

		try
		{

			final NodeList nodeList = domService.getNodeListFromFile( xmlFile, MUNICIPIO_KML_TAG );
			final Municipio municipio = municipioService.getMunicipioFromNodeList( nodeList, entryMunicipio, isCode );
			if ( municipio != null )
			{
				final BoundingBox boundingBox = municipio.getBoundingBox();
				final Document overPassResponse = overpassService.getOverpassDocument( boundingBox );
				final MunicipioData municipioData = municipioService.getMunicipioDataFromDocument( overPassResponse );
			}
		}
		catch ( final IOException e )
		{
			System.out.println( "Houve um problema com a requisição." );
			throw e;
		}

	}
}
