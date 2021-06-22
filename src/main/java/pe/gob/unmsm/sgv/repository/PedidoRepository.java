
package pe.gob.unmsm.sgv.repository;

import java.util.List;
import pe.gob.unmsm.sgv.models.Pedido;


public interface PedidoRepository {
    
        public Pedido obtenerPedidoPorId(int pedido_id);
        public void añadirPedido(Pedido pedido);
        public List <Pedido> obtenerPedidos(); 
        public void actualizarPedido (Pedido pedido);
        public void eliminarPedido (int pedido_id);
}
