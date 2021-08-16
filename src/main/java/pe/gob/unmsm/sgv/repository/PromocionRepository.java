
package pe.gob.unmsm.sgv.repository;

import java.util.List;

import pe.gob.unmsm.sgv.models.Promocion;

public interface PromocionRepository {
	
    public Promocion obtenerPromocionPorId(int id);
    public void agregarPromocion(Promocion promocion);
    public List <Promocion> obtenerPromociones(); 
    public void actualizarPromocion (Promocion promocion);
    public void eliminarPromocion (int id);
    

}