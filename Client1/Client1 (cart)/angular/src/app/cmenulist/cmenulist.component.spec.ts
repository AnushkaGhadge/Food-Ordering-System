import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CmenulistComponent } from './cmenulist.component';

describe('CmenulistComponent', () => {
  let component: CmenulistComponent;
  let fixture: ComponentFixture<CmenulistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CmenulistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CmenulistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
