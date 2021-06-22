package pe.gob.unmsm.sgv.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.gob.unmsm.sgv.models.Pedido;
import pe.gob.unmsm.sgv.repository.impl.PedidoRepositoryImpl;
import pe.gob.unmsm.sgv.service.PedidoService;
@Service

public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepositoryImpl ur;

	private Logger logger =LoggerFactory.getLogger(PedidoService.class);
	
	@Override
	public Pedido obtenerPedidoPorId(int pedido_id) {
		return ur.obtenerPedidoPorId(pedido_id);
                
	}

        @Override
         public void añadirPedido(Pedido pedido) {
             ur.añadirPedido(pedido);
        }

        @Override
        public List<Pedido> obtenerPedidos() {
            return ur.obtenerPedidos();
        }

        @Override
        public void eliminarPedido(int pedido_id) {
            ur.eliminarPedido(pedido_id);
        }

        @Override
        public void actualizarPedido(Pedido pedido) {
            ur.actualizarPedido(pedido);
        }
       

}
