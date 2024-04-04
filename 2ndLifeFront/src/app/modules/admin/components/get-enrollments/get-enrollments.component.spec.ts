import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GetEnrollmentsComponent } from './get-enrollments.component';

describe('GetEnrollmentsComponent', () => {
  let component: GetEnrollmentsComponent;
  let fixture: ComponentFixture<GetEnrollmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GetEnrollmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GetEnrollmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
