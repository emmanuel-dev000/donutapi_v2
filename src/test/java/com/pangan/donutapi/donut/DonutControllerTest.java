package com.pangan.donutapi.donut;

import com.pangan.donutapi.model.Donut;
import com.pangan.donutapi.controller.DonutController;
import com.pangan.donutapi.service.DonutService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@WebMvcTest(controllers = DonutController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class DonutControllerTest {

    @Autowired
    private DonutController donutController;
    @MockBean
    private DonutService donutService;

    @Test
    public void getAllDonutsList_IsNotEmpty_ShouldReturnTrue() {
        List<Donut> actualDonuts = donutService.getAllDonuts();
        final int EMPTY = 0;
        Assertions.assertNotEquals(EMPTY, actualDonuts.toArray().length);
    }
}