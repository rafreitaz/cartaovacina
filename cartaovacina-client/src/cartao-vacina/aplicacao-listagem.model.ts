import {Acesso} from "../acesso/acesso.model";
import {Usuario} from "../usuario/usuario.model";
import {Vacina} from "../vacina/vacina.model";
import {Clinica} from "../clinica/clinica.model";

export class AplicacaoListagem {

  id: number;
  usuario: String;
  vacina: String;
  clinica: String;
  dataAplicacao: Date;

  constructor() {
  }
}
