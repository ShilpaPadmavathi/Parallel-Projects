import { Component, OnInit } from '@angular/core';
import { CustomerService, Customer } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  service:CustomerService;
  router:Router;

  message:string;
  newMessage() {
    this.service.changeMessage("login")
  }

  constructor(service:CustomerService,router:Router) { 
    this.service=service;
    this.router=router;
  }

  customers:Customer[]=[];
  isLogin:boolean=true;

  login(data:any){

    if(this.service.login(data)){
      this.isLogin=this.service.isLogin;
      this.router.navigate(['app-homepage']);
    }else{
      alert("Values did not matched!")
    }
  }

  ngOnInit() {
    this.service.fetchCustomers();
    this.customers=this.service.getCustomers();
    this.service.currentMessage.subscribe(message => this.message = message)
  }

}
