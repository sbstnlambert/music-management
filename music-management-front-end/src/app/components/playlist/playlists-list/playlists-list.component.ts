import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Playlist } from 'src/app/model/playlist.model';
import { AuthService } from 'src/app/service/auth.service';
import { PlaylistService } from 'src/app/service/playlist.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-playlists-list',
  templateUrl: './playlists-list.component.html',
  styleUrls: ['./playlists-list.component.scss']
})
export class PlaylistsListComponent implements OnInit {

  playlists!: Array<Playlist>;
  playlistName!: string;
  private searchSubscription!: Subscription;
  // private refreshSubscription!: Subscription;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private playlistService: PlaylistService,
    private searchService: SearchService,
    public authService: AuthService
  ) {
    this.playlistService.refreshSubject.subscribe({
      next: () => {
        this.playlistService.getPlaylistsByUser().subscribe({
          next: playlists => this.playlists = playlists,
          error: () => console.log("An error has occured while communicating with the back-end service")
        });
      },
      error: () => console.log('Subscription to refreshSubject of PlaylistService failed')
    });
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.playlistService.createPlaylist(this.playlistName).subscribe({
      next: playlist => {
        this.router.navigate(['playlist', playlist.id]);
      },
      error: () => console.log("An error has occured while communicating with the back-end service")
    });
  }

  // ngOnDestroy(): void {
  //   this.refreshSubscription.unsubscribe();
  // }

}
