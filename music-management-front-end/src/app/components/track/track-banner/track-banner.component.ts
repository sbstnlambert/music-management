import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TrackSimple } from 'src/app/model/track.model';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-track-banner',
  templateUrl: './track-banner.component.html',
  styleUrls: ['./track-banner.component.scss']
})
export class TrackBannerComponent implements OnInit {

  @Input()
  track!: TrackSimple;

  constructor(
    private router: Router,
    private searchService: SearchService
  ) { }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['track', this.track.id]);
  }

}
