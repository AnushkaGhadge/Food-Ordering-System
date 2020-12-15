import { DataService } from './../data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../user.service';
import { toUnicode } from 'punycode';
import { EmitterserviceService } from '../emitterservice.service';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = {

    email: "",
    password: ""
  }

  userdtls = {
    address: { street: "", city: "", area: "", state: "" },
    id: "",
    name: "",
    email: "",
    password: "",
    phoneNo: "",
    role: ""
  }

  Userdetails = {

  }

  abcd: boolean;
  constructor(
    private emtService: EmitterserviceService,
    private userService: UserService,
    private router: Router,
    private auth: AuthService) { }


  ngOnInit() {
  }

  onLogin() {

    if (this.user.email.length == 0) {
      alert('enter email');
    } else if (this.user.password.length == 0) {
      alert('enter password');
    } else {

      console.log(this.onLogin.name);



      let observable = this.auth.validate(this.user);
      //console.log(observable);
      observable.subscribe((result) => {
        console.log(result);

        this.userdtls.id = result["id"]
        this.userdtls.email = result["email"]
        this.userdtls.name = result["name"]
        this.userdtls.address = result["address"]
        this.userdtls.password = result["password"]
        this.userdtls.role = result["role"]
        this.userdtls.phoneNo = result["phoneNo"]


        console.log(this.userdtls.role);


        if (result["role"] == 'ADMIN' && this.user.email == result['email'] && this.user.password == result['password']) {
          sessionStorage['login_status'] = '1';
          localStorage.setItem('email', result.toLocaleString());
          localStorage.setItem('flag', 'true');

          localStorage.setItem('role', 'ADMIN');

          localStorage.setItem('userdtls', JSON.stringify(this.userdtls));


          this.router.navigate(['/admin']);

        }

        else if (result["role"] == 'DELIVERYBOY' && this.user.email == result['email'] && this.user.password == result['password']) {
          sessionStorage['login_status'] = '1';
          localStorage.setItem('email', result["role"]);
          localStorage.setItem('flag', 'true');

          localStorage.setItem('userdtls', JSON.stringify(this.userdtls));
          localStorage.setItem('role', 'DELIVERYBOY');


          // this.emtService.navBarSwitch(true);
          this.router.navigate(['/deliveryboy']);

        }

        else if (result["role"] == 'CUSTOMER' && this.user.email == result['email'] && this.user.password == result['password']) {

          sessionStorage['login_status'] = '1';
          localStorage.setItem('email', result["role"]);
          localStorage.setItem('flag', 'true');

          localStorage.setItem('userdtls', JSON.stringify(this.userdtls));
          localStorage.setItem('role', 'CUSTOMER');


          // this.emtService.navBarSwitch(true);
          this.router.navigate(['/customer']);

        }
        else if (result["role"] == 'VENDOR' && this.user.email == result['email'] && this.user.password == result['password']) {
          sessionStorage['login_status'] = '1';
          localStorage.setItem('vendor', result.toString());
          localStorage.setItem('role', 'VENDOR');

          localStorage.setItem('flag', 'true');
          localStorage.setItem('abcd', 'true');
          //localStorage.setItem('vendordetails',JSON.tringify(this.user));


          console.log("INSIDE VENDOR" + this.user);

          localStorage.setItem('userdtls', JSON.stringify(this.userdtls));

          var User = JSON.parse(localStorage['userdtls']);

          console.log("local storage user:" + User);


          this.router.navigate(['/vendor']);
        } else {
          alert("invalid login");
          this.router.navigate(['']);
        }
      });
    }
  }


  onSignup() {
    this.router.navigate(['/register']);
  }
}
