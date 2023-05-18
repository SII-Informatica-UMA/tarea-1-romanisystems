import { Component } from '@angular/core';
import  {Notificacion} from '../notificacion';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-formulario-notificacion',
  templateUrl: './formulario-notificacion.component.html',
  styleUrls: ['./formulario-notificacion.component.css']
})
export class FormularioNotificacionComponent {
  accion: "Añadir" | "Editar" | undefined;
  notificacion: Notificacion = {
      id: 0,
      mensaje: '',
      momentoRealEnvio: '',
    }

  constructor(public modal: NgbActiveModal) { }

  guardarNotifica(): void {
    this.modal.close(this.notificacion);
  }

}
