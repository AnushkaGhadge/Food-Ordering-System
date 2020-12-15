import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VlistallproductsComponent } from './vlistallproducts.component';

describe('VlistallproductsComponent', () => {
  let component: VlistallproductsComponent;
  let fixture: ComponentFixture<VlistallproductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VlistallproductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VlistallproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
