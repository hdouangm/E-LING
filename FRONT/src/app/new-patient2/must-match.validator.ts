import { FormGroup } from '@angular/forms';

export function MustMatch(numSS: string, genre: string, dateNaissance: string, pays: string) {
    return (formGroup: FormGroup) => {
        const ss = formGroup.controls[numSS];
        const genre_ = formGroup.controls[genre];
        const dateNaissance_ = formGroup.controls[dateNaissance];
        const pays_ = formGroup.controls[pays];
        const ssGenre = ss.value.substring(0, 1);
        const ssAnnee = ss.value.substring(1, 3);
        const ssMois = ss.value.substring(3, 5);
        const mois = dateNaissance_.value.substring(5, 7);
        const annee = dateNaissance_.value.substring(2, 4);

        // set error on matchingControl if validation fails
        if (pays_.value === 'France' && ss.value === '') {
          ss.setErrors({ mustMatch: true });
          return;
        }
        if (pays_.value !== 'France' && ss.value !== '') {
          ss.setErrors({ mustMatch: true });
          return;
        }
        if (pays_.value === 'France') {
          if ((ssGenre != "1" && ssGenre != "2")) {
            ss.setErrors({mustMatch: true});
            return;
          }
          if ((ssGenre == "1" && genre_.value !== 'M')) {
            ss.setErrors({mustMatch: true});
            return;
          }
          if ((ssGenre == "2" && genre_.value !== 'F')) {
            ss.setErrors({mustMatch: true});
            return;
          }
          if (ssAnnee !== annee) {
            ss.setErrors({mustMatch: true});
            return;
          }
          if (ssMois !== mois) {
            ss.setErrors({mustMatch: true});
            return;
          }
        }
        ss.setErrors(null);

    };
}
