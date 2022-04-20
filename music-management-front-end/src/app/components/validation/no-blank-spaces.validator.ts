import { AbstractControl, ValidationErrors } from "@angular/forms";

export function noBlankSpaces(name: AbstractControl): ValidationErrors | null {
    const isWhitespace = (name.value || '').trim().length === 0;
    const isValid = !isWhitespace;
    if (isValid) {
        return null;
    } else {
        return {
            noBlankSpaces: {
                message: 'Name must contain at least one character.'
            }
        }
    }
}