package com.core.arnuv.utils;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

import java.util.Arrays;
import java.util.List;

@Data
public abstract class RequestComun<T> {

    /**
     * Metodo que inserta los datos de una entidad DTO a una clase de JPA para manejar los datos en el backend.
     * @param source   Entidad JPA
     * @param excludedProperties    Propiedades que no van a ser mapeadas
     */
    public T mapearDato(Object source, Class<T> destinationType, String... excludedProperties) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        List<String> exclusiones = Arrays.asList(excludedProperties);
        modelMapper.getConfiguration().setPropertyCondition(context ->
                !exclusiones.contains(context.getMapping().getLastDestinationProperty().getName()));

        return modelMapper.map(source, destinationType);
    }
}
