package com.company.erp.erplab.caller;


import com.company.erp.erplab.api.thirdparty.ProductResourceApi;
import com.company.erp.erplab.config.PropertiesEnv;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;


@Component
public class ProductApiCaller {

    private PropertiesEnv propertiesEnv;

    public ProductApiCaller(PropertiesEnv propertiesEnv) {
        this.propertiesEnv = propertiesEnv;
    }

    public com.company.erp.erplab.business.model.Product getProduct(Long id) throws IOException {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(propertiesEnv.getApiPath())
                .addConverterFactory(GsonConverterFactory.create()).build();
        ProductResourceApi productResourceApi = retrofit.create(ProductResourceApi.class);
        Call<com.company.erp.erplab.business.model.Product> product = productResourceApi.getProduct(id);
        return product.execute().body();
    }

}
