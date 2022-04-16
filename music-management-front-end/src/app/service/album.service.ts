import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Album } from '../model/album.model';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {

  private BASE_URL: string = 'http://localhost:8080/album';

  constructor(private http: HttpClient) { }

  public getAlbumsByArtist(artistId: number): Observable<Array<Album>> {
    return this.http.get<Array<Album>>(`${this.BASE_URL}/artist/${artistId}`);
  }

  public getAlbumById(id: number): Observable<Album> {
    return this.http.get<Album>(`${this.BASE_URL}/${id}`);
  }

  public getAlbumsByNameWithAutocomplete(nameFragment: string): Observable<Array<Album>> {
    return this.http.get<Array<Album>>(`${this.BASE_URL}/search?name=${nameFragment}`);
  }

}
