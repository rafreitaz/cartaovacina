import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MenuComponent } from './menu.component';
import {PanelMenuModule} from 'primeng/panelmenu';
import {MenuItem} from 'primeng/api';

@NgModule({
  imports: [
    CommonModule,
    PanelMenuModule
  ],
  declarations: [MenuComponent]
})
export class MenuModule { }
