package co.edu.uco.TradeShop.dto;

import java.util.Date;

import co.edu.uco.crosscutting.util.date.UtilDate;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class PedidoDTO {

	private int codigo;
	private String descripcion;
	private int cantidad;
	private Date fecha;
	private PersonaDTO comprador;
	private HistorialPedidoDTO historial;
	private PublicacionDTO publicacion;
	private ProductoDTO producto;
	
	public PedidoDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
		setComprador(new PersonaDTO());
		setHistorial(new HistorialPedidoDTO());
		setPublicacion(new PublicacionDTO());
		setProducto(new ProductoDTO());
	}
	
	public PedidoDTO(int codigo, String descripcion, int cantidad, Date fecha, PersonaDTO comprador,
			HistorialPedidoDTO historial, PublicacionDTO publicacion, ProductoDTO producto) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
		setCantidad(cantidad);
		setFecha(fecha);
		setComprador(comprador);
		setHistorial(historial);
		setPublicacion(publicacion);
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
		this.descripcion = descripcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = UtilDate.getUtilDate().getDefault(fecha);
	}
	public PersonaDTO getComprador() {
		return comprador;
	}
	public void setComprador(PersonaDTO comprador) {
		this.comprador = UtilObject.getUtilObject().getDefault(comprador, new PersonaDTO());
	}
	public HistorialPedidoDTO getHistorial() {
		return historial;
	}
	public void setHistorial(HistorialPedidoDTO historial) {
		this.historial = UtilObject.getUtilObject().getDefault(historial, new HistorialPedidoDTO());
	}
	public PublicacionDTO getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(PublicacionDTO publicacion) {
		this.publicacion = UtilObject.getUtilObject().getDefault(publicacion, new PublicacionDTO());
	}
	public ProductoDTO getProducto() {
		return producto;
	}
	public void setProducto(ProductoDTO producto) {
		this.producto = UtilObject.getUtilObject().getDefault(producto, new ProductoDTO());
	}
	
	
}
