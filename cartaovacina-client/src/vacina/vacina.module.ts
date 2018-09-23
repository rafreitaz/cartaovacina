import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VacinaComponent } from './vacina.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from "@angular/material";
import { VacinaEditComponent } from './vacina-edit.component';
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";

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
    FormsModule
  ],
  exports: [VacinaComponent, VacinaEditComponent],
  declarations: [VacinaComponent, VacinaEditComponent]
})
export class VacinaModule { }
