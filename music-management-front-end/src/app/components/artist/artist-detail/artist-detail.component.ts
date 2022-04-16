import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Album } from 'src/app/model/album.model';
import { Artist } from 'src/app/model/artist.model';
import { AlbumService } from 'src/app/service/album.service';
import { ArtistService } from 'src/app/service/artist.service';

@Component({
  selector: 'app-artist-detail',
  templateUrl: './artist-detail.component.html',
  styleUrls: ['./artist-detail.component.scss']
})
export class ArtistDetailComponent implements OnInit {

  public artist!: Artist;
  public albums!: Array<Album>;

  constructor(
    private route: ActivatedRoute,
    private router: Router, 
    private albumService: AlbumService,
    private artistService: ArtistService
  ) {
    let artistIdString: string | null = route.snapshot.paramMap.get('id');
    let artistId: number = artistIdString ? parseInt(artistIdString) : -1;

    if (artistId && artistId > 0) {
      this.artistService.getArtistById(artistId).subscribe({
        next: artist => this.artist = artist,
        error: () => console.log("An error has occured while communicating with the back-end service")
      });

      this.albumService.getAlbumsByArtist(artistId).subscribe({
        next: albums => this.albums = albums,
        error: () => console.log("An error has occured while communicating with the back-end service")
      });
    } else {
      alert('Invalid ID');
    }
  }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.router.navigate(['artist', this.artist.id, 'album', 'add']);
  }

}
