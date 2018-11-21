import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './menu.component';
import {PanelMenuModule} from 'primeng/panelmenu';
import {MenuItem} from 'primeng/api';
import {ButtonModule} from "primeng/button";

@NgModule({
  imports: [
    CommonModule,
    PanelMenuModule,
    ButtonModule
  ],
  declarations: [MenuComponent]
})
export class MenuVacinaModule { }
