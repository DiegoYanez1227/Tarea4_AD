package alumno;

import java.util.Date;

public class Alumno {

	private Integer nia;
	private String nombre;
	private String apellidos;
	private Date fecha;
	private Character genero;
	private String ciclo;
	private String curso;
	private String grupo;
	
	
	public Alumno() {
	}
	public Alumno(Integer nia, String nombre,String apellidos, Date fecha, Character genero,String ciclo, String curso, String grupo) {
		
		this.nia = nia;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.genero = genero;
		this.ciclo = ciclo;
		this.curso = curso;
		this.grupo = grupo;
		this.genero = genero;
		this.fecha = fecha;
	}
	
	
	public Integer getNia() {
		return nia;
	}
	public void setNia(Integer nia) {
		this.nia = nia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Character getGenero() {
		return genero;
	}
	public void setGenero(Character genero) {
		this.genero = genero;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	@Override
	public String toString() {
		return "Alumno [nia=" + nia + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha=" + fecha
				+ ", genero=" + genero + ", ciclo=" + ciclo + ", curso=" + curso + ", grupo=" + grupo + "]";
	}
	
}
