export class LeaveDetails {
    leaveId: number;
    startDate: Date;
    endDate: Date;
    noOfDays: number;
    leaveReason: String;
    leaveAppliedOn: Date;
    leaveType: LeaveType;
    leaveStatus: LeaveStatus;

    constructor(leaveId: number, startDate: Date, endDate: Date, noOfDays: number, leaveReason: String, leaveAppliedOn: Date,
        leaveType: LeaveType, leaveStatus: LeaveStatus) {
        this.leaveId = leaveId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.noOfDays = noOfDays;
        this.leaveReason = leaveReason;
        this.leaveAppliedOn = leaveAppliedOn;
        this.leaveType = leaveType;
        this.leaveStatus = leaveStatus;

    }
}
export enum LeaveStatus {
    PENDING,
    APPROVED,
    DENIED
}
export enum LeaveType {
    EL
}
