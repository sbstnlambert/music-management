import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Album } from 'src/app/model/album.model';
import { AlbumService } from 'src/app/service/album.service';
import { SearchService } from 'src/app/service/search.service';

@Component({
  selector: 'app-album-card',
  templateUrl: './album-card.component.html',
  styleUrls: ['./album-card.component.scss']
})
export class AlbumCardComponent implements OnInit {
  @Input()
  album!: Album;

  isHovered: boolean = false;

  constructor(
    private service: AlbumService,
    private router: Router,
    private searchService: SearchService
  ) { }

  ngOnInit(): void {
  }

  public onClick(): void {
    this.searchService.resetSearch();
    this.router.navigate(['album', this.album.id]);
  }

  onHover(): void {
    this.isHovered = !this.isHovered;
  }

  onDelete(): void {
    this.service.deleteAlbumById(this.album.id).subscribe({
      next: deletedAlbum => console.log(`Album with id = ${deletedAlbum.id} has been successfully deleted`),
      error: () => console.log('An error has occured during the communication with the back-end service')
    });
  }

}
