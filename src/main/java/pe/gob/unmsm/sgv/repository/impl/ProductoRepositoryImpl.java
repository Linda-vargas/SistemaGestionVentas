package pe.gob.unmsm.sgv.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import pe.gob.unmsm.sgv.mapper.ProductoRowMapper;
import pe.gob.unmsm.sgv.models.Producto;
import pe.gob.unmsm.sgv.repository.ProductoRepository;

@Repository
public class ProductoRepositoryImpl extends JdbcDaoSupport implements ProductoRepository {
	
	@Autowired
	private ApplicationContext context;
	
	private static String CONEXION_DB="jdbc_sgv";
	
	@Autowired
	public void DataSource (DataSource setDataSource) {
		setDataSource(setDataSource);
	}
	
	@Override
	public Producto obtenerProductoPorId(int producto_id) {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
		String sql = "select * from producto where producto_id="+producto_id+"";
		Producto u = new Producto();
		u=jdbctemplate.queryForObject(sql, new ProductoRowMapper());
		return u;
	}

    @Override
        public void añadirProducto(Producto producto) {
        JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="insert into producto (nombre, descripcion, stock, precio, estado,created_at, updated_at) values ('"+ producto.getNombre()+"','"+producto.getDescripcion()+"',"+producto.getStock()+","+producto.getPrecio()+",'"+producto.isEstado()+"',current_timestamp,current_timestamp)";           
        jdbctemplate.update(sql);
	}
        
    @Override
        public List<Producto> obtenerProductos() {
        JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="select * from producto ";          
        List<Producto> productos = new ArrayList<Producto> ();
        productos=jdbctemplate.query(sql, new ProductoRowMapper());
        return productos;
    }
<<<<<<< HEAD

    @Override
    public void actualizarProducto(Producto producto) {
        JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="update producto set  nombre='"+ producto.getNombre()+"',descripcion='"+producto.getDescripcion()+"', stock="+producto.getStock()+", precio="+producto.getPrecio()+", estado='"+producto.isEstado()+"', updated_at=current_timestamp where producto_id="+producto.getProducto_id()+"";           
        jdbctemplate.update(sql);
    }

    @Override
=======

    @Override
    public void actualizarProducto(Producto producto) {
        JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="update producto set  nombre='"+ producto.getNombre()+"',descripcion='"+producto.getDescripcion()+"', stock="+producto.getStock()+", precio="+producto.getPrecio()+", estado='"+producto.isEstado()+"', updated_at=current_timestamp where producto_id="+producto.getProducto_id()+"";           
        jdbctemplate.update(sql);
    }

    @Override
>>>>>>> 6822c2cb6e7dc87e16d946a778476d6b7272c2d8
    public void eliminarProducto(int producto_id) {
        JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="delete from producto where producto_id="+producto_id;         
        jdbctemplate.update(sql);
    }
	
    @Override
    public void actualizarStock(int producto_id,int stock) {
        JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="update producto set  stock="+stock+" where producto_id="+producto_id+"";           
        jdbctemplate.update(sql);
    }
}
