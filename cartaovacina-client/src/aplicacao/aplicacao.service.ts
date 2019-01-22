import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Aplicacao} from "./aplicacao.model";
import {Headers, Http, RequestOptions, ResponseContentType} from "@angular/http";

@Injectable()
export class AplicacaoService {

  public API = '//localhost:8080';
  public APLICACAO_API = this.API + '/aplicacao';

  constructor(private http: HttpClient,
              private https: Http) { }

  getAll(idUsuario: number): Observable<any>{
    return this.http.get(`${this.APLICACAO_API}/${idUsuario}`)
  }

  findOne(cpf: string){
    return this.http.get(`${this.APLICACAO_API}/${cpf}`)
  }

  save(aplicacao: Aplicacao): Observable<any> {
    let result: Observable<Object>;
    if (aplicacao['id']) {
      result = this.http.put(this.APLICACAO_API, aplicacao);
    } else {
      result = this.http.post(this.APLICACAO_API, aplicacao);
    }
    return result;
  }

  delete(id: number){
    return this.http.delete(`${this.APLICACAO_API}/${id}`);
  }

  downloadPdf(id: number) {
    return this.http
      .get(`${this.APLICACAO_API}/exportacao/${id}`, { responseType:'blob' })
      .toPromise();
  }

}
