import { Component, OnInit} from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';
import { LeavedetailsService } from './leavedetails.service';
import { LeaveDetails } from './leavedetails';
import { Employee } from './Employee';
import { Leave } from './Leave';
import {EmployeeLeave} from './EmployeeLeave';
@Component({
  selector: 'app-manager-pending-apps',
  templateUrl: './manager-pending-apps.component.html',
  styleUrls: ['./manager-pending-apps.component.css'],
  providers: [LeavedetailsService]
})
export class ManagerPendingAppsComponent implements OnInit {
  /*@ViewChild('#abc')
  textarea: ElementRef;  , AfterContentInit,AfterViewInit,ViewChild,ElementRef */
constructor(private leavedetailsService: LeavedetailsService,private router: Router,private activatedRoute:ActivatedRoute) { 

}
  leavedetails: Object[];
  emp:Employee[];
  leaved:Leave[];
  empId:number;
  leave:Leave;
  empl:Employee;
  val:string;
  pending():void { 
  console.log("****Pending****");
  let jsData = JSON.stringify(this.leavedetails);
  this.val = jsData;
  console.log(this.leavedetails);
  console.log(jsData);
  try{
  var JsonData = JSON.parse(jsData || null);
  }catch(e){
      console.log(e);
  }
  console.log("---->"+JsonData);
  this.emp=JsonData.Employee;
  this.leaved=JsonData.Leave;
}

flag:boolean=true;
approveordeny(leave,e):void {
  this.flag=false;
  sessionStorage.setItem("empId",e.empId);
  sessionStorage.setItem("empName",e.empName);
  sessionStorage.setItem("empBal",e.empLeaveBalance);
  sessionStorage.setItem("lId",leave.leaveId);
  sessionStorage.setItem("stdate",leave.startDate);
  sessionStorage.setItem("edate",leave.endDate);
  sessionStorage.setItem("days",leave.noOfDays);
  sessionStorage.setItem("lreason",leave.leaveReason);
  sessionStorage.setItem("empManagerId",e.empManagerId);
}
appden():void {
  this.router.navigate(['/dashboard/'+this.empId, {outlets:{'approveordeny':['app-approveor-deny'], 'pending':null}}])
}
/*ngAfterViewInit() {
  let jsData = JSON.stringify(this.leavedetails);
  this.val = jsData;
  console.log(this.leavedetails);
  console.log(jsData);
  try{
  var JsonData = JSON.parse(jsData || null);
  }catch(e){
      console.log(e);
  }
  console.log("---->"+JsonData);
  this.emp=JsonData.Employee;
  this.leaved=JsonData.Leave;
}
ngAfterContentInit() {
  let jsData = JSON.stringify(this.leavedetails);
  this.val = jsData;
  console.log(this.leavedetails);
  console.log(jsData);
  try{
  var JsonData = JSON.parse(jsData || null);
  }catch(e){
      console.log(e);
  }
  console.log("---->"+JsonData);
  this.emp=JsonData.Employee;
  this.leaved=JsonData.Leave;
}*/
ngOnInit(){
  this.empId=eval(sessionStorage.getItem("Id"));
  this.leavedetailsService.getPending(this.empId).subscribe(values=>this.leavedetails=values);
  
}
}
