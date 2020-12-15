import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CcartComponent } from './ccart.component';

describe('CcartComponent', () => {
  let component: CcartComponent;
  let fixture: ComponentFixture<CcartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CcartComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CcartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
