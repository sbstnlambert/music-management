import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Album } from 'src/app/model/album.model';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-album-card',
  templateUrl: './album-card.component.html',
  styleUrls: ['./album-card.component.scss']
})
export class AlbumCardComponent implements OnInit {
  @Input()
  album!: Album;

  constructor(
    private router: Router,
    private searchService: SearchService
  ) { }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['album', this.album.id]);
  }

}
