import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { DepositComponent } from './deposit/deposit.component';
import { WithdrawComponent } from './withdraw/withdraw.component';
import { ShowBalanceComponent } from './show-balance/show-balance.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { PrintTransactionComponent } from './print-transaction/print-transaction.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CustomerService } from './customer.service';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    LoginComponent,
    DepositComponent,
    WithdrawComponent,
    ShowBalanceComponent,
    FundTransferComponent,
    PrintTransactionComponent,
    CreateCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [HttpClient,CustomerService],
  bootstrap: [AppComponent]
})
export class AppModule { }
