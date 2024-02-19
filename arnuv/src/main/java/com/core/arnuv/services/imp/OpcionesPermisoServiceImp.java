package com.core.arnuv.services.imp;

import com.core.arnuv.model.Opcionespermiso;
import com.core.arnuv.model.OpcionespermisoId;
import com.core.arnuv.repository.IOpcionesPermisoRepository;
import com.core.arnuv.service.IOpcionesPermisoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class OpcionesPermisoServiceImp implements IOpcionesPermisoService {

	@Autowired
	private IOpcionesPermisoRepository repo;

	@Override
	public List<Opcionespermiso> listarTodos() {
		return repo.findAll();
	}

	@Override
	public Opcionespermiso insertar(Opcionespermiso data) {
		return repo.save(data);
	}

	@Override
	public Opcionespermiso actualizar(Opcionespermiso data) {
		Opcionespermiso existe = repo.findById(data.getId()).orElse(null);
		existe.setIdrol(data.getIdrol());
		existe.setIdopcionpadre(data.getIdopcionpadre());
		existe.setRecursos(data.getRecursos());
		existe.setNombre(data.getNombre());
		existe.setActivo(data.getActivo());
		existe.setMostar(data.getMostar());
		existe.setCrear(data.getCrear());
		existe.setEditar(data.getEditar());
		existe.setEliminar(data.getEliminar());

		return repo.save(existe);
	}

	@Override
	public Opcionespermiso buscarPorId(OpcionespermisoId id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Map<String, Object>> buscarTitulosMenu(int idrol) {
		var lresult = repo.buscarTitulosMenu(idrol);
		var lresponse = new ArrayList<Map<String, Object>>();
		for (Object[] obj : lresult) {
			var mapaObjeto = new HashMap<String, Object>();
			mapaObjeto.put("nombre", obj[0]);
			mapaObjeto.put("idopcion", obj[1]);
			lresponse.add(mapaObjeto);
		}

		return lresponse;
	}

	@Override
	public List<Map<String, Object>> buscarItemMenu(int idrol, Long idopcionpadre) {
		var lresult = repo.buscarItemMenu(idrol, idopcionpadre);
		var lresponse = new ArrayList<Map<String, Object>>();
		for (Object[] obj : lresult) {
			var mapaObjeto = new HashMap<String, Object>();
			mapaObjeto.put("idrol", obj[0]);
			mapaObjeto.put("idopcion", obj[1]);
			mapaObjeto.put("idmodulo", obj[2]);
			mapaObjeto.put("idrecurso", obj[3]);
			mapaObjeto.put("nombre", obj[4]);
			mapaObjeto.put("ruta", obj[5]);
			mapaObjeto.put("crear", obj[6]);
			mapaObjeto.put("editar", obj[7]);
			mapaObjeto.put("eliminar", obj[8]);
			lresponse.add(mapaObjeto);
		}

		return lresponse;
	}

	@Override
	public List<Opcionespermiso> buscarIdRol(int idrol) {
		return repo.buscarPorRol(idrol);
	}
}
