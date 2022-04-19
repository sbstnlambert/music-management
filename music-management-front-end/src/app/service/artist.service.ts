import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { Artist, ArtistForm } from '../model/artist.model';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  private BASE_URL: string = 'http://localhost:8080/artist';
  public refreshSubject: BehaviorSubject<any> = new BehaviorSubject<any>('');

  constructor(private http: HttpClient) { }

  public insertArtist(toInsert: ArtistForm): Observable<Artist> {
    return this.http.post<Artist>(`${this.BASE_URL}/add`, toInsert);
  }

  public getAllArtists(): Observable<Array<Artist>> {
    return this.http.get<Array<Artist>>(this.BASE_URL);
  }

  public getArtistById(id: number): Observable<Artist> {
    return this.http.get<Artist>(`${this.BASE_URL}/${id}`);
  }

  public getArtistsByNameWithAutocomplete(nameFragment: string): Observable<Array<Artist>> {
    return this.http.get<Array<Artist>>(`${this.BASE_URL}/search?name=${nameFragment}`);
  }

  public deleteArtistById(id: number): Observable<Artist> {
    return this.http.delete<Artist>(`${this.BASE_URL}/${id}`).pipe(
      tap(() => this.refreshSubject.next(''))
    );
  }

  public pingRefreshSubject(): void {
    this.refreshSubject.next('');
  }

}
