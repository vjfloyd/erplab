package com.company.erp.erplab.api.thirdparty;

import com.company.erp.erplab.business.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ProductResourceApi {

    @Headers({ "Accept: application/json" })
    @GET("/api/v1/product/{id}")
    Call<Product> getProduct(@Path("id") Long id);


}
