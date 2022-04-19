import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { debounceTime, Subscription } from 'rxjs';
import { Artist } from 'src/app/model/artist.model';
import { ArtistService } from 'src/app/service/artist.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-artists-list',
  templateUrl: './artists-list.component.html',
  styleUrls: ['./artists-list.component.scss']
})
export class ArtistsListComponent implements OnInit, OnDestroy {
  public artists!: Array<Artist>;
  private searchSubscription!: Subscription;

  constructor(
    private artistService: ArtistService,
    private searchService: SearchService,
    private router: Router
  ) {
    this.artistService.refreshSubject.subscribe({
      next: () => {
        this.artistService.getAllArtists().subscribe({
          next: artists => {
            this.artists = artists;
          },
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to deleteSubject in ArtistService failed")
    });
  }

  ngOnInit(): void {
    this.searchSubscription = this.searchService.searchSubject.pipe(
      debounceTime(500)
    ).subscribe({
      next: search => {
        this.artistService.getArtistsByNameWithAutocomplete(search).subscribe({
          next: artists => {
            this.artists = artists;
          },
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to SearchService failed")
    });
  }

  ngOnDestroy(): void {
    this.searchSubscription.unsubscribe();
  }

  public onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['artist', 'add']);
  }

}
