import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-graph',
  templateUrl: './graph.component.html',
  styleUrls: ['./graph.component.scss'],
})
export class GraphComponent implements OnInit {
  apiData: any;
  colorsWarning: Array<any> = [];
  colorsDeath: Array<any> = [];
  colorsRecovered: Array<any> = [];
  border: Array<any> = [];
  deaths: Array<Number> = [];
  recovered: Array<Number> = [];
  cases: Array<Number> = [];
  countries: Array<any> = [];

  constructor(private http: HttpClient) {}

  loadChart() {
    this.http.get('http://localhost:8080/country/parse').subscribe((data) => {
      this.apiData = data;
      for (let i in this.apiData) {
        this.countries.push(this.apiData[i].country);
        this.deaths.push(this.apiData[i].deaths);
        this.cases.push(this.apiData[i].cases);
        this.recovered.push(this.apiData[i].recovered);
        this.colorsDeath.push('rgba(255, 99, 132, 0.2)');
        this.colorsWarning.push('rgba(255, 206, 86, 0.2)');
        this.colorsRecovered.push('rgba(75, 192, 192, 0.2)');
        this.border.push('rgba(255,99,132,1)');
      }
    });
  }
  ngOnInit(): void {
    this.loadChart();
  }

  public chartType: string = 'horizontalBar';

  public chartDatasets: Array<any> = [
    { data: this.cases, label: 'Cases' },
    { data: this.deaths, label: 'Death' },
    { data: this.recovered, label: 'Recovered' },
  ];

  public chartLabels: Array<any> = this.countries;

  public chartColors: Array<any> = [
    {
      backgroundColor: this.colorsWarning,
      borderColor: this.colorsWarning,
      borderWidth: 2,
    },
    {
      backgroundColor: this.colorsDeath,
      borderColor: this.colorsDeath,
      borderWidth: 2,
    },
    {
      backgroundColor: this.colorsRecovered,
      borderColor: this.colorsRecovered,
      borderWidth: 2,
    },
  ];

  public chartOptions: any = {
    responsive: false,
  };
  public chartClicked(e: any): void {}
  public chartHovered(e: any): void {}
}
