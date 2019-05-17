package pm.projetofinal.pm_project.Model;

import java.util.ArrayList;
import java.util.List;

public class Poligono {
	
	List<String> coordenadas;
	
	public Poligono()
	{
		this.coordenadas = new ArrayList<String>();
	}

	public List<String> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(List<String> coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	
}
