package pe.gob.unmsm.sgv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.gob.unmsm.sgv.models.Promocion;

public class PromocionRowMapper implements RowMapper<Promocion> {

	@Override
	public Promocion mapRow(ResultSet rs, int rowNum) throws SQLException {
		Promocion us = new Promocion();
		us.setIdPromocion(rs.getInt("idPromocion"));
		us.setNombre(rs.getString("nombre"));
		us.setDescripcion(rs.getString("descripcion"));
        us.setCantidad(rs.getInt("cantidad"));
        us.setFechainicio(rs.getString("fecha_inicio"));
        us.setFechafin(rs.getString("fecha_fin"));
        us.setCosto(rs.getFloat("costo"));
        us.setEstado(rs.getString("estado").charAt(0));
        us.setCreatedat(rs.getString("created_at"));
        us.setUpdatedat(rs.getString("updated_at"));
		return us;
	}	
}

