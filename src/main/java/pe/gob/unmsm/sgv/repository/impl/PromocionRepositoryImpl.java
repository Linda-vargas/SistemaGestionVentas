
package pe.gob.unmsm.sgv.repository.impl;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import pe.gob.unmsm.sgv.mapper.PromocionRowMapper;
import pe.gob.unmsm.sgv.models.Promocion;
import pe.gob.unmsm.sgv.repository.PromocionRepository;

@Repository
public class PromocionRepositoryImpl extends JdbcDaoSupport implements PromocionRepository {
	
	@Autowired
	private ApplicationContext context;
	
	private static String CONEXION_DB="jdbc_sgv";
	
	@Autowired
	public void DataSource (DataSource setDataSource) {
		setDataSource(setDataSource);
	}

	@Override
	public Promocion obtenerPromocionPorId(int id) {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
		String sql="select * from promocion where idPromocion = "+id;
		Promocion p =  new Promocion();
		p=jdbctemplate.queryForObject(sql, new PromocionRowMapper());
		return p;
	}

	@Override
	public void añadirPromocion(Promocion promocion) {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="insert into promocion (nombre, descripcion, cantidad, fecha_inicio, fecha_fin, costo, estado, created_at, updated_at) values ('"+ promocion.getNombre().toUpperCase()+"','"+promocion.getDescripcion()+"',"+promocion.getCantidad()+",'"+promocion.getFecha_inicio()+"','"+promocion.getFecha_fin()+"',"+promocion.getCosto()+",'1',current_timestamp,current_timestamp)";          
        jdbctemplate.update(sql);
     
        sql = "select max(idPromocion) from promocion";
		int idProducto= jdbctemplate.queryForObject(sql,(rs, rowNum) ->
                rs.getInt("max")             
        );
		
		sql ="insert into producto_promocion (producto_id, idPromocion ) values ("+promocion.getIdProducto()+","+idProducto+")";
        jdbctemplate.update(sql);

	}

	@Override
	public List<Promocion> obtenerPromociones() {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="select * from promocion where estado='1'";          
        List<Promocion> promociones = new ArrayList<Promocion> ();
        promociones=jdbctemplate.query(sql, new PromocionRowMapper());
        return promociones;
	}

	@Override
	public void actualizarPromocion(Promocion promocion) {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="update promocion set nombre="+"'"+ promocion.getNombre().toUpperCase()+"',descripcion="+"'"+promocion.getDescripcion()+"', cantidad="+promocion.getCantidad()+", fecha_inicio='"+promocion.getFecha_inicio()+"',fecha_fin='"+promocion.getFecha_fin()+"', costo="+promocion.getCosto()+", estado='1', updated_at=current_timestamp where idPromocion="+promocion.getIdPromocion()+"";          
        jdbctemplate.update(sql);
        
	}

	@Override
	public void eliminarPromocion(int id) {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
        String sql="update promocion set estado='0' where idPromocion="+id;         
        jdbctemplate.update(sql);
	}
	
}