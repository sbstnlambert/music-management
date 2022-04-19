import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { debounceTime } from 'rxjs';
import { Artist } from 'src/app/model/artist.model';
import { ArtistService } from 'src/app/service/artist.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-artists-list',
  templateUrl: './artists-list.component.html',
  styleUrls: ['./artists-list.component.scss']
})
export class ArtistsListComponent implements OnInit {
  public artists!: Array<Artist>;

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
            console.log(1);
          },
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to deleteSubject in ArtistService failed")
    });
  }

  ngOnInit(): void {
    this.searchService.searchSubject.pipe(
      debounceTime(1000)
    ).subscribe({
      next: search => {
        this.artistService.getArtistsByNameWithAutocomplete(search).subscribe({
          next: artists => {
            this.artists = artists;
            console.log(2);
          },
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to SearchService failed")
    });
  }

  public onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['artist', 'add']);
  }

}
