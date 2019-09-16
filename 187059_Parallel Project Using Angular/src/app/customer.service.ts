import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  http:HttpClient;
  isLogin:boolean=true;
  customers:Customer[]=[];
  transactions:Transactions[]=[];
  tempTransaction:Transactions[]=[];
  fetched:boolean=false;
  fetchedT:boolean=false;
  loginAccount:number=0;
  
  private check = new BehaviorSubject('');
  currentMessage = this.check.asObservable();

  changeMessage(message: string) {
    this.check.next(message)
  }

  constructor(http:HttpClient) { 
    this.http=http;
    this.fetchCustomers();
    this.fetchTransactions();
  }

  fetchCustomers()
  {
    this.http.get('./assets/Customer.json')
    .subscribe
    (
      data=>
      {
        if(!this.fetched)
        {
          this.convert(data);
          this.fetched=true;
        }
      }
    );
  }

  convert(data:any)
  {
    for(let o of data)
    {
      let e=new Customer(o.caccount,o.cname,o.cphone,o.cpassword,o.ccity,o.cbalance);
      this.customers.push(e);
    }
  }

  fetchTransactions()
  {
    this.http.get('./assets/Transactions.json')
    .subscribe
    (
      data=>
      {
        if(!this.fetchedT)
        {
          this.convertTransaction(data);
          this.fetchedT=true;
        }
      }
    );
  }

  convertTransaction(dataT:any)
  {
    for(let o of dataT)
    {
      let e=new Transactions(o.tid,o.taccount_sender,o.taccount_reciver,o.tamount,o.ttype);
      this.transactions.push(e);
      console.log(this.transactions)
    }
  }

  getCustomers():Customer[]
  {
    return this.customers;
  }

  getTransactions():Transactions[]
  {
    return this.transactions;
  }

  miniStatement(caccount:number):Transactions[]{
    this.tempTransaction=[];
    for(let i=0;i<this.transactions.length;i++)
    {
      let e=this.transactions[i];
      if(caccount==e.taccount_sender)
      {
        this.tempTransaction.push(e);
      }
    }
    return this.tempTransaction;
  }

  add(e:Customer){
    this.customers.push(e);
    var myJSON = JSON.stringify(this.customers);
  }

  addTransaction(e:Transactions){
    this.transactions.push(e);
    console.log(this.transactions)
  }

  showBalance():number{
    for(let i=0;i<this.customers.length;i++)
      {
        if(this.loginAccount == this.customers[i].caccount)
        {
          let cbalance=this.customers[i].cbalance;
          alert("Current Balance : "+cbalance)
          return cbalance;
        }else{
          continue;
        }
      }
      alert("Account No does not matched!")
  }

  depositeBalance(caccount_second:number,cbalance:number):boolean{

    for(let i=0;i<this.customers.length;i++)
    {
      if(this.loginAccount== this.customers[i].caccount)
      {
        let depositeB:number=this.customers[i].cbalance;
        this.customers[i].cbalance=parseInt(depositeB.toString()) + parseInt(cbalance.toString());
        alert("Amount deposited from "+this.loginAccount+"\nUpdated balance : "+this.customers[i].cbalance);
        return true;
      }else if(caccount_second == this.customers[i].caccount){
        let depositeB:number=this.customers[i].cbalance;
        this.customers[i].cbalance=parseInt(depositeB.toString()) + parseInt(cbalance.toString());
        alert("Amount deposited from "+this.loginAccount+"\nUpdated balance : "+this.customers[i].cbalance);
        return true;
      }
      else
      {
        continue;
      }
    }
      alert("Please Login First")
  }

  withdrawBalance(caccount_second:number,cbalance:number){

    for(let j=0;j<this.customers.length;j++)
    {
      if(this.loginAccount == this.customers[j].caccount)
      {
        let depositec:number=this.customers[j].cbalance;
        this.customers[j].cbalance=parseInt(depositec.toString()) - parseInt(cbalance.toString());
        alert("Amount withdrawn to "+this.loginAccount+"\nUpdated Balance : "+this.customers[j].cbalance);
        return true;
      }else if(caccount_second == this.customers[j].caccount){
        let depositeB:number=this.customers[j].cbalance;
        this.customers[j].cbalance=parseInt(depositeB.toString()) - parseInt(cbalance.toString());
        alert("Amount withdrawn to "+this.loginAccount+"\nUpdated balance : "+this.customers[j].cbalance);
        return true;
      }else{
        continue;
      }
    }
      alert("Please Login First")
  }

  login(data:Customer):boolean
  {
    this.loginAccount=data.caccount;
    let cpassword=data.cpassword;

    for(let a of this.customers)
    {
      console.log(this.customers)
      if(this.loginAccount == a.caccount && cpassword == a.cpassword)
      {
       
        alert("Value Matched!")
        this.isLogin=!this.isLogin;
        this.changeMessage('loginhai');
        return true;
      }else {
        continue;
      }
      
    }
    return false; 
  }
}
export class Customer{
  caccount:number;
  cname:string;
  cphone:number;
  cpassword:string;
  ccity:string;
  cbalance:number;
    constructor(caccount:number,cname:string,cphone:number,cpassword:string,ccity:string,cbalance:number)
    {
      this.cbalance=cbalance;
      this.caccount=caccount;
      this.cname=cname;
      this.cphone=cphone;
      this.cpassword=cpassword;
      this.ccity=ccity;
    }
}

export class Transactions{
  tid:number;
  taccount_sender:number;
  taccount_reciver:number;
  tamount:number;
  ttype:string;
    constructor(tid:number,taccount_sender:number,taccount_reciver:number,tamount:number,ttype:string)
    {
      this.tid=tid;
      this.taccount_sender=taccount_sender;
      this.taccount_reciver=taccount_reciver;
      this.tamount=tamount;
      this.ttype=ttype;
    }
}