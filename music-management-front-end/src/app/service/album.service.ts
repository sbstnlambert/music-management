import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { Album, AlbumForm } from '../model/album.model';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  private BASE_URL: string = 'http://localhost:8080/album';
  public refreshSubject: BehaviorSubject<any> = new BehaviorSubject<any>('');

  constructor(private http: HttpClient) { }

  public insertAlbum(toInsert: AlbumForm): Observable<Album> {
    return this.http.post<Album>(`${this.BASE_URL}/add`, toInsert);
  }

  public getAlbumsByArtist(artistId: number): Observable<Array<Album>> {
    return this.http.get<Array<Album>>(`${this.BASE_URL}/artist/${artistId}`);
  }

  public getAlbumById(id: number): Observable<Album> {
    return this.http.get<Album>(`${this.BASE_URL}/${id}`);
  }

  public getAlbumsByNameWithAutocomplete(nameFragment: string): Observable<Array<Album>> {
    return this.http.get<Array<Album>>(`${this.BASE_URL}/search?name=${nameFragment}`);
  }

  public deleteAlbumById(id: number): Observable<Album> {
    return this.http.delete<Album>(`${this.BASE_URL}/${id}`).pipe(
      tap(() => this.refreshSubject.next(''))
    );
  }

}
