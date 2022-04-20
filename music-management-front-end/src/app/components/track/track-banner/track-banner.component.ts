import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { faTrashCan } from '@fortawesome/free-solid-svg-icons';
import { TrackSimple } from 'src/app/model/track.model';
import { AuthService } from 'src/app/service/auth.service';
import { SearchService } from 'src/app/service/search.service';
import { TrackService } from 'src/app/service/track.service';

@Component({
  selector: 'app-track-banner',
  templateUrl: './track-banner.component.html',
  styleUrls: ['./track-banner.component.scss']
})
export class TrackBannerComponent implements OnInit {

  // Font Awesome icons
  faTrashCan = faTrashCan
  iconColor: string = '#ff7c7c';
  
  isHovered: boolean = false;

  @Input()
  track!: TrackSimple;

  constructor(
    private router: Router,
    private searchService: SearchService,
    private trackService: TrackService,
    public authService: AuthService
  ) { }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['track', this.track.id]);
  }

  public onHoverDeleteButton(): void {
    this.iconColor = (this.iconColor === '#ff7c7c' ? 'red' : '#ff7c7c');
  }

  public onHover(): void {
    this.isHovered = !this.isHovered;
  }

  public onDelete(): void {
    this.trackService.deleteTrackById(this.track.id).subscribe({
      next: track => console.log(`Track of id = ${track.id} has been successfully deleted`),
      error: () => console.log('An error has occured during the communication with the back-end service')
    });
  }

}
