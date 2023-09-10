import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';



interface AutoCompleteCompleteEvent {
    originalEvent: Event;
    query: string;
}

@Component({
  selector: 'app-add-treatment-plan',
  templateUrl: './add-treatment-plan.component.html',
  styleUrls: ['./add-treatment-plan.component.scss']
})
export class AddTreatmentPlanComponent implements OnInit {
    contactForm: FormGroup;
    date: Date | undefined;
    isFormValid: boolean = true;
    addConctactFields = {
        title:'Add treatment Plan',
        name:'Nom',
        patientName:'Nom du Patient',
        description:'Description',
        date:'Date'
    };

    countries: any[] | undefined;

    formGroup: FormGroup | undefined;

    filteredPatients: any[];


    constructor(private fb:FormBuilder) {

    }

    ngOnInit(): void {
        this.initContactForm();

        this.countries =  [
            { name: 'Nicolas', code: 'AF' },
            { name: 'Naom', code: 'AL' },
            { name: 'Albert', code: 'DZ' },
            { name: 'Adam', code: 'AS' }
        ];

    this.formGroup = new FormGroup({
        selectedCountry: new FormControl<object | null>(null)
    });
    }

    onSubmit() {
        this.isFormValid = this.contactForm.valid;
        if (this.isFormValid){
            this.saveUser(this.contactForm.value);
        }
    }

    saveUser(contact:any){

    }

    initContactForm(){
        this.contactForm = this.fb.group({
            name: ['', [Validators.required, Validators.minLength(1)]],
            patientName: ['', [Validators.required, Validators.minLength(1)]],
            description: [''],
            date: [null],

        });

    }

    filter(event: AutoCompleteCompleteEvent) {
        let filtered: any[] = [];
        let query = event.query;

        for (let i = 0; i < (this.countries as any[]).length; i++) {
            let country = (this.countries as any[])[i];
            if (country.name.toLowerCase().indexOf(query.toLowerCase()) == 0) {
                filtered.push(country);
            }
        }

        this.filteredPatients = filtered;
    }

}
