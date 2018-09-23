import {Component, OnInit} from '@angular/core';
import {VacinaService} from "./vacina.service";

@Component({
  selector: 'app-vacina',
  templateUrl: './vacina.component.html',
})
export class VacinaComponent implements OnInit {

  vacinas: any[];

  constructor(private vacinaService: VacinaService) {
  }

  ngOnInit() {
    this.vacinaService.getAll().subscribe(data => {
      this.vacinas = data;
    })
  }

}
