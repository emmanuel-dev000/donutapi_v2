package com.pangan.donutapi.service;

import com.pangan.donutapi.repository.DonutRepository;
import com.pangan.donutapi.dto.DonutDto;
import com.pangan.donutapi.mapper.DonutMapper;
import com.pangan.donutapi.model.Donut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonutService {

    public static final String DELETE_ERROR_MESSAGE = "Didn't find donut with id: ";
    public static final String DELETE_SUCCESSFUL_MESSAGE = "Donut was successfully deleted.";
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

    public DonutDto getDonutById(String id) {
        Optional<Donut> donutOptional = donutRepository.findById(id);
        if (donutOptional.isEmpty())
            return null;

        return DonutMapper.mapDonutToDto(donutOptional.get());
    }

    public String deleteDonutById(String id) {
        Optional<Donut> donutOptional = donutRepository.findById(id);
        if (donutOptional.isEmpty())
            return DELETE_ERROR_MESSAGE + id;

        donutRepository.deleteById(id);
        return DELETE_SUCCESSFUL_MESSAGE;
    }

    public DonutDto updateDonutById(String id, DonutDto updatedDonut) {
        Donut donut = donutRepository.findById(id).get();

        donut.setId(updatedDonut.id());
        donut.setName(updatedDonut.name());
        donut.setDescription(updatedDonut.description());
        donut.setImageUrl(updatedDonut.imageUrl());

        donutRepository.save(donut);
        return DonutMapper.mapDonutToDto(donut);
    }
}
