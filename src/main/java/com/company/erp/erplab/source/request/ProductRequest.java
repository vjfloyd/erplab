package com.company.erp.erplab.source.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Getter
@Setter
@Data
public class ProductRequest {

//    @NotNull
//    @NotEmpty
    private Long id;


    @NotNull(message = "name no puede ser nul")
    @NotEmpty(message = "name no puede ser vacio")
    @Size(min=4, max= 100)
    @Pattern(regexp = "[a-zA-Z0-9_\\-]+", message = "ProductRequest.name no cumple con el " +
            "formato correcto.Debe ser Alphanumerico")
    private String name;

    @NotNull(message = "category no puede ser nul")
    @NotEmpty(message = "category no puede ser vacio")
    @Size(min=4, max= 100)
    @Pattern(regexp = "[a-zA-Z0-9_\\-]+",message = "ProductRequest.category no cumple con el" +
            " formato correcto.Debe ser Alphanumerico")
    private String category;

}
