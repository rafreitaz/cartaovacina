import {Component, OnInit} from '@angular/core';
import {VacinaService} from "./vacina.service";
import {Vacina} from "./vacina.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-vacina',
  templateUrl: './vacina.component.html',
})
export class VacinaComponent implements OnInit {

  vacinas: Vacina[];
  vacinaSelecionada: Vacina;
  cols: any[];

  constructor(private vacinaService: VacinaService,
              private router: Router) {
  }

  ngOnInit() {
    this.vacinaService.getAll().subscribe(res => {
      this.vacinas = res;
    });

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

}
