package pm.projetofinal.pm_project.Model;

public class BoundingBox
{

	/**
	 * <p>
	 * </p>
	 * 
	 * @param maxLat
	 * @param maxLong
	 * @param minLat
	 * @param minLong
	 */
	public BoundingBox( final double maxLat, final double maxLong, final double minLat, final double minLong )
	{
		super();
		this.maxLat = maxLat;
		this.maxLong = maxLong;
		this.minLat = minLat;
		this.minLong = minLong;
	}

	public double getMaxLat()
	{
		return this.maxLat;
	}

	public double getMaxLong()
	{
		return this.maxLong;
	}

	public double getMinLat()
	{
		return this.minLat;
	}

	public double getMinLong()
	{
		return this.minLong;
	}

	public String getStringForOverpass()
	{
		final String response = String.format(
			"%.14f,%.14f,%.14f,%.14f",
			getMinLat(),
			getMinLong(),
			getMaxLat(),
			getMaxLong() );
		return response;
	}

	public void setMaxLat( final double maxLat )
	{
		this.maxLat = maxLat;
	}

	public void setMaxLong( final double maxLong )
	{
		this.maxLong = maxLong;
	}

	public void setMinLat( final double minLat )
	{
		this.minLat = minLat;
	}

	public void setMinLong( final double minLong )
	{
		this.minLong = minLong;
	}

	@Override
	public String toString()
	{
		final String boundingBoxString = String.format(
			"maxLat: %f \n maxLong: %f \n minLat: %f \n minLong: %f",
			this.maxLat,
			this.maxLong,
			this.minLat,
			this.minLong );
		return boundingBoxString;
	}

	double maxLat;

	double maxLong;

	double minLat;

	double minLong;
}
