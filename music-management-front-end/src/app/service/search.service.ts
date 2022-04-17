import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  private _inputSearch!: string;
  searchSubject: BehaviorSubject<string> = new BehaviorSubject<string>("");
  resetSubject: BehaviorSubject<any> = new BehaviorSubject<any>(null);

  constructor() { }

  public set inputSearch(input: string) {
    this._inputSearch = input;
    this.emitSubject();
  }

  private emitSubject(): void {
    this.searchSubject.next(this._inputSearch);
  }

  public resetSearch(): void {
    this.resetSubject.next(null);
  }

}
