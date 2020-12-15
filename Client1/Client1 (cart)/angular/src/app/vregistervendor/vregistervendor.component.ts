import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-vregistervendor',
  templateUrl: './vregistervendor.component.html',
  styleUrls: ['./vregistervendor.component.css']
})
export class VregistervendorComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private router: Router,
    private service: UserService) { }
  user= {"name":"","email": "","password": "","phoneNo": ""};
  ngOnInit() {
  }

  Insert()
  {
    // console.log(this.vendor);
    // let observableResult=this.service.Insert(this.vendor);
    // observableResult.subscribe((result)=>{
      console.log("inside register");
      this.router.navigate(['/vendor/vregisteraddress']);
  
  }

}
