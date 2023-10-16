import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-feature-and-api',
  templateUrl: './feature-and-api.component.html',
  styleUrls: ['./feature-and-api.component.css']
})
export class FeatureAndApiComponent implements OnInit {

  constructor(public router: Router) { }

  ngOnInit() {
  }


  tableOnApiData(){
    this.router.navigate(['angular-table-one'])
  }
}
