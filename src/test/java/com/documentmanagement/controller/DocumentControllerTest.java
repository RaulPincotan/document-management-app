package com.documentmanagement.controller;

import com.documentmanagement.domain.entity.Document;
import com.documentmanagement.service.DocumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class DocumentControllerTest {

    private MockMvc mockMvc;

    @Mock
    private DocumentService documentService;

    @InjectMocks
    private DocumentController documentController;

    @BeforeEach()
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(documentController)
                .build();
    }

    @Test
    @DisplayName("""
            WHEN documentController.getDocuments is called
            THEN GET documents endpoint should be called
            """)
    void getDocuments() throws Exception {

        Mockito.when(documentService.getDocuments("R"))
                .thenReturn(List.of(Document.builder()
                        .id(1L)
                        .totalPages(23)
                        .author("Raul")
                        .name("Electricity Bill")
                        .classification("Invoice")
                        .build()));

        MvcResult response = mockMvc.perform(get("/documents?author=R"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Electricity Bill"))
                .andExpect(jsonPath("$[0].classification").value("Invoice"))
                .andExpect(jsonPath("$[0].totalPages").value(23))
                .andExpect(jsonPath("$[0].author").value("Raul"))
                .andReturn();
    }
}