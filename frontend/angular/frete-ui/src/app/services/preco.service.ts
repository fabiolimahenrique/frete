import { Preco, Frete } from './../models/frete.model';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrecoService {
  private listaPreco: any[];
  private url = 'http://localhost:8080/price';
  private urlFrete = 'http://localhost:8080/price/freight';


  constructor(private httpClient: HttpClient) {
    this.listaPreco = [];
   }

   getPrecos(): Observable<Preco[]>{
     return this.httpClient.get<Preco[]>(this.url);
   }

   getFrete(frete: Frete): Observable<Frete[]> {
     return this.httpClient.post<Frete[]>(this.urlFrete, frete);
   }


}
