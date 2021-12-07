package com.company.erp.erplab.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PropertiesEnv {

    @Value("${api.third-services.product-api.base-url}")
    private String apiPath;

}
