import {Component, OnInit} from '@angular/core';
import {VacinaService} from "./vacina.service";
import {Vacina} from "./vacina.model";
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-vacina',
  templateUrl: './vacina.component.html',
})
export class VacinaComponent implements OnInit {

  vacinas: Vacina[];
  vacinaSelecionada: Vacina;
  cols: any[];

  constructor(private vacinaService: VacinaService,
              private router: Router,
              private toastService: ToastrService
  ) {
  }

  ngOnInit() {
    this.updateListaVacinas();

    this.cols = [
      { field: 'id', header: 'ID' },
      { field: 'nome', header: 'Nome' }
    ];
  }

  cadastrar() {
    this.router.navigate(['/app-vacina-add']);
  }

  editar() {
    this.router.navigate(['/app-vacina-edit', this.vacinaSelecionada.id]);
  }

  voltarMenu() {
    this.router.navigate(['/app-menu']);

  }

  hasSelection() {
    return !!this.vacinaSelecionada;
  }

  delete() {
    this.subscribeToDeleteResponse(this.vacinaService.delete(this.vacinaSelecionada.id));
  }

  private subscribeToDeleteResponse(result: Observable<any>) {
    result.subscribe((res) => {
      this.toastService.success("Vacina excluída com sucesso!");
      this.updateListaVacinas();
    }, (error) => {
      this.toastService.error("Erro ao excluir a vacina!");
    });
  }

  updateListaVacinas() {
    this.vacinaService.getAll().subscribe(res => {
      this.vacinas = res;
    });
  }

}
