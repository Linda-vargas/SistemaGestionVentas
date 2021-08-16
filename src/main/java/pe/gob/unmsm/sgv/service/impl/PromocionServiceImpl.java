package pe.gob.unmsm.sgv.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.gob.unmsm.sgv.models.Producto;


import pe.gob.unmsm.sgv.models.Promocion;
import pe.gob.unmsm.sgv.repository.impl.PromocionRepositoryImpl;
import pe.gob.unmsm.sgv.service.PromocionService;

@Service
public class PromocionServiceImpl implements PromocionService {
	
	@Autowired
	private PromocionRepositoryImpl p;
	private Logger logger =LoggerFactory.getLogger(PromocionServiceImpl.class);
        @Autowired
	private ProductoServiceImpl ps;

        String msj1="Error al obtener Promocion: no existe la promocion {} ";
        String msj2=" NO EXISTE";
        String msj3=" La promoción con ID";
	@Override
	public Promocion obtenerPromocionPorId(int id) {
		
		Promocion promocion= p.obtenerPromocionPorId(id);
		
		if(promocion == null){
	        logger.error(msj1,id);
	        throw new NoSuchElementException(msj3+ id + msj2);
	    }
	     
        return promocion;
	}

	@Override
	public String agregarPromocion(Promocion promocion) {
		if(promocion == null){
	        logger.error("Error al añadir Promocion: la promocion es nula");
	        throw new IllegalArgumentException("LA PROMOCION ES NULA");
	    }
		Producto pr=ps.obtenerProductoPorId(promocion.getIdProducto());
		if(pr!=null) {
			p.agregarPromocion(promocion);
			return "ok";
		}else {
			return "No hemos encontrado el id del producto";
		}
	}

	@Override
	public List<Promocion> obtenerPromociones() {
		return p.obtenerPromociones();
	}

	@Override
	public void actualizarPromocion(Promocion promocion) {
		
		Promocion pr= p.obtenerPromocionPorId(promocion.getIdPromocion());
		if(pr == null){
	        logger.error(msj1,promocion.getIdPromocion());
	        throw new NoSuchElementException(msj3+ promocion.getIdPromocion() + msj2);
	    }
		p.actualizarPromocion(promocion);
	}

	@Override
	public void eliminarPromocion(int id) {
		Promocion promocion= p.obtenerPromocionPorId(id);
		if(promocion == null){
	        logger.error(msj1,id);
	        throw new NoSuchElementException(msj3 + id + msj2);
	    }
		p.eliminarPromocion(id);
	}

}