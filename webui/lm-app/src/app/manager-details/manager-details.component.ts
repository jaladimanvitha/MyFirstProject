import { Component, OnInit ,Input, OnChanges } from '@angular/core';
import { Employee } from './../home/employee';
import { EmployeeService } from './../home/employee.service';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';
import { Http } from '@angular/http';
import {Router} from '@angular/router';


@Component({
  selector: 'app-manager-details',
  templateUrl: './manager-details.component.html',
  styleUrls: ['./manager-details.component.css'],
  providers: [ EmployeeService ]
})
export class ManagerDetailsComponent implements OnInit,OnChanges {

  constructor(private employeeService: EmployeeService,private router: Router) { }
  employees:Employee;
  @Input()
  manager:Employee;
  mgrId: number;
ngOnInit() {
    this.employeeService.getManagerDetails(this.mgrId)
    .subscribe((emp:Employee)=>console.log(this.employees=emp)),error=>console.log(error),console.log("completed");
  }
  ngOnChanges(){
    this.mgrId=this.manager.empManagerId;
    //this.mgrId=this.activatedRoute.snapshot.params['mgrId'];
    this.ngOnInit();
  }
 
}
