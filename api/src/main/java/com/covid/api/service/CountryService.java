package com.covid.api.service;

import com.covid.api.dto.CountryDTO;
import com.covid.api.dto.TotalDTO;
import com.covid.api.model.Country;
import com.covid.api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ConverterService converterService;
    @Autowired
    private  TotalDTO totalDTO;


    public List<CountryDTO> getAllCountry(){
        List<Country> countries =countryRepository.findAllByOrderByCasesDesc();
        if(countries.size() != 0) {
            return countries.stream().map(converterService::convertToCountryDTO).collect(Collectors.toList());
        }else {
            return  null;
        }
    }
    public CountryDTO getCountryById(Long id){
        Country countryObj = countryRepository.findById(id).orElse(null);
        if(countryObj != null) {
            return converterService.convertToCountryDTO(countryObj);
        }else{
            return null;
        }
    }

    public CountryDTO getCountryByCode(String code){
        Country countryObj = countryRepository.findByIso2(code);
        if(countryObj != null) {
            return converterService.convertToCountryDTO(countryObj);
        }else{
            return null;
        }
    }

    public TotalDTO getTotalStat(){
        List<Country> countryObj = countryRepository.findAll();
        Integer deaths = countryObj.stream().mapToInt(obj -> obj.getDeaths()).sum();
        Integer confirmed = countryObj.stream().mapToInt(obj -> obj.getCases()).sum();
        Integer recovered = countryObj.stream().mapToInt(obj -> obj.getRecovered()).sum();
        Integer todayCases     = countryObj.stream().mapToInt(obj -> obj.getTodayCases()).sum();
        totalDTO.setDeaths(deaths.longValue());
        totalDTO.setConfirmed(confirmed.longValue());
        totalDTO.setRecovered(recovered.longValue());
        totalDTO.setTodayCases(todayCases.longValue());
        return totalDTO;
    }





}
