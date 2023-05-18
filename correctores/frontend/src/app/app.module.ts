import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DetalleCorrectorComponent } from './detalle-corrector/detalle-corrector.component';
import { FormularioCorrectorComponent } from './formulario-corrector/formulario-corrector.component';

@NgModule({
  declarations: [
    AppComponent,
    DetalleCorrectorComponent,
    FormularioCorrectorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
