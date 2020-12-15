import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CfeedbackComponent } from './cfeedback.component';

describe('CfeedbackComponent', () => {
  let component: CfeedbackComponent;
  let fixture: ComponentFixture<CfeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CfeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CfeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
