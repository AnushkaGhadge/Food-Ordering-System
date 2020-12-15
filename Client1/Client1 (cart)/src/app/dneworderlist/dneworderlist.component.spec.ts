import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DneworderlistComponent } from './dneworderlist.component';

describe('DneworderlistComponent', () => {
  let component: DneworderlistComponent;
  let fixture: ComponentFixture<DneworderlistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DneworderlistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DneworderlistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
