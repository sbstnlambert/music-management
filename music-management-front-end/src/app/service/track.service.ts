import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { TrackDetailed, TrackForm, TrackSimple } from '../model/track.model';

@Injectable({
  providedIn: 'root'
})
export class TrackService {

  private BASE_URL: string = "http://localhost:8080/track"
  public refreshSubject: BehaviorSubject<any> = new BehaviorSubject<any>('');

  constructor(private http: HttpClient) { }

  public insertTrack(toInsert: TrackForm): Observable<TrackSimple> {
    return this.http.post<TrackSimple>(`${this.BASE_URL}/add`, toInsert);
  }

  public getTracksByArtist(artistId: number): Observable<Array<TrackSimple>> {
    return this.http.get<Array<TrackSimple>>(`${this.BASE_URL}/artist/${artistId}`);
  }

  public getTracksByAlbum(albumId: number): Observable<Array<TrackSimple>> {
    return this.http.get<Array<TrackSimple>>(`${this.BASE_URL}/album/${albumId}`);
  }

  public getTracksByPlaylist(playlistId: number): Observable<Array<TrackSimple>> {
    return this.http.get<Array<TrackSimple>>(`${this.BASE_URL}/playlist/${playlistId}`);
  }

  public getTrackById(id: number): Observable<TrackDetailed> {
    return this.http.get<TrackDetailed>(`${this.BASE_URL}/${id}`);
  }

  public getTracksByNameWithAutocomplete(nameFragment: string): Observable<Array<TrackSimple>> {
    return this.http.get<Array<TrackSimple>>(`${this.BASE_URL}/search?name=${nameFragment}`);
  }

  public deleteTrackById(id: number): Observable<TrackSimple> {
    return this.http.delete<TrackSimple>(`${this.BASE_URL}/${id}`).pipe(
      tap(() => this.refreshSubject.next(''))
    )
  }

}