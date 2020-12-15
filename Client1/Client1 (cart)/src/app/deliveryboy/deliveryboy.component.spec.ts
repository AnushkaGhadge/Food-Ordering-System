import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DeliveryboyComponent } from './deliveryboy.component';

describe('DeliveryboyComponent', () => {
  let component: DeliveryboyComponent;
  let fixture: ComponentFixture<DeliveryboyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DeliveryboyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DeliveryboyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
