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
	public Producto obtenerProductoPorId(int producto_id) {
		return ur.obtenerProductoPorId(producto_id);
                
	}

        @Override
         public void añadirProducto(Producto producto) {
             ur.añadirProducto(producto);
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
        public void eliminarProducto(int producto_id) {
            ur.eliminarProducto(producto_id);
    }
       

}
