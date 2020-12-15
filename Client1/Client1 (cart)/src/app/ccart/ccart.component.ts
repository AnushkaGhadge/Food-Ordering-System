import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import { _localeFactory } from '@angular/core/src/application_module';

@Component({
  selector: 'app-ccart',
  templateUrl: './ccart.component.html',
  styleUrls: ['./ccart.component.css']
})
export class CcartComponent implements OnInit {
  cart: any = [];
  qtymsg: any = [];
  finaltotal: number = 0;
  prod = new Array;

  bill: any;
  total: any;
  pr: any;
  vid: any;
  pid: any;
  price: any;
  orderlist: any = [];
  constructor(private router: Router, private data: DataService) {
  }
  neworder: any;
  ngOnInit() {
    this.loadcart();
  }
  loadcart() {
    this.cart = JSON.parse(localStorage.getItem('cart'));
    for (let i = 0; i < this.cart.length; i++) {
      if (this.cart[i].pqty == "") {
        this.cart[i].pqty = "1";
      }
      if (this.cart[i].total == "") {
        this.cart[i].total = parseInt(this.cart[i].pPrice);
        this.finaltotal = this.finaltotal + this.cart[i].total;
      }
      // else
      // {
      //   this.cart[i].total=parseInt(this.cart[i].pPrice)*parseInt(this.cart[i].pqty);
      //   this.finaltotal=this.finaltotal+this.cart[i].total;
      // }

      console.log(this.cart[i]);
    }

  }

  userdtls = { id: "" }
  paydetails() {
    console.log("in paydetails");
    //console.log(this.price);
    //console.log(this.qty);
    this.userdtls = JSON.parse(localStorage['userdtls']);
    this.vid = JSON.parse(localStorage['vid']);
    for (let i = 0; i < this.cart.length; i++) {
      let orderdetails = { pId: "", pPrice: "", pqty: "" };
      console.log(this.cart);
      orderdetails.pId = this.cart[i].pId;
      orderdetails.pPrice = this.cart[i].pPrice;
      orderdetails.pqty = this.cart[i].pqty;
      this.orderlist.push(orderdetails);
    }
    console.log(this.orderlist);
    let observe = this.data.addorder(this.orderlist, this.userdtls.id, this.vid, this.finaltotal);
    observe.subscribe((result) => {
      console.log(result);
      this.neworder = result;
      console.log(this.neworder);
      localStorage.setItem('latestorder', JSON.stringify(this.neworder))
      //    localStorage.removeItem('addedprod');
      this.router.navigate(['/customer/paymentdetails']);
    })
  }

  //decrease qty
  dec(qty: any, id: any) {

    for (let i = 0; i < this.cart.length; i++) {
      if (this.cart[i].pqty > 1) {

        if (this.cart[i].pId == id) {
          this.qtymsg[i] = "";
          let qt = parseInt(qty) - 1;
          this.cart[i].pqty = qt;
        //  this.cart[i].total = parseInt(this.cart[i].pPrice) * parseInt(this.cart[i].pqty);
          this.finaltotal = this.finaltotal -  this.cart[i].pPrice;
          localStorage.setItem('cart', JSON.stringify(this.cart));
          this.loadcart();
        }
      } else {
      }
    }

  }
  inc(qty: any, id: number) {
    for (let i = 0; i < this.cart.length; i++) {
      if (this.cart[i].pId == id) {
        let qt = parseInt(qty) + 1;
        this.cart[i].pqty = qt;
      //  this.cart[i].total = parseInt(this.cart[i].pPrice) * parseInt(this.cart[i].pqty);
        this.finaltotal = this.finaltotal + parseInt(this.cart[i].pPrice);
        localStorage.setItem('cart', JSON.stringify(this.cart));
        this.loadcart();
      }
    }
  }


}

