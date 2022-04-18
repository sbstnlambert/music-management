import { Component, Input, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Artist } from 'src/app/model/artist.model';
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
    private searchService: SearchService
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

}
