import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import {FormsModule} from '@angular/forms';
import {RouterTestingModule} from '@angular/router/testing';
import { HomeComponent } from './home.component';
import { EmployeeService } from './employee.service';
import { MockBackend } from '@angular/http/testing';
import { Employee } from './employee';
class MockEmployeeService {
  getEmployees(): Promise<Employee[]> {
    console.log('Mock getEmployees called');
    return Promise.resolve([new Employee(1000,"Manvitha",7659892371,"JaladigayatriM@hexaware.com","CEO",null,10),
    new Employee(2000,"RAGUL",9603780160,"RagulK@hexaware.com","MANAGER",1000,11)]);
  }
}
fdescribe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeComponent ],
      imports :[RouterTestingModule, FormsModule]
    }).overrideComponent(HomeComponent, {
    set: {
      providers: [
        {provide: EmployeeService, useClass: MockEmployeeService }
      ]
    }
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
  fit('should create the home', async(() => {
    const fixture = TestBed.createComponent(HomeComponent);
    const home = fixture.debugElement.componentInstance;
    expect(home).toBeTruthy();
  }));
  fit(`should have as title 'Leave Management Application'`, async(() => {
    const fixture = TestBed.createComponent(HomeComponent);
    const home = fixture.debugElement.componentInstance;
    expect(home.title).toEqual('Leave Management Application');
  }));
  fit('should render one employee record', async(() => {
    const fixture = TestBed.createComponent(HomeComponent);
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      fixture.detectChanges();
      const  getEmployees = fixture.debugElement.nativeElement;
      expect( getEmployees.querySelectorAll('.employees tr').length).toBe(2);
    });
  }));

  fit('should be created', () => {
    expect(component).toBeTruthy();
  });
});

