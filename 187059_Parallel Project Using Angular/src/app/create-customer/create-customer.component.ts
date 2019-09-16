import { Component, OnInit } from '@angular/core';
import { CustomerService, Customer, Transactions } from '../customer.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  createdCustomer:Customer;
  createdTransaction:Transactions;
  createdFlag:boolean=false;
  router:Router;
  service:CustomerService;

  constructor(service:CustomerService,router:Router) 
  {
    this.service=service;
    this.router=router;
  }


  add(data:any){
    data.caccount=Math.floor(Math.random() * 10) + 4326 
    let tid=Math.floor(Math.random() * 10) + 7985 ;
    data.cbalance=100;
    this.createdCustomer=new Customer(data.caccount,data.cname,data.cphone,data.cpassword,data.ccity,data.cbalance);
    this.service.add(this.createdCustomer);
    this.createdTransaction=new Transactions(tid,data.caccount,0,data.cbalance,"Account Created");
    this.service.addTransaction(this.createdTransaction)
    alert("Added Succesfully!!!\nYour Account No: "+data.caccount);
    this.createdFlag=true;
    this.router.navigate(['app-login']);
  }

  ngOnInit(){
  }
}
