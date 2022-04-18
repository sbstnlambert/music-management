import { Component, OnInit } from '@angular/core';
import { TrackSimple } from 'src/app/model/track.model';
import { SearchService } from 'src/app/service/search.service';
import { TrackService } from 'src/app/service/track.service';

@Component({
  selector: 'app-tracks-list',
  templateUrl: './tracks-list.component.html',
  styleUrls: ['./tracks-list.component.scss']
})
export class TracksListComponent implements OnInit {

  tracks!: Array<TrackSimple>;

  constructor(
    private searchService: SearchService,
    private trackService: TrackService
  ) {
    this.searchService.searchSubject.subscribe({
      next: search => {
        this.trackService.getTracksByNameWithAutocomplete(search).subscribe({
          next: tracks => this.tracks = tracks,
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to SearchService failed")
    });

    this.trackService.refreshSubject.subscribe({
      next: () => {
        this.trackService.getTracksByNameWithAutocomplete('').subscribe({
          next: tracks => this.tracks = tracks,
          error: () => console.log("An error has occured during the communication with the back-end service")
        });
      },
      error: () => console.log("Subscription to refreshSubject of TrackService failed")
    });
  }

  ngOnInit(): void {
  }

}
