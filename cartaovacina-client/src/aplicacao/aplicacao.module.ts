import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from "@angular/material";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {ButtonModule, InputMaskModule, InputTextModule} from "primeng/primeng";
import {TableModule} from "primeng/table";
import {AplicacaoService} from "./aplicacao.service";
import {AplicacaoComponent} from "./aplicacao.component";
import {UsuarioService} from "../usuario/usuario.service";
import {DropdownModule} from 'primeng/dropdown';
import {VacinaService} from "../vacina/vacina.service";
import {CalendarModule} from 'primeng/calendar';
import {HttpModule} from "@angular/http";

@NgModule({
  imports: [
    CommonModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    RouterModule,
    FormsModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    InputMaskModule,
    DropdownModule,
    CalendarModule,
    HttpModule,
  ],
  providers: [AplicacaoService, UsuarioService, VacinaService],
  exports: [AplicacaoComponent],
  declarations: [AplicacaoComponent]
})
export class AplicacaoModule { }
