import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {VacinaEditComponent} from "../vacina/vacina-edit.component";
import {VacinaComponent} from "../vacina/vacina.component";
import {MenuComponent} from "../menu/menu.component";

const appRoutes: Routes = [
  { path: '', redirectTo: '/app-menu', pathMatch: 'full' },
  {
    path: 'app-menu',
    component: MenuComponent
  },
  {
    path: 'app-vacina',
    component: VacinaComponent
  },
  {
    path: 'app-vacina-add',
    component: VacinaEditComponent
  },
  {
    path: 'app-vacina-edit/:id',
    component: VacinaEditComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})

export class AppRoutingModule {

}
