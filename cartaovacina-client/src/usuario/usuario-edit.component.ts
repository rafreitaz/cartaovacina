import {Component, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {NgForm} from "@angular/forms";
import {UsuarioService} from "./usuario.service";
import {Usuario} from "./usuario.model";
import isValidCpf from '@brazilian-utils/is-valid-cpf';
import {ToastrService} from "ngx-toastr";
import {Acesso} from "../acesso/acesso.model";

@Component({
  selector: 'app-usuario-edit',
  templateUrl: './usuario-edit.component.html',
})
export class UsuarioEditComponent implements OnInit, OnDestroy {

  usuario: Usuario = new Usuario;

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private usuarioService: UsuarioService,
              private toastService: ToastrService
  ) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.usuarioService.findOne(id).subscribe((usuario: any) => {
          if (usuario) {
            this.usuario = usuario;
          } else {
            console.log(`Usuario with id '${id}' not found, returning to list`);
            this.goToList();
          }
        });
      } else {
        this.usuario.acesso = new Acesso();
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  goToList() {
    this.router.navigate(['/app-menu']);
  }

  save(form: NgForm) {
    if (!isValidCpf(this.usuario.cpf)) {
      this.toastService.warning("CPF Inválido!")
      return;
    }
    if (!form.valid) {
      this.toastService.error("Todos os campos devem ser preenchidos corretamente!");
      return;
    }
    this.usuarioService.save(this.usuario).subscribe(res => {
      this.goToList();
    }, error => this.toastService.error(error.headers.get('X-cv-error')));
  }

  delete() {
    this.usuarioService.delete(this.usuario.id).subscribe(result => {
      this.goToList();
    }, error => this.toastService.error(error.headers.get('X-cv-error')));
  }
}
