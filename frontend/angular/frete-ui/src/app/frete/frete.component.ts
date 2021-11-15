import { Frete } from './../models/frete.model';
import { PrecoService } from './../services/preco.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-frete',
  templateUrl: './frete.component.html',
  styleUrls: ['./frete.component.css']
})
export class FreteComponent implements OnInit {
  origem : string = '';
  destino: string = '';
  km: number = 0;
  valor: number = 0;

  fretes: any[] = [];

  constructor(private service: PrecoService) { }

  ngOnInit(): void {

  }

  calcular(){
    const valorEmitir: Frete = {origem: this.origem, destino: this.destino, km: this.km, valor: this.valor};
    this.service.getFrete(valorEmitir).subscribe( (resultado: Frete[] ) =>{
      //console.log( resultado );
      this.fretes = resultado;
      console.log( this.fretes );
    },
     error =>  console.error(error)

    );
  }


}
