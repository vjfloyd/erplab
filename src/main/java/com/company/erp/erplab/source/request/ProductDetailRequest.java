package com.company.erp.erplab.source.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Getter
@Setter
@Data
public class ProductDetailRequest {


    @NotNull(message = "name no puede ser nul")
    @NotEmpty(message = "name no puede ser vacio")
    @Size(min=4, max= 100)
    @Pattern(regexp = "[a-zA-Z0-9_\\-]+", message = "ProductRequest.name no cumple con el " +
            "formato correcto.Debe ser Alphanumerico")
    private String name;

    @NotNull(message = "category no puede ser nulo")
    @NotEmpty(message = "category no puede ser vacio")
    @Size(min=4, max= 100)
    @Pattern(regexp = "[a-zA-Z0-9_\\-]+",message = "ProductRequest.category no cumple con el" +
            " formato correcto.Debe ser Alphanumerico")
    private String category;

    @NotNull(message = "price no puede ser nulo")
//    @Pattern(regexp = "\\d{0,2}\\.\\d{1,2}", message = "ProductRequest.name no cumple con el " +
//            "formato correcto.Debe ser Alphanumerico")
    private BigDecimal price;

    @NotNull(message = "imageUrl no puede ser nulo")
    @NotEmpty(message = "imageUrl no puede ser vacio")
    @Size(min=4, max= 100, message = "La long. debe ser entre 4 a 100 caracters")
    private String imageUrl;

    @NotNull(message = "brand no puede ser nulo")
    @NotEmpty(message = "brand no puede ser vacio")
    @Size(min=4, max= 100, message = "La long. debe ser entre 4 a 100 caracters")
    @Pattern(regexp = "[a-zA-Z0-9_ \\-]+", message = "ProductDetailRequest.brand no cumple con el " +
            "formato correcto.Debe ser Alphanumerico")
    private String brand;

    @NotNull(message = "description no puede ser nulo")
    @NotEmpty(message = "description no puede ser vacio")
    @Size(min=4, max= 400, message = "La long. debe ser entre 4 a 100 caracters")
    @Pattern(regexp = "[a-zA-Z0-9_ \\-]+",message = "ProductDetailRequest.description no cumple con el" +
            " formato correcto.Debe ser Alphanumerico")
    private String description;



}
