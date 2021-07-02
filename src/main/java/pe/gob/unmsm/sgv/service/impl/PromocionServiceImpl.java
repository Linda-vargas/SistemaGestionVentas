package pe.gob.unmsm.sgv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.gob.unmsm.sgv.models.Promocion;
import pe.gob.unmsm.sgv.repository.impl.PromocionRepositoryImpl;
import pe.gob.unmsm.sgv.service.PromocionService;

@Service
public class PromocionServiceImpl implements PromocionService {
	
	@Autowired
	private PromocionRepositoryImpl p;
	private Logger logger =LoggerFactory.getLogger(PromocionService.class);


	@Override
	public Promocion obtenerPromocionPorId(int id) {
		
		Promocion promocion= p.obtenerPromocionPorId(id);
		
		if(promocion == null){
	        logger.error("Error al obtener Promocion: no existe la promocion '"+id+"' en el sistema");
	        throw new NoSuchElementException("LA PROMOCION CON ID " + id + "NO EXISTE");
	    }
	     
        return promocion;
	}

	@Override
	public void añadirPromocion(Promocion promocion) {
		if(promocion == null){
	        logger.error("Error al añadir Promocion: la promocion es nula");
	        throw new IllegalArgumentException("LA PROMOCION ES NULA");
	    }
		p.añadirPromocion(promocion);
	}

	@Override
	public List<Promocion> obtenerPromociones() {
		return p.obtenerPromociones();
	}

	@Override
	public void actualizarPromocion(Promocion promocion) {
		
		Promocion pr= p.obtenerPromocionPorId(promocion.getIdPromocion());
		if(pr == null){
	        logger.error("Error al actualizar Promocion: no existe la promocion '"+promocion.getIdPromocion()+"' en el sistema");
	        throw new NoSuchElementException("LA PROMOCION CON ID " + promocion.getIdPromocion() + "NO EXISTE");
	    }
		p.actualizarPromocion(promocion);
	}

	@Override
	public void eliminarPromocion(int id) {
		Promocion promocion= p.obtenerPromocionPorId(id);
		if(promocion == null){
	        logger.error("Error al eliminar Promocion: no existe la promocion '"+id+"' en el sistema");
	        throw new NoSuchElementException("LA PROMOCION CON ID " + id + "NO EXISTE");
	    }
		p.eliminarPromocion(id);
	}

}