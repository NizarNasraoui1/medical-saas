import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TreatmentPlanListComponent } from './components/treatment-plan-list/treatment-plan-list.component';
import { AddTreatmentPlanComponent } from './components/add-treatment-plan/add-treatment-plan.component';
import { ViewTreatmentPlanComponent } from './components/view-treatment-plan/view-treatment-plan.component';

const routes: Routes = [
    { path: '', component: TreatmentPlanListComponent },
    { path: 'add', component: AddTreatmentPlanComponent },
    { path: 'view/:id', component: ViewTreatmentPlanComponent },
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule],
})
export class TreatmentPlanRoutingModule {}
