import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AviewhistoryComponent } from './aviewhistory.component';

describe('AviewhistoryComponent', () => {
  let component: AviewhistoryComponent;
  let fixture: ComponentFixture<AviewhistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AviewhistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AviewhistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
