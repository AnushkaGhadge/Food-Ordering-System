import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  deletepdf(id: any) {
    return this.http.get("http://localhost:8080/fileupload/user/delete/"+id);
  }
  listbooks() {
    return this.http.get("http://localhost:8080/fileupload/user/list");
  }

  addbook(authname: any, pdfbook: any, bookName: any) {
    const formdata = new FormData();
    formdata.append('pdf', pdfbook);
    formdata.append('authName', authname);
    formdata.append('bookName', bookName);


    return this.http.post("http://localhost:8080/fileupload/user", formdata);
  }




  sendmail(mail: { destEmail: string; message: string; subject: string; }) {
    return this.http.post("http://localhost:8080/FoodOrderSystem/email", mail);
  }

  addimagetovendor(rimage: any, vid: any) {
    const formdata = new FormData();
    formdata.append('image', rimage);
    formdata.append('vId', vid);
    return this.http.post("http://localhost:8080/FoodOrderSystem/admin", formdata);

  }



  paymentdetails(order) {

    return this.http.post("http://localhost:8080/FoodOrderSystem/customer/paymentdetails/", order);

  }





  // viewhistorybyuid(uid: string) {
  //   return this.http.get("http://localhost:8080/FoodOrderSystem/deliveryboy/deliveryhistory/"+uid);

  // }

  changeorderstatus(orderid, uid) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/deliveryboy/changestatus/" + orderid + "/" + uid);
  }

  getuserbycid(cId) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/home/getCustomerById/" + cId);
  }
  dneworderist(id) {
    console.log(id);
    return this.http.get("http://localhost:8080/FoodOrderSystem/deliveryboy/neworders/" + id);
  }
  addvendor(vendor, rname) {

    // vendor={
    //   id:"",
    //   name:"",
    //   email:"",
    //   phoneNo:"",
    //   password:"",
    //   role:"",
    //   address:{
    //         city:"",
    //         street:"",
    //         state:"",
    //         area:"",
    //         pinCode:""
    //   }
    // };





    const formdata = new FormData();
    formdata.append('name', vendor.name);
    formdata.append('email', vendor.email);
    formdata.append('phoneNo', vendor.phoneNo);
    formdata.append('password', vendor.password);
    formdata.append('role', vendor.role);
    formdata.append('address', vendor.address);
    formdata.append('vRestaurant', rname);
    // formdata.append('vImage',rimage);





    //   return this.http.post("http://localhost:8080/FoodOrderSystem/admin/addvendor",formdata);



    //   return this.http.post("http://localhost:8080/FoodOrderSystem/admin/addvendor/"+rname,vendor);


    console.log(vendor);
    console.log(rname);

    return this.http.post("http://localhost:8080/FoodOrderSystem/admin/addvendor/" + rname, vendor);

  }
  // viewHistory() {
  //   return this.http.get("http://localhost:8080/FoodOrderSystem/admin/viewhistory/");

  // }


  /////////cart for 1 product
  // addorder(productobj, qty, userid, vendorid) {

  //   return this.http.post("http://localhost:8080/FoodOrderSystem/customer/addorder/" + userid + "/" + vendorid + "/" + qty, productobj);
  // }

  /////cart for list of products
  addorder(productlist, userid, vendorid, finaltotal) {

    return this.http.post("http://localhost:8080/FoodOrderSystem/customer/addorder/" + userid + "/" + vendorid + "/" + finaltotal, productlist);
  }



  orderhistoryById(uid) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/customer/orderhistoryById/" + uid);
  }
  getallvendors() {
    return this.http.get("http://localhost:8080/FoodOrderSystem/customer/showallvendors");
  }

  constructor(private http: HttpClient) { }

  ValidateUser(user) {
    console.log(user);

    console.log(DataService.name + this.ValidateUser.name);

    return this.http.post("http://localhost:8080/FoodOrderSystem/home/login", user);
  }

  showproductbyId(uid) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/vendor/showallproducts/" + uid);
  }

  showproductbyvId(vid) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/vendor/showallproductsbyvid/" + vid);
  }


  updateproduct(product) {
    return this.http.post("http://localhost:8080/FoodOrderSystem/vendor/editproduct", product);
  }


  editproduct(No) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/vendor/editproduct/" + No);
  }


  addproduct(product, vid, img) {
    const formdata = new FormData();
    formdata.append('pName', product.pName);
    formdata.append('pPrice', product.pPrice);
    formdata.append('vegnonveg', product.vegnonveg);
    formdata.append('cType', product.cType);
    formdata.append('vId', vid);
    formdata.append('image', img);





    return this.http.post("http://localhost:8080/FoodOrderSystem/vendor", formdata);
  }


  editVendor(vendor) {
    return this.http.post("http://localhost:8080/FoodOrderSystem/vendor/editvendor", vendor);
  }



  updatePassword(user) {
    return this.http.put("http://localhost:8080/FoodOrderSystem/home/changepassword", user);

  }


  pendingOrders(uid) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/vendor/pendingorders/" + uid);

  }

  getsingleprodbyId(pid: any) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/customer/getproductbyid/" + pid);
  }


  assignDB(orderid) {
    return this.http.get("http://localhost:8080/FoodOrderSystem/admin/assigndb/" + orderid);
  }

  listUser() {
    return this.http.get("http://localhost:8080/FoodOrderSystem/admin/list");
  }
  viewHistory() {
    return this.http.get("http://localhost:8080/FoodOrderSystem/admin/viewhistory");
  }
  addDeliveryBoy(db) {
    return this.http.post("http://localhost:8080/FoodOrderSystem/admin/adddeliveryboy", db);
  }



  listpendingOrder() {
    return this.http.get("http://localhost:8080/FoodOrderSystem/admin/listpendingorder");
  }

  registerCustomer(c) {
    return this.http.post("http://localhost:8080/FoodOrderSystem/customer/registercustomer", c);
  }

}


