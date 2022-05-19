package com.example.springwebshop.item;

import com.example.springwebshop.customer.Customer;
import com.example.springwebshop.customer.CustomerRepository;
import org.json.JSONObject;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerIntegrationTest {
    private final Map<String, String> newItem = new HashMap<>();
    private final Map<String, String> newOrder = new HashMap<>();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemRepository mockRepo;

    @MockBean
    private CustomerRepository customerMockRepo;



    @BeforeEach
    void initEach(){
        Item i1 = new Item(1L, "Chair", 500);
        Item i2 = new Item(2L, "Mug", 50);
        Item i3 = new Item(3L, "Tree", 5000);
        Item i4 = new Item(4L, "Comb", 100);

        Customer c1 = new Customer(4L, "Robin", "Robin@gmail.com", LocalDate.now());

        newItem.put("name", "Glass");
        newItem.put("price", "10000");

        newOrder.put("itemId", "1");
        newOrder.put("customerId", "4");


        when(customerMockRepo.existsById(4L)).thenReturn(true);
        when(mockRepo.existsById(1L)).thenReturn(true);

        when(mockRepo.findAll()).thenReturn(List.of(i1,i2,i3,i4));
        when(mockRepo.findById(2L)).thenReturn(Optional.of(i2));
    }


    @Test
    void getAllItems() throws Exception {

        mockMvc.perform(get("/items").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[" +
                                "{\"id\":1,\"name\":\"Chair\",\"price\":500,\"priceClass\":50}," +
                                "{\"id\":2,\"name\":\"Mug\",\"price\":50,\"priceClass\":5}," +
                                "{\"id\":3,\"name\":\"Tree\",\"price\":5000,\"priceClass\":500}," +
                                "{\"id\":4,\"name\":\"Comb\",\"price\":100,\"priceClass\":10}" +
                                "]"));
    }


    @Test
    void getCustomerById() throws Exception {

        mockMvc.perform(get("/items/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\":2,\"name\":\"Mug\",\"price\":50,\"priceClass\":5}"
                ));

        //Testing that the exception if id doesn't exist pops
        assertThatThrownBy(() ->
                mockMvc.perform(get("/items/5")
                        .accept(MediaType.APPLICATION_JSON)))
                .isExactlyInstanceOf(NestedServletException.class);

    }

    @Test
    void createNewItem() throws Exception{

        System.out.println(new JSONObject(newItem));

        mockMvc.perform(post("/items")
                        .content(String.valueOf(new JSONObject(newItem)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    void createNewOrder() throws Exception{

        System.out.println(new JSONObject(newOrder));

        mockMvc.perform(post("/items/buy")
                        .content(String.valueOf(new JSONObject(newOrder)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
