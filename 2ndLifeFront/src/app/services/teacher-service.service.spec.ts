import { TestBed } from '@angular/core/testing';

import { TeacherService } from './teacher-service.service';

describe('TeacherServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TeacherService = TestBed.get(TeacherService);
    expect(service).toBeTruthy();
  });
});
