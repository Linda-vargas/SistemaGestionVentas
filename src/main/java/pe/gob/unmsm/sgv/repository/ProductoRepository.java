package pe.gob.unmsm.sgv.repository;

import java.util.List;


import pe.gob.unmsm.sgv.models.Producto;

public interface ProductoRepository {
	public Producto obtenerProductoPorId(int productoid);
	public void agregarProducto(Producto producto);
        public List <Producto> obtenerProductos(); 
        public void actualizarProducto (Producto producto);
        public void eliminarProducto (int productoid);
        public void actualizarStock(int productoid,int stock);
        public List<Producto> obtenerProductoPorCantidad(int cantidad);
        
}
