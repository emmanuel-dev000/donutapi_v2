package com.pangan.donutapi.donut;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.List;

@WebMvcTest(controllers = DonutController.class)
@AutoConfigureMockMvc(addFilters = false)
@ExtendWith(MockitoExtension.class)
class DonutControllerTest {

    @Autowired
    private DonutController donutController;

    @Test
    public void getAllDonutsList_IsNotEmpty_ShouldReturnTrue() {
        List<Donut> actualDonuts = donutController.getAllDonuts();
        final int EMPTY = 0;
        Assertions.assertNotEquals(EMPTY, actualDonuts.toArray().length);
    }
}