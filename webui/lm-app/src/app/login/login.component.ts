import { Component, OnInit } from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import { EmployeeService } from '../home/employee.service';
import { Employee } from '../home/employee';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private router:Router, private activatedRoute:ActivatedRoute) { }
  empid:number;
  verifyEmpInfo(empInfo):void{
   let pass=empInfo.pass;
      
   if(pass!=0 && pass!=null){
     this.router.navigate(['/dashboard/'+this.empid, {outlets:{'leaveapp':['app-leaveapplications'], 'pending':['app-manager-pending-apps']
  }}])
   }

  }
  cancel():void{
    this.router.navigate(['/home'])
  }

  ngOnInit() {
  this.empid=this.activatedRoute.snapshot.params['empId']; 
  }

}
