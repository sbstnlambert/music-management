import { Component, Input, OnInit } from '@angular/core';
import { TrackSimple } from 'src/app/model/track.model';

@Component({
  selector: 'app-track-banner',
  templateUrl: './track-banner.component.html',
  styleUrls: ['./track-banner.component.scss']
})
export class TrackBannerComponent implements OnInit {

  @Input()
  track!: TrackSimple;

  constructor() { }

  ngOnInit(): void {
  }

}
