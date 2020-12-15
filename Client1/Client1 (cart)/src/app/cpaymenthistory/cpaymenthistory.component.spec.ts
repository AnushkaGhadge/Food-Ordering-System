import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CpaymenthistoryComponent } from './cpaymenthistory.component';

describe('CpaymenthistoryComponent', () => {
  let component: CpaymenthistoryComponent;
  let fixture: ComponentFixture<CpaymenthistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CpaymenthistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CpaymenthistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
