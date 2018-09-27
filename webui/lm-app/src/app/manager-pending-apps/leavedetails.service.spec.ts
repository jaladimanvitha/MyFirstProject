import { TestBed, inject } from '@angular/core/testing';

import { LeavedetailsService } from './leavedetails.service';

describe('LeavedetailsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LeavedetailsService]
    });
  });

  it('should be created', inject([LeavedetailsService], (service: LeavedetailsService) => {
    expect(service).toBeTruthy();
  }));
});
