import { DataService } from './../data.service';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { EmitterserviceService } from '../emitterservice.service';

@Component({
  selector: 'app-veditvendor',
  templateUrl: './veditvendor.component.html',
  styleUrls: ['./veditvendor.component.css']
})
export class VeditvendorComponent implements OnInit {

  constructor(private userService: UserService,private router: Router,
    private emservice:EmitterserviceService,
    private data:DataService ) { }
vendor={
        id:"",
        name:"",
        email:"",
        phoneNo:"",
        password:"",
        role:"",
        address:{
              city:"",
              street:"",
              state:"",
              area:"",
              pinCode:""
        }
      };
  ngOnInit() {
    var User=JSON.parse(localStorage['userdtls']);
// this.vendor.id=User["id"]

// this.vendor.email=User["email"]
// this.vendor.name=User["name"]
// this.vendor.address=User["address"]
// this.vendor.password=User["password"]
// this.vendor.role=User["role"]
// this.vendor.phoneNo=User["phoneNo"]
// this.vendor.role=User["role"]

this.vendor=User;
// this.vendor.address.street=User["address.street"]

  }
  edit(){
    let observable=this.data.editVendor(this.vendor);
    //console.log(observable);
    observable.subscribe((result)=>{
      console.log(result);
      
    alert("information updated  successfully")
this.router.navigate(['/vendor/showallproducts'])
    })
  }
}
