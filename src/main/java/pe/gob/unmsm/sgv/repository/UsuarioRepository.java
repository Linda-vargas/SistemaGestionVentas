package pe.gob.unmsm.sgv.repository;

import java.util.List;

import pe.gob.unmsm.sgv.models.Roles;
import pe.gob.unmsm.sgv.models.Usuario;

public interface UsuarioRepository {
	public Usuario datosUsuario(String username);
	public List<Roles> roles(String username);
	public List<Usuario> obtenerUsuarioPorId(String username);
        public void agregarUsuario(Usuario usuario,int tarjetaid);
        public List <Usuario> obtenerUsuarios(); 
        public void actualizarUsuario (Usuario usuario);
        public void eliminarUsuario (String username);
        
}
