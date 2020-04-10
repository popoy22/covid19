package com.covid.api.dto;

import org.springframework.stereotype.Component;

@Component
public class CountryInfoDTO {

        public Long _id;
        public String iso2;
        public String iso3;
        public Integer lat;
        public Integer lng;
        public String flag;

        public Long get_id() {
                return _id;
        }

        public void set_id(Long _id) {
                this._id = _id;
        }

        public String getIso2() {
                return iso2;
        }

        public void setIso2(String iso2) {
                this.iso2 = iso2;
        }

        public String getIso3() {
                return iso3;
        }

        public void setIso3(String iso3) {
                this.iso3 = iso3;
        }

        public Integer getLat() {
                return lat;
        }

        public void setLat(Integer lat) {
                this.lat = lat;
        }

        public Integer getLng() {
                return lng;
        }

        public void setLng(Integer lng) {
                this.lng = lng;
        }

        public String getFlag() {
                return flag;
        }

        public void setFlag(String flag) {
                this.flag = flag;
        }
}
