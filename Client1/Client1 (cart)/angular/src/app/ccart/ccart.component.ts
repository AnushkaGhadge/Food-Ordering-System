import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ccart',
  templateUrl: './ccart.component.html',
  styleUrls: ['./ccart.component.css']
})
export class CcartComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit() {
  }

  paydetails()
  {
    alert("navigating to payment details");
    this.router.navigate(['/customer/cpaymentdetails'])
  }
}
