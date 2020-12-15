import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClistallrestaurantComponent } from './clistallrestaurant.component';

describe('ClistallrestaurantComponent', () => {
  let component: ClistallrestaurantComponent;
  let fixture: ComponentFixture<ClistallrestaurantComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClistallrestaurantComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClistallrestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
