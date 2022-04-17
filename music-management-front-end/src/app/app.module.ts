import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlbumCardComponent } from './components/album/album-card/album-card.component';
import { AlbumDetailedComponent } from './components/album/album-detailed/album-detailed.component';
import { AlbumsListComponent } from './components/album/albums-list/albums-list.component';
import { AlbumFormComponent } from './components/album/form/album-form/album-form.component';
import { ArtistCardComponent } from './components/artist/artist-card/artist-card.component';
import { ArtistDetailComponent } from './components/artist/artist-detail/artist-detail.component';
import { ArtistsListComponent } from './components/artist/artists-list/artists-list.component';
import { ArtistFormComponent } from './components/artist/form/artist-form/artist-form.component';
import { Error404Component } from './components/error404/error404.component';
import { HeaderComponent } from './components/header/header.component';
import { TrackBannerComponent } from './components/track/track-banner/track-banner.component';
import { TrackDetailedComponent } from './components/track/track-detailed/track-detailed.component';
import { TracksListComponent } from './components/track/tracks-list/tracks-list.component';
import { NumberSuffixPipe } from './pipe/number-suffix.pipe';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ArtistsListComponent,
    Error404Component,
    ArtistCardComponent,
    ArtistDetailComponent,
    AlbumCardComponent,
    AlbumDetailedComponent,
    TrackDetailedComponent,
    TrackBannerComponent,
    NumberSuffixPipe,
    ArtistFormComponent,
    AlbumsListComponent,
    TracksListComponent,
    AlbumFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
