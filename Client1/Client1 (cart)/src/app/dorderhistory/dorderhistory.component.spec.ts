import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DorderhistoryComponent } from './dorderhistory.component';

describe('DorderhistoryComponent', () => {
  let component: DorderhistoryComponent;
  let fixture: ComponentFixture<DorderhistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DorderhistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DorderhistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
