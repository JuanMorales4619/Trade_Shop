package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class NovedadDTO {

	private int codigo;
	private String descripcion;
	private PersonaDTO usuario;
	
	public NovedadDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
		setUsuario(new PersonaDTO());
	}
	
	public NovedadDTO(int codigo, String descripcion, PersonaDTO usuario) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
		setUsuario(usuario);
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
	public PersonaDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(PersonaDTO usuario) {
		this.usuario = UtilObject.getUtilObject().getDefault(usuario, new PersonaDTO());
	}
	
	
}
