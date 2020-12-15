import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dorderhistory',
  templateUrl: './dorderhistory.component.html',
  styleUrls: ['./dorderhistory.component.css']
})
export class DorderhistoryComponent implements OnInit {
orders:any;
  constructor() {
    this.orders=[
      {'id':1,'orderdate':'01-01-2020','ordertime':'6:05:10','customerId':2,'vendorId':10},
    ];
   }

  ngOnInit() {
  }

}
