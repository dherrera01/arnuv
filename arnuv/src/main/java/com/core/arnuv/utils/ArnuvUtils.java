package com.core.arnuv.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class ArnuvUtils {

    public static <T> Collection convertirLista(List lsource, Class<T> destinationType, String... excludedProperties) {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.getConfiguration().setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);

        if (excludedProperties != null) {
            List<String> exclusiones = Arrays.asList(excludedProperties);
            modelMapper.getConfiguration().setPropertyCondition(context ->
                    !exclusiones.contains(context.getMapping().getLastDestinationProperty().getName()));
        }

        return lsource.stream().map(o -> (T) modelMapper.map(o, destinationType)).toList();
    }

    public static <T> T convertirObjeto(Object source, Class<T> destinationType, String... excludedProperties) {

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
