import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Usuario} from "./usuario.model";

@Injectable()
export class UsuarioService {

  public API = '//localhost:8080';
  public USUARIOS_API = this.API + '/usuarios';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get(this.USUARIOS_API)
  }

  findOne(cpf: string){
    return this.http.get(`${this.USUARIOS_API}/cpf/${cpf}`)
  }

  save(usuario: Usuario): Observable<any> {
    let result: Observable<Object>;
    if (usuario['id']) {
      result = this.http.put(this.USUARIOS_API, usuario);
    } else {
      result = this.http.post(this.USUARIOS_API, usuario);
    }
    return result;
  }

  delete(id: number){
    return this.http.delete(`${this.USUARIOS_API}/${id}`);
  }

  logarUsuario(login: string, senha: string) {
    return this.http.get(`${this.USUARIOS_API}/logar/${login}/${senha}`)
  }
}
