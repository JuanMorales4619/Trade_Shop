package co.edu.uco.TradeShop.dto;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class EstadoPedidoDTO {

	private int codigo;
	private String descripcion;
	private NovedadDTO novedad;
	private PedidoDTO pedido;
	
	public EstadoPedidoDTO() {
		super();
		setDescripcion(UtilText.EMPTY);
		setNovedad(new NovedadDTO());
		setPedido(new PedidoDTO());
	}
	
	public EstadoPedidoDTO(int codigo, String descripcion, NovedadDTO novedad, PedidoDTO pedido) {
		super();
		setCodigo(codigo);
		setDescripcion(descripcion);
		setNovedad(novedad);
		setPedido(pedido);
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
	public NovedadDTO getNovedad() {
		return novedad;
	}
	public void setNovedad(NovedadDTO novedad) {
		this.novedad = UtilObject.getUtilObject().getDefault(novedad, new NovedadDTO());
	}
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = UtilObject.getUtilObject().getDefault(pedido, new PedidoDTO());
	}
	
	
}
