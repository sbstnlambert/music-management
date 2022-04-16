import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AlbumForm } from 'src/app/model/album.model';
import { AlbumService } from 'src/app/service/album.service';

@Component({
  selector: 'app-album-form',
  templateUrl: './album-form.component.html',
  styleUrls: ['./album-form.component.scss']
})
export class AlbumFormComponent implements OnInit {

  albumForm!: FormGroup;

  constructor(
    private service: AlbumService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    let artistIdString: string | null = this.route.snapshot.paramMap.get('id');
    let id: number = artistIdString ? parseInt(artistIdString) : -1;
    if (id && id > 0) {
      this.albumForm = new FormGroup({
        name: new FormControl(null, Validators.required),
        releaseDate: new FormControl(null),
        recordLabel: new FormControl(null),
        imageUrl: new FormControl(null),
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
      let form: AlbumForm = {
        name: this.albumForm.value['name'],
        releaseDate: this.albumForm.value['releaseDate'],
        recordLabel: this.albumForm.value['recordLabel'],
        imageUrl: this.albumForm.value['imageUrl'],
        artistId: this.albumForm.value['artistId']
      };
      this.service.insertAlbum(form).subscribe({
        next: album => {
          this.router.navigate(['album', album.id]);
        },
        error: () => console.log("An error has occured while communicating with the back-end service")
      });
    } else {
      alert("Invalid form");
    }
    console.log(this.albumForm);
  }

}