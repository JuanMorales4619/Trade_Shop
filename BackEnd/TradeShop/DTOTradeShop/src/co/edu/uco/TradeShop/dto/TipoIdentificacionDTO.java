package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.text.UtilText;

public class TipoIdentificacionDTO {

	private int codigo;
	private String descripcion;
	
	public TipoIdentificacionDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
	}
	
	public TipoIdentificacionDTO(int codigo, String descripcion) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
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
}
