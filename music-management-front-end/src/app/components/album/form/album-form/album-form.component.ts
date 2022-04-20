import { formatDate } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { noBlankSpaces } from 'src/app/components/validation/no-blank-spaces.validator';
import { AlbumService } from 'src/app/service/album.service';
import { dateIsNotInFuture } from '../../../validation/release-date.validator';

@Component({
  selector: 'app-album-form',
  templateUrl: './album-form.component.html',
  styleUrls: ['./album-form.component.scss']
})
export class AlbumFormComponent implements OnInit {

  albumForm!: FormGroup;
  currentDate: Date = new Date();
  today: string = formatDate(this.currentDate, 'yyyy-MM-dd', 'en-US');

  constructor(
    private service: AlbumService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    let artistIdString: string | null = this.route.snapshot.paramMap.get('id');
    let id: number = artistIdString ? parseInt(artistIdString) : -1;
    if (id && id > 0) {
      this.albumForm = new FormGroup({
        name: new FormControl(null, [Validators.required, Validators.maxLength(255), noBlankSpaces]),
        releaseDate: new FormControl(null, dateIsNotInFuture),
        recordLabel: new FormControl(null, Validators.maxLength(255)),
        imageUrl: new FormControl(null, [Validators.maxLength(255), Validators.pattern('^[A-Za-z0-9]*$')]),
        artistId: new FormControl(id)
      });
    } else {
      alert("Invalid ID");
    }
  }

  ngOnInit(): void {
  }

  public onSubmit(): void {
    if (this.albumForm.valid) {
      this.service.insertAlbum(this.albumForm.value).subscribe({
        next: album => {
          this.router.navigate(['album', album.id]);
        },
        error: () => console.log("An error has occured while communicating with the back-end service")
      });
    } else {
      alert("Invalid form");
    }
  }

}
