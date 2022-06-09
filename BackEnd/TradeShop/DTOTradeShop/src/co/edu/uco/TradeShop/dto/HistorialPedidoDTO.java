package co.edu.uco.TradeShop.dto;

import java.util.Date;

import co.edu.uco.crosscutting.util.object.UtilObject;

public class HistorialPedidoDTO {

	private int codigo;
	private Date fecha;
	private PersonaDTO vendedor;
	private PersonaDTO comprador;
	
	public HistorialPedidoDTO() {
		super();
		setFecha(fecha);
		setVendedor(new PersonaDTO());
		setComprador(new PersonaDTO());
	}
	
	public HistorialPedidoDTO(int codigo, Date fecha, PersonaDTO vendedor, PersonaDTO comprador) {
		super();
		setCodigo(codigo);
		setFecha(fecha);
		setVendedor(vendedor);
		setComprador(comprador);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public PersonaDTO getVendedor() {
		return vendedor;
	}
	public void setVendedor(PersonaDTO vendedor) {
		this.vendedor = UtilObject.getUtilObject().getDefault(vendedor, new PersonaDTO());
	}
	public PersonaDTO getComprador() {
		return comprador;
	}
	public void setComprador(PersonaDTO comprador) {
		this.comprador = UtilObject.getUtilObject().getDefault(comprador, new PersonaDTO());
	}
	
	
}
