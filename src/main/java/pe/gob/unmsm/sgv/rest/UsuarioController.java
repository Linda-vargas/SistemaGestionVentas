package pe.gob.unmsm.sgv.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.unmsm.sgv.models.Usuario;
import pe.gob.unmsm.sgv.service.UsuarioService;

@RestController
@RequestMapping("/sgv")
public class UsuarioController {
	
	    @Autowired
	    private  UsuarioService us;
	    
	    @Autowired
	    private BCryptPasswordEncoder passwordEncoder;
	    
	    @PostMapping("/insertarusuario")
	    public void save(@RequestBody Usuario u){
	    	u.setUsername(u.getEmail());
	    	String passwordBcrypt =passwordEncoder.encode(u.getPassword());
	    	u.setPassword(passwordBcrypt);
	        us.agregarUsuario(u);
	    }
        @GetMapping("/listar_usuarios")
	    public List<Usuario> listarusuarios(){
	        return us.obtenerUsuarios();
	    }
        
        @GetMapping("/buscarUsuarioPorId")
	    public List<Usuario> buscar(@RequestParam String username){
        	return us.obtenerUsuarioPorId(username);
	    }
        
        @PostMapping("/actualizarUsuario")
	    public void save1(@RequestBody Usuario u){
        	us.actualizarUsuario(u);
	    }
        
        @PostMapping("/eliminarUsuario")
	    public void save2(@RequestParam String username){
        	us.eliminarUsuario(username);
	    }
        
               
        
}
