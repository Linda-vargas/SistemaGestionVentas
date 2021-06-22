package pe.gob.unmsm.sgv.service;

import java.util.List;
import pe.gob.unmsm.sgv.models.Usuario;

public interface UsuarioService {
	public Usuario datosUsuario(String username);
        public Usuario obtenerUsuarioPorId(int idusuario);
        public void añadirUsuario(Usuario usuario);
        public List <Usuario> obtenerUsuarios(); 
        public void actualizarUsuario (Usuario usuario);
        public void eliminarUsuario (int idusuario);
}
