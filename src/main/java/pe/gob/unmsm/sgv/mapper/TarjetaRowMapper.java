package pe.gob.unmsm.sgv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import pe.gob.unmsm.sgv.models.Tarjeta;

public class TarjetaRowMapper implements RowMapper<Tarjeta> {

	@Override
	public Tarjeta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tarjeta us = new Tarjeta();
		us.setTarjeta_id(rs.getInt("tarjeta_id"));
		us.setFecha_vencimiento(rs.getString("fecha_vencimiento"));
            	us.setSaldo(rs.getInt("saldo"));
                us.setEstado(rs.getString("estado").charAt(0));
                us.setCreated_at(rs.getString("created_at"));
                us.setUpdated_at(rs.getString("updated_at"));
		return us;
	}	
}

