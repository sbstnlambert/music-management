import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, tap } from 'rxjs';
import { Playlist } from '../model/playlist.model';
import { TrackSimple } from '../model/track.model';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private BASE_URL: string = "http://localhost:8080/playlist";
  public refreshSubject: BehaviorSubject<any> = new BehaviorSubject<any>('');

  constructor(private http: HttpClient) { }

  public createPlaylist(name: string): Observable<Playlist> {
    return this.http.post<Playlist>(`${this.BASE_URL}/add?name=${name}`, null);
  }

  public getPlaylistsByUser(): Observable<Array<Playlist>> {
    return this.http.get<Array<Playlist>>(`${this.BASE_URL}`);
  }

  public getPlaylistById(id: number): Observable<Playlist> {
    return this.http.get<Playlist>(`${this.BASE_URL}/${id}`);
  }

  public addTrackToPlaylist(playlistId: number, trackId: number): Observable<TrackSimple> {
    return this.http.patch<TrackSimple>(`${this.BASE_URL}/${playlistId}/addTrack/${trackId}`, null);
  }

  public removeTrackFromPlaylist(playlistId: number, trackId: number): Observable<TrackSimple> {
    return this.http.patch<TrackSimple>(`${this.BASE_URL}/${playlistId}/removeTrack/${trackId}`, null);
  }
  
  public deletePlaylistById(id: number): Observable<Playlist> {
    return this.http.delete<Playlist>(`${this.BASE_URL}/${id}`).pipe(
      tap(() => this.refreshSubject.next(''))
    );
  }

}
