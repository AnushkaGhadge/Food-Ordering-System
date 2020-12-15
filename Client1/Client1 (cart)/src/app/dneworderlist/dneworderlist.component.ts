import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-dneworderlist',
  templateUrl: './dneworderlist.component.html',
  styleUrls: ['./dneworderlist.component.css']
})
export class DneworderlistComponent implements OnInit {
  constructor(private data: DataService,private route:Router) { }
  // order: any;
  message: any;
  order = {
    id: "",
    oCustomer: { cId: "", cFb: "" },
    oDeliveryBoy: { dId: "", dStatus: "" },
    oPayment: "",
    oStatus: "",
    oVendor: { vId: "", vRestaurant: "" },
    orderDate: "",
    orderTime: "",
    orderTotal: ""
  }


  userdtls = { id: "" }
  customer = {
    name: "", phoneNo: "", address: {
      city: "",
      street: "",
      state: "",
      area: "",
      pinCode: ""
    }
  };




  ngOnInit() {
    this.userdtls = JSON.parse(localStorage['userdtls']);
    console.log();
    let observableresult = this.data.dneworderist(this.userdtls.id);
    observableresult.subscribe((result) => {
      console.log(result);
      // let obs=this.data.getuserbyuid(this.orders.oCustomer.cId);
      // obs.subscribe((data1)=>{
      //   console.log(data1);
      // this.customer=data1;
      // })
      this.order.id = result['id']
      this.order.oStatus = result['oStatus'];
      this.order.oVendor = result['oVendor'];

      this.order.oCustomer = result['oCustomer'];
      this.order.oDeliveryBoy = result['oDeliveryBoy'];
      this.order.orderDate = result['orderDate'];
      this.order.orderTime = result['orderTime'];

      let obs = this.data.getuserbycid(this.order.oCustomer.cId);
      obs.subscribe((data1) => {
        console.log(data1);
        
        if (data1 == null) {
          alert("no pending orders")
          this.message = "No Pending Orders";
        }
          this.customer = data1['userCustomer'];
          console.log(this.customer);
        
        
      })
    })

  }


  orderdelivered(orderid) {

    this.userdtls = JSON.parse(localStorage['userdtls']);
    let uid = this.userdtls.id

    let obs = this.data.changeorderstatus(orderid, uid);
    obs.subscribe((data1) => {
      console.log(data1);
      this.customer = data1['userCustomer'];



      
      this.route.navigate(['/deliveryboy/neworderlist'])
    })


  }




}
