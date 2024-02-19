package com.core.arnuv.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class InterceptorArnuv implements HandlerInterceptor {

    private static Logger log = LoggerFactory.getLogger(InterceptorArnuv.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Este método se ejecuta antes de que se maneje la solicitud.
        // Puedes realizar acciones como la validación previa a la manipulación.
        return true; // Devuelve true para permitir que la solicitud continúe, o false para detenerla.
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("[postHandle][" + request + "]");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // Este método se ejecuta después de que se ha completado la manipulación de la solicitud.
        // Puedes realizar acciones finales o limpiar recursos.
    }

}
