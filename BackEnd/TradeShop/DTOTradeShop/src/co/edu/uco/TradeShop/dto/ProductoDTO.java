package co.edu.uco.TradeShop.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class ProductoDTO {

	private int codigo;
	private String nombre;
	private String tipoProducto;
	private String imagen;
	
	public ProductoDTO() {
		super();
		setNombre(UtilText.EMPTY);
		setTipoProducto(UtilText.EMPTY);
		setImagen(UtilText.EMPTY);
	}
	
	public ProductoDTO(int codigo, String nombre, String tipoProducto,
			String imagen) {
		super();
		setCodigo(codigo);
		setNombre(nombre);
		setTipoProducto(tipoProducto);
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
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = UtilText.getDefault(tipoProducto);
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = UtilText.getDefault(imagen);
	}
	
	public void validationName(List<String> validationMessages){
		validationMessages = UtilObject.getUtilObject().getDefault(validationMessages, new ArrayList<>());
		
		if(UtilText.isEmpty(getNombre())) {
			validationMessages.add("Name of id product is required!!!");
		}else if(UtilText.getDefault(getNombre()).length() > 20) {
			validationMessages.add("Lenght of name of product must be less or equals to 20 characters!!!");
		}else if(!UtilText.getDefault(getNombre()).matches("^[a-zA-ZÒ—·¡È…ÌÕÛ”˙⁄ ]*$")) {
			validationMessages.add("Name of product contains invalid characters!!!");
		}
	}
}



