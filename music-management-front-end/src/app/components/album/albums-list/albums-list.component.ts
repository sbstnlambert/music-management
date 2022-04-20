import { Component, OnDestroy, OnInit } from '@angular/core';
import { debounceTime, Subscription } from 'rxjs';
import { Album } from 'src/app/model/album.model';
import { AlbumService } from 'src/app/service/album.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-albums-list',
  templateUrl: './albums-list.component.html',
  styleUrls: ['./albums-list.component.scss']
})
export class AlbumsListComponent implements OnInit, OnDestroy {

  albums!: Array<Album>;
  private searchSubscription!: Subscription;
  private refreshSubscription!: Subscription;

  constructor(
    private albumService: AlbumService,
    private searchService: SearchService
  ) {
    this.albumService.refreshSubject.subscribe({
      next: () => {
        this.albumService.getAlbumsByNameWithAutocomplete('').subscribe({
          next: albums => this.albums = albums,
          error: () => console.log("An error has occured while communicating with the back-end service")
        });
      },
      error: () => console.log('Subscription to refreshSubject of AlbumService failed')
    });
  }

  ngOnInit(): void {
    this.searchSubscription = this.searchService.searchSubject.pipe(
      debounceTime(500)
    ).subscribe({
      next: search => {
        this.albumService.getAlbumsByNameWithAutocomplete(search).subscribe({
          next: albums => this.albums = albums,
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to SearchService failed")
    });
  }

  ngOnDestroy(): void {
    this.searchSubscription.unsubscribe();
    this.refreshSubscription.unsubscribe();
  }

}
