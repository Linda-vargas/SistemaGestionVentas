package pe.gob.unmsm.sgv.service;

import java.util.List;
import pe.gob.unmsm.sgv.models.Producto;

public interface ProductoService {
	public Producto obtenerProductoPorId(int productoid);
        public void agregarProducto(Producto producto);
        public List <Producto> obtenerProductos(); 
        public List <Producto> obtenerProductosPorCantidad(int cantidad); 
        public void actualizarProducto (Producto producto);
        public void eliminarProducto (int productoid);
}
