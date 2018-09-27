import { Employee } from './employee';


import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';

import { Http } from '@angular/http';
import { Injectable } from '@angular/core'; 


@Injectable()
export class EmployeeService {
    constructor(private http: Http) {
    }

    getEmployees(): Promise<Employee[]> {
        console.log('getEmployees called on employee.service');
        return this.http.get('http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/employees')
        .toPromise()
        .then(response => response.json() as Employee[])
        .catch(this.handleError);
    }

    getManagerDetails(mgrId: number): Observable<Employee> {
        console.log('getEmployees called on employee.service');
        return this.http.get('http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/employees/' +mgrId)
        .map(data=><Employee>data.json())
        
    }

    getEmployee(empId: number): Promise<Employee> {
        console.log('getEmployee called on employee.service');
        return this.http.get('http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/employees/'+empId)
        .toPromise()
        .then(response => response.json() as Employee)
        .catch(this.handleError);
    }
  

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}
