import { Router } from '@angular/router';
import { Injectable } from '@angular/core';
import { DataService } from './data.service';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private service:DataService,private router:Router) { }

validate(user)
{
return this.service.ValidateUser(user);
}

}
