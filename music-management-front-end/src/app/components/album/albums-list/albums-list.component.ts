import { Component, OnInit } from '@angular/core';
import { Album } from 'src/app/model/album.model';
import { AlbumService } from 'src/app/service/album.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-albums-list',
  templateUrl: './albums-list.component.html',
  styleUrls: ['./albums-list.component.scss']
})
export class AlbumsListComponent implements OnInit {

  albums!: Array<Album>;

  constructor(
    private albumService: AlbumService,
    private searchService: SearchService
  ) {
    this.searchService.searchSubject.subscribe({
      next: search => {
        this.albumService.getAlbumsByNameWithAutocomplete(search).subscribe({
          next: albums => this.albums = albums,
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to SearchService failed")
    });
  }

  ngOnInit(): void {
  }

}
