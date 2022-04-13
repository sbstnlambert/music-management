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
}
