import { Component, OnInit } from '@angular/core';
import { TreatmentPlanService } from '../../services/treatment-plan.service';
import { TreatmentPlan } from '../../models/treatment-plan';
import { Router } from '@angular/router';

@Component({
    selector: 'app-treatment-plan-list',
    templateUrl: './treatment-plan-list.component.html',
    styleUrls: ['./treatment-plan-list.component.scss'],
})
export class TreatmentPlanListComponent implements OnInit {
    name: string = '';
    fields = {
        title: 'Plan de traitement',
        arrayFields: ['nom', 'patient', 'date', 'description'],
    };

    paginationSetting = {
        first: 0,
        page: 0,
        pageCount: 12,
        rows: 5,
    };

    data!: TreatmentPlan[];

    constructor(private treatmentPlanService: TreatmentPlanService,private router:Router) {}

    ngOnInit() {
        this.searchTreatmentPlanPage();
    }

    searchTreatmentPlanPage() {
        this.treatmentPlanService
            .getTreatmentPlanPage(
                this.paginationSetting.page,
                this.paginationSetting.rows,
                this.name,
            )
            .subscribe((res) => {
                this.data = res.content;
            });
    }

    onPageChange(changes: any) {
        this.paginationSetting.first = changes.first;
        this.paginationSetting.page = changes.page;
        this.paginationSetting.pageCount = changes.pageCount;
        this.paginationSetting.rows = changes.rows;
        this.searchTreatmentPlanPage();
    }

    navigateToView(id:number){
        this.router.navigate(['treatment-plan/view/',id]);
    }
}
