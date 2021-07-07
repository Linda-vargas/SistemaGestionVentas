package pe.gob.unmsm.sgv.models;

import java.util.List;

public class Usuario {
	
	private String username;
	private String password;
	private String nombre;
	private String apellido;
	private String dni;
        private String telefono;
	private String direccion;
	private String email;
	private char estado;
        private int tarjeta_id;
	private List<Roles> roles;
	
	
	
	public List<Roles> getRoles() {
		return roles;
	}
	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

        public int getTarjeta_id() {
                return tarjeta_id;
        }

        public void setTarjeta_id(int tarjeta_id) {
             this.tarjeta_id = tarjeta_id;
        }
 
	public char isEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

        public String getTelefono() {
        return telefono;
        }

        public void setTelefono(String telefono) {
        this.telefono = telefono;
        }
              
        public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
