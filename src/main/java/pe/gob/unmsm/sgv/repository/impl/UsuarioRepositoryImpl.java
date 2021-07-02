package pe.gob.unmsm.sgv.repository.impl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
	//@Autowired
    //private BCryptPasswordEncoder passwordEncoder;
    
	

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

        @Override
        public List<Usuario> obtenerUsuarioPorId(String username) {
                JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
		String sql="select * from usuario where username like '"+username+"%'";
		List<Usuario> u;
		u=jdbctemplate.query(sql, new UsuarioRowMapper());
		return u;
        }

        @Override
        public void añadirUsuario(Usuario usuario) {
            //String passwordBcrypt =passwordEncoder.encode(usuario.getPassword());
        	
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            LocalDate localdate = LocalDate.now();
            String sql="insert into usuario (username, password, nombre, apellido, dni, telefono, direccion, email, estado, created_at, updated_at) values ('"+ usuario.getUsername().toUpperCase()+"','"+usuario.getPassword()+"','"+usuario.getNombre().toUpperCase()+"','"+usuario.getApellido().toUpperCase()+"','"+usuario.getDni()+"','"+usuario.getTelefono()+"','"+usuario.getDireccion()+"','"+usuario.getEmail()+"','1',current_timestamp,current_timestamp)";          
            jdbctemplate.update(sql);
        }

        @Override
        public List<Usuario> obtenerUsuarios() {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            String sql="select * from usuario where estado='1'";          
            List<Usuario> usuarios = new ArrayList<Usuario> ();
            usuarios=jdbctemplate.query(sql, new UsuarioRowMapper());
            return usuarios;
        }   

        @Override
        public void actualizarUsuario(Usuario usuario) {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            LocalDate localdate = LocalDate.now();
            String sql="update usuario set  username="+"'"+ usuario.getUsername()+"',password="+"'"+usuario.getPassword()+"', dni='"+usuario.getDni()+"', nombre='"+usuario.getNombre()+"',apellido='"+usuario.getApellido()+"', telefono='"+usuario.getTelefono()+"', direccion='"+usuario.getDireccion()+"', email='"+usuario.getEmail()+"', estado='"+usuario.isEstado()+"', updated_at=current_timestamp where username='"+usuario.getUsername()+"'";          
            jdbctemplate.update(sql);
        }

        @Override
        public void eliminarUsuario(String username) {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            String sql="update usuario set estado='0' where username='"+username+"'";         
            jdbctemplate.update(sql);
        }
	
}
