package com.kits.log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.turbo.TurboFilter;
import ch.qos.logback.core.spi.FilterReply;
import com.bstek.bdf2.core.context.ContextHolder;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import javax.servlet.http.HttpSession;

public class LogInterceptor extends TurboFilter {

    String marker;
    Marker markerToAccept;

    @Override
    public FilterReply decide(Marker marker, Logger logger, Level level, String format, Object[] params, Throwable t) {
        if (level.levelInt > Level.DEBUG_INT) {
            String username = null;
            HttpSession session = ContextHolder.getHttpSession();
            if (session != null) {
                username = ContextHolder.getLoginUserName();
            }
            MDC.put("pathPrefix", username);
        }
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }

        if ((markerToAccept.equals(marker))) {
            return FilterReply.ACCEPT;
        } else {
            return FilterReply.NEUTRAL;
        }
    }

    @Override
    public void start() {
        if (marker != null && marker.trim().length() > 0) {
            markerToAccept = MarkerFactory.getMarker(marker);
            super.start();
        }
    }

    public String getMarker() {
        return marker;
    }

    public void setMarker(String markerStr) {
        this.marker = markerStr;
    }
}
