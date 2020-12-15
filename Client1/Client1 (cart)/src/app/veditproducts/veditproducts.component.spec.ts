import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VeditproductsComponent } from './veditproducts.component';

describe('VeditproductsComponent', () => {
  let component: VeditproductsComponent;
  let fixture: ComponentFixture<VeditproductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VeditproductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VeditproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
