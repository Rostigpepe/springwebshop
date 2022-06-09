/*package com.example.springwebshop.order;

import com.example.springwebshop.model.Orders;
import com.example.springwebshop.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OrderControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository mockRepo;

    //Just initializing objects to use tests on
    @BeforeEach
    void initEach(){
        Orders o1 = new Orders(1L, 1L, 1L);
        Orders o2 = new Orders(2L, 1L, 2L);
        Orders o3 = new Orders(3L, 1L, 3L);
        Orders o4 = new Orders(4L, 2L, 1L);
        Orders o5 = new Orders(5L, 3L, 3L);
        Orders o6 = new Orders(6L, 3L, 2L);

        //Defining what should happen when the repos methods are called
        //For getAllOrders test
        when(mockRepo.findAll()).thenReturn(List.of(o1,o2,o3,o4,o5,o6));
        //For getOrderWithId test
        when(mockRepo.findById(4L)).thenReturn(java.util.Optional.of(o4));
        //For getOrdersWithCustomerId test
        when(mockRepo.findAllByCustomerId(1L)).thenReturn(Optional.of(List.of(o1,o2,o3)));
    }

    //Testing getting all orders
    @Test
    void getAllOrders() throws Exception {
        LocalDate today = LocalDate.now();

        mockMvc.perform(get("/orders").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        //Defining what json array is to be expected
                       "[" +
                               "{\"id\":1,\"customerId\":1,\"itemId\":1,\"orderDate\":\""+today+"\"}," +
                               "{\"id\":2,\"customerId\":1,\"itemId\":2,\"orderDate\":\""+today+"\"}," +
                               "{\"id\":3,\"customerId\":1,\"itemId\":3,\"orderDate\":\""+today+"\"}," +
                               "{\"id\":4,\"customerId\":2,\"itemId\":1,\"orderDate\":\""+today+"\"}," +
                               "{\"id\":5,\"customerId\":3,\"itemId\":3,\"orderDate\":\""+today+"\"}," +
                               "{\"id\":6,\"customerId\":3,\"itemId\":2,\"orderDate\":\""+today+"\"}" +
                               "]" ));
    }



    @Test
    void getOrderWithId() throws Exception {
        LocalDate today = LocalDate.now();

        mockMvc.perform(get("/orders/order/4").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\":4,\"customerId\":2,\"itemId\":1,\"orderDate\":\""+today+"\"}"
                        ));

        //Testing that the exception if id doesn't exist pops
        assertThatThrownBy(() ->
                mockMvc.perform(get("/orders/order/10")
                        .accept(MediaType.APPLICATION_JSON)))
                .isExactlyInstanceOf(NestedServletException.class);

    }

    @Test
    void getOrderWithCustomerId() throws Exception {
        LocalDate today = LocalDate.now();

        mockMvc.perform(get("/orders/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[" +
                                "{\"id\":1,\"customerId\":1,\"itemId\":1,\"orderDate\":\""+today+"\"}," +
                                "{\"id\":2,\"customerId\":1,\"itemId\":2,\"orderDate\":\""+today+"\"}," +
                                "{\"id\":3,\"customerId\":1,\"itemId\":3,\"orderDate\":\""+today+"\"}" +
                                "]"
                ));

        //Testing that the exception if id doesn't exist pops
        assertThatThrownBy(() ->
                mockMvc.perform(get("/orders/10")
                        .accept(MediaType.APPLICATION_JSON)))
                .isExactlyInstanceOf(NestedServletException.class);

    }

}*/
