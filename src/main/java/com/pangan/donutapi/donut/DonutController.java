package com.pangan.donutapi.donut;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("api/v1/donuts")
public class DonutController {

    static final String IMAGE_URL_1 = "https://images.unsplash.com/photo-1626094309830-abbb0c99da4a?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1632&q=80";
    @GetMapping
    public List<Donut> getAllDonuts() {
        Donut a = new Donut("ID 1", "Donut", "A sweet and round donut.", IMAGE_URL_1);
        List<Donut> donuts = new ArrayList<>();
        donuts.add(a);
        System.out.println(donuts.size());
        return donuts;
    }
}
