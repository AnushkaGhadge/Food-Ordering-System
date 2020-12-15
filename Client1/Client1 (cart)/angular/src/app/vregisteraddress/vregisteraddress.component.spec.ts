import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VregisteraddressComponent } from './vregisteraddress.component';

describe('VregisteraddressComponent', () => {
  let component: VregisteraddressComponent;
  let fixture: ComponentFixture<VregisteraddressComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VregisteraddressComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VregisteraddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
