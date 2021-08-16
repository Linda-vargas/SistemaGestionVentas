
package pe.gob.unmsm.sgv.repository;
import pe.gob.unmsm.sgv.models.Tarjeta;

public interface TarjetaRepository {
    
        public Tarjeta obtenerTarjeta(int tarjetaid, String username,String dni);   
        public int agregarTarjeta();
        public void actualizarSaldo (Tarjeta tarjeta);
        public Tarjeta tarjetbyId(String username);
        public Tarjeta tarjetbyNum(int tarjetaid);
}
