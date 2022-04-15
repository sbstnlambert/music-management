import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private _inputSearch!: string;
  searchSubject: BehaviorSubject<string> = new BehaviorSubject<string>("");

  constructor() { }

  public set inputSearch(input: string) {
    this._inputSearch = input;
    this.emitSubject();
  }

  private emitSubject(): void {
    this.searchSubject.next(this._inputSearch);
  }
}
