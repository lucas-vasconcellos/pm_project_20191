package pm.projetofinal.pm_project.Model;

public class BoundingBox {

	double maxLat;
	double maxLong;
	double minLat;
	double minLong;

	public double getMaxLat() {
		return maxLat;
	}

	public void setMaxLat(double maxLat) {
		this.maxLat = maxLat;
	}

	public double getMaxLong() {
		return maxLong;
	}

	public void setMaxLong(double maxLong) {
		this.maxLong = maxLong;
	}

	public double getMinLat() {
		return minLat;
	}

	public void setMinLat(double minLat) {
		this.minLat = minLat;
	}

	public double getMinLong() {
		return minLong;
	}

	public void setMinLong(double minLong) {
		this.minLong = minLong;
	}

	public String toString(){
		String boundingBoxString = String.format("maxLat: %f \n maxLong: %f \n minLat: %f \n minLong: %f", this.maxLat, this.maxLong, this.minLat, this.minLong);
		return boundingBoxString;
	}
}
