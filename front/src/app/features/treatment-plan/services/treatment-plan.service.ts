import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpUtilService } from 'src/app/util/service/http-util.service';
import { TreatmentPlan } from '../models/treatment-plan';
import { PageResponseDTO } from 'src/app/shared/models/page-response';
import { Operation } from '../models/operation';

const TREATMENT_PLAN_URL = '/api/treatment-plan';

@Injectable({
    providedIn: 'root',
})
export class TreatmentPlanService {
    constructor(private httpUtilService: HttpUtilService) {}

    saveTreatmentPlan(treatmentPlan: TreatmentPlan): Observable<TreatmentPlan> {
        return this.httpUtilService.post(TREATMENT_PLAN_URL, treatmentPlan);
    }

    getTreatmentPlanById(id: string): Observable<TreatmentPlan> {
        return this.httpUtilService.get(`${TREATMENT_PLAN_URL}/${id}`);
    }

    getTreatmentPlanPage(
        page: number,
        size: number,
        name: string,
    ): Observable<PageResponseDTO<TreatmentPlan>> {
        return this.httpUtilService.get(`${TREATMENT_PLAN_URL}/search`, {
            page: page,
            size: size,
            name: name,
        });
    }

    addOperationToTreatmentPlan(id:number,operation:Operation): Observable<TreatmentPlan> {
        return this.httpUtilService.post(`${TREATMENT_PLAN_URL}/${id}/add-operation`, operation);
    }
}
