import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CregisterComponent } from './cregister.component';

describe('CregisterComponent', () => {
  let component: CregisterComponent;
  let fixture: ComponentFixture<CregisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CregisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
