import{NgModule} from '@angular/core';
import {RouterModule,Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {LeaveapplicationsComponent } from './leaveapplications/leaveapplications.component';
import {MydetailsComponent} from './mydetails/mydetails.component';
import {ManagerPendingAppsComponent} from './manager-pending-apps/manager-pending-apps.component';
import{ManagerDetailsComponent} from './manager-details/manager-details.component';
import { ApproveorDenyComponent } from './approveor-deny/approveor-deny.component';
import {ApplyleaveComponent} from './applyleave/applyleave.component';

const routesInfo:Routes=[
    {path:'login/:empId',component:LoginComponent},

    {path:'dashboard/:empId',component:DashboardComponent,
     children:[
     {path:'mydetails',component:MydetailsComponent},
     {path:'app-leaveapplications',component:LeaveapplicationsComponent, outlet:'leaveapp'},
     {path:'app-manager-pending-apps',component:ManagerPendingAppsComponent, outlet:'pending'},
     {path:'manager-details',component:ManagerDetailsComponent},
     {path:'app-applyleave',component:ApplyleaveComponent, outlet:'applyleave'},
     {path:'app-approveor-deny',component:ApproveorDenyComponent, outlet: 'approveordeny'}
    ]},
    
    {path:'home',component:HomeComponent},
    {path:'',redirectTo:'/home',pathMatch:'full'},
     
]
@NgModule({
 imports:[RouterModule.forRoot(routesInfo)],
 exports:[RouterModule]
})
export class RoutingConfigDemo{

}