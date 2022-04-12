import { Component, Input, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Artist } from 'src/app/model/artist.model';

@Component({
  selector: 'app-artist-card',
  templateUrl: './artist-card.component.html',
  styleUrls: ['./artist-card.component.scss']
})
export class ArtistCardComponent implements OnInit {
  @Input()
  artist!: Artist;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  onClick(): void {
    this.router.navigate(['artist', this.artist.id]);
  }

}
