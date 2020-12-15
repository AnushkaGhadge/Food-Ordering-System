import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AassigndelboyComponent } from './aassigndelboy.component';

describe('AassigndelboyComponent', () => {
  let component: AassigndelboyComponent;
  let fixture: ComponentFixture<AassigndelboyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AassigndelboyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AassigndelboyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
