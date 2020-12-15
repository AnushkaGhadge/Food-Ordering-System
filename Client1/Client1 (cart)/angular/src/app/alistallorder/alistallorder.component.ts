import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alistallorder',
  templateUrl: './alistallorder.component.html',
  styleUrls: ['./alistallorder.component.css']
})
export class AlistallorderComponent implements OnInit {
orders:any;
  constructor() { this.orders=[
    {'id':1,'ostatus':'Delivered','orderdate':'01-01-2020','ordertime':'6:05:10','customerId':2,'vendorId':10},
  ];
  }

  // listOfOrders(){
  //   this.orders=[
  //     {'id':1,'ostatus':'Delivered','orderdate':'01-01-2020','ordertime':'6:05:10','customerId':2,'vendorId':10},
  //   ];
  //     }

  ngOnInit() {
  }

}