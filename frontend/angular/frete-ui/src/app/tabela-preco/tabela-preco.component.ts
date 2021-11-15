import { Preco } from './../models/frete.model';
import { PrecoService } from './../services/preco.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-tabela-preco',
  templateUrl: './tabela-preco.component.html',
  styleUrls: ['./tabela-preco.component.css']
})
export class TabelaPrecoComponent implements OnInit {
  precos: any[] = [];

  constructor(private service: PrecoService) { }

  ngOnInit(): void {
     this.service.getPrecos().subscribe( (precos: Preco[]) =>{
        console.table(precos);
        this.precos = precos;
        console.log(this.precos);
     })

  }


}
