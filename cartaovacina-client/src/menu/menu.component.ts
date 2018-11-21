import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
})
export class MenuComponent implements OnInit {

  items: MenuItem[];
  clickevent: any;

  constructor() {
  }

  ngOnInit() {
    this.items = [
      {
        label: 'ADM', icon: 'pi pi-pw pi-user',
        items: [{
          label: 'Vacinas', icon: 'pi pi-fw pi-filter', routerLink: ['/app-vacina'],
        },
        {
          label: 'Clínicas', icon: 'pi pi-fw pi-home'
        },
        ]
      },
      {
        label: 'Usuários', icon: 'pi pi-pw pi-users',
        items: [{
          label: 'Cadastrar', icon: 'pi pi-fw pi-user-plus',
        },
          {
            label: 'Vizualizar cartão', icon: 'pi pi-fw pi-list'
          },
        ]
      },
      {
        label: 'Clínica', icon: 'pi pi-pw pi-home',
        items: [{
          label: 'Cadastrar aplicação de vacina', icon: 'pi pi-fw pi-calendar-plus',
        },
        ]
      },
    ];
  }

  click(event) {
    this.clickevent = event.item.label;
  }

}
