import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {VacinaService} from "../vacina/vacina.service";
import {HttpClientModule} from "@angular/common/http";
import {VacinaModule} from "../vacina/vacina.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from "@angular/material";
import { AppRoutingModule } from './app-routing.module';
import {MenuVacinaModule} from "../menu/menu-vacina.module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    VacinaModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    AppRoutingModule,
    MenuVacinaModule
  ],
  providers: [VacinaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
