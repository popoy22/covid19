package com.covid.api.repository;

import com.covid.api.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {

    public List<Country> findAllByOrderByCasesDesc();
}
