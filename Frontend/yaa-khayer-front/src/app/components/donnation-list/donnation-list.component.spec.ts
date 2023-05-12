import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DonnationListComponent } from './donnation-list.component';

describe('DonnationListComponent', () => {
  let component: DonnationListComponent;
  let fixture: ComponentFixture<DonnationListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DonnationListComponent]
    });
    fixture = TestBed.createComponent(DonnationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
