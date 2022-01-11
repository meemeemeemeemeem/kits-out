package com.kits.inms.api.expection;

import com.kits.inms.bs.exception.ApiException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SpringHandlerExceptionResolver extends DefaultHandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        if (ex instanceof ApiException) {
            ApiException exception = (ApiException) ex;
            mav.addObject("code", exception.getCode());
            mav.addObject("msg", exception.getMessage());
        } else if (ex instanceof RuntimeException) {
            mav.addObject("code", "400");
            if (ex.getMessage() == null || "".equals(ex.getMessage())) {
                mav.addObject("msg", ex.getClass().getName());
            } else {
                mav.addObject("msg", ex.getMessage());
            }
        } else if (ex != null) {
            mav.addObject("code", "500");
            if (ex.getMessage() == null || "".equals(ex.getMessage())) {
                mav.addObject("msg", ex.getClass().getName());
            } else {
                mav.addObject("msg", ex.getMessage());
            }
        } else {
            return super.resolveException(request, response, handler, ex);
        }
        return mav;
    }


}