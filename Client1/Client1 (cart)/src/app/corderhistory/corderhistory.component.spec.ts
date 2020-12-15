import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CorderhistoryComponent } from './corderhistory.component';

describe('CorderhistoryComponent', () => {
  let component: CorderhistoryComponent;
  let fixture: ComponentFixture<CorderhistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CorderhistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CorderhistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
