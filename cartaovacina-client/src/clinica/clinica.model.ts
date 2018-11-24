import {Acesso} from "../acesso/acesso.model";

export class Clinica {

  id: number;
  nome: string;
  cnpj: string;
  email: string;
  acesso: Acesso;

  constructor() {
  }
}
