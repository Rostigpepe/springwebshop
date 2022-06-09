/*package com.example.springwebshop.customer;

import com.example.springwebshop.model.Customer;
import com.example.springwebshop.repository.CustomerRepository;
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

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerIntegrationTest {
    private final LocalDate yearAgo = LocalDate.now().minusYears(1);
    private final Map<String, String> c5Map = new HashMap<>();


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository mockRepo;


    @BeforeEach
    void initEach(){
        Customer c1 = new Customer(1L, "Robin", "Robin@gmail.com", yearAgo);
        Customer c2 = new Customer(2L, "Erin", "Erin@gmail.com", yearAgo);
        Customer c3 = new Customer(3L, "Will", "Will@gmail.com", yearAgo);
        Customer c4 = new Customer(4L, "Jakob", "Jakob@gmail.com", yearAgo);
        c5Map.put("name", "Wilhelm");
        c5Map.put("email", "Wilhelm@gmail.com");
        c5Map.put("birthday", yearAgo.toString());



        when(mockRepo.findAll()).thenReturn(List.of(c1,c2,c3,c4));
        when(mockRepo.findById(2L)).thenReturn(java.util.Optional.of(c2));
    }


    @Test
    void getAllCustomers() throws Exception {

        mockMvc.perform(get("/customers").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[" +
                                "{\"id\":1,\"name\":\"Robin\",\"email\":\"Robin@gmail.com\",\"birthday\":\""+yearAgo+"\",\"age\":1}," +
                                "{\"id\":2,\"name\":\"Erin\",\"email\":\"Erin@gmail.com\",\"birthday\":\""+yearAgo+"\",\"age\":1}," +
                                "{\"id\":3,\"name\":\"Will\",\"email\":\"Will@gmail.com\",\"birthday\":\""+yearAgo+"\",\"age\":1}," +
                                "{\"id\":4,\"name\":\"Jakob\",\"email\":\"Jakob@gmail.com\",\"birthday\":\""+yearAgo+"\",\"age\":1}" +
                                "]"));

    }

    @Test
    void getCustomerById() throws Exception {

        mockMvc.perform(get("/customers/2").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\":2,\"name\":\"Erin\",\"email\":\"Erin@gmail.com\",\"birthday\":\""+yearAgo+"\",\"age\":1}"
                ));

        //Testing that the exception if id doesn't exist pops
        assertThatThrownBy(() ->
                mockMvc.perform(get("/customers/5")
                        .accept(MediaType.APPLICATION_JSON)))
                .isExactlyInstanceOf(NestedServletException.class);

    }


    @Test
    void registerNewCustomer() throws Exception{

        System.out.println(new JSONObject(c5Map));

        mockMvc.perform(post("/customers")
                        .content(String.valueOf(new JSONObject(c5Map)))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}*/
