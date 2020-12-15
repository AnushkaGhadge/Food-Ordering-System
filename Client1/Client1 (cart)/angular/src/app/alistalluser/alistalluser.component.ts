import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-alistalluser',
  templateUrl: './alistalluser.component.html',
  styleUrls: ['./alistalluser.component.css']
})
export class AlistalluserComponent implements OnInit {
users:any;
  constructor() {
    this.users=[
      {'id':1,'area':'Hinjewadi','city':'Pune','pincode':'415046','state':'Maharashtra','email':'anushka@gmail.com','name':'Anushka','phoneNo':'8788536096','user_role':'Admin'},
    ];
   
   }


  // listOfUsers(){
  //     }
    
  ngOnInit() {
  }

}