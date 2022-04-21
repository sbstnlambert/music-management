import { AbstractControl, ValidationErrors } from "@angular/forms";

export function dateIsNotInFuture(releaseDate: AbstractControl): ValidationErrors | null {
	if (new Date() > new Date(releaseDate.value)) {
		return null;
	} else {
        return {
            dateIsNotInFuture: {
                message: 'Release date should be in the past or present.'
            }
        }
    }
}