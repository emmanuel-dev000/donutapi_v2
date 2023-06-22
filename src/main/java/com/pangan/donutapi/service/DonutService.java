package com.pangan.donutapi.service;

import com.pangan.donutapi.DonutRepository;
import com.pangan.donutapi.dto.DonutDto;
import com.pangan.donutapi.mapper.DonutMapper;
import com.pangan.donutapi.model.Donut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonutService {

    private final DonutRepository donutRepository;

    @Autowired
    public DonutService(DonutRepository donutRepository) {
        this.donutRepository = donutRepository;
    }

    public DonutDto addNewDonut(DonutDto donutDto) {
        Donut donut = DonutMapper.mapDtoToDonut(donutDto);
        donutRepository.save(donut);
        return donutDto;
    }

    public List<Donut> getAllDonuts() {
        return donutRepository.findAll();
    }
}
