package pe.gob.unmsm.sgv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import pe.gob.unmsm.sgv.models.Producto;
import pe.gob.unmsm.sgv.repository.impl.ProductoRepositoryImpl;
import pe.gob.unmsm.sgv.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepositoryImpl ur;

	
	@Override
	public Producto obtenerProductoPorId(int productoid) {
		return ur.obtenerProductoPorId(productoid);
                
	}
	@Override
	public List<Producto> obtenerProductosPorCantidad(int cantidad) {
		return ur.obtenerProductoPorCantidad(cantidad);
                
	}

        @Override
         public void agregarProducto(Producto producto) {
             ur.agregarProducto(producto);
        }

        @Override
        public List<Producto> obtenerProductos() {
            return ur.obtenerProductos();
        }

        @Override
        public void actualizarProducto(Producto producto) {
            ur.actualizarProducto(producto);
        }

        @Override
        public void eliminarProducto(int productoid) {
            ur.eliminarProducto(productoid);
    }
       

}
