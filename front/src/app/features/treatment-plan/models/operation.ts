import { OperationStatusEnum } from './satatu-enum';

export interface Operation {
    id: number,
    name: string,
    date: Date,
    desciption: string,
    status: OperationStatusEnum
}
