package pe.gob.unmsm.sgv.rest;
import org.springframework.beans.factory.annotation.Autowired;
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