import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {VacinaService} from "./vacina.service";
import {NgForm} from "@angular/forms";
import {Vacina} from "./vacina.model";

@Component({
  selector: 'app-vacina-edit',
  templateUrl: './vacina-edit.component.html',
})
export class VacinaEditComponent implements OnInit, OnDestroy {

  vacina: Vacina = new Vacina;

  sub: Subscription;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private vacinaService: VacinaService) {
  }

  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.vacinaService.findOne(id).subscribe((vacina: any) => {
          if (vacina) {
            this.vacina = vacina;
            this.vacina.id = vacina.id;
          } else {
            console.log(`Vacina with id '${id}' not found, returning to list`);
            this.goToList();
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
    this.vacinaService.save(this.vacina).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }

  delete() {
    this.vacinaService.delete(this.vacina.id).subscribe(result => {
      this.goToList();
    }, error => console.error(error));
  }
}
