import {Acesso} from "../acesso/acesso.model";
import {Usuario} from "../usuario/usuario.model";
import {Vacina} from "../vacina/vacina.model";
import {Clinica} from "../clinica/clinica.model";

export class Aplicacao {

  id: number;
  usuario: Usuario;
  vacina: Vacina;
  clinica: Clinica;
  dataAplicacao: Date;

  constructor() {
  }
}
