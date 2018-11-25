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
          label: 'Clínicas', icon: 'pi pi-fw pi-home', routerLink: ['/app-clinica']
        },
        ]
      },
      {
        label: 'Usuários', icon: 'pi pi-pw pi-users',
        items: [{
          label: 'Cadastrar', icon: 'pi pi-fw pi-user-plus', routerLink: ['/app-usuario-edit'],
        },
        ]
      },
      {
        label: 'Login', icon: 'pi pi-pw pi-home',
        items: [{
          label: 'Fazer login', icon: 'pi pi-fw pi-calendar-plus', routerLink: ['/app-login']
        },
        ]
      },
    ];
  }

  click(event) {
    this.clickevent = event.item.label;
  }

}
