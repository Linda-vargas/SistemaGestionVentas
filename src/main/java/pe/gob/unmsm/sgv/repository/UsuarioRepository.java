package pe.gob.unmsm.sgv.repository;

import java.util.List;

import pe.gob.unmsm.sgv.models.Roles;
import pe.gob.unmsm.sgv.models.Usuario;

public interface UsuarioRepository {
	public Usuario datosUsuario(String username);
	public List<Roles> roles(String username);
}
