package org.humingk.movie.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
class SearchControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void searchTips() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST, "/search_tips")
                .contentType("application/json")
                .param("keyword", "星")
                .param("offset", "0")
                .param("limit", "5")
        ).andExpect(MockMvcResultMatchers.status().isOk()).andDo(print());
    }
}