import { Component, OnInit } from '@angular/core';
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
    private searchService: SearchService
  ) {
    this.searchService.searchSubject.subscribe({
      next: search => {
        this.artistService.getArtistsByNameWithAutocomplete(search).subscribe({
          next: artists => this.artists = artists,
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to SearchService failed")
    });
  }

  ngOnInit(): void {
    
  }

}
