package pe.gob.unmsm.sgv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import pe.gob.unmsm.sgv.models.Alert;


import pe.gob.unmsm.sgv.models.Pedido;
import pe.gob.unmsm.sgv.models.PedidoProducto;
import pe.gob.unmsm.sgv.models.Producto;
import pe.gob.unmsm.sgv.models.Tarjeta;
import pe.gob.unmsm.sgv.repository.impl.PedidoRepositoryImpl;
import pe.gob.unmsm.sgv.repository.impl.ProductoRepositoryImpl;
import pe.gob.unmsm.sgv.repository.impl.TarjetaRepositoryImpl;
import pe.gob.unmsm.sgv.service.PedidoService;
@Service
public class PedidoServiceImpl implements PedidoService {
	
	@Autowired
	PedidoRepositoryImpl ur;
        
        @Autowired
	ProductoRepositoryImpl pr;
        
        @Autowired
	TarjetaRepositoryImpl tj;

	
	@Override
	public Pedido obtenerPedidoPorId(int pedidoid) {
		return ur.obtenerPedidoPorId(pedidoid);
                
	}

        @Override
        public List<Pedido> obtenerPedidos() {
            return ur.obtenerPedidos();
        }

        @Override
        public void eliminarPedido(int pedidoid) {
            ur.eliminarPedido(pedidoid);
        }

        @Override
        public void actualizarPedido(Pedido pedido) {
            ur.actualizarPedido(pedido);
        }

        @Override
        public Alert realizarPago(List<Producto> productos, String username) {
        Alert alerta= new Alert();
            float total=0;
        
            for(int i=0;i<productos.size();i++){
            Producto prod = productos.get(i);
            total+=prod.getPrecio()*prod.getCantidad();                     
        }
                              
           
           Tarjeta tarjeta= tj.obtenerTarjeta(0, username, null);
           float monto=tarjeta.getSaldo()-total;
           if(monto>=0){
               
               for(int i=0;i<productos.size();i++){
                Producto prod = productos.get(i);
                PedidoProducto pedprod= new PedidoProducto();
                pedprod.setPedidoid(ur.agregarPedido(username));
                ur.agregarPedidoProducto(pedprod);
                int stock=0;
                stock=prod.getStock()-prod.getCantidad(); 
                pr.actualizarStock(prod.getProductoid(),stock);
            
        }
               tarjeta.setSaldo(monto);
               tj.actualizarSaldo(tarjeta);
               alerta.setMensaje("Pago realizado exitosamente");
               alerta.setMensajeti("Realizar Pago");
               alerta.setInfo("success");
               
           }else {
               alerta.setMensaje("Salgo insuficiente");
               alerta.setMensajeti("Realizar Pago");
               alerta.setInfo("error");
           }
           
               
           return alerta;
             
        }

        
       

}
