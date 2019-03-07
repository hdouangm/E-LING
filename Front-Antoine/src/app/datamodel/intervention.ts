import { Acte } from 'src/app/datamodel/acte';
import { Employe } from 'src/app/datamodel/Employe';

export class Intervention {
    constructor(
        public id: number = 0,
        public date: string = '',
        public lieu: string = '',
        public payer: boolean = false,
        public prix: number = 0,
        public publication: boolean = false,
        public dmp: DMP,
        public type: string = '',
        public responsable: Employe = null,
        public codesActes: Array<Acte> = new Array<Acte>()

    ) {}


}
