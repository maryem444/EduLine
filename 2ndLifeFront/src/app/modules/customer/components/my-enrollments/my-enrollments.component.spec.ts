import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyEnrollmentsComponent } from './my-enrollments.component';

describe('MyEnrollmentsComponent', () => {
  let component: MyEnrollmentsComponent;
  let fixture: ComponentFixture<MyEnrollmentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyEnrollmentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyEnrollmentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
