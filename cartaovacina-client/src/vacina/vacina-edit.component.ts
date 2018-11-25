import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {VacinaService} from "./vacina.service";
import {NgForm} from "@angular/forms";
import {Vacina} from "./vacina.model";
import {ToastrService} from "ngx-toastr";
import {BlockUI, NgBlockUI} from 'ng-block-ui';

@Component({
  selector: 'app-vacina-edit',
  templateUrl: './vacina-edit.component.html',
})
export class VacinaEditComponent implements OnInit, OnDestroy {

  vacina: Vacina = new Vacina;

  sub: Subscription;

  @BlockUI() blockUI: NgBlockUI;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private vacinaService: VacinaService,
              private toastService: ToastrService
  ) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.blockUI.start("Carregando...")
        this.vacinaService.findOne(id).subscribe((vacina: any) => {
          if (vacina) {
            this.vacina = vacina;
            this.vacina.id = vacina.id;
            this.blockUI.stop();
          } else {
            this.blockUI.stop();
            this.toastService.error("Erro cao carregar vacina.")
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  goToList() {
    this.router.navigate(['/app-vacina']);
  }

  save(form: NgForm) {
    if (!form.valid) {
      this.toastService.error("Todos os campos devem ser preenchidos!");
      return;
    }
    this.blockUI.start("Salvando vacina...")
    this.vacinaService.save(this.vacina).subscribe(result => {
      this.blockUI.stop();
      this.toastService.success("Vacina salva com sucesso!");
      this.goToList();
    }, error => {
      this.blockUI.stop();
      this.toastService.error("Erro ao salvar a vacina!")
    });
  }
}
