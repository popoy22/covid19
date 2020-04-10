import { Component, OnInit, HostListener } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MdbTableDirective } from 'angular-bootstrap-md';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
  providers: [MdbTableDirective],
})
export class HomeComponent implements OnInit {
  apiData: any = [];
  dSource: any = [];
  url: string = '';
  searchText: string = '';
  previous: string;
  elements: any = [];
  headElements = ['Country', 'Cases', 'Deaths', 'Recovered'];
  interfaceTable: any = [];
  loading: any;

  constructor(private http: HttpClient, private mdbTable: MdbTableDirective) {}

  ngOnInit(): void {
    this.loadData('http://localhost:8080/api/country');
  }

  loadData(url) {
    this.elements = [];
    this.http.get(url).subscribe((data) => {
      this.dSource = data;
      this.loading = data;
      for (let i in this.dSource) {
        var x = {
          iso: this.dSource[i].countryInfo.iso2,
          country: this.dSource[i].country,
          cases: parseInt(this.dSource[i].cases),
          deaths: parseInt(this.dSource[i].deaths),
          recovered: parseInt(this.dSource[i].recovered),
          flag: this.dSource[i].countryInfo.flag,
        };
        this.elements.push(x);
        this.apiData.push(x);
      }
      this.mdbTable.setDataSource(this.elements);
    });
  }

  searchItems() {
    if (!this.searchText) {
      this.elements = this.mdbTable.getDataSource();
    }
    if (this.searchText) {
      this.elements = this.mdbTable.searchLocalDataBy(this.searchText);
    }
  }

  returZero() {
    return 0;
  }
}
