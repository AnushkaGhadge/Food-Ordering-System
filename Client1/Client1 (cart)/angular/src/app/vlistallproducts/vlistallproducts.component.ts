import { DataService } from './../data.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-vlistallproducts',
  templateUrl: './vlistallproducts.component.html',
  styleUrls: ['./vlistallproducts.component.css']
})
export class VlistallproductsComponent implements OnInit {

  constructor(private data:DataService,private router:Router) { }


userdtls={
  id:""
}

product:any;



  ngOnInit() {


    this.userdtls=JSON.parse(localStorage['userdtls'])

let uid=this.userdtls.id;

let observableresult= this.data.showproductbyId(uid);
observableresult.subscribe((data)=>{
this.product=data;


// this.router.navigate(['/vendor/showallproducts']);

});  
}

}
