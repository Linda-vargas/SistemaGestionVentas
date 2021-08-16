
package pe.gob.unmsm.sgv.repository;

import java.util.List;
import pe.gob.unmsm.sgv.models.Pedido;
import pe.gob.unmsm.sgv.models.PedidoProducto;


public interface PedidoRepository {
    
        public Pedido obtenerPedidoPorId(int pedidoid);
        public int agregarPedido(String username);
        public List <Pedido> obtenerPedidos(); 
        public void actualizarPedido (Pedido pedido);
        public void eliminarPedido (int pedidoid);
        public void agregarPedidoProducto(PedidoProducto pedidoproducto);
        
}
