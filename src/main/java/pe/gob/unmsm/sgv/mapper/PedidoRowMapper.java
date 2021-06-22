package pe.gob.unmsm.sgv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.gob.unmsm.sgv.models.Pedido;

public class PedidoRowMapper implements RowMapper<Pedido> {

	@Override
	public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Pedido us = new Pedido();
		us.setPedido_id(rs.getInt("pedido_id"));
                us.setUsername(rs.getString("username"));
		us.setEstado(rs.getString("estado").charAt(0));
                us.setCreated_at(rs.getString("created_at"));
                us.setUpdated_at(rs.getString("updated_at"));
		return us;
	}	
}
