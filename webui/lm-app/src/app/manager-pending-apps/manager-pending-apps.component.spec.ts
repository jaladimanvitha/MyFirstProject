import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule} from '@angular/router/testing';
import { ManagerPendingAppsComponent } from './manager-pending-apps.component';
import { FormsModule } from '@angular/forms';
import {LeavedetailsService} from './leavedetails.service';
import { Observable } from 'rxjs/Rx';
import {LeaveDetails,LeaveType,LeaveStatus} from './leavedetails';
class MockLeavedetailsService {
  getPending(empId):Observable<Object[]> {
    console.log('Mock getPending called');
    return Observable.of([new LeaveDetails(1,new Date(2018,2,3),new Date(2018,2,5),2,"sick",new Date(2018,2,2),LeaveType.EL,LeaveStatus.PENDING)]);
}
}
fdescribe('ManagerPendingAppsComponent', () => {
  let component: ManagerPendingAppsComponent;
  let fixture: ComponentFixture<ManagerPendingAppsComponent>;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerPendingAppsComponent ],
      imports: [ RouterTestingModule,FormsModule],
    }).overrideComponent(ManagerPendingAppsComponent, {
      set: {
        providers: [
          {provide: LeavedetailsService, useClass: MockLeavedetailsService }
        ]
      }
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerPendingAppsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  fit('should be created', () => {
    expect(component).toBeTruthy();
  });
  fit('should create the pending', async(()=>{
    const fixture = TestBed.createComponent(ManagerPendingAppsComponent);
    const pending = fixture.debugElement.componentInstance;
    expect(pending).toBeTruthy();
  }));
  fit(`should have as title 'empId'`, async(() => {
    const fixture = TestBed.createComponent(ManagerPendingAppsComponent);
    const mp = fixture.debugElement.componentInstance;
    expect(mp.empId).toBeUndefined();
  }));
  fit(`should have as title 'leavedetails'`, async(() => {
    const fixture = TestBed.createComponent(ManagerPendingAppsComponent);
    const mp = fixture.debugElement.componentInstance;
    expect(mp.leavedetails).toBeUndefined();
  }));
  fit('should render title in a h1 tag', async(() => {
    const fixture = TestBed.createComponent(ManagerPendingAppsComponent);
    fixture.detectChanges();
    const compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('My Reporting Employees Leave Applications');
  }));
  fit('should create the appden', async(()=>{
    const fixture = TestBed.createComponent(ManagerPendingAppsComponent);
    const appden = fixture.debugElement.componentInstance;
    expect(appden).toBeTruthy();
  }));
  fit('should create the approveordeny', async(()=>{
    const fixture = TestBed.createComponent(ManagerPendingAppsComponent);
    const approveordeny = fixture.debugElement.componentInstance;
    expect(approveordeny).toBeTruthy();
  }));
});
