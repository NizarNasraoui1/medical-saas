import { Operation } from './operation';

export interface TreatmentPlan {
    id: number;
    name: string;
    patientName: string;
    description: string;
    date: Date;
    operations?: Operation[];
}
