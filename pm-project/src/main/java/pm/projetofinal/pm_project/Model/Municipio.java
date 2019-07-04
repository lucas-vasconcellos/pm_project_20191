package pm.projetofinal.pm_project.Model;

public class Municipio {
	String nome;
	String codigo;
	String uf;
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

	public String getuf() {
		return uf;
	}

	public void setuf(String uf) {
		this.uf = uf;
	}

	public BoundingBox getBoundingBox() {
		return boundingBox;
	}

	public void setBoundingBox(BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}
}
