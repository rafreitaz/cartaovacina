import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule} from "@angular/material";
import {RouterModule} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {ButtonModule, DropdownModule, InputMaskModule, InputTextModule} from "primeng/primeng";
import {TableModule} from "primeng/table";
import {UsuarioService} from "../usuario/usuario.service";
import {ClinicaService} from "../clinica/clinica.service";
import {LoginComponent} from "./login.component";
import {ToastrModule} from "ngx-toastr";
import {CartaoVacinaModule} from "../cartao-vacina/cartao-vacina.module";
import {AplicacaoModule} from "../aplicacao/aplicacao.module";

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
    CartaoVacinaModule,
    AplicacaoModule
  ],
  providers: [UsuarioService, ClinicaService],
  exports: [LoginComponent],
  declarations: [LoginComponent]
})
export class LoginModule { }
