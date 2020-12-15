import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-vregistervendor',
  templateUrl: './vregistervendor.component.html',
  styleUrls: ['./vregistervendor.component.css']
})
export class VregistervendorComponent implements OnInit {

  constructor(private route: ActivatedRoute,
    private router: Router,
    private service: UserService,
    private data: DataService) { }

  rname: any;
  rimage: any;
  onSelectFile(event) {
    this.rimage = event.target.files[0];
  }

  user = { "name": "", "email": "", "password": "", "phoneNo": "" };

  vendor = {
    id: "",
    name: "",
    email: "",
    phoneNo: "",
    password: "",
    role: "",
    address: {
      city: "",
      street: "",
      state: "",
      area: "",
      pinCode: ""
    }
  };


  ngOnInit() {
  }
  addvendor() {
    this.vendor.id = "";
    this.vendor.role = "VENDOR"
    let observable = this.data.addvendor(this.vendor, this.rname);
    //console.log(observable);
    observable.subscribe((result) => {
      console.log(result);

      console.log(this.rimage);
      let vid = result['vId']

      console.log(vid);
      let observable = this.data.addimagetovendor(this.rimage, vid)
      observable.subscribe((data) => {
        console.log(data);
      })
      this.router.navigate(['/admin/listUser'])
    })
  }
}

