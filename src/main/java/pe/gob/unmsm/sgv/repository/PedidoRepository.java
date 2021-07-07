
package pe.gob.unmsm.sgv.repository;

import java.util.List;
import pe.gob.unmsm.sgv.models.Pedido;
import pe.gob.unmsm.sgv.models.PedidoProducto;


public interface PedidoRepository {
    
        public Pedido obtenerPedidoPorId(int pedido_id);
        public int añadirPedido(String username);
        public List <Pedido> obtenerPedidos(); 
        public void actualizarPedido (Pedido pedido);
        public void eliminarPedido (int pedido_id);
        public void añadirPedidoProducto(PedidoProducto pedidoproducto);
        
}
