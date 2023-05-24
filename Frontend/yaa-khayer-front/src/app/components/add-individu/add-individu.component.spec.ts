import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddIndividuComponent } from './add-individu.component';

describe('AddIndividuComponent', () => {
  let component: AddIndividuComponent;
  let fixture: ComponentFixture<AddIndividuComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddIndividuComponent]
    });
    fixture = TestBed.createComponent(AddIndividuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
