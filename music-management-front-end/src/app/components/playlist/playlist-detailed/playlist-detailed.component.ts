import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Playlist } from 'src/app/model/playlist.model';
import { TrackSimple } from 'src/app/model/track.model';
import { AuthService } from 'src/app/service/auth.service';
import { PlaylistService } from 'src/app/service/playlist.service';
import { TrackService } from 'src/app/service/track.service';

@Component({
  selector: 'app-playlist-detailed',
  templateUrl: './playlist-detailed.component.html',
  styleUrls: ['./playlist-detailed.component.scss']
})
export class PlaylistDetailedComponent implements OnInit {

  public playlist!: Playlist;
  public tracks!: Array<TrackSimple>;
  private refreshSubscription!: Subscription;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private playlistService: PlaylistService,
    private trackService: TrackService,
    public authService: AuthService
  ) {
      let playlistIdString: string | null = this.route.snapshot.paramMap.get('id');
      let playlistId: number = playlistIdString ? parseInt(playlistIdString) : -1;

      if (playlistId && playlistId > 0) {
        this.playlistService.getPlaylistById(playlistId).subscribe({
          next: playlist => this.playlist = playlist,
          error: () => console.log('An error has occured while communicating with the back-end service')
        });
  
        this.trackService.getTracksByPlaylist(playlistId).subscribe({
          next: tracks => this.tracks = tracks,
          error: () => console.log("An error has occured while communicating with the back-end service")
        });
  
        this.refreshSubscription = this.trackService.refreshSubject.subscribe({
          next: () => {
            this.trackService.getTracksByPlaylist(playlistId).subscribe({
              next: tracks => this.tracks = tracks,
              error: () => console.log("An error has occured while communicating with the back-end service")
            });
          },
          error: () => console.log("Subscription to refreshSubject of TrackService failed")
        });
        
      } else {
        alert('Invalid ID');
      }
    }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.router.navigate(['playlist', 'add']);
  }

  ngOnDestroy(): void {
    this.refreshSubscription.unsubscribe();
  }

}
