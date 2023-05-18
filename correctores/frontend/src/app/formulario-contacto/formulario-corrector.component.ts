import { Component } from '@angular/core';
import  {Corrector} from '../corrector';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-formulario-corrector',
  templateUrl: './formulario-corrector.component.html',
  styleUrls: ['./formulario-corrector.component.css']
})
export class FormularioCorrectorComponent {
  accion: "Añadir" | "Editar" | undefined;
  corrector: Corrector = {id: 0, nombre: '', apellidos: '', correoElectronico: '', telefono: '', maxExamCorregir: 1, identificadorUsuario: 0};

  constructor(public modal: NgbActiveModal) { }

  guardarCorrector(): void {
    this.modal.close(this.corrector);
  }

}
