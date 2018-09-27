import { Component, OnInit } from '@angular/core';
import {Router,ActivatedRoute} from '@angular/router';
import { LeavedetailsService } from './../manager-pending-apps/leavedetails.service';
import {FormGroup,FormControl,Validators} from '@angular/forms';
import {Leave} from './../manager-pending-apps/Leave';
import {Employee} from './../manager-pending-apps/Employee';
//import {SortPipe} from '../manager-pending-apps/sort';
@Component({
  selector: 'app-approveor-deny',
  templateUrl: './approveor-deny.component.html',
  styleUrls: ['./approveor-deny.component.css'],
  providers: [LeavedetailsService]
})
export class ApproveorDenyComponent implements OnInit {

  constructor(private leavedetailsService: LeavedetailsService,private router: Router,private activatedRoute:ActivatedRoute) { }
  leave:Leave[];
  emp:Employee[];
  empId:number;
  empName:string;
  empLeaveBalance:number;
  leaveId:number;
  leaveType:string;
  startDate:Date;
  endDate:Date;
  noOfDays:number;
  leaveReason:string;
  status:string;
  comments:string;
  empMgrId:number;
  approve():void {
    this.status="APPROVED";
    this.leavedetailsService.approveOrDeny(this.leaveId,this.status,this.comments);
    this.router.navigate(['/dashboard/'+this.empMgrId, {outlets:{'pending':['app-manager-pending-apps'], 'approveordeny':null}}])
  }
  deny():void {
    this.status="DENIED";
    this.leavedetailsService.approveOrDeny(this.leaveId,this.status,this.comments);
    this.router.navigate(['/dashboard/'+this.empMgrId, {outlets:{'pending':['app-manager-pending-apps'], 'approveordeny':null}}])
  }

  cancel():void {
    this.status="PENDING";
    this.leavedetailsService.approveOrDeny(this.leaveId,this.status,this.comments);
    this.router.navigate(['/dashboard/'+this.empMgrId, {outlets:{'pending':['app-manager-pending-apps'], 'approveordeny':null}}])
  }
  ngOnInit() {
     this.empId = parseInt(sessionStorage.getItem("empId"));
     this.empName = sessionStorage.getItem("empName");
     this.empLeaveBalance = parseInt(sessionStorage.getItem("empBal"));
     this.leaveId = parseInt(sessionStorage.getItem("lId"));
     let sDate = new Date(sessionStorage.getItem("stdate"));
     let eDate = new Date(sessionStorage.getItem("edate"));
     this.noOfDays = parseInt(sessionStorage.getItem("days"));
     this.leaveType = "Earned Leave";
     this.empMgrId=eval(sessionStorage.getItem("Id"));
     this.leaveReason = sessionStorage.getItem("lreason");
     this.startDate = new Date(sDate);
     this.endDate = new Date(eDate);
  }

}
