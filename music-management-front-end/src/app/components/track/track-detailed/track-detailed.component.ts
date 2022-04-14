import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TrackDetailed } from 'src/app/model/track.model';
import { TrackService } from 'src/app/service/track.service';

@Component({
  selector: 'app-track-detailed',
  templateUrl: './track-detailed.component.html',
  styleUrls: ['./track-detailed.component.scss']
})
export class TrackDetailedComponent implements OnInit {
 
  public isHovered: boolean = false;
  public isInitialized: boolean = false;
  public track!: TrackDetailed;

  constructor(
    private route: ActivatedRoute,
    private service: TrackService
    ) { 
      let trackIdString: string | null = route.snapshot.paramMap.get('id');
      let trackId: number = trackIdString ? parseInt(trackIdString) : -1;

      if (trackId && trackId > 0) {
        this.service.getTrackById(trackId).subscribe({
          next: track => this.track = track,
          error: () => console.log("An error has occured while communicating with the back-end service")
        });
      } else {
        alert('Invalid ID');
      }
    }

  ngOnInit(): void {
  }

  public onHover(): void {
    if (!this.isInitialized) {
      this.isInitialized = true;
    }
    this.isHovered = !this.isHovered;
  }

}
