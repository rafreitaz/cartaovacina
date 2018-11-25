import {Component, OnInit, Output} from '@angular/core';
import {SelectItem} from "primeng/api";
import {Acesso} from "../acesso/acesso.model";
import {Usuario} from "../usuario/usuario.model";
import {Clinica} from "../clinica/clinica.model";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";
import {NgForm} from "@angular/forms";
import {UsuarioService} from "../usuario/usuario.service";
import {BlockUI, NgBlockUI} from 'ng-block-ui';
import {ClinicaService} from "../clinica/clinica.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
})
export class LoginComponent implements OnInit {

  acesso: Acesso = new Acesso();
  @Output() usuario: Usuario;
  @Output() clinica: Clinica;

  @BlockUI() blockUI: NgBlockUI;

  tiposAcesso: SelectItem[] = [];

  isTelaClinica: boolean = false;
  isTelaUsuario: boolean = false;
  isTelaLogin: boolean = true;

  constructor(private router: Router,
              private toastrService: ToastrService,
              private usuarioService: UsuarioService,
              private clinicaService: ClinicaService) {
  }

  ngOnInit() {
    this.carregarTipoAcesso();
  }

  carregarTipoAcesso() {
    this.tiposAcesso = [
      {label: 'Usuário', value: 'U'},
      {label: 'Clínica', value: 'C'}
    ]
  }

  goToList() {
    this.router.navigate(['/app-menu'])
  }

  login(form: NgForm) {
    if (!form.valid) {
      this.toastrService.error("Todos os campos devem ser preenchidos!");
      return;
    }
    if (this.acesso.tipoAcesso == 'U') {
      this.blockUI.start('Fazendo login...')
      this.usuarioService.logarUsuario(this.acesso.login, this.acesso.senha).subscribe( (res: any) => {
        this.usuario = res;
        this.blockUI.stop();
        this.toastrService.success("Login realizado com sucesso!")
        this.logaUsuario();
      }, error1 => {
        this.blockUI.stop();
        this.toastrService.error('Usuário ou senha inválidos!')
      })
    }
    if (this.acesso.tipoAcesso == 'C') {
      this.blockUI.start('Fazendo login...')
      this.clinicaService.logarClinica(this.acesso.login, this.acesso.senha).subscribe( (res: any) => {
        this.clinica = res;
        this.blockUI.stop();
        this.toastrService.success("Login realizado com sucesso!")
        this.logaClinica();
      }, error1 => {
        this.blockUI.stop();
        this.toastrService.error('Usuário ou senha inválidos!')
      })
    }
  }

  logoff() {
    this.isTelaLogin = true;
    this.isTelaUsuario = false;
    this.isTelaClinica = false;
    this.acesso = new Acesso();
    this.usuario = undefined;
    this.clinica = undefined;
  }

  logaUsuario() {
    this.isTelaUsuario = true;
    this.isTelaLogin = false;
  }

  logaClinica() {
    this.isTelaClinica = true;
    this.isTelaLogin = false;
  }
}
