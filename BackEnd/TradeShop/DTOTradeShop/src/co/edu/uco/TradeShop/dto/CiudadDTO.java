package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class CiudadDTO {
	
	private int codigo;
	private String descripcion;
	private DepartamentoDTO departamento;
	
	public CiudadDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
		setDepartamento(new DepartamentoDTO());
	}
	
	public CiudadDTO(int codigo, String descripcion, PaisDTO pais) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
		setDepartamento(departamento);
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
	public DepartamentoDTO getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = UtilObject.getUtilObject().getDefault(departamento, new DepartamentoDTO());
	}
}
