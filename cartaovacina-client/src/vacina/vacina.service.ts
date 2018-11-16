import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/internal/Observable";
import {Vacina} from "./vacina.model";

@Injectable()
export class VacinaService {

  public API = '//localhost:8080';
  public VACINA_API = this.API + '/vacinas';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get(this.VACINA_API)
  }

  findOne(id: number){
    return this.http.get(`${this.VACINA_API}/${id}`)
  }

  save(vacina: Vacina): Observable<any> {
    let result: Observable<Object>;
    if (vacina['id']) {
      result = this.http.put(this.VACINA_API, vacina);
    } else {
      result = this.http.post(this.VACINA_API, vacina);
    }
    return result;
  }

  delete(id: number){
    return this.http.delete(`${this.VACINA_API}/${id}`);
  }
}
