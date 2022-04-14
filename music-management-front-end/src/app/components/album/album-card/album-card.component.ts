import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Album } from 'src/app/model/album.model';

@Component({
  selector: 'app-album-card',
  templateUrl: './album-card.component.html',
  styleUrls: ['./album-card.component.scss']
})
export class AlbumCardComponent implements OnInit {
  @Input()
  album!: Album;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.router.navigate(['album', this.album.id]);
  }

}
