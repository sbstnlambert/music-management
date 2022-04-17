import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ArtistService } from 'src/app/service/artist.service';

@Component({
  selector: 'app-artist-form',
  templateUrl: './artist-form.component.html',
  styleUrls: ['./artist-form.component.scss']
})
export class ArtistFormComponent implements OnInit {

  constructor(
    private service: ArtistService,
    private router: Router
  ) { }

  artistForm = new FormGroup({
    name: new FormControl(null, Validators.required),
    imageUrl: new FormControl(null)
  });

  ngOnInit(): void {
  }

  public onSubmit(): void {
    if (this.artistForm.valid) {
      this.service.insertArtist(this.artistForm.value).subscribe({
        next: artist => {
          this.router.navigate(['artist', artist.id]);
        },
        error: () => console.log("An error has occured while communicating with the back-end service")
      });
    } else {
      alert("Invalid form");
    }
  }
}
