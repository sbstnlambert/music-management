import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbumCardComponent } from './components/album/album-card/album-card.component';
import { AlbumDetailedComponent } from './components/album/album-detailed/album-detailed.component';
import { ArtistDetailComponent } from './components/artist/artist-detail/artist-detail.component';
import { ArtistsListComponent } from './components/artist/artists-list/artists-list.component';
import { ArtistFormComponent } from './components/artist/form/artist-form/artist-form.component';
import { Error404Component } from './components/error404/error404.component';
import { TrackDetailedComponent } from './components/track/track-detailed/track-detailed.component';

const routes: Routes = [
  { path: '', redirectTo: 'artist', pathMatch: 'full'},
  { path: 'artist', component: ArtistsListComponent },
  { path: 'artist/add', component: ArtistFormComponent },
  { path: 'artist/:id', component: ArtistDetailComponent },
  { path: 'album/:id', component: AlbumDetailedComponent },
  { path: 'track/:id', component: TrackDetailedComponent },
  { path: '404', component: Error404Component },
  { path: '**', redirectTo: '404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
