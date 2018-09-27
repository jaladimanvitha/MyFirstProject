import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import {RouterTestingModule} from '@angular/router/testing';
import { LeaveapplicationsComponent } from './leaveapplications.component';
import { LeavedetailsService } from '../manager-pending-apps/leavedetails.service';
import { LeaveDetails, LeaveStatus, LeaveType } from '../manager-pending-apps/leavedetails';
class MockLeaveService {
  getLeaveDetails(empId):Promise<Object[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new LeaveDetails(1,new Date(2018,2,3),new Date(2018,2,5),2,'sick',new Date(2018,3,1),LeaveType.EL,LeaveStatus.PENDING)]);
  }
}
fdescribe('LeaveapplicationsComponent', () => {
  let component: LeaveapplicationsComponent;
  let fixture: ComponentFixture<LeaveapplicationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveapplicationsComponent ], 
      imports: [ RouterTestingModule,FormsModule]

    }).overrideComponent(LeaveapplicationsComponent, {
      set: {
        providers: [
          {provide: LeavedetailsService, useClass: MockLeaveService }
        ]
      }
    }).compileComponents();
  }));
    beforeEach(() => {
      fixture = TestBed.createComponent(LeaveapplicationsComponent);
      component = fixture.componentInstance;
      fixture.detectChanges();
    });

  fit('should be created', () => {
    const fixture = TestBed.createComponent(LeaveapplicationsComponent);
    const app = fixture.debugElement.componentInstance;
    expect(component).toBeTruthy();
  });
  it('should render one leavedetails record', async(() => {
    const fixture = TestBed.createComponent(LeaveapplicationsComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      const compiled = fixture.debugElement.nativeElement;
      expect(compiled.querySelectorAll('.leavedetails tr').length).toBe(3);
    });
  }));
});

