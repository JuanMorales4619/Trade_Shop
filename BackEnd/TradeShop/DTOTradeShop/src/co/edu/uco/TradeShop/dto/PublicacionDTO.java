package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class PublicacionDTO {

	private int codigo;
	private String descripcion;
	private int precio;
	private int cantidad;
	private PersonaDTO vendedor;
	private TipoVentaDTO tipoVenta;
	private ProductoDTO producto;
	
	public PublicacionDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
		setVendedor(new PersonaDTO());
		setTipoVenta(new TipoVentaDTO());
		setProducto(new ProductoDTO());
	}
	
	public PublicacionDTO(int codigo, String descripcion, int precio, int cantidad, PersonaDTO vendedor, TipoVentaDTO tipoVenta, ProductoDTO producto) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
		setPrecio(precio);
		setCantidad(cantidad);
		setVendedor(vendedor);
		setTipoVenta(tipoVenta);
		setProducto(producto);
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = UtilObject.getUtilObject().getDefault(producto, new ProductoDTO());
	}
	
	
	


	
	
}
