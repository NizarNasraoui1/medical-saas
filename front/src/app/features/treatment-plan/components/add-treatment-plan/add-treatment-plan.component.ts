import { Component, OnInit } from '@angular/core';
import {
    FormBuilder,
    FormControl,
    FormGroup,
    Validators,
} from '@angular/forms';
import { TreatmentPlanService } from '../../services/treatment-plan.service';
import { DatePipe } from '@angular/common';

interface AutoCompleteCompleteEvent {
    originalEvent: Event;
    query: string;
}

@Component({
    selector: 'app-add-treatment-plan',
    templateUrl: './add-treatment-plan.component.html',
    styleUrls: ['./add-treatment-plan.component.scss'],
})
export class AddTreatmentPlanComponent implements OnInit {
    treatmentPlanForm: FormGroup;
    date: Date | undefined;
    isFormValid: boolean = true;
    addConctactFields = {
        title: "Création d'un plan de traitement",
        name: 'Nom',
        patientName: 'Nom du Patient',
        description: 'Description',
        date: 'Date',
    };

    patients: any[] | undefined;

    formGroup: FormGroup | undefined;

    filteredPatients: any[];

    constructor(
        private fb: FormBuilder,
        private treatmentPlanService: TreatmentPlanService,
        private datePipe: DatePipe,
    ) {}

    ngOnInit(): void {
        this.initTreatmentPlanForm();

        this.patients = [
            { name: 'Nicolas', id: 1 },
            { name: 'Naom', id: 2 },
            { name: 'Albert', id: 3 },
            { name: 'Adam', id: 4 },
        ];
    }

    onSubmit() {
        // this.isFormValid = this.treatmentPlanForm.valid;
        // if (this.isFormValid) {
        //     this.saveTreatmentPlan(this.treatmentPlanForm.value);
        // }
        this.saveTreatmentPlan(this.treatmentPlanForm.value);
    }

    saveTreatmentPlan(treatmentPlan: any) {
        treatmentPlan.patientName = treatmentPlan.patientName.name;
        treatmentPlan.date = this.datePipe.transform(
            treatmentPlan.date,
            'dd/MM/yyyy',
        );
        console.log(treatmentPlan);
        this.treatmentPlanService
            .saveTreatmentPlan(treatmentPlan)
            .subscribe(() => {});
    }

    initTreatmentPlanForm() {
        this.treatmentPlanForm = this.fb.group({
            name: ['', [Validators.required, Validators.minLength(1)]],
            patientName: ['', [Validators.required, Validators.minLength(1)]],
            description: [''],
            date: [new Date()],
        });
    }

    filter(event: AutoCompleteCompleteEvent) {
        let filtered: any[] = [];
        let query = event.query;

        for (let i = 0; i < (this.patients as any[]).length; i++) {
            let patient = (this.patients as any[])[i];
            if (patient.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                filtered.push(patient);
            }
        }

        this.filteredPatients = filtered;
    }
}
