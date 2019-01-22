import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Clinica} from "./clinica.model";

@Injectable()
export class ClinicaService {

  public API = '//localhost:8080';
  public CLINICAS_API = this.API + '/clinicas';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get(this.CLINICAS_API)
  }

  findOne(id: number){
    return this.http.get(`${this.CLINICAS_API}/${id}`)
  }

  save(clinica: Clinica): Observable<any> {
    let result: Observable<Object>;
    if (clinica['id']) {
      result = this.http.put(this.CLINICAS_API, clinica);
    } else {
      result = this.http.post(this.CLINICAS_API, clinica);
    }
    return result;
  }

  delete(id: number){
    return this.http.delete(`${this.CLINICAS_API}/${id}`);
  }

  logarClinica(login: string, senha: string) {
    return this.http.get(`${this.CLINICAS_API}/logar/${login}/${senha}`)
  }
}
