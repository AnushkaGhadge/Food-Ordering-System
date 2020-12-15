import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VeditvendorComponent } from './veditvendor.component';

describe('VeditvendorComponent', () => {
  let component: VeditvendorComponent;
  let fixture: ComponentFixture<VeditvendorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VeditvendorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VeditvendorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
