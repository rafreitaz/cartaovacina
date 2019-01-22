import {Acesso} from "../acesso/acesso.model";

export class Usuario {

  id: number;
  nome: string;
  cpf: string;
  email: string;
  acesso: Acesso;


  constructor() {
  }
}
