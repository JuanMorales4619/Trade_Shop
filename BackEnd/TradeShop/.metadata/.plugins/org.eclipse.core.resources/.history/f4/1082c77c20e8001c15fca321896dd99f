package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class PublicacionDTO {

	private int codigo;
	private String descripcion;
	private int precio;
	private PersonaDTO vendedor;
	private TipoVentaDTO tipoVenta;
	
	public PublicacionDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
		setVendedor(new PersonaDTO());
		setTipoVenta(new TipoVentaDTO());
	}
	
	public PublicacionDTO(int codigo, String descripcion, int precio, PersonaDTO vendedor, TipoVentaDTO tipoVenta) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
		setPrecio(precio);
		setVendedor(vendedor);
		setTipoVenta(tipoVenta);
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
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public PersonaDTO getVendedor() {
		return vendedor;
	}
	public void setVendedor(PersonaDTO vendedor) {
		this.vendedor = UtilObject.getUtilObject().getDefault(vendedor, new PersonaDTO());
	}
	public TipoVentaDTO getTipoVenta() {
		return tipoVenta;
	}
	public void setTipoVenta(TipoVentaDTO tipoVenta) {
		this.tipoVenta = UtilObject.getUtilObject().getDefault(tipoVenta, new TipoVentaDTO());
	}
	
	
	


	
	
}
