package org.enricogiurin.poc.springdatajpa.rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
import org.enricogiurin.poc.springdatajpa.entity.CommentEntity;
import org.enricogiurin.poc.springdatajpa.entity.PostEntity;
import org.enricogiurin.poc.springdatajpa.service.PostService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@WebMvcTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = {PostController.class})
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    PostService postService;
    static final String URL = "/v1/post";

    @Test
    void find() throws Exception {

        //given
        when(postService.find(1L)).thenReturn(buildPost());
        //when-then
        MvcResult mvcResult = this.mockMvc.perform(get(URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.content").value("post comment"))
                .andExpect(jsonPath("$.comments[0].content").value("comment one"))
                .andExpect(jsonPath("$.comments[1].content").value("comment two"))
                .andReturn();
        //String contentAsString = mvcResult.getResponse().getContentAsString();
    }

    PostEntity buildPost(){
        PostEntity postEntity = PostEntity.builder()
                .content("post comment")
                .build();
        LinkedList<CommentEntity> comments = new LinkedList<>();
        comments.add(CommentEntity.builder()
                .content("comment one")
                .build());
        comments.add(CommentEntity.builder()
                .content("comment two")
                .build());
        postEntity.setComments(comments);
        return postEntity;

    }

    @BeforeEach
    void setUp() {

    }
}