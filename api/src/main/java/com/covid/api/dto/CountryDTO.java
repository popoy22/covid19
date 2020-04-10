package com.covid.api.dto;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CountryDTO {

    private Long id;
    private String country;

    private Long updated;
    private Integer cases;
    private Integer todayCases;
    private Integer deaths;
    private Integer todayDeaths;
    private Integer recovered;
    private Integer active;
    private Integer critical;
    private Float casesPerOneMillion;
    private Float deathsPerOneMillion;
    private Integer tests;
    private Float testsPerOneMillion;
    private Date dateUpdated;
    private CountryInfoDTO countryInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getUpdated() {
        return updated;
    }

    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    public Integer getCases() {
        return cases;
    }

    public void setCases(Integer cases) {
        this.cases = cases;
    }

    public Integer getTodayCases() {
        return todayCases;
    }

    public void setTodayCases(Integer todayCases) {
        this.todayCases = todayCases;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(Integer todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public Integer getRecovered() {
        return recovered;
    }

    public void setRecovered(Integer recovered) {
        this.recovered = recovered;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getCritical() {
        return critical;
    }

    public void setCritical(Integer critical) {
        this.critical = critical;
    }

    public Float getCasesPerOneMillion() {
        return casesPerOneMillion;
    }

    public void setCasesPerOneMillion(Float casesPerOneMillion) {
        this.casesPerOneMillion = casesPerOneMillion;
    }

    public Float getDeathsPerOneMillion() {
        return deathsPerOneMillion;
    }

    public void setDeathsPerOneMillion(Float deathsPerOneMillion) {
        this.deathsPerOneMillion = deathsPerOneMillion;
    }

    public Integer getTests() {
        return tests;
    }

    public void setTests(Integer tests) {
        this.tests = tests;
    }

    public Float getTestsPerOneMillion() {
        return testsPerOneMillion;
    }

    public void setTestsPerOneMillion(Float testsPerOneMillion) {
        this.testsPerOneMillion = testsPerOneMillion;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public CountryInfoDTO getCountryInfo() {
        return countryInfo;
    }

    public void setCountryInfo(CountryInfoDTO countryInfo) {
        this.countryInfo = countryInfo;
    }
}
