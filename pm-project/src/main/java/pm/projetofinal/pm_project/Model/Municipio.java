package pm.projetofinal.pm_project.Model;

public class Municipio
{

	/**
	 * <p>
	 * </p>
	 */
	public Municipio()
	{
	}

	/**
	 * <p>
	 * </p>
	 *
	 * @param boundingBox
	 * @param codigo
	 * @param nome
	 */
	public Municipio( final BoundingBox boundingBox, final String codigo, final String nome )
	{
		super();
		this.boundingBox = boundingBox;
		this.codigo = codigo;
		this.nome = nome;
	}

	public BoundingBox getBoundingBox()
	{
		return this.boundingBox;
	}

	public String getCodigo()
	{
		return this.codigo;
	}

	public String getNome()
	{
		return this.nome;
	}

	public void setBoundingBox( final BoundingBox boundingBox )
	{
		this.boundingBox = boundingBox;
	}

	public void setCodigo( final String codigo )
	{
		this.codigo = codigo;
	}

	public void setNome( final String nome )
	{
		this.nome = nome;
	}

	BoundingBox boundingBox;

	String codigo;

	String nome;
}
