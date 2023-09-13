import { NgModule } from '@angular/core';
import { CommonModule, DatePipe } from '@angular/common';

import { TreatmentPlanRoutingModule } from './treatment-plan-routing.module';
import { TreatmentPlanListComponent } from './components/treatment-plan-list/treatment-plan-list.component';
import { TableModule } from 'primeng/table';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { AddTreatmentPlanComponent } from './components/add-treatment-plan/add-treatment-plan.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ViewTreatmentPlanComponent } from './components/view-treatment-plan/view-treatment-plan.component';
import { AutoCompleteModule } from 'primeng/autocomplete';
import { CalendarModule } from 'primeng/calendar';
import { PaginatorModule } from 'primeng/paginator';

@NgModule({
    declarations: [
        TreatmentPlanListComponent,
        AddTreatmentPlanComponent,
        ViewTreatmentPlanComponent,
    ],
    imports: [
        CommonModule,
        TreatmentPlanRoutingModule,
        TableModule,
        ButtonModule,
        InputTextModule,
        FormsModule,
        ReactiveFormsModule,
        AutoCompleteModule,
        CalendarModule,
        PaginatorModule,
    ],
    providers: [DatePipe],
})
export class TreatmentPlanModule {}
