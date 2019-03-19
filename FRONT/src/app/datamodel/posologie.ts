import { Employe } from 'src/app/datamodel/Employe';

export class Posologie {
    constructor(
    public dmp: DMP,
    public id: number,
    public payer: boolean,
    public posologie: string,
    public prix: number,
    public publication: boolean,
    public responsable: Employe
    ) {}

}
