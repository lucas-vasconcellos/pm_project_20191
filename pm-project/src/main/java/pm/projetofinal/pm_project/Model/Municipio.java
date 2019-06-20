package pm.projetofinal.pm_project.Model;

import java.util.ArrayList;
import java.util.List;

public class Municipio {
	
	String nome;
	String codigo;
	String poligonos;
	
	public Municipio() {
		
		this.nome = "";
		this.codigo = "";
		this.poligonos = ""; //new ArrayList<Poligono>();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPoligonos(String poligonos) {
		this.poligonos = poligonos;
	}

	public String getNome() {
		return nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getPoligonos() {
		return poligonos;
	}
}
