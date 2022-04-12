import { Component, OnInit } from '@angular/core';
import { Artist } from 'src/app/model/artist.model';
import { ArtistService } from 'src/app/service/artist.service';

@Component({
  selector: 'app-artists-list',
  templateUrl: './artists-list.component.html',
  styleUrls: ['./artists-list.component.scss']
})
export class ArtistsListComponent implements OnInit {
  private _artists!: Array<Artist>;

  constructor(private artistService: ArtistService) { }

  public get artists(): Array<Artist> {
    return this._artists.slice();
  }

  ngOnInit(): void {
    this.artistService.getAllArtists().subscribe({
      next: artists => this._artists = artists,
      error: () => console.log("An error has occured during the communication with the back-end service")
    })
  }

}
