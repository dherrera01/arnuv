package com.core.arnuv.utils;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public abstract class RespuestaComun<T> {
    public String mensaje;
    public String codigo;
    private T dto;
    private List<T> lista = new ArrayList<>();

    /**
     * Metodo que inserta los datos de una entidad JPA a una clase DTO para transferir los datos.
     * @param source   Entidad JPA
     * @param destinationType   Clase DTO destino
     * @param excludedProperties    Propiedades que no van a ser mapeadas
     */
    public void mapearDato(Object source, Class<T> destinationType, String... excludedProperties) throws Exception {
        if (source == null) {
            throw new ArnuvNotFoundException("No existe la fuente o entidad de datos");
        }
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        List<String> exclusiones = Arrays.asList(excludedProperties);
        modelMapper.getConfiguration().setPropertyCondition(context ->
                !exclusiones.contains(context.getMapping().getLastDestinationProperty().getName()));

        this.setDto(modelMapper.map(source, destinationType));
    }

    /**
     * Metodo que inserta una lista de los datos de una entidad JPA a una clase DTO para transferir los datos.
     * @param lsource   Lista de entidades JPA
     * @param destinationType   Clase DTO destino
     * @param excludedProperties    Propiedades que no van a ser mapeadas
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void setListaDto(List lsource, Class<T> destinationType, String... excludedProperties) {
        if (lsource == null || lsource.isEmpty()) return;

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        if (excludedProperties != null) {
            List<String> exclusiones = Arrays.asList(excludedProperties);
            modelMapper.getConfiguration().setPropertyCondition(context ->
                    !exclusiones.contains(context.getMapping().getLastDestinationProperty().getName()));
        }

        setLista(lsource.stream().map(o -> (T) modelMapper.map(o, destinationType)).toList());
    }
}
