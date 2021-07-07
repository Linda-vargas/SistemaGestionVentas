<<<<<<< HEAD
package pe.gob.unmsm.sgv.service;

import java.util.List;

import pe.gob.unmsm.sgv.models.Promocion;

public interface PromocionService {
	public Promocion obtenerPromocionPorId(int id);
	public void añadirPromocion(Promocion promocion);
    public List <Promocion> obtenerPromociones(); 
    public void actualizarPromocion (Promocion promocion);
    public void eliminarPromocion (int id);
}
=======
package pe.gob.unmsm.sgv.service;

import java.util.List;

import pe.gob.unmsm.sgv.models.Promocion;

public interface PromocionService {
	public Promocion obtenerPromocionPorId(int id);
	public void añadirPromocion(Promocion promocion);
    public List <Promocion> obtenerPromociones(); 
    public void actualizarPromocion (Promocion promocion);
    public void eliminarPromocion (int id);
}
>>>>>>> 6822c2cb6e7dc87e16d946a778476d6b7272c2d8
