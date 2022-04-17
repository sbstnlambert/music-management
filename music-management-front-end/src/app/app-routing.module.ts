import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbumDetailedComponent } from './components/album/album-detailed/album-detailed.component';
import { AlbumsListComponent } from './components/album/albums-list/albums-list.component';
import { AlbumFormComponent } from './components/album/form/album-form/album-form.component';
import { ArtistDetailComponent } from './components/artist/artist-detail/artist-detail.component';
import { ArtistsListComponent } from './components/artist/artists-list/artists-list.component';
import { ArtistFormComponent } from './components/artist/form/artist-form/artist-form.component';
import { Error404Component } from './components/error404/error404.component';
import { TrackFormComponent } from './components/track/form/track-form/track-form.component';
import { TrackDetailedComponent } from './components/track/track-detailed/track-detailed.component';
import { TracksListComponent } from './components/track/tracks-list/tracks-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'artist', pathMatch: 'full'},
  { path: 'artist', component: ArtistsListComponent },
  { path: 'artist/add', component: ArtistFormComponent },
  { path: 'artist/:id/album/add', component: AlbumFormComponent },
  { path: 'artist/:id', component: ArtistDetailComponent },
  { path: 'album', component: AlbumsListComponent },
  { path: 'album/:id/track/add', component: TrackFormComponent },
  { path: 'album/:id', component: AlbumDetailedComponent },
  { path: 'track', component: TracksListComponent },
  { path: 'track/:id', component: TrackDetailedComponent },
  { path: '404', component: Error404Component },
  { path: '**', redirectTo: '404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
