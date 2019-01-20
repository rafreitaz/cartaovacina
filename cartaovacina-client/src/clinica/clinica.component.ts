import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Observable} from "rxjs";
import {ToastrService} from "ngx-toastr";
import {Clinica} from "./clinica.model";
import {ClinicaService} from "./clinica.service";

@Component({
  selector: 'app-clinica',
  templateUrl: './clinica.component.html',
})
export class ClinicaComponent implements OnInit {

  clinicas: Clinica[];
  clinicaSelecionada: Clinica;
  cols: any[];

  constructor(private clinicaService: ClinicaService,
              private router: Router,
              private toastService: ToastrService
  ) {
  }

  ngOnInit() {
    this.updateListaClinicas();

    this.cols = [
      { field: 'nome', header: 'Nome' },
      { field: 'cnpj', header: 'CNPJ' }
    ];
  }

  cadastrar() {
    this.router.navigate(['/app-clinica-add']);
  }

  editar() {
    this.router.navigate(['/app-clinica-edit', this.clinicaSelecionada.id]);
  }

  voltarMenu() {
    this.router.navigate(['/app-menu']);

  }

  hasSelection() {
    return !!this.clinicaSelecionada;
  }

  delete() {
    this.subscribeToDeleteResponse(this.clinicaService.delete(this.clinicaSelecionada.id));
  }

  private subscribeToDeleteResponse(result: Observable<any>) {
    result.subscribe((res) => {
      this.toastService.success("Clínica excluída com sucesso!");
      this.updateListaClinicas();
    }, (error) => {
      this.toastService.error("Erro ao excluir a Clínica!");
    });
  }

  updateListaClinicas() {
    this.clinicaService.getAll().subscribe(res => {
      this.clinicas = res;
    });
  }

}
