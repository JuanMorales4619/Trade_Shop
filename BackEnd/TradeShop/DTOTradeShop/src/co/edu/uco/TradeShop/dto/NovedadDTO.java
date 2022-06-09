package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class NovedadDTO {

	private int codigo;
	private String descripcion;
	private EstadoPedidoDTO estadoPedido;
	
	public NovedadDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
		setEstadoPedido(new EstadoPedidoDTO());
	}
	
	public NovedadDTO(int codigo, String descripcion, EstadoPedidoDTO estadoPedido) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
		setEstadoPedido(estadoPedido);
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
	public EstadoPedidoDTO getEstadoPedidoDTO() {
		return estadoPedido;
	}
	public void setEstadoPedido(EstadoPedidoDTO estadoPedido) {
		this.estadoPedido = UtilObject.getUtilObject().getDefault(estadoPedido, new EstadoPedidoDTO());
	}
	
	
}
