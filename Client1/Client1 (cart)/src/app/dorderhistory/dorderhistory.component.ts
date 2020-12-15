import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-dorderhistory',
  templateUrl: './dorderhistory.component.html',
  styleUrls: ['./dorderhistory.component.css']
})
export class DorderhistoryComponent implements OnInit {
orders:any;
  constructor(private data:DataService) {
    // this.orders=[
    //   {'id':1,'orderdate':'01-01-2020','ordertime':'6:05:10','customerId':2,'vendorId':10},
    // ];
   }


   orderhistory:any;

     userdtls={id:""}

   
  ngOnInit() {

    this.userdtls=JSON.parse(localStorage['userdtls'])

    let uid=this.userdtls.id;


    // let observableresult= this.data.viewhistorybyuid(uid);
    // observableresult.subscribe((data)=>{
    // this.orderhistory=data;
    
    // console.log(this.orderhistory);
    
    
    // this.router.navigate(['/vendor/showallproducts']);
    
    // });  

  }



}
