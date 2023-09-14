import { Component, OnInit, AfterViewInit, Input } from '@angular/core';
import * as d3 from 'd3';
import { TreatmentPlanService } from '../../services/treatment-plan.service';
import { ActivatedRoute } from '@angular/router';
import { OperationStatusEnum } from '../../models/satatu-enum';

const red = '#c21616';
const yellow = '#ecc442';
const blue = '#0858ad';
const green = '#5eb41f';

@Component({
    selector: 'app-view-treatment-plan',
    templateUrl: './view-treatment-plan.component.html',
    styleUrls: ['./view-treatment-plan.component.scss'],
})
export class ViewTreatmentPlanComponent implements OnInit {
    viewAddOperationModal = true;
    id: string | null;
    data: any;
    timeline: any;
    popup: any;
    data2 = [
        {
            date: '2023-01-01',
            state: 'Done',
            label: 'Do something step 1',
            color: red,
            description:
                'some description here 1 Lorem ipsum, dolor sit amet consectetur adipisicing elit.',
        },
        {
            date: '2023-01-01',
            state: 'Done',
            label: '',
            color: red,
            description:
                'some description here 1 Explicabo nemo ipsum voluptatibus sed voluptates corporis atque, ipsa laboriosam corrupti dignissimos perspiciatis tenetur vel vero nisi quas! Molestias reiciendis esse eum?',
        },
        {
            date: '2023-02-01',
            state: 'Done',
            label: 'More events to do step 2',
            color: yellow,
            description:
                'some description here 2 ipsum voluptatibus sed voluptates corporis atque, ipsa laboriosam corrupti dignissimos perspiciatis tenetur vel vero nisi quas! Molestias reiciendis esse eum?',
        },
        {
            date: '2023-02-01',
            state: 'Done',
            label: '',
            color: yellow,
            description:
                'some description here 2 corporis atque, ipsa laboriosam corrupti dignissimos perspiciatis tenetur vel vero nisi quas! Molestias reiciendis esse eum?',
        },
        {
            date: '2023-08-01',
            state: 'Done',
            label: '',
            color: green,
            description:
                'some description here 4 Lorem ipsum, dolor sit amet consectetur adipisicing elit. Explicabo nemo ipsum voluptatibus sed ',
        },
        {
            date: '2023-08-01',
            state: 'Done',
            label: '',
            color: green,
            description:
                'some description here 4 Lorem ipsum, dolor sit amet consectetur adipisicing elit.',
        },
        {
            date: '01/02/1998',
            state: 'Done',
            label: 'quick description',
            color: red,
            description:
                'some description here 1 Lorem ipsum , dolor sit amet consectetur adipisicing elit.',
        },

        {
            id: 254,
            date: '10/02/2002',
            description: 'desciption 5',
            label: 'operation 3',
            state: 'CURRENT',
            color: '#c21616',
        },
    ];

    constructor(
        private treatmentPlanService: TreatmentPlanService,
        private activatedRoute: ActivatedRoute,
    ) {}

    ngOnInit(): void {
        this.activatedRoute.paramMap.subscribe((res) => {
            this.id = res.get('id');
            this.getTreatmentPlanById();
        });
    }

    getTreatmentPlanById() {
        if (this.id) {
            this.treatmentPlanService
                .getTreatmentPlanById(this.id)
                .subscribe((res) => {
                    console.log(res);
                    this.data = res.operations;
                });
        }
    }

    onSaveAndCloseModal(event: any) {
        this.viewAddOperationModal = false;
    }
}
