import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule} from '@angular/router/testing';
import { ApproveorDenyComponent } from './approveor-deny.component';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs/Rx';
import {LeavedetailsService} from './../manager-pending-apps/leavedetails.service';
import {LeaveDetails,LeaveType,LeaveStatus} from './../manager-pending-apps/leavedetails';
describe('ApproveorDenyComponent', () => {
  let component: ApproveorDenyComponent;
  let fixture: ComponentFixture<ApproveorDenyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ApproveorDenyComponent ],
      imports :[RouterTestingModule, FormsModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ApproveorDenyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
  it('should create the Approve', async(()=>{
    const fixture = TestBed.createComponent(ApproveorDenyComponent);
    const approve = fixture.debugElement.componentInstance;
    expect(approve).toBeTruthy();
  }));
  it('should create the Deny', async(()=>{
    const fixture = TestBed.createComponent(ApproveorDenyComponent);
    const deny = fixture.debugElement.componentInstance;
    expect(deny).toBeTruthy();
  }));
  it('should create the cancel', async(()=>{
    const fixture = TestBed.createComponent(ApproveorDenyComponent);
    const cancel = fixture.debugElement.componentInstance;
    expect(cancel).toBeTruthy();
  }));
});
