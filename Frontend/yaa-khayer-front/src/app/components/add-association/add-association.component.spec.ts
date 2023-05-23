import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddAssociationComponent } from './add-association.component';

describe('AddAssociationComponent', () => {
  let component: AddAssociationComponent;
  let fixture: ComponentFixture<AddAssociationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddAssociationComponent]
    });
    fixture = TestBed.createComponent(AddAssociationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
