import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CpaymentdetailsComponent } from './cpaymentdetails.component';

describe('CpaymentdetailsComponent', () => {
  let component: CpaymentdetailsComponent;
  let fixture: ComponentFixture<CpaymentdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CpaymentdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CpaymentdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
