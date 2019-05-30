package org.humingk.movie.controller;

import org.humingk.movie.baseTest;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class MovieControllerTest extends baseTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before()
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

    }


    @Test
    public void subject() {
        MvcResult result = null;
        try {
            result = mockMvc.perform(
                    MockMvcRequestBuilders.get("/subject/1889243"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            logger.info(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addMovieAll() {
        MvcResult result = null;
        try {
            result = mockMvc.perform(
                    MockMvcRequestBuilders.get("/subject/1889243"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            logger.info(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getBtbtdyResource() {
        MvcResult result = null;
        try {
            result = mockMvc.perform(
                    MockMvcRequestBuilders.get("/subject/1889243"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            logger.info(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getLoldyttResource() {
        MvcResult result = null;
        try {
            result = mockMvc.perform(
                    MockMvcRequestBuilders.get("/subject/1889243"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            logger.info(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateRate() {
        MvcResult result = null;
        try {
            result = mockMvc.perform(
                    MockMvcRequestBuilders.get("/subject/1889243"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            logger.info(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateImdbid() {
        MvcResult result = null;
        try {
            result = mockMvc.perform(
                    MockMvcRequestBuilders.get("/subject/1889243"))
                    .andExpect(MockMvcResultMatchers.status().is(200))
                    .andDo(MockMvcResultHandlers.print())
                    .andReturn();
            logger.info(result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}