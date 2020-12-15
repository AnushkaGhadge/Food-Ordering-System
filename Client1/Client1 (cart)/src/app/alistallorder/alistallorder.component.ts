import { DataService } from './../data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alistallorder',
  templateUrl: './alistallorder.component.html',
  styleUrls: ['./alistallorder.component.css']
})
export class AlistallorderComponent implements OnInit {
orders:any;
   constructor(private data:DataService) { 
  //   {'id':1,'ostatus':'Delivered','orderdate':'01-01-2020','ordertime':'6:05:10','customerId':2,'vendorId':10},
  // ];
  }

  ngOnInit() {
      let observableresult=this.data.listpendingOrder();
      observableresult.subscribe((result)=>
      {


console.log(result);


        this.orders=result;
      })
  }
}
