import { Injectable } from '@angular/core';
import { LeaveDetails } from './leavedetails';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';
import { Http } from '@angular/http';
import {EmployeeLeave} from './EmployeeLeave';
@Injectable()
export class LeavedetailsService {

  constructor(private http: Http) { }
getPending(empId): Observable<Object[]> {
    console.log('getLeaveDetails called on leavedetails.service');
    return this.http.get('http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/leavedetails/pending/'+empId)
    .map(data=>data.json());
}


/*getPending(empId): Promise<Object[]> {
    console.log('getLeaveDetails called on leavedetails.service');
    return this.http.get('http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/leavedetails/pending/'+empId)
    .toPromise()
    .then(response => response.json() as Object[])
    .catch(this.handleError);
}*/
getLeaveDetails(id): Promise<LeaveDetails[]> {
    let emp=id;
    console.log('getLeaveDetails called on leavedetails.service');
    return this.http.get('http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/leavedetails/leaveapp/'+emp)
    .toPromise()
    .then(response => response.json() as LeaveDetails[])
    .catch(this.handleError);
}
approveOrDeny(leaveId,status,comments): void {
    
    let url = 'http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/leavedetails/approveordeny' 
               + '/' + leaveId + '/' + status +'/' + comments;
    this.http.post(url,null).subscribe(res => console.log(res),
        error => (console.log("Error"+error)),()=>console.log("completed"));
    console.log("In service class");
} 
getApplyLeave(obj,empId):void{
    let val={}
    var startdate=obj.get("startdate").value;
    var enddate=obj.get("enddate").value;
    var noofdays=obj.get("noOfDays").value;
    var ltype=obj.get("ltype").value;
    var lreason=obj.get("lreason").value;
    console.log(enddate);
    let url ="http://localhost:8080/ftp13-0.0.1-SNAPSHOT/api/leavedetails/applyleave/"+empId+"/"+startdate+"/"+enddate+"/"+ltype+"/"+lreason;
    console.log('apply leave on leaveDetails service');
    
    this.http.post(url,val).subscribe(res=>console.log("inserted"),error=>console.log(error));
    console.log("Record Inserted");
   }

private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
}
}
