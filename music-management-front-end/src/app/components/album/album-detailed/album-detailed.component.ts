import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Album } from 'src/app/model/album.model';
import { TrackSimple } from 'src/app/model/track.model';
import { AlbumService } from 'src/app/service/album.service';
import { TrackService } from 'src/app/service/track.service';

@Component({
  selector: 'app-album-detailed',
  templateUrl: './album-detailed.component.html',
  styleUrls: ['./album-detailed.component.scss']
})
export class AlbumDetailedComponent implements OnInit {

  public album!: Album;
  public tracks!: Array<TrackSimple>;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private albumService: AlbumService,
    private trackService: TrackService
  ) {
    let albumIdString: string | null = this.route.snapshot.paramMap.get('id');
    let albumId: number = albumIdString ? parseInt(albumIdString) : -1;

    if (albumId && albumId > 0) {
      this.albumService.getAlbumById(albumId).subscribe({
        next: album => this.album = album,
        error: () => console.log('An error has occured while communicating with the back-end service')
      });

      this.trackService.getTracksByAlbum(albumId).subscribe({
        next: tracks => this.tracks = tracks,
        error: () => console.log("An error has occured while communicating with the back-end service")
      });

      this.trackService.refreshSubject.subscribe({
        next: () => {
          this.trackService.getTracksByAlbum(albumId).subscribe({
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
    this.router.navigate(['album', this.album.id,'track', 'add']);
  }

}
