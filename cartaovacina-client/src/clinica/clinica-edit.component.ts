import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import isValidCnpj from '@brazilian-utils/is-valid-cnpj';
import {ToastrService} from "ngx-toastr";
import {Clinica} from "./clinica.model";
import {ClinicaService} from "./clinica.service";
import {Acesso} from "../acesso/acesso.model";
import {Observable} from "rxjs";

@Component({
  selector: 'app-clinica-edit',
  templateUrl: './clinica-edit.component.html',
})
export class ClinicaEditComponent implements OnInit, OnDestroy {

  clinica: Clinica = new Clinica;

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private clinicaService: ClinicaService,
              private toastService: ToastrService
  ) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.clinicaService.findOne(id).subscribe((clinica: any) => {
          if (clinica) {
            this.clinica = clinica;
          } else {
            console.log(`Clinica with id '${id}' not found, returning to list`);
            this.goToList();
          }
        });
      } else {
        this.clinica.acesso = new Acesso();
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  goToList() {
    this.router.navigate(['/app-clinica']);
  }

  save(form: NgForm) {
    if (!isValidCnpj(this.clinica.cnpj)) {
      this.toastService.warning("CNPJ Inválido!")
      return;
    }
    if (!form.valid) {
      this.toastService.error("Todos os campos devem ser preenchidos corretamente!");
      return;
    }
    this.subscribeToSaveResponse(this.clinicaService.save(this.clinica));
  }

  private subscribeToSaveResponse(result: Observable<any>) {
    result.subscribe((res) => {
      this.toastService.success("Clínica salva com sucesso!");
      this.goToList();
    }, (error: Response) => {
      this.toastService.error(error.headers.get('X-cv-error'));
    });
  }
}
