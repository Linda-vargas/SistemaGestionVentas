package pe.gob.unmsm.sgv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import pe.gob.unmsm.sgv.models.Tarjeta;

public class TarjetaRowMapper implements RowMapper<Tarjeta> {

	@Override
	public Tarjeta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tarjeta us = new Tarjeta();
		us.setTarjetaid(rs.getInt("tarjeta_id"));
		us.setFechavencimiento(rs.getString("fecha_vencimiento"));
            	us.setSaldo(rs.getInt("saldo"));
                us.setEstado(rs.getString("estado").charAt(0));
                us.setCreatedat(rs.getString("created_at"));
                us.setUpdatedat(rs.getString("updated_at"));
		return us;
	}	
}

