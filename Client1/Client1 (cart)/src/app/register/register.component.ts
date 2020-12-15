import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import { EmitterserviceService } from '../emitterservice.service';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user: any;

  constructor(private userService: UserService, private router: Router,
    private emservice: EmitterserviceService,
    private data: DataService) { }
  c = {
    id: "",
    name: "",
    email: "",
    phoneNo: "",
    password: "",
    role: "",
    address: {
      city: "",
      street: "",
      state: "",
      area: "",
      pinCode: ""
    }
  };

  mail={
 destEmail:"",
 message:"",
 subject:""

  }
  ngOnInit() {

    }

    addCustomer()
    {
      this.c.id = "";
      this.c.role = "CUSTOMER"
      let observableresult = this.data.registerCustomer(this.c);
      observableresult.subscribe((result) => {
        console.log(result);
    
this.mail.destEmail=this.c.email;
this.mail.message="Hello you are registered successfully";
this.mail.subject="Registration"

let mailme=this.data.sendmail(this.mail)
// mailme.subscribe


        this.router.navigate(['/home/login']);
      })
    }
  onSignup() {

    }

  onCancel() {
      this.router.navigate(['/login']);
    }
  

  
  }


