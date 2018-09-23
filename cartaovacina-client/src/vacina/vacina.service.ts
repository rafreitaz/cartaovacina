import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class VacinaService {

  constructor(private http: HttpClient) { }
}
