import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-aassigndelboy',
  templateUrl: './aassigndelboy.component.html',
  styleUrls: ['./aassigndelboy.component.css']
})
export class AassigndelboyComponent implements OnInit {

dboy1={dId:"", dStatus: ""}

  orders: any;
  
dboy:any;
  constructor(private data: DataService) { }

  ngOnInit() {
    let observableresult = this.data.listpendingOrder();
    observableresult.subscribe((result) => {
      this.orders = result;
    })
  }
  assigndbtoorder(orderid) {
    let observableresult = this.data.assignDB(orderid);
    observableresult.subscribe((result) => {
      
      this.dboy = result;
this.dboy1.dId=result["dId"];
console.log(this.dboy1.dId);

alert("Delivery Boy Assigned with Id :" +this.dboy1.dId);



if(this.dboy==0)
{
  alert("No delivery boy present")
}


console.log(this.dboy.dId);


    }),(error)=>{
      console.log(error);
      
    }

  }





}
