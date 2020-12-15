import { CustomerComponent } from './customer/customer.component';
import { VendorComponent } from './vendor/vendor.component';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { UserService } from './user.service';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { HttpClientModule } from '@angular/common/http';
import { ContactComponent } from './contact/contact.component';
import { RegisterComponent } from './register/register.component';
import { RouterModule, Routes } from '@angular/router';
import {NgModel, FormsModule, NgForm} from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { ChangepasswordComponent } from './changepassword/changepassword.component';
import { EditprofileComponent } from './editprofile/editprofile.component'
import { AlistalluserComponent } from './alistalluser/alistalluser.component';
import { AlistallorderComponent } from './alistallorder/alistallorder.component';
import { AviewhistoryComponent } from './aviewhistory/aviewhistory.component';
import { AdeletevendorComponent } from './adeletevendor/adeletevendor.component';
import { AassigndelboyComponent } from './aassigndelboy/aassigndelboy.component';
import { AadddelboyComponent } from './aadddelboy/aadddelboy.component';
import { DorderhistoryComponent } from './dorderhistory/dorderhistory.component';
import { DneworderlistComponent } from './dneworderlist/dneworderlist.component';
import { CmenulistComponent } from './cmenulist/cmenulist.component';
import { CcartComponent } from './ccart/ccart.component';
import { CpaymenthistoryComponent } from './cpaymenthistory/cpaymenthistory.component';
import { CpaymentdetailsComponent } from './cpaymentdetails/cpaymentdetails.component';
import { CfeedbackComponent } from './cfeedback/cfeedback.component';
import { CregisterComponent } from './cregister/cregister.component';
import { CorderhistoryComponent } from './corderhistory/corderhistory.component';
import { VaddproductsComponent } from './vaddproducts/vaddproducts.component';
import { VeditproductsComponent } from './veditproducts/veditproducts.component';
import { VlistallproductsComponent } from './vlistallproducts/vlistallproducts.component';
import { VregistervendorComponent } from './vregistervendor/vregistervendor.component';
import { VpendingordersComponent } from './vpendingorders/vpendingorders.component';
import { VregisteraddressComponent } from './vregisteraddress/vregisteraddress.component';
import { VeditvendorComponent } from './veditvendor/veditvendor.component';
import { AdminComponent } from './admin/admin.component';
import { DeliveryboyComponent } from './deliveryboy/deliveryboy.component';
const parentModuleRoutes: Routes = [
{
path:'',component:LoginComponent,
},

{
path:'home',component:HomeComponent,children:[{path:'about',component:AboutusComponent}]
},
{
path:'home',component:HomeComponent,children:[{path:'contact',component:ContactComponent}]
},
{
path:'home',component:HomeComponent,children:[{path:'changepassword',component:ChangepasswordComponent}]
},
{ 
path:'home',component:HomeComponent,children:[{path:'edit',component:EditprofileComponent}]
},
{
path:'home',component:HomeComponent,children:[{path:'register',component:RegisterComponent}]
},
{ 
path:'admin',component:AdminComponent,children:[{path:'listUser',component:AlistalluserComponent}]
},
{ 
path:'admin',component:AdminComponent,children:[{path:'listOrder',component:AlistallorderComponent}]
},
{ 
path:'admin',component:AdminComponent,children:[{path:'viewHistory',component:AviewhistoryComponent}]
},
{
path:'admin',component:AdminComponent,children:[{path:'deleteVendor',component:AdeletevendorComponent}]
},
{
path:'admin',component:AdminComponent,children:[{path:'assignDelBoy',component:AassigndelboyComponent}]
},
{
path:'admin',component:AdminComponent,children:[{path:'addDelBoy',component:AadddelboyComponent}]
},
{
path:'admin',component:AdminComponent,children:[{path:'addvendor',component:VregistervendorComponent}]
},

{
path:'deliveryboy',component:DeliveryboyComponent,children:[{path:'deliveryhistory',component:DorderhistoryComponent}]
},
{
path:'deliveryboy',component:DeliveryboyComponent,children:[{path:'neworderlist',component:DneworderlistComponent}]
},
{
path:'customer',component:CustomerComponent,children:[{path:'ccart',component:CcartComponent}]},
{
path:'customer',component:CustomerComponent,children:[{path:'cfeedback',component:CfeedbackComponent}]},
{
path:'customer',component:CustomerComponent,children:[{path:'cmenulist',component:CmenulistComponent}]},
{
path:'customer',component:CustomerComponent,children:[{path:'cpaymentdetails',component:CpaymentdetailsComponent}]},


{
path:'customer',component:CustomerComponent,children:[{path:'cpaymenthistory',component:CpaymenthistoryComponent}]},
{
path:'customer',component:CustomerComponent,children:[{path:'cregister',component:CregisterComponent}]},
{
path:'customer',component:CustomerComponent,children:[{path:'corderhistory',component:CorderhistoryComponent}]},
{
path:'vendor',component:VendorComponent,children:[{path:'addproduct',component:VaddproductsComponent}]},
{
path:'vendor',component:VendorComponent,children:[{path:'editproduct/:id',component:VeditproductsComponent}]},
{
path:'vendor',component:VendorComponent,children:[{path:'showallproducts',component:VlistallproductsComponent}]},
{
  path:'vendor',component:VendorComponent,children:[{path:'vregistervendor',component:VregistervendorComponent}]},
  {
    path:'vendor',component:VendorComponent,children:[{path:'vregisteraddress',component:VregisteraddressComponent}]},
{
path:'vendor',component:VendorComponent,children:[{path:'veditvendor',component:VeditvendorComponent}]},
      




];

@NgModule({
declarations: [
AppComponent,
HomeComponent,
AboutusComponent,
EditprofileComponent,
ContactComponent,
RegisterComponent,
ChangepasswordComponent,
LoginComponent,
AlistalluserComponent,
AlistallorderComponent,
AviewhistoryComponent,
AdeletevendorComponent,
AassigndelboyComponent,
AadddelboyComponent,
DorderhistoryComponent,
DneworderlistComponent,
CorderhistoryComponent,
CregisterComponent,
CcartComponent,
CfeedbackComponent,
CmenulistComponent,
CpaymenthistoryComponent,
CpaymentdetailsComponent,
VaddproductsComponent,
VeditproductsComponent,
VeditvendorComponent,
VlistallproductsComponent,
VpendingordersComponent,
VregisteraddressComponent,
VregistervendorComponent,
AdminComponent,
VendorComponent,
DeliveryboyComponent,
CustomerComponent,
],
imports: [
BrowserModule,
FormsModule,
HttpClientModule,
RouterModule.forRoot(parentModuleRoutes)
// RouterModule.forRoot([
// { path: "", component: HomeComponent , canActivate:[AuthserviceService]}, 
//  { path: "home", component: HomeComponent  , canActivate:[AuthserviceService]},
//  { path: "register", component: RegisterComponent  , canActivate:[AuthserviceService]},
//  { path: "about", component: AboutusComponent },
//  { path: "contact", component: ContactComponent },
//  { path: "login", component: LoginComponent },
//  { path: "edit/:No", component: EditComponent  , canActivate:[AuthserviceService]},
//  { path: "delete/:No", component: DeleteComponent , canActivate:[AuthserviceService] },
//  { path: "**", component: NotfoundComponent }
// ])
],
exports:[RouterModule],
providers: [

UserService
],
bootstrap: [AppComponent]
})
export class AppModule 
{
constructor()
{
console.log("App Module Created");
}
}




