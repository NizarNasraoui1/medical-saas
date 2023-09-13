import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TreatmentPlanService } from '../../services/treatment-plan.service';
import { DatePipe } from '@angular/common';
import { OperationStatusEnum } from '../../models/satatu-enum';
import { CodeLabel } from 'src/app/shared/models/code-label';

@Component({
    selector: 'app-add-operation-modal',
    templateUrl: './add-operation-modal.component.html',
    styleUrls: ['./add-operation-modal.component.scss']
})
export class AddOperationModalComponent implements OnInit {
    @Input()id:any;
    @Output() saveAndClose = new EventEmitter<any>();
    displayModal = true;
    colors:CodeLabel[]=[
        {code:'#c21616',label:"red"},
        {code:'#ecc442',label:"yellow"},
        {code:'#0858ad',label:"blue"},
        {code:'#5eb41f',label:"green"}
    ];
    states:CodeLabel[]=[
        {code:"1",label:"done"},
        {code:"2",label:"current"},
        {code:"3",label:"undone"}
        ];


    operationForm: FormGroup;
    date: Date | undefined;
    isFormValid: boolean = true;
    addConctactFields = {
        title: "Ajouter operation",
        name: 'Nom',
        color: 'Couleur',
        description: 'Description',
        state: 'Etat',
        date: 'Date',
    };
    formGroup: FormGroup | undefined;

    constructor(
        private fb: FormBuilder,
        private treatmentPlanService: TreatmentPlanService,
        private datePipe: DatePipe,
    ) { }

    ngOnInit(): void {
        this.initOperationForm();


    }

    onSubmit() {
        console.log(this.operationForm.value)
        this.formatForm();
        console.log(this.operationForm.value)
        this.treatmentPlanService.addOperationToTreatmentPlan(this.id,this.operationForm.value).subscribe(()=>{
            this.saveAndClose.emit();
        });

    }

    formatForm(){
this.operationForm.value.color=this.operationForm.value.color.code;
        this.operationForm.value.state=this.operationForm.value.state.code;
        this.operationForm.value.date=this.datePipe.transform(
            this.operationForm.value.date,
            'dd/MM/yyyy',
        );
    }


    initOperationForm() {
        this.operationForm = this.fb.group({
            name: ['', [Validators.required, Validators.minLength(1)]],
            color: [this.colors[0], [Validators.required, Validators.minLength(1)]],
            state: [this.states[0], [Validators.required, Validators.minLength(1)]],
            description: [''],
            date: [new Date()],
        });
    }


}
