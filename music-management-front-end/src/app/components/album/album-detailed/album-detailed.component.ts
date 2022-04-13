import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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

  public album: Album = {
    id: 1,
    name: 'Blurry Face',
    imageUrl: 'https://bit.ly/3KEwcUU',
    releaseDate: new Date("2015-10-12"),
    recordLabel: 'Fueled By Ramen'
  };

  public tracks!: Array<TrackSimple>;

  constructor(
    private route: ActivatedRoute,
    private albumService: AlbumService,
    private trackService: TrackService
  ) {
    let albumIdString: string | null = route.snapshot.paramMap.get('id');
    let albumId: number = albumIdString ? parseInt(albumIdString) : -1;

    if (albumId && albumId > 0) {
      // this.albumService.getAlbumById(albumId).subscribe({
      //   next: album => this.album = album,
      //   error: () => console.log('An error has occured while communicating with the back-end service')
      // });

      this.trackService.getTracksByAlbum(albumId).subscribe({
        next: tracks => this.tracks = tracks,
        error: () => console.log("An error has occured while communicating with the back-end service")
      });
    } else {
      alert('Invalid ID');
    }
   }

  ngOnInit(): void {
  }

}