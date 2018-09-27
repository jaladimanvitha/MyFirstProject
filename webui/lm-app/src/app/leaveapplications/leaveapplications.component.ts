import { Component, OnInit, Input } from '@angular/core';
import {LeavedetailsService} from '../manager-pending-apps/leavedetails.service';
import {LeaveDetails} from '../manager-pending-apps/leavedetails';
import {Router, ActivatedRoute} from '@angular/router';
import {SortPipe } from './../manager-pending-apps/sort';


@Component({
  selector: 'app-leaveapplications',
  templateUrl: './leaveapplications.component.html',
  styleUrls: ['./leaveapplications.component.css'],
  providers:[LeavedetailsService]
})
export class LeaveapplicationsComponent implements OnInit {
 @Input()
empId :number;
  constructor(private leavedetailsService: LeavedetailsService, private router: Router,private activatedRoute:ActivatedRoute) { }
          leavedetails:LeaveDetails[];
          getLeaveDetails():void{
            this.leavedetailsService.getLeaveDetails(this.empId).then(leavedetails=>{

              console.log('getLeavedetails promise resolved' + leavedetails.length);
              this.leavedetails=leavedetails;
            });
          }
         
    
          newApplication():void{
            this.router.navigate(['/dashboard/'+this.empId, {outlets:{'applyleave':['app-applyleave'], 'leaveapp':null}}])
            
          }
         
  ngOnInit() {
       // this.empId=this.activatedRoute.snapshot.params['empId'];
       this.empId=eval(sessionStorage.getItem("Id"));
          this.getLeaveDetails();  
        }
}
