import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {ToastrService} from "ngx-toastr";
import {AplicacaoListagem} from "./aplicacao-listagem.model";
import {AplicacaoService} from "../aplicacao/aplicacao.service";
import {Usuario} from "../usuario/usuario.model";
import { saveAs } from 'file-saver'
import {BlockUI, NgBlockUI} from 'ng-block-ui';


@Component({
  selector: 'app-cartao-vacina',
  templateUrl: './cartao-vacina.component.html',
})
export class CartaoVacinaComponent implements OnInit {

  @Input() usuario: Usuario;
  @Output() logoff: EventEmitter<any> = new EventEmitter();

  @BlockUI() blockUI: NgBlockUI;

  aplicacoes: AplicacaoListagem[];
  aplicacaoSelecionada: AplicacaoListagem;
  cols: any[];

  constructor(private aplicacaoService: AplicacaoService,
              private router: Router,
              private toastService: ToastrService
  ) {
  }

  ngOnInit() {
    this.carregaListagemVacinas();

    this.cols = [
      { field: 'vacina', header: 'Vacina' },
      { field: 'dataAplicacao', header: 'Data da Aplicacao' },
      { field: 'clinica', header: 'Clínica' }
    ];
  }

  voltarMenu() {
    this.router.navigate(['/app-menu']);
  }

  delete() {
    this.subscribeToDeleteResponse(this.aplicacaoService.delete(this.aplicacaoSelecionada.id));
  }

  private subscribeToDeleteResponse(result: Observable<any>) {
    result.subscribe((res) => {
      this.toastService.success("Registro excluído com sucesso!");
      this.carregaListagemVacinas();
    }, (error) => {
      this.toastService.error("Erro ao excluir o registro!");
    });
  }

  carregaListagemVacinas() {
    this.blockUI.start('Carregando...')
    this.aplicacaoService.getAll(this.usuario.id).subscribe(res => {
      this.blockUI.stop();
      this.aplicacoes = res;
    }, error1 => {
      this.blockUI.stop();
      this.toastService.error('Erro ao carregas os registros.')
    });
  }

  fazerLogoff() {
    this.logoff.emit();
  }


  download() {
    this.blockUI.start( "Buscando relatório..." );
    this.aplicacaoService.downloadPdf(this.usuario.id).then(
      res => {
        saveAs (res, 'cartao_vacina.pdf');
        this.blockUI.stop();
      },
      err => {
        this.toastService.error( "Erro ao gerar arquivo." );
        this.blockUI.stop();
      }
    );
  }

}
