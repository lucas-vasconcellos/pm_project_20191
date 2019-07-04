package pm.projetofinal.pm_project.Model;

/**
 * <p>
 * </p>
 *
 * @author joao.brouck
 * @version 1.0 Created on Jul 3, 2019
 */
public class Municipio {

	/**
	 * <p>
	 * Construtor vazio
	 * </p>
	 */
	public Municipio() {
	}

	/**
	 * <p>
	 * Construtor
	 * </p>
	 *
	 * @param boundingBox
	 * @param codigo
	 * @param nome
	 */
	public Municipio(final BoundingBox boundingBox, final String codigo, final String nome) {
		super();
		this.boundingBox = boundingBox;
		this.codigo = codigo;
		this.nome = nome;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the boundingBox.
	 * @see #boundingBox
	 */
	public BoundingBox getBoundingBox() {
		return this.boundingBox;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the codigo.
	 * @see #codigo
	 */
	public String getCodigo() {
		return this.codigo;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @return Returns the nome.
	 * @see #nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param boundingBox
	 *            The boundingBox to set.
	 * @see #boundingBox
	 */
	public void setBoundingBox(final BoundingBox boundingBox) {
		this.boundingBox = boundingBox;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param codigo
	 *            The codigo to set.
	 * @see #codigo
	 */
	public void setCodigo(final String codigo) {
		this.codigo = codigo;
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param nome
	 *            The nome to set.
	 * @see #nome
	 */
	public void setNome(final String nome) {
		this.nome = nome;
	}

	BoundingBox boundingBox;

	String codigo;

	String nome;
}
