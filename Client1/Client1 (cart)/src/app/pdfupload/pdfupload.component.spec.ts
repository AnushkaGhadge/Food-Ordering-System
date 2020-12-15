import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PdfuploadComponent } from './pdfupload.component';

describe('PdfuploadComponent', () => {
  let component: PdfuploadComponent;
  let fixture: ComponentFixture<PdfuploadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PdfuploadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PdfuploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
