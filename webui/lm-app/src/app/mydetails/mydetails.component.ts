import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { EmployeeService } from '../home/employee.service';
import { Employee } from '../home/employee';
//import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';
import {Http} from '@angular/http';
@Component({
  selector: 'app-mydetails',
  templateUrl: './mydetails.component.html',
  styleUrls: ['./mydetails.component.css'],
  providers: [EmployeeService]
})
export class MydetailsComponent implements OnInit {

  constructor(private employeeService: EmployeeService,private router: Router,private activatedRoute:ActivatedRoute) { }
  employee: Employee;
  empId:number;
  getEmployee(): void {
    this.employeeService.getEmployee(this.empId).then(employee => {
      console.log('getEmployee promise resolved');
      this.employee = employee;
    }
  );
}

  ngOnInit() {
    this.empId=this.activatedRoute.snapshot.params['empId'];
    this.getEmployee();
  }

}
