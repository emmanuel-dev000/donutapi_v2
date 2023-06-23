package com.pangan.donutapi.repository;

import com.pangan.donutapi.model.Donut;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonutRepository extends MongoRepository<Donut, String> {
}
