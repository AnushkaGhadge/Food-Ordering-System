import { Router, ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-cmenulist',
  templateUrl: './cmenulist.component.html',
  styleUrls: ['./cmenulist.component.css']
})
export class CmenulistComponent implements OnInit {

  product: any;
  prodlist = new Array();

  singleproduct={
    pId:"",
    pName: "",
    pPrice: "",
    pqty:"",
    total:""
  }
  cart:any= JSON.parse(localStorage.getItem('cart'));

  allproducts: any = [];

  constructor(private router: Router, private route: ActivatedRoute,
    private data: DataService) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe((result) => { //from url
      var No = result.get("vid");
      localStorage.setItem("vid", No);
      let observableResult = this.data.showproductbyvId(No);//send to db and get result
      observableResult.subscribe((data) => { //db result on data 
        this.allproducts = data;
        //add data in all products array
        // console.log(this.product.pId);
      })
    })
  }
  addtoCart(pid) {
    console.log(pid);
    console.log("list of all products" + this.allproducts);
    let status = this.findprodbyid(pid);
    if (status > 0) {
      alert("product added in cart successfully")
      console.log("cart details are")
      console.log(this.cart);
    }
  }

  private findprodbyid(id: string) {
    for (var i = 0; i < this.allproducts.length; i++) {
      if (this.allproducts[i].pId == id) {

       // console.log(" found" + this.allproducts);
       this.singleproduct=this.allproducts[i];
       this.singleproduct.pqty="";
       this.singleproduct.total="";
       this.cart.push(this.singleproduct);
        localStorage.setItem('cart', JSON.stringify(this.cart));
        localStorage.setItem('cartlength', JSON.stringify(this.cart.length));

        console.log(this.cart);
        return this.allproducts[i].pId;
      }

    }
    return -1;
  }
}
