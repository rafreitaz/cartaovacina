import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {VacinaEditComponent} from "../vacina/vacina-edit.component";
import {VacinaComponent} from "../vacina/vacina.component";
import {MenuComponent} from "../menu/menu.component";
import {UsuarioEditComponent} from "../usuario/usuario-edit.component";
import {ClinicaEditComponent} from "../clinica/clinica-edit.component";
import {ClinicaComponent} from "../clinica/clinica.component";
import {AplicacaoComponent} from "../aplicacao/aplicacao.component";
import {CartaoVacinaComponent} from "../cartao-vacina/cartao-vacina.component";
import {LoginComponent} from "../login/login.component";

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
  },
  {
    path: 'app-usuario-edit',
    component: UsuarioEditComponent
  },
  {
    path: 'app-clinica',
    component: ClinicaComponent
  },
  {
    path: 'app-clinica-add',
    component: ClinicaEditComponent
  },
  {
    path: 'app-clinica-edit/:id',
    component: ClinicaEditComponent
  },
  {
    path: 'app-aplicacao',
    component: AplicacaoComponent
  },
  {
    path: 'app-cartao-vacina',
    component: CartaoVacinaComponent
  },
  {
    path: 'app-login',
    component: LoginComponent
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
