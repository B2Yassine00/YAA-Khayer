import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonnationDetailsComponent } from './donnation-details.component';

describe('DonnationDetailsComponent', () => {
  let component: DonnationDetailsComponent;
  let fixture: ComponentFixture<DonnationDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DonnationDetailsComponent]
    });
    fixture = TestBed.createComponent(DonnationDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
