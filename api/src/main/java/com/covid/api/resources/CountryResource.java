package com.covid.api.resources;

import com.covid.api.dao.CountryDAO;
import com.covid.api.dto.CountryDTO;
import com.covid.api.dto.TotalDTO;
import com.covid.api.exceptions.CountryNotFoundException;
import com.covid.api.model.Country;
import com.covid.api.repository.CountryRepository;

import com.covid.api.service.ConverterService;
import com.covid.api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/")
public class CountryResource {

    private final CountryRepository countryRepository;
    private final CountryDAO countryDAO;
    private final CountryService countryService;

    CountryResource(CountryRepository countryRepository, CountryDAO countryDAO, CountryService countryService) {
        this.countryRepository = countryRepository;
        this.countryDAO = countryDAO;
        this.countryService = countryService;
    }



    @GetMapping(value = "total")
    public TotalDTO getTotals() {
        return countryService.getTotalStat();

    }

    @GetMapping(value = "parse")
    public List<Country> parse() throws Exception {
        countryRepository.saveAll(countryDAO.fetch());
        return countryRepository.findAllByOrderByCasesDesc();
    }

    @GetMapping(value = "country")
    public List<CountryDTO> getAll() {
       return countryService.getAllCountry();

    }

    @GetMapping(value = "/country/{code}")
    public CountryDTO single(@PathVariable String code) {
        return countryService.getCountryByCode(code);
    }

    @PostMapping(value = "/country/")
    public Country add(@Valid @RequestBody Country newCountry) {
        return countryRepository.save(newCountry);
    }

    @PutMapping(value = "/country/{id}")
    Country replaceCountry(@RequestBody Country newCountry, @PathVariable Long id) {

        return countryRepository.findById(id)
                .map(country -> {
                    country.setCountry(newCountry.getCountry());
                    country.setActive(newCountry.getActive());
                    return countryRepository.save(country);
                })
                .orElseGet(() -> {
                    newCountry.setId(id);
                    return countryRepository.save(newCountry);
                });
    }

    @DeleteMapping(value = "/country/{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryRepository.deleteById(id);
    }


}
