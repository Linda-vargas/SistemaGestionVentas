package pe.gob.unmsm.sgv.repository.impl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import pe.gob.unmsm.sgv.mapper.PedidoRowMapper;
import pe.gob.unmsm.sgv.models.Pedido;
import pe.gob.unmsm.sgv.models.PedidoProducto;
import pe.gob.unmsm.sgv.repository.PedidoRepository;

@Repository
public class PedidoRepositoryImpl extends JdbcDaoSupport implements PedidoRepository {
	
	@Autowired
	private ApplicationContext context;
	
	private static String CONEXION_DB="jdbc_sgv";
	
	@Autowired
	public void DataSource (DataSource setDataSource) {
		setDataSource(setDataSource);
	}
	
	

	@Override
	public Pedido obtenerPedidoPorId(int pedido_id) {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
		String sql="select * from pedido where pedido_id='"+pedido_id+"'";
		Pedido u = new Pedido();
		u=jdbctemplate.queryForObject(sql, new PedidoRowMapper());
		return u;
	}

        @Override
            public int añadirPedido(String username) {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            LocalDate localdate = LocalDate.now();
            String sql="insert into pedido (username,estado,created_at, updated_at) values ('"+ username+"','1',current_timestamp,current_timestamp)";         
            String sql2="select max(pedido_id) from pedido";
            jdbctemplate.update(sql);
            return jdbctemplate.queryForObject(sql2, Integer.class);
	}
        
        

        @Override
            public List<Pedido> obtenerPedidos() {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            String sql="select * from pedido ";          
            List<Pedido> pedidos = new ArrayList<Pedido> ();
            pedidos=jdbctemplate.query(sql, new PedidoRowMapper());
            return pedidos;
        }

        @Override
        public void actualizarPedido(Pedido pedido) {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            LocalDate localdate = LocalDate.now();
            String sql="update pedido set  pedido_id='"+ pedido.getPedido_id()+"', estado='"+pedido.getEstado()+"', updated_at=current_timestamp where pedido_id="+pedido.getPedido_id()+";";          
            jdbctemplate.update(sql);
        }

        @Override
        public void eliminarPedido(int pedido_id) {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            String sql="delete from pedido where pedido_id="+pedido_id;         
            jdbctemplate.update(sql);
        }

        @Override
        public void añadirPedidoProducto(PedidoProducto pedidoproducto) {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            LocalDate localdate = LocalDate.now();
            String sql="insert into producto_pedido (pedido_id,producto_id,cantidad) values ('"+ pedidoproducto.getPredido_id()+"','"+pedidoproducto.getProducto_id()+"',"+pedidoproducto.getCantidad()+")";         
            jdbctemplate.update(sql);
        }
	
        
        
	
}
