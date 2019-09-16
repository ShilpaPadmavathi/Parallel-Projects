import { Component, OnInit } from '@angular/core';
import { Customer, CustomerService } from '../customer.service';

@Component({
  selector: 'app-show-balance',
  templateUrl: './show-balance.component.html',
  styleUrls: ['./show-balance.component.css']
})
export class ShowBalanceComponent implements OnInit {

  isLogin:boolean=true;
  customers:Customer[]=[];
  cbalance:number;
  isShowBalance:boolean=true;
  service:CustomerService;

  constructor(service:CustomerService) { 
    this.service=service;
    this.isLogin=this.service.isLogin;
  }

  showBalance(data:any){
    this.cbalance=this.service.showBalance();
    this.isShowBalance=!this.isShowBalance;
  }
          
  ngOnInit() {
    this.service.fetchCustomers();;
    this.customers=this.service.getCustomers();
  }

}
