import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { noBlankSpaces } from 'src/app/components/validation/no-blank-spaces.validator';
import { NoBlankSpacesDirective } from 'src/app/directive/no-blank-spaces.directive';
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
    name: new FormControl('', [Validators.required, Validators.maxLength(255), noBlankSpaces]),
    imageUrl: new FormControl(null, [Validators.maxLength(255), Validators.pattern('^[A-Za-z0-9]*$')])
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
