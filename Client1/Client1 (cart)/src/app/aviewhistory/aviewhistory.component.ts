import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
@Component({
  selector: 'app-aviewhistory',
  templateUrl: './aviewhistory.component.html',
  styleUrls: ['./aviewhistory.component.css']
})
export class AviewhistoryComponent implements OnInit {
orders:any;
  constructor(private data:DataService) { 
  //    this.orders=[
  //   {'id':1,'orderdate':'01-01-2020','ordertime':'6:05:10','customerId':2,'vendorId':10},
  // ];}
  }
userdtls={id:""}
  ngOnInit() {
    this.userdtls=JSON.parse(localStorage['userdtls'])

    let uid=this.userdtls.id;


    let observableresult=this.data.viewHistory();
  observableresult.subscribe((result)=>
  {

    this.orders=result;
    
  })

  }

}
