package pe.gob.unmsm.sgv.repository;

import java.util.List;


import pe.gob.unmsm.sgv.models.Producto;

public interface ProductoRepository {
	public Producto obtenerProductoPorId(int producto_id);
	public void añadirProducto(Producto producto);
        public List <Producto> obtenerProductos(); 
        public void actualizarProducto (Producto producto);
        public void eliminarProducto (int producto_id);
        public void actualizarStock(int producto_id,int stock);
        
}
