package pe.gob.unmsm.sgv.repository.impl;


import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pe.gob.unmsm.sgv.mapper.RolMapper;
import pe.gob.unmsm.sgv.mapper.UsuarioRowMapper;
import pe.gob.unmsm.sgv.models.Roles;
import pe.gob.unmsm.sgv.models.Usuario;
import pe.gob.unmsm.sgv.repository.UsuarioRepository;

@Repository
public class UsuarioRepositoryImpl extends JdbcDaoSupport implements UsuarioRepository {
	
	@Autowired
	private ApplicationContext context;
	
	private static String CONEXION_DB="jdbc_sgv";
	
	@Autowired
	public void DataSource (DataSource setDataSource) {
		setDataSource(setDataSource);
	}
	
	

	@Override
	public Usuario datosUsuario(String username) {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
		String sql="select * from usuario where username='"+username+"'";
		Usuario u = new Usuario();
		u=jdbctemplate.queryForObject(sql, new UsuarioRowMapper());
		u.setRoles(roles(username));
		return u;
	}
	
	@Override
	public List<Roles> roles(String username) {
		JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
		String sql="select r.nombre from rol r\r\n"
				+ "inner join usuario_rol u on r.rol_id=u.rol_id\r\n"
				+ "where u.username='"+username+"'";
		List<Roles> r=jdbctemplate.query(sql, new RolMapper());
		return r;
	}
	
}
