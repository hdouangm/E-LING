export class Acte {

    constructor(
        public id: number = 0,
        public description: string = '',
        public prix: number = 0,
        public examen: Examen = null,
        public intervention: Intervention = null,
        public diagnostique: Diagnostique = null,
        public posologie: Posologie = null

    ) {}
}


export class Competence {

    constructor(
        public id: number = 0,
        public description: string = '',
        public employe: Employe = null

    ) {}
}


export class CompteAphp {

    constructor(
        public login: string = '',
        public motDePasse: string = '',
        public langue: string = '',
        public employe: Employe = null

    ) {}
}


export class ConstanteVitale {

    constructor(
        public id: number = 0,
        public dmp: DMP = null,
        public date: string = '',
        public constante: string = '',
        public infirmierEnCharge: Employe = null

    ) {}
}


export class DemandeExamen {

    constructor(
        public id: number = 0,
        public dmp: DMP = null,
        public type: number = 0,
        public date: string = '',
        public publierDemande: boolean = false,
        public demandeRemplie: boolean = false,
        public examen: Employe = null

    ) {}
}


export class DemandeIntervention {

    constructor(
        public id: number = 0,
        public dmp: DMP = null,
        public date: string = '',
        public publierDemande: boolean = false,
        public demandeRemplie: boolean = false,
        public type: string = '',
        public intervention: Intervention

    ) {}
}


export class Diagnostique {

    constructor(
        public id: number = 0,
        public dmp: DMP = null,
        public diagnostic: string = '',
        public responsable: Employe = null,
        public publication: boolean = false,
        public date: string = '',
        public codesActes: Array<Acte> = new Array<Acte>(),
        public prix: number = 0,
        public payer: boolean = false

    ) {}
}


export class DMP {

    constructor(
        public id: number = 0,
        public ss: string = '',
        public intervention: Intervention = null,
        public demandeIntervention: DemandeIntervention = null,
        public examen: Examen = null,
        public demandeExamen: DemandeExamen = null,
        public patient: Patient = null,
        public posologie: Posologie = null,
        public diagnostique: Diagnostique = null,
        public profession: string = '',
        public motif: string = '',
        public affectionCongenitales: string = '',
        public maladieInfectieuse: string = '',
        public autreAffections: string = '',
        public interventionsChir: string = '',
        public accidents: string = '',
        public maladies: string = '',
        public allergies: string = ''

    ) {}
}


export class DonneesSociales {

    constructor(
        public id: number = 0,
        public nom: string = '',
        public prenom: string = '',
        public adresse: string = '',
        public ville: string = '',
        public codePostal: string = '',
        public pays: string = '',
        public genre: string = '',
        public age: string = '',
        public employe: Employe = null,
        public patient: Patient = null

    ) {}
}


export class Employe {

    constructor(
        public id: number = 0,
        public noeudHopital: NoeudHopital = null,
        public compteAphp: CompteAphp = null,
        public donneesSociales: DonneesSociales = null,
        public examen: Examen = null,
        public niveau: number = 0,
        public competences: Array<Competence> = new Array<Competence>()

    ) {}
}


export class Examen {

    constructor(
        public id: number = 0,
        public dmp: DMP = null,
        public date: string = '',
        public urlResultats: string = '',
        public responsable: Employe = null,
        public publication: boolean = false,
        public codesActes: Array<Acte> = new Array<Acte>(),
        public prix: number = 0,
        public payer: boolean = false,
        public demandeExamen: DemandeExamen = null
    ) {}
}


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


export class NoeudHopital {

    constructor(
        public id: number = 0,
        public niveau: number = 0,
        public noeudsInferieurs: Array<NoeudHopital> = new Array<NoeudHopital>(),
        public chef: Employe = null,
        public patient: Patient,
        public noeudSuperieur: NoeudHopital = null

    ) {}
}


export class Patient {

    constructor(
        public id: number = 0,
        public noeudHopital: NoeudHopital = null,
        public dmp: DMP = null,
        public donneesSociales: DonneesSociales = null

    ) {}
}


export class Posologie {

    constructor(
        public id: number = 0,
        public dmp: DMP = null,
        public dateDebut: string = '',
        public dateFin: string = '',
        public posologie: string = '',
        public suiviTraitement: Array<SuiviTraitement> = new Array<SuiviTraitement>(),
        public responsable: Employe = null,
        public publication: boolean = false,
        public codesActes: Array<Acte> = new Array<Acte>(),
        public prix: number = 0,
        public payer: boolean = false

    ) {}
}


export class SuiviTraitement {

    constructor(
        public id: number = 0,
        public date: string = '',
        public priseTraitement: boolean = false,
        public infirmiere: Employe = null,
        public posologie: Posologie = null

    ) {}
}
