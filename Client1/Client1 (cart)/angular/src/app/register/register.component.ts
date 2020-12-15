import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  name = '';
  role = '';
  email = '';
  password = '';
  phone = '';

  constructor(
    private router: Router,
    private userService: UserService) { }

  ngOnInit() {
  }

  onSignup() {
    
  }

  onCancel() {
    this.router.navigate(['/login']);
  }

}
