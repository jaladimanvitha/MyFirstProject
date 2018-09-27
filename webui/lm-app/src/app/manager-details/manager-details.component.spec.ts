import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import {RouterTestingModule} from '@angular/router/testing';
import { ManagerDetailsComponent } from './manager-details.component';
import { Employee } from '../home/employee';
import { EmployeeService } from '../home/employee.service';
class MockEmployeeService {
  getEmployees(): Promise<Employee[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new Employee(1000,"Manvitha",7659892371,"JaladigayatriM@hexaware.com","CEO",null,10),
    new Employee(2000,"RAGUL",9603780160,"RagulK@hexaware.com","MANAGER",1000,11),
    new Employee(2001,"SHRADDHA",8297720156,"ShraddhaG@hexaware.com","MANAGER",1000,9)]);
  }
}

describe('ManagerDetailsComponent', () => {
  let comp: ManagerDetailsComponent;
  let fixture: ComponentFixture<ManagerDetailsComponent>;
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        ManagerDetailsComponent
      ],
      imports :[RouterTestingModule, FormsModule]
    }).overrideComponent(ManagerDetailsComponent, {
      set: {
        providers: [
          {provide: EmployeeService, useClass: MockEmployeeService }
        ]
      }
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerDetailsComponent);
    comp = fixture.componentInstance;
    fixture.detectChanges();
  });
  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(ManagerDetailsComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeFalsy();
  }));
});
