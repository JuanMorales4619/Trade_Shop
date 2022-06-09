package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.text.UtilText;

public class TipoProductoDTO {
	
	private int codigo;
	private String descripcion;
	
	public TipoProductoDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
	}
	
	public TipoProductoDTO(int codigo, String descripcion) {
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
