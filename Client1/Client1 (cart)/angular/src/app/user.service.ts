import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpRequest} from '@angular/common/http';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable(    )
export class UserService implements CanActivate {

  flag :boolean=false;
  url = 'http://localhost:3000/user';

  constructor(
    private router: Router,
    private http: HttpClient) {
      console.log("aaaaaaaaaaaa")
      //this.flag=true;
     }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    // check if user has logged in
    if (sessionStorage['login_status'] == '1') {
     console.log("ffff");
   //   this.flag=true;
      return true;
    }
    
    this.router.navigate(['/login']);
    return false;
  }

 

}
