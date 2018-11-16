import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
})
export class MenuComponent implements OnInit {

  items: MenuItem[];

  constructor() {
  }

  ngOnInit() {
    this.items = [
      {
        label: 'Vacinas', icon: 'pi pi-pw pi-file',
        items: [{
          label: 'Cadastrar', icon: 'pi pi-fw pi-plus',
        },
        {
          label: 'Visualizar', icon: 'pi pi-fw pi-external-link'
        },
        ]
      },
    ];
  }
}
