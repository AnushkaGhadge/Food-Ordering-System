import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AlistallorderComponent } from './alistallorder.component';

describe('AlistallorderComponent', () => {
  let component: AlistallorderComponent;
  let fixture: ComponentFixture<AlistallorderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AlistallorderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AlistallorderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
