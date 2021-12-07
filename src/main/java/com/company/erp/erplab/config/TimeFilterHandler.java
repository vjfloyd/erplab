package com.company.erp.erplab.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;


@Component
@WebFilter("/*")
@Slf4j
public class TimeFilterHandler implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        Instant start = Instant.now();
        try {
            filterChain.doFilter(request, response);
        } finally {
            Instant finish = Instant.now();
            long time = Duration.between(start, finish).toMillis();
            log.info("Tiempo Respuesta => Endpoint {}: Tiempo {} ms ", ((HttpServletRequest) request).getRequestURI(),  time);
        }
    }

}

