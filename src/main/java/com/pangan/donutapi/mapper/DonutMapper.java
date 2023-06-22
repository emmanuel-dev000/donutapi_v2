package com.pangan.donutapi.mapper;

import com.pangan.donutapi.dto.DonutDto;
import com.pangan.donutapi.model.Donut;

import java.util.Optional;

public class DonutMapper {

    public static DonutDto mapDonutToDto(Donut donut) {
        if (donut == null)
            return null;

        return new DonutDto(
                donut.getId(),
                donut.getName(),
                donut.getDescription(),
                donut.getImageUrl()
        );
    }

    public static Donut mapDtoToDonut(DonutDto donutDto) {
        if (donutDto == null)
            return null;

        return new Donut(
                donutDto.id(),
                donutDto.name(),
                donutDto.description(),
                donutDto.imageUrl()
        );
    }
}
