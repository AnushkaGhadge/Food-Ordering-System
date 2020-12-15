import { Component, OnInit } from '@angular/core';
import { EmitterserviceService } from '../emitterservice.service';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';

@Component({
selector: 'app-veditproducts',
templateUrl: './veditproducts.component.html',
styleUrls: ['./veditproducts.component.css']
})
export class VeditproductsComponent implements OnInit {

constructor(private emtService:EmitterserviceService,
private userService: UserService,
private router: Router,
private data :DataService,
private route:ActivatedRoute) { }

product={pId:"", pName:"", pPrice:"" ,


  vegnonveg: "",
  cType: "",
  // image:{
  // image: "",
  // imageID: ""

  // },

  pVendor: {
      vId: "",
    userVendor: {
          id: "",
          name: "",
          email: "",
          phoneNo: "",
          password: "",
          role: "",
          address: {
              street: "",
              city: "",
              area: "",
              state: "",
              pinCode: ""
          }
      },
      vRestaurant: ""
  }
}

ngOnInit() {
      this.route.paramMap.subscribe((result)=>{ //from url
      var No=result.get("id");
      let observableResult=this.data.editproduct(No);//send to db and get result
      observableResult.subscribe((data)=>{ //db result on data 
      console.log(data);
      this.product.pId=data['pId'];
      this.product.pName=data['pName'];
      this.product.pPrice=data['pPrice'];
      this.product.pVendor=data['pVendor'];
      this.product.vegnonveg=data['vegnonveg']
      this.product.cType=data['cType'];
// this.product.image=data['image'];

console.log(this.product);
})
})
}


showallprod()
{

console.log(this.product);

  let observableResult=this.data.updateproduct(this.product);
  observableResult.subscribe((data)=>{
    console.log(data);
    
    alert("product edited successfully")
    this.router.navigate(['/vendor/showallproducts'])
  })
  }


}
