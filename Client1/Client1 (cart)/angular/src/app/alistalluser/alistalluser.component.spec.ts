import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlistalluserComponent } from './alistalluser.component';

describe('AlistalluserComponent', () => {
  let component: AlistalluserComponent;
  let fixture: ComponentFixture<AlistalluserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlistalluserComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlistalluserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
