package pe.gob.unmsm.sgv.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.gob.unmsm.sgv.models.Producto;

public class ProductoRowMapper implements RowMapper<Producto> {

	@Override
	public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
		Producto us = new Producto();
		us.setProducto_id(rs.getInt("producto_id"));
		us.setNombre(rs.getString("nombre"));
		us.setDescripcion(rs.getString("descripcion"));
            	us.setStock(rs.getInt("stock"));
                us.setPrecio(rs.getFloat("precio"));
                us.setEstado(rs.getString("estado").charAt(0));
                us.setCreated_at(rs.getString("created_at"));
                us.setUpdated_at(rs.getString("updated_at"));
		return us;
	}	
}
