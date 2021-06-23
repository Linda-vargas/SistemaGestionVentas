package pe.gob.unmsm.sgv.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.unmsm.sgv.models.Producto;
import pe.gob.unmsm.sgv.service.ProductoService;

@RestController
@RequestMapping("/sgv")
public class ProductoController {
	
	    @Autowired
	    private  ProductoService us;
	    
	    @PostMapping("/insertarProducto")
	    public void save(@RequestBody Producto p){
	        us.añadirProducto(p);
	    }
        @GetMapping("/listar_productos")
	    public List<Producto> listar_producto(){
	        return us.obtenerProductos();
	    }
        
        @GetMapping("/buscarProductoPorId")
	    public Producto save(@RequestParam int producto_id){
        	return us.obtenerProductoPorId(producto_id);
	    }
        
        @PostMapping("/actualizarProducto")
	    public void save1(@RequestBody Producto p){
        	us.actualizarProducto(p);
	    }
        
        @PostMapping("/eliminarProducto")
	    public void save2(@RequestParam int producto_id){
        	us.eliminarProducto(producto_id);
	    }
        
               
        
}
