package com.core.arnuv.service;

import java.util.List;

import com.core.arnuv.model.MascotaDetalle;

public interface IMascotaDetalleService {

	List<MascotaDetalle> listarMascotasDetalle();

	public MascotaDetalle insertarMascotaDetalle(MascotaDetalle data);
	
	public MascotaDetalle actualizarMascotaDetalle(MascotaDetalle data);

	public MascotaDetalle buscarPorId(Long id);
}
