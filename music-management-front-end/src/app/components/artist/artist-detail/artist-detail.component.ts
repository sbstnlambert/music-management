import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Album } from 'src/app/model/album.model';
import { Artist } from 'src/app/model/artist.model';
import { AlbumService } from 'src/app/service/album.service';
import { ArtistService } from 'src/app/service/artist.service';
import { AuthService } from 'src/app/service/auth.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-artist-detail',
  templateUrl: './artist-detail.component.html',
  styleUrls: ['./artist-detail.component.scss']
})
export class ArtistDetailComponent implements OnInit, OnDestroy {

  public artist!: Artist;
  public albums!: Array<Album>;
  private refreshSubscription!: Subscription;

  constructor(
    private route: ActivatedRoute,
    private router: Router, 
    private albumService: AlbumService,
    private artistService: ArtistService,
    private searchService: SearchService,
    public authService: AuthService
  ) {
    let artistIdString: string | null = this.route.snapshot.paramMap.get('id');
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

      this.refreshSubscription = this.albumService.refreshSubject.subscribe({
        next: () => {
          this.albumService.getAlbumsByArtist(artistId).subscribe({
            next: albums => this.albums = albums,
            error: () => console.log("An error has occured while communicating with the back-end service")
          });
        },
        error: () => console.log('Subscription to refreshSubject of AlbumService failed')
      });
    } else {
      alert('Invalid ID');
    }
  }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['artist', this.artist.id, 'album', 'add']);
  }

  ngOnDestroy(): void {
    this.refreshSubscription.unsubscribe();
  }

}
