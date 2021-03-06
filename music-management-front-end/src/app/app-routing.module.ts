import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbumDetailedComponent } from './components/album/album-detailed/album-detailed.component';
import { AlbumsListComponent } from './components/album/albums-list/albums-list.component';
import { AlbumFormComponent } from './components/album/form/album-form/album-form.component';
import { ArtistDetailComponent } from './components/artist/artist-detail/artist-detail.component';
import { ArtistsListComponent } from './components/artist/artists-list/artists-list.component';
import { ArtistFormComponent } from './components/artist/form/artist-form/artist-form.component';
import { Error404Component } from './components/error404/error404.component';
import { SignInComponent } from './components/user-account/sign-in/sign-in.component';
import { TrackFormComponent } from './components/track/form/track-form/track-form.component';
import { TrackDetailedComponent } from './components/track/track-detailed/track-detailed.component';
import { TracksListComponent } from './components/track/tracks-list/tracks-list.component';
import { SignUpComponent } from './components/user-account/sign-up/sign-up.component';
import { AdminGuard } from './guard/admin.guard';

const routes: Routes = [
  { path: '', redirectTo: 'artist', pathMatch: 'full'},
  { path: 'artist', component: ArtistsListComponent },
  { path: 'artist/add', component: ArtistFormComponent, canActivate: [AdminGuard] },
  { path: 'artist/:id/album/add', component: AlbumFormComponent, canActivate: [AdminGuard] },
  { path: 'artist/:id', component: ArtistDetailComponent },
  { path: 'album', component: AlbumsListComponent },
  { path: 'album/:id/track/add', component: TrackFormComponent, canActivate: [AdminGuard] },
  { path: 'album/:id', component: AlbumDetailedComponent },
  { path: 'track', component: TracksListComponent },
  { path: 'track/:id', component: TrackDetailedComponent },
  { path: 'signin', component: SignInComponent },
  { path: 'signup', component: SignUpComponent },
  { path: '404', component: Error404Component },
  { path: '**', redirectTo: '404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
