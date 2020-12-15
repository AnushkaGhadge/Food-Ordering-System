import { DataService } from './../data.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  show:boolean=true;
  constructor(private router:Router,
    private data:DataService) {
      // localStorage.setItem('hidediv', 'true');
     }


vendorlist:any;
vendor={
  vId:"", 
  vRestaurant: ""
 }

cart:any=[];
length:number =JSON.parse(localStorage.getItem('cartlength'));
     
ngOnInit() {

 let oberservableresult= this.data.getallvendors();
oberservableresult.subscribe((result)=>{
this.vendorlist=result;
console.log(result);
localStorage.setItem('cart', JSON.stringify(this.cart));

})
  }

  ShowProdById()
  {
    localStorage.setItem('hidediv', 'false');
    this.router.navigate(['/customer/cmenulist']);
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
  cmenu(){  
    this.show=false;
    this.router.navigate(['customer/cmenulist']);
  }
}
