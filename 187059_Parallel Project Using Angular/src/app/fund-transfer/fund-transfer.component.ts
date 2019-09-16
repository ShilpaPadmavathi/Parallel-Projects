import { Component, OnInit } from '@angular/core';
import { CustomerService, Transactions } from '../customer.service';

@Component({
  selector: 'app-fund-transfer',
  templateUrl: './fund-transfer.component.html',
  styleUrls: ['./fund-transfer.component.css']
})
export class FundTransferComponent implements OnInit {

  isLogin:boolean=true;
  createdTransaction:Transactions;
  service:CustomerService;
  
  constructor(service:CustomerService) { 
    this.service=service;
    this.isLogin=this.service.isLogin;
  }

  fundTransfer(data:any){
    let caccount_second=data.caccount_second;
    let caccount_first=this.service.loginAccount;
    let cbalance=data.cbalance;
    var ttype:string;
    let tid=Math.floor(Math.random() * 10) + 2549 ;
    ttype="Fund Transfer"
    this.service.depositeBalance(caccount_second,cbalance);
    this.service.withdrawBalance(caccount_first,cbalance)
    
    this.createdTransaction=new Transactions(tid,caccount_first,caccount_second,data.cbalance,ttype);
    this.service.addTransaction(this.createdTransaction)

    this.createdTransaction=new Transactions(tid,caccount_second,caccount_first,data.cbalance,ttype);
    this.service.addTransaction(this.createdTransaction)
  }

  ngOnInit() {
  }
}
