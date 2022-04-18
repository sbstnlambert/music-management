import { Component, Input, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Artist } from 'src/app/model/artist.model';
import { ArtistService } from 'src/app/service/artist.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-artist-card',
  templateUrl: './artist-card.component.html',
  styleUrls: ['./artist-card.component.scss']
})
export class ArtistCardComponent implements OnInit {
  @Input()
  artist!: Artist;

  isHovered: boolean = false;

  constructor(
    private router: Router,
    private searchService: SearchService,
    private artistService: ArtistService
  ) { }

  ngOnInit(): void {
  }

  onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['artist', this.artist.id]);
  }

  onHover(): void {
    this.isHovered = !this.isHovered;
  }

  onDelete(): void {
    this.artistService.deleteArtistById(this.artist.id).subscribe({
      next: deletedArtist => console.log(`Artist with id = ${deletedArtist.id} has been successfully deleted`),
      error: () => console.log('An error has occured during the communication with the back-end service')
    });
  }

}
