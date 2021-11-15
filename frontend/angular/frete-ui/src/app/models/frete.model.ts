export interface Frete {
  origem: string;
  destino: string;
  km: number;
  valor: number;
}

export interface Preco {
  id: number;
  faixa1: number;
  faixa2: number;
  valor: number;
}
