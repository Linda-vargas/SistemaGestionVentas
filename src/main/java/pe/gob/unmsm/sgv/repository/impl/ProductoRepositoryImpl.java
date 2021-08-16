package pe.gob.unmsm.sgv.repository.impl;


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
	
	private static String conn="jdbc_sgv";
	
	@Autowired
	public void fuenteDatos (DataSource setDataSource) {
		setDataSource(setDataSource);
	}
	
	@Override
	public Producto obtenerProductoPorId(int productoid) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		String sql = "select * from producto where producto_id="+productoid+"";
		return jdbctemplate.queryForObject(sql, new ProductoRowMapper());
	}
	
	@Override
	public List<Producto> obtenerProductoPorCantidad(int cantidad) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		String sql = "select * from producto where stock<="+cantidad+"";
		return jdbctemplate.query(sql, new ProductoRowMapper());
	}

    @Override
        public void agregarProducto(Producto producto) {
        JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        String sql="insert into producto (nombre, descripcion, stock, precio, estado,created_at, updated_at) values ('"+ producto.getNombre().toUpperCase()+"','"+producto.getDescripcion().toUpperCase()+"',"+producto.getStock()+","+producto.getPrecio()+",'1',current_timestamp,current_timestamp)";           
        jdbctemplate.update(sql);
	}
        
    @Override
        public List<Producto> obtenerProductos() {
        JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        String sql="select * from producto ";          
        return jdbctemplate.query(sql, new ProductoRowMapper());
    }

    @Override
    public void actualizarProducto(Producto producto) {
        JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        String sql="update producto set  nombre='"+ producto.getNombre()+"',descripcion='"+producto.getDescripcion()+"', stock="+producto.getStock()+", precio="+producto.getPrecio()+", estado='"+producto.isEstado()+"', updated_at=current_timestamp where producto_id="+producto.getProductoid()+"";           
        jdbctemplate.update(sql);
    }

    @Override
    public void eliminarProducto(int productoid) {
        JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        String sql="delete from producto where producto_id="+productoid;         
        jdbctemplate.update(sql);
    }
	
    @Override
    public void actualizarStock(int productoid,int stock) {
        JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
        String sql="update producto set  stock="+stock+" where producto_id="+productoid+"";           
        jdbctemplate.update(sql);
    }
}
