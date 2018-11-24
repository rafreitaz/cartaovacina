import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from "@angular/material";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {ButtonModule, InputMaskModule, InputTextModule} from "primeng/primeng";
import {TableModule} from "primeng/table";
import {ClinicaService} from "./clinica.service";
import {ClinicaEditComponent} from "./clinica-edit.component";
import {ClinicaComponent} from "./clinica.component";

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
  providers: [ClinicaService],
  exports: [ClinicaEditComponent, ClinicaComponent],
  declarations: [ClinicaEditComponent, ClinicaComponent]
})
export class ClinicaModule { }
