package pm.projetofinal.pm_project.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class Utils
{

	/**
	 * <p>
	 * Map com os códigos como chave e UF como valor Field <code>UF_MAP</code>
	 * </p>
	 */
	public static final Map<String, String> UF_MAP = new HashMap<String, String>();

	/**
	 * <p>
	 * Faz uma tentativa de parsear uma string para inteiro.
	 * </p>
	 *
	 * @param str
	 * @return
	 */
	public static boolean isIntegerParseInt( final String str )
	{
		try
		{
			Integer.parseInt( str );
			return true;
		}
		catch ( final NumberFormatException nfe )
		{
			return false;
		}
	}

	/**
	 * <p>
	 * Remove elementos duplicados de um ArrayList
	 * </p>
	 *
	 * @param list
	 * @return
	 */
	public static <T> ArrayList<T> removeDuplicates( final ArrayList<T> list )
	{

		// Create a new ArrayList
		final ArrayList<T> newList = new ArrayList<T>();

		// Traverse through the first list
		for ( final T element : list )
		{

			// If this element is not present in newList
			// then add it
			if ( !newList.contains( element ) )
			{

				newList.add( element );
			}
		}

		// return the new list
		return newList;
	}

	static
	{
		UF_MAP.put( new String( "12" ), "AC" );
		UF_MAP.put( new String( "27" ), "AL" );
		UF_MAP.put( new String( "13" ), "AM" );
		UF_MAP.put( new String( "16" ), "AP" );
		UF_MAP.put( new String( "29" ), "BA" );
		UF_MAP.put( new String( "23" ), "CE" );
		UF_MAP.put( new String( "53" ), "DF" );
		UF_MAP.put( new String( "32" ), "ES" );
		UF_MAP.put( new String( "52" ), "GO" );
		UF_MAP.put( new String( "21" ), "MA" );
		UF_MAP.put( new String( "31" ), "MG" );
		UF_MAP.put( new String( "50" ), "MS" );
		UF_MAP.put( new String( "51" ), "MT" );
		UF_MAP.put( new String( "15" ), "PA" );
		UF_MAP.put( new String( "25" ), "PB" );
		UF_MAP.put( new String( "26" ), "PE" );
		UF_MAP.put( new String( "22" ), "PI" );
		UF_MAP.put( new String( "41" ), "PR" );
		UF_MAP.put( new String( "33" ), "RJ" );
		UF_MAP.put( new String( "24" ), "RN" );
		UF_MAP.put( new String( "11" ), "RO" );
		UF_MAP.put( new String( "14" ), "RR" );
		UF_MAP.put( new String( "43" ), "RS" );
		UF_MAP.put( new String( "42" ), "SC" );
		UF_MAP.put( new String( "28" ), "SE" );
		UF_MAP.put( new String( "35" ), "SP" );
		UF_MAP.put( new String( "17" ), "TO" );
	}
}
