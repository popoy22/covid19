package com.covid.api.dao;


import com.covid.api.model.Country;
import com.covid.api.repository.CountryRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CountryDAO {

    @Autowired
    NetworkDAO networkDAO;
    CountryRepository countryRepository;

    public List<Country> fetch() throws Exception {

        // Variables

        List<Country> allCountryModel = new ArrayList<Country>();

        String rawJSON = networkDAO.request("https://corona.lmao.ninja/countries?sort=country");

        //JSONObject root = new JSONObject(rawJSON);
        JSONArray countries = new JSONArray(rawJSON);

        for (int i = 0; i < countries.length(); i++) {
            Country country = new Country();
            JSONObject jsonCountry = countries.getJSONObject(i);

            String country_name = jsonCountry.getString("country");
            Long updated = jsonCountry.optLong("updated");
            Integer cases = jsonCountry.getInt("cases");
            Integer todayCases = jsonCountry.getInt("todayCases");
            Integer deaths = jsonCountry.getInt("deaths");
            Integer todayDeaths = jsonCountry.getInt("todayDeaths");
            Integer recovered = jsonCountry.getInt("recovered");
            Integer active = jsonCountry.getInt("active");
            Integer critical = jsonCountry.getInt("critical");
            Float casesPerOneMillion = jsonCountry.optFloat("casesPerOneMillion", 0);
            Float deathsPerOneMillion = jsonCountry.optFloat("deathsPerOneMillion", 0);
            Integer tests = jsonCountry.getInt("tests");
            Float testsPerOneMillion = jsonCountry.optFloat("testsPerOneMillion", 0);

            JSONObject countryInfo = jsonCountry.getJSONObject("countryInfo");
            country.setId(countryInfo.optLong("_id", 0));
            country.set_id(countryInfo.optInt("_id", 0));
            country.setIso2(countryInfo.optString("iso2", null));
            country.setIso3(countryInfo.optString("iso3"));
            country.setLat(countryInfo.optInt("lat"));
            country.setLng(countryInfo.optInt("long"));
            country.setFlag(countryInfo.optString("flag"));
            country.setCountry(country_name);
            country.setUpdated(updated);
            country.setCases(cases);
            country.setTodayCases(todayCases);
            country.setDeaths(deaths);
            country.setTodayDeaths(todayDeaths);
            country.setRecovered(recovered);
            country.setActive(active);
            country.setCritical(critical);
            country.setCasesPerOneMillion(casesPerOneMillion);
            country.setDeathsPerOneMillion(deathsPerOneMillion);
            country.setTests(tests);
            country.setTestsPerOneMillion(testsPerOneMillion);
            Timestamp ts = new Timestamp(updated);
            Date date = new Date(ts.getTime());
            country.setDateUpdated(date);
            allCountryModel.add(country);
        }


        return allCountryModel;
    }


}
