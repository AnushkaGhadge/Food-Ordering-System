import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-deliveryboy',
  templateUrl: './deliveryboy.component.html',
  styleUrls: ['./deliveryboy.component.css']
})
export class DeliveryboyComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
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
