import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { EmitterserviceService } from '../emitterservice.service';
import { UserService } from '../user.service';
import { DataService } from '../data.service';

@Component({
  selector: 'app-vaddproducts',
  templateUrl: './vaddproducts.component.html',
  styleUrls: ['./vaddproducts.component.css']
})
export class VaddproductsComponent implements OnInit {

  product={
pName:"",
pPrice:"",
vegnonveg:"",
cType:"",

}
image:any;

userdtls={id:""}

  constructor(private emtService:EmitterserviceService,
    private userService: UserService,
    private router: Router,
    private data:DataService) { }
  onSelectFile(event) {
  this.image = event.target.files[0];

}

addproduct(){
  console.log(this.product.pName);
  console.log(this.product.pPrice);
  console.log(this.product.cType);
  console.log(this.product.vegnonveg);
  
  
  this.userdtls=JSON.parse(localStorage['userdtls'])
  console.log(this.userdtls.id);

  let vid=this.userdtls.id;
  let observable=this.data.addproduct(this.product,vid,this.image);
  //console.log(observable);
  observable.subscribe((result)=>{
  alert("product added successfully");

  this.router.navigate(['/vendor/showallproducts']);
  });
}

  ngOnInit() {
    //localStorage.removeItem('abcd');

  }

}
