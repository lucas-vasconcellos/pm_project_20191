package pm.projetofinal.pm_project.Model;

import java.util.ArrayList;
import java.util.List;

public class Municipio {
	
	String nome;
	int codigo;
	List<Poligono> poligonos;
	
	public Municipio() {
		
		this.nome = "";
		this.codigo = 0;
		this.poligonos = new ArrayList<Poligono>();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setPoligonos(List<Poligono> poligonos) {
		this.poligonos = poligonos;
	}

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public List<Poligono> getPoligonos() {
		return poligonos;
	}
}
