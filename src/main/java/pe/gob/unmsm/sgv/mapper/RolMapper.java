package pe.gob.unmsm.sgv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.gob.unmsm.sgv.models.Roles;



public class RolMapper implements RowMapper<Roles> {

	@Override
	public Roles mapRow(ResultSet rs, int rowNum) throws SQLException {
		Roles rol = new Roles();
		rol.setNombre(rs.getString("nombre"));
		
		return rol;
	}

}
