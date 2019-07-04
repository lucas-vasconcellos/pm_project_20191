package pm.projetofinal.pm_project.Model;

import java.util.ArrayList;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class MunicipioData
{

	/**
	 * <p>
	 * </p>
	 * 
	 * @return Returns the aeroways.
	 * @see #aeroways
	 */
	public ArrayList<String> getAeroways()
	{
		return this.aeroways;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @return Returns the highways.
	 * @see #highways
	 */
	public ArrayList<String> getHighways()
	{
		return this.highways;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @return Returns the ports.
	 * @see #ports
	 */
	public ArrayList<String> getPorts()
	{
		return this.ports;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @return Returns the railways.
	 * @see #railways
	 */
	public ArrayList<String> getRailways()
	{
		return this.railways;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param aeroways
	 *            The aeroways to set.
	 * @see #aeroways
	 */
	public void setAeroways( final ArrayList<String> aeroways )
	{
		this.aeroways = aeroways;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param highways
	 *            The highways to set.
	 * @see #highways
	 */
	public void setHighways( final ArrayList<String> highways )
	{
		this.highways = highways;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param ports
	 *            The ports to set.
	 * @see #ports
	 */
	public void setPorts( final ArrayList<String> ports )
	{
		this.ports = ports;
	}

	/**
	 * <p>
	 * </p>
	 * 
	 * @param railways
	 *            The railways to set.
	 * @see #railways
	 */
	public void setRailways( final ArrayList<String> railways )
	{
		this.railways = railways;
	}

	public ArrayList<String> aeroways;

	public ArrayList<String> highways;

	public ArrayList<String> ports;

	public ArrayList<String> railways;
}
