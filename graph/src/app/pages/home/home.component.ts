import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  constructor(private http: HttpClient) {}
  apiData: any;
  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.http.get('http://localhost:8080/country').subscribe((data) => {
      this.apiData = data;
    });
  }
}
