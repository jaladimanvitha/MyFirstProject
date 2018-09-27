export class Employee {
    empId: number;
    empName: String;
    empPhone: number;
    empEmail: String;
    empDept: String;
    empManagerId: number;
    empLeaveBalance: number;

    constructor(id: number,name: string,ph: number,email: string,dept: String,mgrId: number,lbal: number) {
      this.empId = id;
      this.empName = name;
      this.empPhone = ph;
      this.empEmail = email;
      this.empDept = dept;
      this.empManagerId = mgrId;
      this.empLeaveBalance = lbal;
    }
}
