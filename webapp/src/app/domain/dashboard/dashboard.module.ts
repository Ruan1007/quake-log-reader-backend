import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {DashboardRouting} from './dashboard-routing.module';
import {DashboardComponent} from './dashboard.component';
import {DataTablesModule} from 'angular-datatables';

@NgModule({
  declarations: [DashboardComponent],
  imports: [
    CommonModule,
    DashboardRouting,
    DataTablesModule
  ],
  
})
export class DashboardModule {
}
