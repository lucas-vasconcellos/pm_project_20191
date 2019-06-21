package pm.projetofinal.pm_project.Model;

public class Municipio {
	String nome;
	String codigo;
	String poligonos;
	BoundingBox boundingBox;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getPoligonos() {
		return poligonos;
	}

	public void setPoligonos(String poligonos) {
		this.poligonos = poligonos;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}
}
