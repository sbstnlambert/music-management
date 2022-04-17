import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TrackService } from 'src/app/service/track.service';

@Component({
  selector: 'app-track-form',
  templateUrl: './track-form.component.html',
  styleUrls: ['./track-form.component.scss']
})
export class TrackFormComponent implements OnInit {

  trackForm!: FormGroup;
  albumId!: number;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: TrackService
  ) {
    let albumIdString: string | null = this.route.snapshot.paramMap.get('id');
    let id: number = albumIdString ? parseInt(albumIdString) : -1;
    if (id && id > 0) {
      this.albumId = id;
      this.trackForm = new FormGroup({
        name: new FormControl(null, Validators.required),
        lengthInSeconds: new FormControl(null, Validators.required),
        albumPosition: new FormControl(null, Validators.required),
        videoUrl: new FormControl(null),
        albumId: new FormControl(id)
      });
    } else {
      alert("Invalid ID");
    }
  }

  ngOnInit(): void {
  }

  public onSubmit(): void {
    if (this.trackForm.valid) {
      this.service.insertTrack(this.trackForm.value).subscribe({
        next: track => {
          this.router.navigate(['album', this.albumId]);
        },
        error: () => console.log("An error has occured while communicating with the back-end service")
      })
    } else {
      alert("Invalid form");
    }
  }

}
