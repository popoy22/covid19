import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  title = 'graph';
  constructor(private http: HttpClient) {}

  deaths: Number = 0;
  confirmed: Number = 0;
  recovered: Number = 0;
  todayCases: Number = 0;
  data: any;

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.http.get('http://localhost:8080/api/total').subscribe((data) => {
      this.data = data;
      this.deaths = this.data.deaths;
      this.confirmed = this.data.confirmed;
      this.recovered = this.data.recovered;
      this.todayCases = this.data.todayCases;
      console.log(data);
    });
  }
}
