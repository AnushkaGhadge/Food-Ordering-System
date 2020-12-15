import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
import { EmitterserviceService } from '../emitterservice.service';
@Component({
  selector: 'app-aadddelboy',
  templateUrl: './aadddelboy.component.html',
  styleUrls: ['./aadddelboy.component.css']
})
export class AadddelboyComponent implements OnInit {
user:any;
  constructor(private userService: UserService,private router: Router,
    private emservice:EmitterserviceService,
    private data:DataService ) { }
    db={
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
  //  this.db=User;
  }
  add()
  {
    this.db.id="";
    this.db.role="DELIVERYBOY"
    let observableresult=this.data.addDeliveryBoy(this.db);
    observableresult.subscribe((result)=>
    {
      console.log(result);
       
      this.router.navigate(['/admin/listUser']);
    })
  }
  }


