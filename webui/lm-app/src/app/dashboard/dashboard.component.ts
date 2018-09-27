import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { EmployeeService } from '../home/employee.service';
import { Employee } from '../home/employee';
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router:Router, private activatedRoute:ActivatedRoute) { }
  empId:number;

  pending():void{
    this.router.navigate(['pending/'+this.empId])
  }
  flag:boolean = false;
  ngOnInit() {
    this.empId=this.activatedRoute.snapshot.params['empId'];
    sessionStorage.setItem("Id",this.empId.toString()); 
  }
  logout():void {
    this.router.navigate(['/home']);
  }

}
