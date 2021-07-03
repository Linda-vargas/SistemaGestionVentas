package pe.gob.unmsm.sgv.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import pe.gob.unmsm.sgv.models.Promocion;
import pe.gob.unmsm.sgv.service.PromocionService;

@RestController
@RequestMapping("/sgv/promociones")
public class PromocionController {
	
	    @Autowired
	    private  PromocionService ps;
	    
		@PostMapping(value = "")
	    public void savePromocion(@RequestBody Promocion p){
	        ps.añadirPromocion(p);
	    }
        @GetMapping("")
	    public ResponseEntity<List<Promocion>> listAll(){
	        return ResponseEntity.ok(ps.obtenerPromociones());
	    }
        
        @GetMapping("/{id}")
	    public  ResponseEntity<Promocion> getById(@RequestParam int idPromocion){
        	return ResponseEntity.ok(ps.obtenerPromocionPorId(idPromocion));
	    }
        
        @PutMapping(value = "/{id}")
	    public void updatePromocion(@RequestParam int idPromocion,@RequestBody Promocion p){
        	ps.actualizarPromocion(p);
	    }
        
        @DeleteMapping(value = "/{id}")
	    public void deletePromocion(@RequestParam int idPromocion){
        	ps.eliminarPromocion(idPromocion);
	    }
        
               
        
}