package pe.gob.unmsm.sgv.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.unmsm.sgv.models.Usuario;
import pe.gob.unmsm.sgv.service.UsuarioService;

@RestController
@RequestMapping("/sgv")
public class UsuarioController {
	
	    @Autowired
	    private  UsuarioService us;
	    
	    @PostMapping("/insertarusuario")
	    public void save(@RequestBody Usuario u){
	        us.añadirUsuario(u);
	    }
	    
	
}
