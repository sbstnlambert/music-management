import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, retry } from 'rxjs';
import { Artist } from '../model/artist.model';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  private BASE_URL: string = 'http://localhost:8080/artist';

  constructor(private http: HttpClient) { }

  public getAllArtists(): Observable<Array<Artist>> {
    return this.http.get<Array<Artist>>(this.BASE_URL);
  }

  public getArtistById(id: number): Observable<Artist> {
    return this.http.get<Artist>(`${this.BASE_URL}/${id}`);
  }
}
