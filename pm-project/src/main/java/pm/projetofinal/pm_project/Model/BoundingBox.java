package pm.projetofinal.pm_project.Model;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class BoundingBox {

	/**
	 * <p>
	 * Construtor
	 * </p>
	 *
	 * @param maxLat
	 * @param maxLong
	 * @param minLat
	 * @param minLong
	 */
	public BoundingBox(final double maxLat, final double maxLong, final double minLat, final double minLong) {
		super();
		this.maxLat = maxLat;
		this.maxLong = maxLong;
		this.minLat = minLat;
		this.minLong = minLong;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the maxLat.
	 * @see #maxLat
	 */
	public double getMaxLat() {
		return this.maxLat;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the maxLong.
	 * @see #maxLong
	 */
	public double getMaxLong() {
		return this.maxLong;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the minLat.
	 * @see #minLat
	 */
	public double getMinLat() {
		return this.minLat;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the minLong.
	 * @see #minLong
	 */
	public double getMinLong() {
		return this.minLong;
	}

	/**
	 * <p>
	 * Método que retorna a string formatada para usar na api do Overpass
	 * </p>
	 *
	 * @return String formatada
	 */
	public String getStringForOverpass() {
		final String response = String.format("%.14f,%.14f,%.14f,%.14f", getMinLat(), getMinLong(), getMaxLat(),
				getMaxLong());
		return response;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param maxLat
	 *            The maxLat to set.
	 * @see #maxLat
	 */
	public void setMaxLat(final double maxLat) {
		this.maxLat = maxLat;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param maxLong
	 *            The maxLong to set.
	 * @see #maxLong
	 */
	public void setMaxLong(final double maxLong) {
		this.maxLong = maxLong;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param minLat
	 *            The minLat to set.
	 * @see #minLat
	 */
	public void setMinLat(final double minLat) {
		this.minLat = minLat;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param minLong
	 *            The minLong to set.
	 * @see #minLong
	 */
	public void setMinLong(final double minLong) {
		this.minLong = minLong;
	}

	double maxLat;

	double maxLong;

	double minLat;

	double minLong;
}
