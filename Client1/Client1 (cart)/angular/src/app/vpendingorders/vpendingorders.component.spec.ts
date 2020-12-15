import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VpendingordersComponent } from './vpendingorders.component';

describe('VpendingordersComponent', () => {
  let component: VpendingordersComponent;
  let fixture: ComponentFixture<VpendingordersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VpendingordersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VpendingordersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
