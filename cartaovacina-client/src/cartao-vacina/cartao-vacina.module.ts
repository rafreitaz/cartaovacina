import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from "@angular/material";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {ButtonModule, InputTextModule} from "primeng/primeng";
import {TableModule} from "primeng/table";
import {AplicacaoService} from "../aplicacao/aplicacao.service";
import {CartaoVacinaComponent} from "./cartao-vacina.component";

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
    TableModule
  ],
  providers: [AplicacaoService],
  exports: [CartaoVacinaComponent],
  declarations: [CartaoVacinaComponent]
})
export class CartaoVacinaModule { }
