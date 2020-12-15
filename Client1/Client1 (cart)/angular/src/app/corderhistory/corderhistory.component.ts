import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-corderhistory',
  templateUrl: './corderhistory.component.html',
  styleUrls: ['./corderhistory.component.css']
})
export class CorderhistoryComponent implements OnInit {
orders:any;
  constructor() { 
    this.orders=[
      {'id':1,'orderdate':'05-01-2020','ordertime':'06:05:10','customerId':2,'vendorId':10},
      {'id':2,'orderdate':'02-01-2020','ordertime':'15:09:56','customerId':12,'vendorId':2},

    ]
  }

  ngOnInit() {
  }

}
