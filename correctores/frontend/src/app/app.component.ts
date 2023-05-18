import { Component, OnInit } from '@angular/core';
import { Corrector } from './corrector';
import { CorrectoresService } from './correctores.service';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormularioCorrectorComponent} from './formulario-corrector/formulario-corrector.component'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  correctores: Corrector [] = [];
  correctorElegido?: Corrector;

  constructor(private correctoresService: CorrectoresService, private modalService: NgbModal) { }

  ngOnInit(): void {
    this.correctores = this.correctoresService.getCorrectores();
  }

  elegirCorrector(corrector: Corrector): void {
    this.correctorElegido = corrector;
  }

  aniadirCorrector(): void {
    let ref = this.modalService.open(FormularioCorrectorComponent);
    ref.componentInstance.accion = "Añadir";
    ref.componentInstance.contacto = {id: 0, nombre: '', apellidos: '', correoElectronico: '', telefono: '', maxExamCorregir: 1, identificadorUsuario: 0};
    ref.result.then((corrector: Corrector) => {
      this.correctoresService.addCorrector(corrector);
      this.correctores = this.correctoresService.getCorrectores();
    }, (reason) => {});

  }
  correctorEditado(corrector: Corrector): void {
    this.correctoresService.editarCorrector(corrector);
    this.correctores = this.correctoresService.getCorrectores();
    this.correctorElegido = this.correctores.find(c => c.id == corrector.id);
  }

  eliminarCorrector(id: number): void {
    this.correctoresService.eliminarcCorrector(id);
    this.correctores = this.correctoresService.getCorrectores();
    this.correctorElegido = undefined;
  }
}
