import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdeletevendorComponent } from './adeletevendor.component';

describe('AdeletevendorComponent', () => {
  let component: AdeletevendorComponent;
  let fixture: ComponentFixture<AdeletevendorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdeletevendorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdeletevendorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
