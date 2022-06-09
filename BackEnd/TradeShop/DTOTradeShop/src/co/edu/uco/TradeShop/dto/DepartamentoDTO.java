package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class DepartamentoDTO {

	private int codigo;
	private String descripcion;
	private PaisDTO pais;
	
	public DepartamentoDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
		setPais(new PaisDTO());
	}
	
	public DepartamentoDTO(int codigo, String descripcion, PaisDTO pais) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
		setPais(pais);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = UtilText.getDefault(descripcion);
	}
	public PaisDTO getPais() {
		return pais;
	}
	public void setPais(PaisDTO pais) {
		this.pais = UtilObject.getUtilObject().getDefault(pais, new PaisDTO());
	}
	
	
}
