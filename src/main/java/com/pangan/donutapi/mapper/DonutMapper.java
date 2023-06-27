package com.pangan.donutapi.mapper;

import com.pangan.donutapi.dto.DonutDto;
import com.pangan.donutapi.dto.UpdatedDonutDto;
import com.pangan.donutapi.model.Donut;

public class DonutMapper {

    public static DonutDto mapDonutToDonutDto(Donut donut) {
        if (donut == null)
            return null;

        return new DonutDto(
                donut.getId(),
                donut.getName(),
                donut.getDescription(),
                donut.getImageUrl()
        );
    }

    public static Donut mapDonutDtoToDonut(DonutDto donutDto) {
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
