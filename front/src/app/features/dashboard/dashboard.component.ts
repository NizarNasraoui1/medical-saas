import { Component, OnInit, OnDestroy } from '@angular/core';
import { TreatmentPlan } from '../treatment-plan/models/treatment-plan';
import { TreatmentPlanService } from '../treatment-plan/services/treatment-plan.service';
import { Router } from '@angular/router';

const cardsColors = ["#5dd15d", "#d15daf", "#d1cd5d", "#5da6d1", "#ffbf00", "#00ecff", "#ff006a"]

@Component({
    templateUrl: './dashboard.component.html',
    styleUrls: ['./dashboard.component.scss'],
})
export class DashboardComponent implements OnInit, OnDestroy {
    date: Date | undefined;
    DashboardCards: any[] = [
        { label: 'Patients', value: '709 patients' },
        { label: 'Plan de traitements', value: '650 plans' },
        { label: 'Jalons', value: '152 jalons' },
        { label: 'Soins en attente', value: '7 patients' },
        { label: 'PEC en attente', value: '12 patients' }
    ]
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

    constructor(private treatmentPlanService: TreatmentPlanService, private router: Router) { }

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

    navigateToView(id: number) {
        this.router.navigate(['treatment-plan/view/', id]);
    }

    getCardColorLoop(pos: number) {
        return cardsColors[pos % cardsColors.length]
    }

    ngOnDestroy(): void {
    }
}