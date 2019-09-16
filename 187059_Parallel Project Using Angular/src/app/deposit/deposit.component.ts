import { Component, OnInit } from '@angular/core'
import { Customer, Transactions, CustomerService } from '../customer.service';

@Component({
  selector: 'app-deposit',
  templateUrl: './deposit.component.html',
  styleUrls: ['./deposit.component.css']
})
export class DepositComponent implements OnInit {

  isLogin:boolean=true;
  customers:Customer[]=[];
  createdTransaction:Transactions;

  service:CustomerService;
  constructor(service:CustomerService) { 
    this.service=service;
    this.isLogin=this.service.isLogin;
  }

  depositeAmount(data:any){
    let tid=Math.floor(Math.random() * 21) + 6582 ;
    let caccount_first=this.service.loginAccount;
    let cbalance=data.cbalance;
    var ttype:string;
    ttype="Deposit Amount"
    this.service.depositeBalance(caccount_first,cbalance);
    this.createdTransaction=new Transactions(tid,caccount_first,0,cbalance,ttype);
    this.service.addTransaction(this.createdTransaction)
  }

  ngOnInit() {
    this.customers=this.service.getCustomers();
  }
}
