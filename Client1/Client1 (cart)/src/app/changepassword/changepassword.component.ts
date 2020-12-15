import { LoginComponent } from './../login/login.component';
import { DataService } from './../data.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-changepassword',
  templateUrl: './changepassword.component.html',
  styleUrls: ['./changepassword.component.css']
})
export class ChangepasswordComponent implements OnInit {
  flag:boolean=false;
  constructor(private route:Router,
    private data:DataService) {
    this.flag=localStorage['flag'];
    console.log("change"+this.flag);
   }

user={
  email:"",
  password:"",
  newpassword:""
}

usr={
role:""
}


ngOnInit() {
    var User=JSON.parse(localStorage['userdtls']);
this.user.email=User["email"];
this.user.password="";
// this.user=User;
  }
  UpdatePassword()
{
  var User=JSON.parse(localStorage['userdtls']);


  console.log(User);
  
if(this.user.password==User["password"])
{
  console.log("password matched");
  
 var observableresult= this.data.updatePassword(this.user);
 observableresult.subscribe((result)=>{
console.log(result);
console.log("password updated successfully");

// if(this.user.role=='VENDOR')
this.usr.role=User['VENDOR']

console.log(this.usr.role);

alert("password updated ssuccessfully")




})
}
else 
alert("password not matched");
}
}
