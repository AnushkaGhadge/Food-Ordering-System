import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VaddproductsComponent } from './vaddproducts.component';

describe('VaddproductsComponent', () => {
  let component: VaddproductsComponent;
  let fixture: ComponentFixture<VaddproductsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VaddproductsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VaddproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
