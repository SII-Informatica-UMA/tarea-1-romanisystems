import { Component, Input, Output, EventEmitter } from '@angular/core';
import {Notificacion } from '../notificacion';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormularioNotificacionComponent} from '../formulario-notificacion/formulario-notificacion.component'
import { NotificacionesService } from '../notificaciones.service';

@Component({
  selector: 'app-detalle-notificacion',
  templateUrl: './detalle-notificacion.component.html',
  styleUrls: ['./detalle-notificacion.component.css']
})
export class DetalleNotificacionComponent {
  @Input() notificacion?: Notificacion;
  @Output() notificacionEditada = new EventEmitter<Notificacion>();
  @Output() notificacionEliminada = new EventEmitter<number>();

  constructor(private notificacionesService: NotificacionesService, private modalService: NgbModal) { }

  editarNotificacion(): void {
    let ref = this.modalService.open(FormularioNotificacionComponent);
    ref.componentInstance.accion = "Editar";
    ref.componentInstance.notificacion = {...this.notificacion};
    ref.result.then((notificacion: Notificacion) => {
      this.notificacionEditada.emit(notificacion);
    }, (reason) => {});
  }

  eliminarNotificacion(): void {
    this.notificacionEliminada.emit(this.notificacion?.id);
  }
}
