import { Component } from '@angular/core';
import { CustomerService } from './customer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'XYZBankWallet';
  
  message:string;

  constructor(private check: CustomerService) { }

  ngOnInit() {
    this.check.currentMessage.subscribe(message => this.message = message)
  }
}
