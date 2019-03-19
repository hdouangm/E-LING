import { Acte } from 'src/app/datamodel/acte';
import { Employe } from 'src/app/datamodel/Employe';
import { DemandeIntervention } from './Demande_intervention';

export class Intervention {
    constructor(
        public id: number = 0,
        public date: string = '',
        public lieu: string = '',
        public payer: boolean = false,
        public prix: number = 0,
        public publication: boolean = false,
        public dmp: DMP = null,
        public type: string = '',
        public responsable: Employe = null,
        public codesActes: Array<Acte> = new Array<Acte>(),
        public demandeIntervention: DemandeIntervention = null,
        public urlResultats: string = ''

    ) {}


}
