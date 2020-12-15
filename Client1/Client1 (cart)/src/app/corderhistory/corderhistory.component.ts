import { DataService } from './../data.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-corderhistory',
  templateUrl: './corderhistory.component.html',
  styleUrls: ['./corderhistory.component.css']
})
export class CorderhistoryComponent implements OnInit {
  orders: any;
  orderhistory: any;

  userdtls:any;
  constructor(private route: ActivatedRoute, private data: DataService) {
  }


  ngOnInit() {
    this.userdtls=JSON.parse(localStorage['userdtls'])
    console.log(this.userdtls.id);
    let uid=this.userdtls.id;
      let observableResult = this.data.orderhistoryById(uid);//send to db and get result
        observableResult.subscribe((data) => { //db result on data 
        console.log(data);
        this.orderhistory = data;
        console.log(this.orderhistory);
      })
  
  }

}
