package org.humingk.movie.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class MovieControllerTest {

    @Test
    public void showSearchForm() throws Exception {
        MovieController movieController=new MovieController();
        MockMvc mockMvc=standaloneSetup(movieController).build();
        mockMvc.perform(get("/movie/search")).andExpect(view().name("searchForm"));
    }
}