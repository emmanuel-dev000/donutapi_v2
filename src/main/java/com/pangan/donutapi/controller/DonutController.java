package com.pangan.donutapi.controller;

import com.pangan.donutapi.dto.DonutDto;
import com.pangan.donutapi.dto.UpdatedDonutDto;
import com.pangan.donutapi.model.Donut;
import com.pangan.donutapi.service.DonutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v2/donuts")
public class DonutController {
    private final DonutService donutService;

    @Autowired
    public DonutController(DonutService donutService) {
        this.donutService = donutService;
    }

    @GetMapping
    public ResponseEntity<List<Donut>> getAllDonuts() {
        List<Donut> donutList = donutService.getAllDonuts();
        return new ResponseEntity<>(donutList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonutDto> getDonutById(@PathVariable("id") String id) {
        DonutDto donutDto = donutService.getDonutById(id);
        return new ResponseEntity<>(donutDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DonutDto> addNewDonut(@RequestBody DonutDto donutDto) {
        DonutDto savedDonutDto = donutService.addNewDonut(donutDto);
        return new ResponseEntity<>(savedDonutDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDonutById(@PathVariable("id") String id) {
        String deleteMessage = donutService.deleteDonutById(id);
        return new ResponseEntity<>(deleteMessage, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Donut> updateDonutById(@PathVariable("id") String id, @RequestBody UpdatedDonutDto updatedDonut) {
        Donut donut = donutService.updateDonutById(id, updatedDonut);
        return new ResponseEntity<>(donut, HttpStatus.OK);
    }
}
