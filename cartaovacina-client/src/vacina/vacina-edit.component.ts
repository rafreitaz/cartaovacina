import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs/internal/Subscription";
import {ActivatedRoute, Router} from "@angular/router";
import {VacinaService} from "./vacina.service";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-vacina-edit',
  templateUrl: './vacina-edit.component.html',
})
export class VacinaEditComponent implements OnInit, OnDestroy {

  vacina: any = {};

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
            this.gotoList();
          }
        });
      }
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

  gotoList() {
    this.router.navigate(['/app-vacina']);
  }

  save(form: NgForm) {
    this.vacinaService.save(form).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(id) {
    this.vacinaService.delete(id).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
}
