import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-clistallrestaurant',
  templateUrl: './clistallrestaurant.component.html',
  styleUrls: ['./clistallrestaurant.component.css']
})
export class ClistallrestaurantComponent implements OnInit {

  constructor(private data:DataService) { }
  vendorlist:any;
  vendor={
    vId:"", 
    vRestaurant: "",
    image:""
   }
   ngOnInit() {
    let oberservableresult= this.data.getallvendors();
   oberservableresult.subscribe((result)=>{
   this.vendorlist=result;
   
   console.log(this.vendorlist);
   })
}
}
