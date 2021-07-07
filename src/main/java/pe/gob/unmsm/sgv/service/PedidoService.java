package pe.gob.unmsm.sgv.service;

import java.util.List;
import pe.gob.unmsm.sgv.models.Alert;
import pe.gob.unmsm.sgv.models.Pedido;

import pe.gob.unmsm.sgv.models.Producto;

public interface PedidoService {
        public Pedido obtenerPedidoPorId(int pedido_id);
        public List <Pedido> obtenerPedidos(); 
        public void actualizarPedido (Pedido pedido);
        public void eliminarPedido (int pedido_id);
        public Alert realizarPago(List<Producto> productos, String username);
}
