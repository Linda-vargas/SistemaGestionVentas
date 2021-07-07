
package pe.gob.unmsm.sgv.repository.impl;

import java.time.LocalDate;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import pe.gob.unmsm.sgv.mapper.TarjetaRowMapper;
import pe.gob.unmsm.sgv.models.Tarjeta;
import pe.gob.unmsm.sgv.repository.TarjetaRepository;



@Repository
public class TarjetaRepositoryImpl extends JdbcDaoSupport implements TarjetaRepository {
	
	@Autowired
	private ApplicationContext context;
	
	private static String CONEXION_DB="jdbc_sgv";
	
	@Autowired
	public void DataSource (DataSource setDataSource) {
		setDataSource(setDataSource);
	}
	
	@Override
        public Tarjeta obtenerTarjeta(int tarjeta_id, String username,String dni) {
                JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
		String sql = "select * from tarjeta t inner join usuario u on t.tarjeta_id=u.tarjeta_id where tarjeta_id="+tarjeta_id+" or username like '"+username+"%' or dni like '"+dni+"%'";
		Tarjeta u = new Tarjeta();
		u=jdbctemplate.queryForObject(sql, new TarjetaRowMapper());
		return u;
        }	
        
        
        @Override
        public int añadirTarjeta() {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            LocalDate localdate = LocalDate.now();
            int año=localdate.getYear()+2;
            String sql="insert into tarjeta (fecha_vencimiento, saldo, estado, created_at, updated_at) values (to_char("+localdate.getDayOfMonth()+"-"+localdate.getMonth()+"-"+año+" 'dd-mm-yyyy'),current_timestamp,current_timestamp)";          
            String sql2= "select max(tarjeta_id) from tarjeta";
            jdbctemplate.update(sql);
            return jdbctemplate.queryForObject(sql2, Integer.class);
        }

        @Override
        public void actualizarSaldo(Tarjeta tarjeta) {
            JdbcTemplate jdbctemplate = context.getBean(CONEXION_DB, JdbcTemplate.class);
            String sql="update tarjeta set saldo="+ tarjeta.getSaldo()+", updated_at=current_timestamp where tarjeta_id="+tarjeta.getTarjeta_id()+"";          
            jdbctemplate.update(sql);
        }
        
        
        
        
}
