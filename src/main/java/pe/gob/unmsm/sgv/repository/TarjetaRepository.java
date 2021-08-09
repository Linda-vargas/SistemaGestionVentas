
package pe.gob.unmsm.sgv.repository;
import pe.gob.unmsm.sgv.models.Tarjeta;

public interface TarjetaRepository {
    
        public Tarjeta obtenerTarjeta(int tarjeta_id, String username,String dni);   
        public int añadirTarjeta();
        public void actualizarSaldo (Tarjeta tarjeta);
        public Tarjeta tarjetbyId(String username);
        public Tarjeta tarjetbyNum(int tarjeta_id);
}
