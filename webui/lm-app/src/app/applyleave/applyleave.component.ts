import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { FormGroup,FormControl, Validators } from '@angular/forms';
import { LeavedetailsService } from './../manager-pending-apps/leavedetails.service';
import { combineAll } from 'rxjs/operator/combineAll';




@Component({
  selector: 'app-applyleave',
  templateUrl: './applyleave.component.html',
  styleUrls: ['./applyleave.component.css'],
  providers: [LeavedetailsService]
})
export class ApplyleaveComponent implements OnInit {

  constructor(private router:Router, private leavedetails:LeavedetailsService, private activatedRoute: ActivatedRoute) { }
  appleave= new FormGroup({
    startdate: new FormControl('',Validators.required),
    enddate: new FormControl('',Validators.required),
    noOfDays: new FormControl(),
    ltype: new FormControl(),
    lreason: new FormControl(),
  });
  checkStartDate():String{
     var d1=new Date();
     let dd:any= d1.getDate();
     let mon:any = d1.getMonth()+1;
     var year= d1.getFullYear();
     if(dd<10){
      dd="0"+dd;
     }
     if(mon<10){
       mon="0"+mon;
     }
     var todate= year+"-"+mon+"-"+dd;

   return todate;
  }
  applyInfo():void{
    this.leavedetails.getApplyLeave(this.appleave,this.empId);
    this.router.navigate(['/dashboard/'+this.empId, {outlets:{'leaveapp':['app-leaveapplications'], 'applyleave':null}}])
  }
   noofdays:number;
  cal():void{
    var startdate=this.appleave.get("startdate").value;
    var enddate=this.appleave.get("enddate").value;
    let sd=new Date(startdate);
    let ed=new Date(enddate);
    let diff= ed.getTime()-sd.getTime();
    this.noofdays= ((diff)/86400000)+1;
    var leaveType=this.appleave.get("ltype").value;
  }
 cancel():void{
  this.router.navigate(['/dashboard/'+this.empId, {outlets:{'leaveapp':['app-leaveapplications'], 'applyleave':null}}])

 }
  
  empId:number;
  ngOnInit() {

    //this.empId=this.activatedRoute.snapshot.params['empId'];
    this.empId=eval(sessionStorage.getItem("Id"));

  }
  ngOnChanges(changes: SimpleChanges){
    this.ngOnInit();
  }

}
