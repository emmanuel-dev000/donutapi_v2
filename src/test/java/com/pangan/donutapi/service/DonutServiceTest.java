package com.pangan.donutapi.service;

import com.pangan.donutapi.controller.DonutController;
import com.pangan.donutapi.dto.DonutDto;
import com.pangan.donutapi.model.Donut;
import com.pangan.donutapi.repository.DonutRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DonutServiceTest {

    @Mock
    private DonutRepository donutRepository;

    @InjectMocks
    private DonutService donutService;

    @Test
    public void donutSerive_AddNewDonut_ShouldReturnDonutDto() {
        DonutDto donutDto = new DonutDto("ID", "Name", "Description", "ImageUrl");

        Donut donut = new Donut("ID", "Name", "Description", "ImageUrl");

        when(donutRepository.save(Mockito.any(Donut.class))).thenReturn(donut);

        DonutDto savedDonutDto = donutService.addNewDonut(donutDto);

        Assertions.assertThat(savedDonutDto).isNotNull();
    }
}