
package pe.gob.unmsm.sgv.repository.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	private static String conn="jdbc_sgv";
	
	@Autowired
	public void fuenteDatos (DataSource setDataSource) {
		setDataSource(setDataSource);
	}
	
	@Override
        public Tarjeta obtenerTarjeta(int tarjetaid, String username,String dni) {
                JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
		String sql = "select * from tarjeta t inner join usuario u on t.tarjeta_id=u.tarjeta_id where tarjeta_id="+tarjetaid+" or username like '"+username+"%' or dni like '"+dni+"%'";
		return jdbctemplate.queryForObject(sql, new TarjetaRowMapper());
        }	
        
        
        @Override
        public int agregarTarjeta() {
            

           LocalDate dt = LocalDate.now();
            int año=dt.getYear()+2;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
            
            String sql="insert into tarjeta (fecha_vencimiento, saldo, estado, created_at, updated_at) values ('"+año+"-"+formatter.format(dt)+"',0,'1',current_timestamp,current_timestamp)";          
            String sql2= "select max(tarjeta_id) from tarjeta";
            JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
            jdbctemplate.update(sql);
            return jdbctemplate.queryForObject(sql2, Integer.class);
        }

        @Override
        public void actualizarSaldo(Tarjeta tarjeta) {
            JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
            String sql="update tarjeta set saldo="+tarjeta.getSaldo()+", updated_at=current_timestamp where tarjeta_id="+tarjeta.getTarjetaid()+"";          
            jdbctemplate.update(sql);
        }
        
        @Override
    	public Tarjeta tarjetbyId(String username) {
    		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
    		String sql="select t.* from usuario u\r\n"
    				+ "inner join tarjeta t on  t.tarjeta_id=u.tarjeta_id\r\n"
    				+ "where u.username='"+username+"'";
    		
    		return jdbctemplate.queryForObject(sql, new TarjetaRowMapper());
    	}
        
        @Override
    	public Tarjeta tarjetbyNum(int tarjetaid) {
    		JdbcTemplate jdbctemplate = context.getBean(conn, JdbcTemplate.class);
    		String sql="select * from tarjeta t \r\n"
    				+ "where t.tarjeta_id="+tarjetaid+"";
    		
    		return jdbctemplate.queryForObject(sql, new TarjetaRowMapper());
    	}
        

        
        
        
}
