import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { observable } from 'rxjs';
@Component({
  selector: 'app-cpaymentdetails',
  templateUrl: './cpaymentdetails.component.html',
  styleUrls: ['./cpaymentdetails.component.css']
})
export class CpaymentdetailsComponent implements OnInit {
  bill:any;
  payment:any;
  order:any;
  oId:any;
  orderdtls:any;
  customer:any;



pdetails:any;

  paymentdetails={
  
  id: "",
  oCustomer: {userCustomer: {id: "", name: "", email: "", phoneNo: ""}},
  oPayment: "",
  oVendor: {vId: "", vRestaurant: ""},
  orderDate: "",
  orderTime: "",
  orderTotal: "",
  odId: "",
  porder: {pId: "", pPrice: ""},
  pqty: ""
  };

  paymentdetails1:any;

  
  constructor(private data:DataService) { }
  ngOnInit() {
//this.bill=JSON.parse(localStorage['bill']);
//console.log(this.bill);
this.order=JSON.parse(localStorage['latestorder']);  //..
// {id: 8
// oCustomer:
// cFb: null
// cId: 1
// userCustomer: {id: 4, name: "Vishal", email: "vishal221191@gmail.com", phoneNo: "9579822772", password: "123123", …}
// __proto__: Object
// oDeliveryBoy: null
// oPayment: null
// oStatus: "NOT_DELIVERED"
// oVendor: {vId: 1, image: "/9j/4AAQSkZJRgABAQIAHAAcAAD/2wCEAAICAgICAgICAgIDAw…n8PTMapaqw5d96wNYGOdzRxnOBtRG33on3he1IowOdtsmv//Z", vRestaurant: "Wadeshwar"}
// orderDate: "2020-04-16"
// orderTime: "23:29"
// orderTotal: 180
// }
console.log(this.order);
this.customer=JSON.parse(localStorage['userdtls']);


let observable=this.data.paymentdetails(this.order);
observable.subscribe((result)=>
{
  this.pdetails=result;
  console.log(this.pdetails);
  this.orderdtls=result;
  console.log(this.orderdtls.odId);
})
  }
}

