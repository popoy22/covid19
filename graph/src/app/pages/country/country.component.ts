import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.scss'],
})
export class CountryComponent implements OnInit {
  constructor(private http: HttpClient, private route: ActivatedRoute) {}

  url: string = 'http://localhost:8080/api/country/';
  data: any;

  ngOnInit(): void {
    const id: string = this.route.snapshot.params.country;
    this.loadData(id);
  }

  country: any = '';

  loadData(country) {
    this.http.get(this.url + country).subscribe((data) => {
      this.data = data;
      this.chartDatasets = [
        {
          data: [
            this.data.tests,
            this.data.active,
            this.data.deaths,
            this.data.recovered,
          ],
          label: this.data.country,
        },
      ];
    });
  }

  public chartType: string = 'horizontalBar';

  public chartDatasets: Array<any> = [
    {
      data: [0, 0, 0, 0, 0, 0],
      label: this.country,
    },
  ];

  public chartLabels: Array<any> = [
    'Cases',
    'Confirmed',
    'Deaths',
    'Recovered',
  ];

  public chartColors: Array<any> = [
    {
      backgroundColor: [
        'rgba(255, 99, 132, 0.2)',
        'rgba(54, 162, 235, 0.2)',
        'rgba(255, 206, 86, 0.2)',
        'rgba(75, 192, 192, 0.2)',
        'rgba(153, 102, 255, 0.2)',
        'rgba(255, 159, 64, 0.2)',
      ],
      borderColor: [
        'rgba(255,99,132,1)',
        'rgba(54, 162, 235, 1)',
        'rgba(255, 206, 86, 1)',
        'rgba(75, 192, 192, 1)',
        'rgba(153, 102, 255, 1)',
        'rgba(255, 159, 64, 1)',
      ],
      borderWidth: 2,
    },
  ];

  public chartOptions: any = {
    responsive: true,
  };

  public chartClicked(e: any): void {}

  public chartHovered(e: any): void {}
}
