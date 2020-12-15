import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AadddelboyComponent } from './aadddelboy.component';

describe('AadddelboyComponent', () => {
  let component: AadddelboyComponent;
  let fixture: ComponentFixture<AadddelboyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AadddelboyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AadddelboyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
