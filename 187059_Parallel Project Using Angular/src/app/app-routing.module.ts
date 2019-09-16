import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { DepositComponent } from './deposit/deposit.component';
import { FundTransferComponent } from './fund-transfer/fund-transfer.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { PrintTransactionComponent } from './print-transaction/print-transaction.component';
import { ShowBalanceComponent } from './show-balance/show-balance.component';
import { WithdrawComponent } from './withdraw/withdraw.component';


const routes: Routes = [
  {
    path:'app-create-customer',
    component : CreateCustomerComponent
  },
  {
    path:'app-deposit',
    component : DepositComponent
  },
  {
    path:'app-fund-transfer',
    component : FundTransferComponent
  },
  {
    path:'app-homepage',
    component : HomepageComponent
  },
  {
    path:'app-login',
    component : LoginComponent
  },
  {
    path:'app-print-transaction',
    component : PrintTransactionComponent
  },
  {
    path:'app-show-balance',
    component : ShowBalanceComponent
  },
  {
    path:'app-withdraw',
    component : WithdrawComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
