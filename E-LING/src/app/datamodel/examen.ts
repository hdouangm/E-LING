import { Acte } from 'src/app/datamodel/acte';
import { Employe } from 'src/app/datamodel/Employe';
import { DemandeExamen } from 'src/app/datamodel/Demande_examen';

export class Examen {

    constructor(
        public id: number = 0,
        public date: string = '',
        public prix: number = 0,
        public publication: boolean = false,
        public payer: boolean = false,
        public codesActes: Array<Acte> = new Array<Acte>(),
        public URLresultats: string = '',
        public responsable: Employe = null,
        public demandeExamen: DemandeExamen = null,
        public dmp: DMP = null

    ) {}
}
