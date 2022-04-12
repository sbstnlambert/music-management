import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Album } from 'src/app/model/album.model';
import { Artist } from 'src/app/model/artist.model';
import { ArtistService } from 'src/app/service/artist.service';

@Component({
  selector: 'app-artist-detail',
  templateUrl: './artist-detail.component.html',
  styleUrls: ['./artist-detail.component.scss']
})
export class ArtistDetailComponent implements OnInit {

  private _artist!: Artist;
  public albums: Array<Album> = [
    {
      id: 1,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 2,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 3,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 4,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 5,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 6,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 7,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 8,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 9,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    {
      id: 10,
      name: 'Trench',
      releaseDate: new Date(2018, 5),
      recordLabel: 'Fueled By Ramen',
      imageUrl: 'https://bit.ly/38MgZ67'
    },
    
  ];

  constructor(
    private route: ActivatedRoute, 
    private artistService: ArtistService
  ) {
    // let artistIdString: string | null = route.snapshot.paramMap.get('id');
    // let artistId: number = artistIdString ? parseInt(artistIdString) : -1;

    // if (artistId && artistId > 0) {
    //   this.artistService.getArtistById(artistId).subscribe({
    //     next: artist => this._artist = artist,
    //     error: () => alert('La requête a échoué')
    //   });
    // } else {
    //   alert('Id invalide');
    // }
  }

  public get artist(): Artist {
    return this._artist;
  }

  ngOnInit(): void {
  }

}
