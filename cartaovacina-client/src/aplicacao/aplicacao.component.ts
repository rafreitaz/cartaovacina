import {Component, EventEmitter, Input, OnDestroy, OnInit, Output, ViewChild} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import isValidCpf from '@brazilian-utils/is-valid-cpf';
import {ToastrService} from "ngx-toastr";
import {AplicacaoService} from "./aplicacao.service";
import {Aplicacao} from "./aplicacao.model";
import {Usuario} from "../usuario/usuario.model";
import {Clinica} from "../clinica/clinica.model";
import {Vacina} from "../vacina/vacina.model";
import {UsuarioService} from "../usuario/usuario.service";
import {VacinaService} from "../vacina/vacina.service";
import {SelectItem} from "primeng/api";
import {BlockUI, NgBlockUI} from 'ng-block-ui';

@Component({
  selector: 'app-aplicacao',
  templateUrl: './aplicacao.component.html',
})
export class AplicacaoComponent implements OnInit, OnDestroy {

  @Input() clinica: Clinica;

  @Output() logoff: EventEmitter<any> = new EventEmitter();

  @BlockUI() blockUI: NgBlockUI;

  dataMaxima: Date = new Date();

  aplicacao: Aplicacao = new Aplicacao();
  vacinas: SelectItem[] = [];
  pt: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private aplicacaoService: AplicacaoService,
              private vacinaService: VacinaService,
              private usuarioService: UsuarioService,
              private toastService: ToastrService
  ) {
  }

  ngOnInit() {
    this.aplicacao.clinica = this.clinica;
    this.aplicacao.usuario = new Usuario();
    this.aplicacao.vacina = new Vacina();
    this.aplicacao.dataAplicacao = new Date();
    this.buildDropDownVacinas();
    this.createLocale();
  }

  buildDropDownVacinas() {
    this.blockUI.start('Carregando...')
    this.vacinaService.getAll().subscribe( (res: any) => {
      res.forEach( vacina => {
        this.vacinas.push( {label: vacina.nome, value: vacina.id})
      })
      this.blockUI.stop();
    }, error => {
      this.blockUI.stop();
      this.toastService.error('Erro ao buscar vacinas.')
    })

  }

  createLocale() {
    this.pt = {
      firstDayOfWeek: 0,
      dayNames: ["Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira", "Sábado"],
      dayNamesShort: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sáb"],
      dayNamesMin: ["D","S","T","Q","Q","S","S"],
      monthNames: [ "Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro" ],
      monthNamesShort: [ "Jan", "Fev", "Mar", "Abr", "Mai", "Jun","Jul", "Ago", "Set", "Out", "Nov", "Dez" ],
      today: 'Hoje',
      clear: 'Limpar'
    };
  }

  ngOnDestroy() {
  }

  fazerLogoff() {
    this.logoff.emit();
  }

  procurarUsuario() {
    this.usuarioService.findOne(this.aplicacao.usuario.cpf).subscribe( (res: any) => {
      this.aplicacao.usuario = res;
    }, error => {
      this.toastService.error("Usuário não encontrado.")
      });
  }

  save(form: NgForm) {
    if (!form.valid) {
      this.toastService.error("Todos os campos devem ser preenchidos corretamente!");
      return;
    }

    this.aplicacao.clinica = this.clinica;
    this.blockUI.start('Salvando...')
    this.aplicacaoService.save(this.aplicacao).subscribe(res => {
      this.blockUI.stop();
      this.toastService.success('Aplicação salva com sucesso!')
      this.limpaAplicacao();
    }, error => {
      this.blockUI.stop();
      this.toastService.error(error.headers.get('X-cv-error'))
    });
  }

  cpfValido() {
    if (this.aplicacao.usuario.cpf) {
      return isValidCpf(this.aplicacao.usuario.cpf);
    }
    return false;
  }

  limpaAplicacao() {
    var usuario = this.aplicacao.usuario;
    this.aplicacao = new Aplicacao();
    this.aplicacao.usuario = usuario;
    this.aplicacao.clinica = this.clinica;
    this.aplicacao.vacina = new Vacina();
    this.aplicacao.dataAplicacao = new Date();
  }

  limparCpf() {
    this.aplicacao.usuario = new Usuario();
  }
}
