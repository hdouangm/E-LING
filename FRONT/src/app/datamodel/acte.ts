import { Examen } from 'src/app/datamodel/examen';

export class Acte {

    constructor(
        public description: string,
        public id: number,
        public prix: number,
        public examen: Examen
    ) {}
}
