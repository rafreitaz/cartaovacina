import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from "@angular/material";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {ButtonModule, InputMaskModule, InputTextModule} from "primeng/primeng";
import {TableModule} from "primeng/table";
import {UsuarioEditComponent} from "./usuario-edit.component";
import {UsuarioService} from "./usuario.service";

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
    InputMaskModule
  ],
  providers: [UsuarioService],
  exports: [UsuarioEditComponent],
  declarations: [UsuarioEditComponent]
})
export class UsuarioModule { }
