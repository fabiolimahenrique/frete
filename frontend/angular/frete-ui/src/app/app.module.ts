import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { TabelaPrecoComponent } from './tabela-preco/tabela-preco.component';
import { registerLocaleData } from '@angular/common';
import localept from '@angular/common/locales/pt'
import { HttpClientModule } from '@angular/common/http';
import { FreteComponent } from './frete/frete.component';

registerLocaleData(localept, 'pt');

@NgModule({
  declarations: [
    AppComponent,
    TabelaPrecoComponent,
    FreteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    { provide: LOCALE_ID, useValue: 'pt'},
    { provide: DEFAULT_CURRENCY_CODE, useValue: 'BRL' }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
