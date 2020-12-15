import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dneworderlist',
  templateUrl: './dneworderlist.component.html',
  styleUrls: ['./dneworderlist.component.css']
})
export class DneworderlistComponent implements OnInit {

  constructor() { }
orders:any;
  ngOnInit() {
    this.orders=[
      {'id':1,'customerId':2,'vendorId':10},
    ];
  }

}
