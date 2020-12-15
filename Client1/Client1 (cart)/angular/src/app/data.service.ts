import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {


  constructor(private http:HttpClient) { }

ValidateUser(user)
{
  console.log(user);
  
  console.log(DataService.name+this.ValidateUser.name);
  
  return this.http.post("http://localhost:8080/FoodOrderSystem/home/login",user);
}

showproductbyId(uid)
{
  return this.http.get("http://localhost:8080/FoodOrderSystem/vendor/showallproducts/"+uid);
}

updateproduct(product) {
  return this.http.post("http://localhost:8080/FoodOrderSystem/vendor/editproduct",product);
}


editproduct(No)
{
   return this.http.get("http://localhost:8080/FoodOrderSystem/vendor/editproduct/"+No);
}


addproduct(product,vid)
{
   return this.http.post("http://localhost:8080/FoodOrderSystem/vendor/addproduct/"+vid,product);
}


editVendor(vendor)
{
  return this.http.post("http://localhost:8080/FoodOrderSystem/vendor/editvendor",vendor);
}



updatePassword(user) {
return this.http.put("http://localhost:8080/FoodOrderSystem/home/changepassword",user);

}


pendingOrders(uid) {
  return this.http.get("http://localhost:8080/FoodOrderSystem/vendor/pendingorders/"+uid);

}

}


