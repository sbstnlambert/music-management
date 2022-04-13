import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AlbumCardComponent } from './components/album/album-card/album-card.component';
import { AlbumDetailedComponent } from './components/album/album-detailed/album-detailed.component';
import { ArtistDetailComponent } from './components/artist/artist-detail/artist-detail.component';
import { ArtistsListComponent } from './components/artist/artists-list/artists-list.component';
import { Error404Component } from './components/error404/error404.component';

const routes: Routes = [
  { path: '', redirectTo: 'artist', pathMatch: 'full'},
  { path: 'artist', component: ArtistsListComponent },
  { path: 'artist/:id', component: ArtistDetailComponent },
  { path: 'album/:id', component: AlbumDetailedComponent },
  { path: '404', component: Error404Component },
  { path: '**', redirectTo: '404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
