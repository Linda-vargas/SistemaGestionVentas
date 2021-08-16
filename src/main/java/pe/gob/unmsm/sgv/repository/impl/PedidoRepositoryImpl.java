package pe.gob.unmsm.sgv.repository.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import static org.apache.tomcat.jni.User.username;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
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
	
	private static String conn="jdbc_sgv";
	
	@Autowired
	public void fuenteDatos (DataSource setDataSource) {
		setDataSource(setDataSource);
	}
	
	/*@Override
	public Pedido obtenerPedidoPorId(int pedidoid) {
		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		String sql="select * from pedido where pedido_id='"+pedidoid+"'";
		return jdbctemplate.queryForObject(sql, new PedidoRowMapper());
        }*/   
        
        private SimpleJdbcCall obtenerPedidosp;
        //IndexOutOfBoundsException
        @SuppressWarnings("unchecked")
		@Override
        public Pedido obtenerPedidoPorId(int pedidoid) {
            JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);        
            try{
            obtenerPedidosp = new SimpleJdbcCall(jdbctemplate)
                   .withProcedureName("obtenerpedido")
                   .returningResultSet("po_cursor", new PedidoRowMapper());
                  SqlParameterSource input=new MapSqlParameterSource().addValue("_pedido_id", pedidoid);

              Map<String, Object> out = obtenerPedidosp.execute(input);
              List<Pedido> p=(List<Pedido>) out.get("po_cursor");
                  
             return p.get(0) ;
            }catch( EmptyResultDataAccessException ex){                    
                    throw new EmptyResultDataAccessException("El pedido con id: "+pedidoid+" no existe",1);
                }catch(IndexOutOfBoundsException e){
                    throw new IndexOutOfBoundsException("Pedido con id : "+pedidoid+" invalido");
                }
            
        }        
	
        
        

        @Override
            public int agregarPedido(String username) {
            JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
            String sql="insert into pedido (username,estado,created_at, updated_at) values ('"+ username+"','1',current_timestamp,current_timestamp)";         
            String sql2="select max(pedido_id) from pedido";
            jdbctemplate.update(sql);
            return jdbctemplate.queryForObject(sql2, Integer.class);
	}
        
        

        @Override
            public List<Pedido> obtenerPedidos() {
            JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
            String sql="select * from pedido ";          
            return jdbctemplate.query(sql, new PedidoRowMapper());
        }

        @Override
        public void actualizarPedido(Pedido pedido) {
            JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
            String sql="update pedido set  pedido_id='"+ pedido.getPedidoid()+"', estado='"+pedido.getEstado()+"', updated_at=current_timestamp where pedido_id="+pedido.getPedidoid()+";";          
            jdbctemplate.update(sql);
        }

        @Override
        public void eliminarPedido(int pedidoid) {
            JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
            String sql="delete from pedido where pedido_id="+pedidoid;         
            jdbctemplate.update(sql);
        }

        @Override
        public void agregarPedidoProducto(PedidoProducto pedidoproducto) {
            JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
            String sql="insert into producto_pedido (pedido_id,producto_id,cantidad) values ('"+ pedidoproducto.getPedidoid()+"','"+pedidoproducto.getProductoid()+"',"+pedidoproducto.getCantidad()+")";         
            jdbctemplate.update(sql);
        }
	
        
        
	
}
