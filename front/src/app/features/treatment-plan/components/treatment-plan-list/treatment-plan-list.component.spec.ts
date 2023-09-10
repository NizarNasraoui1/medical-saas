import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TreatmentPlanListComponent } from './treatment-plan-list.component';

describe('TreatmentPlanListComponent', () => {
  let component: TreatmentPlanListComponent;
  let fixture: ComponentFixture<TreatmentPlanListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TreatmentPlanListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TreatmentPlanListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
