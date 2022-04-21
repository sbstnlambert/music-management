import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Playlist } from 'src/app/model/playlist.model';
import { AuthService } from 'src/app/service/auth.service';
import { PlaylistService } from 'src/app/service/playlist.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-playlist-card',
  templateUrl: './playlist-card.component.html',
  styleUrls: ['./playlist-card.component.scss']
})
export class PlaylistCardComponent implements OnInit {

  @Input()
  playlist!: Playlist;

  isHovered: boolean = false;

  constructor(
    private service: PlaylistService,
    private router: Router,
    private searchService: SearchService,
    public authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['playlist', this.playlist.id]);
  }

  onHover(): void {
    this.isHovered = !this.isHovered;
  }

  onDelete(): void {
    this.service.deletePlaylistById(this.playlist.id).subscribe({
      next: deletedPlaylist => console.log(`Playlist with id = ${deletedPlaylist.id} has been successfully deleted`),
      error: () => console.log('An error has occured during the communication with the back-end service')
    });
  }

}
