package pe.gob.unmsm.sgv.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.unmsm.sgv.models.Tarjeta;
import pe.gob.unmsm.sgv.repository.impl.TarjetaRepositoryImpl;

@RestController
@RequestMapping("/sgv")
public class TarjetaController {
	
	    @Autowired
	    private  TarjetaRepositoryImpl tr;
	    
		@PutMapping("/recargar")
	    public void recargar(@RequestBody Tarjeta t){
	        tr.actualizarSaldo(t);
	    }
        
        
        
               
        
}