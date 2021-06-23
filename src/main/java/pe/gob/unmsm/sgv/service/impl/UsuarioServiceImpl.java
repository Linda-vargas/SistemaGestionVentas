package pe.gob.unmsm.sgv.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import pe.gob.unmsm.sgv.models.Usuario;
import pe.gob.unmsm.sgv.repository.UsuarioRepository;
import pe.gob.unmsm.sgv.repository.impl.UsuarioRepositoryImpl;
import pe.gob.unmsm.sgv.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService,UserDetailsService {
	
	@Autowired
	private UsuarioRepositoryImpl ur;

	private Logger logger =LoggerFactory.getLogger(UsuarioService.class);
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	   
	    Usuario usuario=ur.datosUsuario(username);
	    if(usuario == null){
	        logger.error("Error en el login: no existe el usuario '"+usuario+"' en el sistema");
	        throw new UsernameNotFoundException("Error ene el login: no existe el usuario '"+usuario+"' en el sistema");
	    }
	    
	    List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol.getNombre())).peek(authority -> logger.info("Rol: "+authority.getAuthority())).collect(Collectors.toList());
	    return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
	}

	@Override
	public Usuario datosUsuario(String username) {
		
		return ur.datosUsuario(username);
	}

        @Override
        public Usuario obtenerUsuarioPorId(int idusuario) {
                return ur.obtenerUsuarioPorId(idusuario);
        }

        @Override
        public void añadirUsuario(Usuario usuario) {
                ur.añadirUsuario(usuario);
        }   

        @Override
        public List<Usuario> obtenerUsuarios() {
                return ur.obtenerUsuarios();
        }

        @Override
        public void actualizarUsuario(Usuario usuario) {
                ur.actualizarUsuario(usuario);
        }

        @Override
        public void eliminarUsuario(int idusuario) {
                ur.eliminarUsuario(idusuario);
        }

}
