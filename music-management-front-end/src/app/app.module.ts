import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { ArtistsListComponent } from './components/artist/artists-list/artists-list.component';
import { Error404Component } from './components/error404/error404.component';
import { ArtistCardComponent } from './components/artist/artist-card/artist-card.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ArtistsListComponent,
    Error404Component,
    ArtistCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
