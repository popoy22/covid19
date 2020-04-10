package com.covid.api.service;

import com.covid.api.dto.CountryDTO;
import com.covid.api.model.Country;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {

    @Autowired
    ModelMapper modelMapper;

    public  CountryDTO convertToCountryDTO(Country countryObj){

        CountryDTO targetDTO = new CountryDTO();
        TypeMap<Country, CountryDTO> typeMap = modelMapper.getTypeMap(Country.class, CountryDTO.class);

        if(typeMap == null) {
            modelMapper.addMappings(new PropertyMap<Country, CountryDTO>() {
                @Override
                protected void configure() {
                    map().getCountryInfo().set_id(source.getId());
                    map().getCountryInfo().setIso2(source.getIso2());
                    map().getCountryInfo().setIso3(source.getIso3());
                    map().getCountryInfo().setFlag(source.getFlag());
                    map().getCountryInfo().setLat(source.getLat());
                    map().getCountryInfo().setLng(source.getLng());
                }
            });
        }
        modelMapper.map(countryObj, targetDTO);
        modelMapper.validate();
        return targetDTO;


    }



}
