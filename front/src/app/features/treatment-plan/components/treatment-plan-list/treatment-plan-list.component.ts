import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-treatment-plan-list',
  templateUrl: './treatment-plan-list.component.html',
  styleUrls: ['./treatment-plan-list.component.scss']
})
export class TreatmentPlanListComponent implements OnInit {
    fields = {
        title:"Plan de traitement",
        arrayFields: ["nom","patient","date"]

    };

    data!: any[];

    first = 0;

    rows = 10;

  constructor() { }

  ngOnInit() {
    this.data = [
      {
        name: 'James Butt',
        lastname: 'a'
      },
      {
        name: 'Josephine Darakjy',
        lastname: 'b'
      },
    ];

  }

  next() {
    console.log('next');
  }

  prev() {
    console.log('prev');
  }

  reset() {
    this.first = 0;
  }

}
