import { OperationColor } from './operation-color';
import { OperationStatusEnum } from './satatu-enum';

export interface Operation {
    id: number;
    name: string;
    date: Date;
    desciption: string;
    state: string;
    color: string
}
