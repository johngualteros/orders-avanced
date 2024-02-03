package org.app.orders.ordersavanced.product.infrastructure.presentation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.app.orders.ordersavanced.product.application.create.CreateProductRequest;
import org.app.orders.ordersavanced.product.application.create.CreateProductUseCase;
import org.app.orders.ordersavanced.product.domain.entity.Product;
import org.app.orders.ordersavanced.product.infrastructure.factories.ProductFactory;
import org.app.orders.ordersavanced.product.infrastructure.presentation.CreateProductRestController;
import org.app.orders.ordersavanced.shared.domain.HttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(CreateProductRestController.class)
public class CreateProductRestControllerTests {
    @MockBean
    private CreateProductUseCase createProductUseCase;

    @Autowired
    private MockMvc mvc;

    private JacksonTester<CreateProductRequest> json;
    private JacksonTester<HttpResponse> jsonHttpResponse;
    private Product product;
    private CreateProductRequest request;

    @Before
    public void setup() {
        JacksonTester.initFields(this, new ObjectMapper());
        product = new Product("product", "description", 10, 10);
    }

    @Test
    public void badRequestWithEmptyBody() throws Exception {
        // given
        given(createProductUseCase.execute(ProductFactory.create(product)))
                .willReturn(ProductFactory.create(product));

        // when
        MockHttpServletResponse response = mvc.perform(
                post("/product/create")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertEquals(400, response.getStatus());
    }

    @Test
    public void createProduct() throws Exception {
        request = new CreateProductRequest(
                "product",
                "description",
                10,
                10
        );
        // given
        given(createProductUseCase.execute(ProductFactory.create(product)))
                .willReturn(ProductFactory.create(product));

        // when
        MockHttpServletResponse response = mvc.perform(
                        post("/product/create")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json.write(request).getJson())
                )
                .andReturn().getResponse();

        // then build the HttpResponse object
        HttpResponse httpResponse = new HttpResponse<>(request, "Product created");

        // then assert the response
        assertEquals(200, response.getStatus());
        assertEquals(jsonHttpResponse.write(httpResponse).getJson(), response.getContentAsString());
    }
}
















