import { Component, OnInit } from '@angular/core';
import { DataService } from './../data.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.css']
})
export class DefaultComponent implements OnInit {
show:boolean=true;
  constructor(private router:Router,
    private data:DataService) { }

     vendorlist:any;
    vendor={
      vId:"", 
      vRestaurant: ""
     }
    
  ngOnInit() {
    let oberservableresult= this.data.getallvendors();
oberservableresult.subscribe((result)=>{
this.vendorlist=result;
console.log(result);

})
 

  }
  ShowProdById()
  {
    localStorage.setItem('hidediv', 'false');
    this.router.navigate(['/home/login']);
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
    this.router.navigate(['/home/login']);
  }
}
// ngOnInit() {}
  