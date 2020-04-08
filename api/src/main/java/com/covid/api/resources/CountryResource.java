package com.covid.api.resources;

import com.covid.api.dao.CountryDAO;
import com.covid.api.exceptions.CountryNotFoundException;
import com.covid.api.model.Country;
import com.covid.api.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/country")
public class CountryResource {

    private final CountryRepository countryRepository;
    private final CountryDAO countryDAO;


    @Autowired
    CountryResource(CountryRepository countryRepository, CountryDAO countryDAO){
        this.countryRepository = countryRepository;
        this.countryDAO = countryDAO;
    }

    @GetMapping(value="parse")
    public List<Country> parse() throws Exception {
        countryRepository.saveAll(countryDAO.fetch());
       return countryRepository.findAllByOrderByCasesDesc();
    }



    @GetMapping(value="")
    public List<Country> getAll(){
        return countryRepository.findAllByOrderByCasesDesc();
    }

    @GetMapping(value="/{id}")
    public Country single(@PathVariable Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new CountryNotFoundException(id));
    }

    @PostMapping(value="")
    public Country add(@Valid @RequestBody Country newCountry){
        return countryRepository.save(newCountry);
    }

    @PutMapping(value="/{id}")
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

    @DeleteMapping(value="/{id}")
    public void deleteCountry(@PathVariable Long id){
       countryRepository.deleteById(id);
    }


}
