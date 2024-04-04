import { TestBed } from '@angular/core/testing';

import { UserJwtService } from './user-jwt.service';

describe('UserJwtService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: UserJwtService = TestBed.get(UserJwtService);
    expect(service).toBeTruthy();
  });
});
