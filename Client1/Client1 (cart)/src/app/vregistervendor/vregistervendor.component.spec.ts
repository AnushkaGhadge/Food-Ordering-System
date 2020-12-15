import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VregistervendorComponent } from './vregistervendor.component';

describe('VregistervendorComponent', () => {
  let component: VregistervendorComponent;
  let fixture: ComponentFixture<VregistervendorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VregistervendorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VregistervendorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
