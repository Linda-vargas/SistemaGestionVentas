package pe.gob.unmsm.sgv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.gob.unmsm.sgv.models.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario us = new Usuario();
		us.setUsername(rs.getString("username"));
		us.setPassword(rs.getString("password"));
		us.setNombre(rs.getString("nombre"));
        us.setApellidos(rs.getString("apellido"));
		return us;
	}	
}
