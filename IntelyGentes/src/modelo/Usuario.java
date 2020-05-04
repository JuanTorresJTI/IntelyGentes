package modelo;

public class Usuario {
	private String dni;
	private String nombre;
	private String apellidos;
	private String telefono;
	private String contrasena;
	private String email;
	private boolean superuser;
	
	public Usuario(String dni, String nombre, String apellidos, String telefono, String contrasena, String email, boolean superuser) {
		this.dni = dni ;
		this.nombre = nombre;
		this.apellidos = apellidos ; 
		this.telefono = telefono;
		this.contrasena = contrasena;
		this.email = email;
		this.superuser = superuser;
	}
	
	public Usuario () {
		this.dni = null;
		this.nombre = null;
		this.apellidos = null;
		this.telefono = null;
		this.contrasena = null;
		this.email = null;
		this.superuser = false;
	}
	
	//GETTERS
	public String getApellidos() {
		return apellidos;
	}
	public String getContrasena() {
		return contrasena;
	}
	public String getDni() {
		return dni;
	}
	public String getEmail() {
		return email;
	}
	public String getNombre() {
		return nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public boolean isSuperuser() {
		return superuser;
	}
	
	//SETTERS
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setSuperuser(boolean superuser) {
		this.superuser = superuser;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
