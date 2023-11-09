package request;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

 class RequestBase {
     RequestSpecification request = new RequestSpecBuilder()
             .addHeader("Content-Type", "application/json")
             .addHeader("api_key", "special-key")
             .setBaseUri("https://petstore.swagger.io/v2")
             .build();

     RequestSpecification requestWithFormData = new RequestSpecBuilder()
             .addHeader("api_key", "special-key")
             .setBaseUri("https://petstore.swagger.io/v2")
             .build();
}
