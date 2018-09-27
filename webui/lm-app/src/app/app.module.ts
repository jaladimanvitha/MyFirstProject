import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {RoutingConfigDemo} from './routingConfig';
import {SortPipe} from './manager-pending-apps/sort';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomeComponent } from './home/home.component';
import { MydetailsComponent } from './mydetails/mydetails.component';
import { ManagerDetailsComponent } from './manager-details/manager-details.component';
import { LeaveapplicationsComponent } from './leaveapplications/leaveapplications.component';
import {ManagerPendingAppsComponent} from './manager-pending-apps/manager-pending-apps.component';
import { ApproveorDenyComponent } from './approveor-deny/approveor-deny.component';
import { ApplyleaveComponent } from './applyleave/applyleave.component';
import { FormGroupDirective } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    DashboardComponent,
    HomeComponent,
    MydetailsComponent,
    ManagerDetailsComponent,
    LeaveapplicationsComponent,
    ManagerPendingAppsComponent,
    ApproveorDenyComponent,
    ApplyleaveComponent,
    SortPipe
  ],
  imports: [
    BrowserModule,HttpModule,FormsModule,RoutingConfigDemo,ReactiveFormsModule
  ],
  
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
