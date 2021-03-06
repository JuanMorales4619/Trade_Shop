package co.edu.uco.TradeShop.dto;

import java.util.Date;

import co.edu.uco.crosscutting.util.date.UtilDate;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class PersonaDTO {
	
	private int codigo;
	private int identificacion;
	private String nombres;
	private String apellidos;
	private Date fechaNacimiento;
	private TipoIdentificacionDTO tipoIdentificacion;
	private CiudadDTO ciudad;
	private NovedadDTO novedad;
	
	public PersonaDTO() {
		super();
		setNombres(UtilText.EMPTY);
		setApellidos(UtilText.EMPTY);
		setTipoIdentificacion(new TipoIdentificacionDTO());
		setCiudad(new CiudadDTO());
		setNovedad(new NovedadDTO());
	}
	
	public PersonaDTO(int codigo, int identificacion, String nombres, String apellidos, Date fechaNacimiento,
			TipoIdentificacionDTO tipoIdentificacion, CiudadDTO ciudad, NovedadDTO novedad) {
		super();
		setCodigo(codigo);
		setIdentificacion(identificacion);
		setNombres(nombres);
		setApellidos(apellidos);
		setFechaNacimiento(fechaNacimiento);
		setTipoIdentificacion(tipoIdentificacion);
		setCiudad(ciudad);
		setNovedad(novedad);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = UtilText.getDefault(nombres);
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = UtilText.getDefault(apellidos);
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = UtilDate.getUtilDate().getDefault(fechaNacimiento);
	}
	public TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public void setTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = UtilObject.getUtilObject().getDefault(tipoIdentificacion, new TipoIdentificacionDTO());
	}
	public CiudadDTO getCiudad() {
		return ciudad;
	}
	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = UtilObject.getUtilObject().getDefault(ciudad, new CiudadDTO());
	}
	public NovedadDTO getNovedad() {
		return novedad;
	}
	public void setNovedad(NovedadDTO novedad) {
		this.novedad = UtilObject.getUtilObject().getDefault(novedad, new NovedadDTO());
	}
	
	
	
}
