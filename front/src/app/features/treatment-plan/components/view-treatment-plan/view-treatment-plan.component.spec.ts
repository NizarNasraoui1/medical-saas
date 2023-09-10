import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewTreatmentPlanComponent } from './view-treatment-plan.component';

describe('ViewTreatmentPlanComponent', () => {
  let component: ViewTreatmentPlanComponent;
  let fixture: ComponentFixture<ViewTreatmentPlanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewTreatmentPlanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewTreatmentPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
