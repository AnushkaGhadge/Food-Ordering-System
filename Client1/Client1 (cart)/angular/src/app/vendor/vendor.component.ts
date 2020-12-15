import { DataService } from './../data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vendor',
  templateUrl: './vendor.component.html',
  styleUrls: ['./vendor.component.css']
})
export class VendorComponent implements OnInit {
orders:any;
abcd:boolean;

userdtls={
  address:{ street:"",city:"",area:"",state:""},
 id:"",
 name:"",
 email:"",
 password:"",
phoneNo:"",
role:""
}

order=
{
  id:"" ,
  orderDate: "",
  orderTime: "",
  oStatus: "",
  oVendor: {
      vId: "",
      vRestaurant: ""
  },
  oCustomer: {
      cId: 1,
  },
 }


  constructor(private router:Router,private data :DataService) {
    console.log("inside vendor constructor");
    // this.orders=[
    //   {'id':1,'ostatus':'Not delivered','orderdate':'01-01-2020','ordertime':'6:05:10','customerId':2,'vendorId':10},
    // ];
    
    localStorage.setItem('abcd','true');

      
let user123=JSON.parse(localStorage['userdtls'])
console.log(user123);

   }


  ngOnInit() {
    console.log("inside vendor init");

  this.userdtls=JSON.parse(localStorage['userdtls'])
  console.log(this.userdtls.id);
  console.log(this.userdtls);
  var uid=this.userdtls.id

   let observable=this.data.pendingOrders(uid);
    console.log(observable);
    observable.subscribe((result)=>{
      console.log(result);



this.order.id=result["id"];
this.order.oCustomer=result["oCustomer"];
this.order.oStatus=result["oStatus"];
this.order.oVendor=result["oVendor"];
this.order.orderDate=result["orderDate"];
this.order.orderTime=result["orderTime"];

      this.orders=result;


//    alert("information updated  successfully")
// this.router.navigate(['/vendor/showallproducts'])
    })
  

}

hideme()
{
  
}
  onLogout() {
    if (sessionStorage['login_status'] == '1') {
      const result = confirm('Are you sure you want to logout?');
      if (result) {
        sessionStorage['login_status'] = '0';
      
        localStorage.removeItem('email');
        localStorage.clear();
        //this.emservice.navBarSwitch(false);
        this.router.navigate(['']);
      }
    } else {
      alert('are you kidding me? first login..');
    }
  }
}

