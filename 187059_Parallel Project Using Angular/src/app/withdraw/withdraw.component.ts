import { Component, OnInit } from '@angular/core';
import { CustomerService, Transactions, Customer } from '../customer.service';

@Component({
  selector: 'app-withdraw',
  templateUrl: './withdraw.component.html',
  styleUrls: ['./withdraw.component.css']
})
export class WithdrawComponent implements OnInit {

  isLogin:boolean=true;
  customers:Customer[]=[];
  createdTransaction:Transactions;
  
  service:CustomerService;
  constructor(service:CustomerService) { 
    this.service=service;
    this.isLogin=this.service.isLogin;
  }

  withdrawAmount(data:any){
    let tid=Math.floor(Math.random() * 10) + 7985 ;
    let caccount_first=this.service.loginAccount;
    let cbalance=data.cbalance;
    var ttype:string;
    ttype="Withdraw Amount"
    this.service.withdrawBalance(caccount_first,cbalance);
    this.createdTransaction=new Transactions(tid,caccount_first,0,cbalance,ttype);
    this.service.addTransaction(this.createdTransaction)
  }

  ngOnInit() {
    this.customers=this.service.getCustomers();
  }
}
