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

import pe.gob.unmsm.sgv.models.Pedido;
import pe.gob.unmsm.sgv.models.Tarjeta;
import pe.gob.unmsm.sgv.repository.impl.PedidoRepositoryImpl;
import pe.gob.unmsm.sgv.repository.impl.TarjetaRepositoryImpl;
import pe.gob.unmsm.sgv.service.PedidoService;

@RestController
@RequestMapping("/sgv")
public class PedidoController {
	
	    @Autowired
	    private  PedidoService us;
	    
	    @Autowired
	    private  PedidoRepositoryImpl ur;
	    
	    @Autowired
	    private  TarjetaRepositoryImpl tr;
	    
	    
        @GetMapping("/listar_pedidos")
	    public List<Pedido> listar_pedidos(){
	        return us.obtenerPedidos();
	    }
        
        @GetMapping("/buscarPedidoPorId")
	    public Pedido save(@RequestParam int pedido_id){
        	return us.obtenerPedidoPorId(pedido_id);
	    }
        
        @GetMapping("/añadirPedido")
	    public void añadir(@RequestParam String u){
        	ur.añadirPedido(u);
	    }
        
        @PostMapping("/actualizarPedido")
	    public void save1(@RequestBody Pedido u){
        	us.actualizarPedido(u);
	    }
        
        @PostMapping("/eliminarPedido")
	    public void save2(@RequestParam int pedido_id){
        	us.eliminarPedido(pedido_id);
	    }
        
        @GetMapping("/tarjetabyUser")
	    public Tarjeta tarjetabyUser(@RequestParam String username){
	        return tr.tarjetbyId(username);
	    }
        
        @GetMapping("/tarjetabyId")
	    public Tarjeta tarjetabyNum(@RequestParam int tarjeta_id){
	        return tr.tarjetbyNum(tarjeta_id);
	    }
        
               
        
}