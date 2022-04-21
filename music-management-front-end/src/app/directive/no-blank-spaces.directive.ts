import { Directive, Input } from '@angular/core';
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from '@angular/forms';

@Directive({
  selector: '[appNoBlankSpaces]',
  providers: [{provide: NG_VALIDATORS, useExisting: NoBlankSpacesDirective, multi: true}]
})
export class NoBlankSpacesDirective implements Validator {

  @Input('appNoBlankSpaces') noBlankSpaces = '';

  validate(name: AbstractControl): ValidationErrors | null {
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
}
