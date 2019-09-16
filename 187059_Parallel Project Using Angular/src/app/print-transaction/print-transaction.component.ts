import { Component, OnInit } from '@angular/core';
import { CustomerService, Transactions, Customer } from '../customer.service';

@Component({
  selector: 'app-print-transaction',
  templateUrl: './print-transaction.component.html',
  styleUrls: ['./print-transaction.component.css']
})
export class PrintTransactionComponent implements OnInit {

  transactions:Transactions[]=[];
  customers:Customer[]=[];
  service:CustomerService;


  constructor(service:CustomerService) { 
    this.service=service;
  }

  miniStatement(data:any){
    this.transactions=this.service.miniStatement(this.service.loginAccount);
  }

  ngOnInit() {
    this.service.fetchTransactions();
    this.customers=this.service.getCustomers();
  }

}
