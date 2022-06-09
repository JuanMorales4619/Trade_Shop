package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class ProductoDTO {

	private int codigo;
	private String nombre;
	private TipoProductoDTO tipoProducto;
	private PublicacionDTO publicacion;
	private String imagen;
	
	public ProductoDTO() {
		super();
		setNombre(UtilText.EMPTY);
		setTipoProducto(new TipoProductoDTO());
		setPublicacion(new PublicacionDTO());
		setImagen(UtilText.EMPTY);
	}
	
	public ProductoDTO(int codigo, String nombre, TipoProductoDTO tipoProducto, PublicacionDTO publicacion,
			String imagen) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
		setTipoProducto(tipoProducto);
		setPublicacion(publicacion);
		setImagen(imagen);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = UtilText.getDefault(nombre);
	}
	public TipoProductoDTO getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(TipoProductoDTO tipoProducto) {
		this.tipoProducto = UtilObject.getUtilObject().getDefault(tipoProducto, new TipoProductoDTO());
	}
	public PublicacionDTO getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(PublicacionDTO publicacion) {
		this.publicacion = UtilObject.getUtilObject().getDefault(publicacion, new PublicacionDTO());
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = UtilText.getDefault(imagen);
	}
	
	
}
