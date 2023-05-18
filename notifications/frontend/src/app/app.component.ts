import { Component, OnInit } from '@angular/core';
import { Notificacion } from './notificacion';
import { NotificacionesService } from './notificaciones.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FormularioNotificacionComponent } from './formulario-notificacion/formulario-notificacion.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  notificaciones: Notificacion[] = [];
  notificacionElegida?: Notificacion;

  constructor(
    private notificacionesService: NotificacionesService,
    private modalService: NgbModal
  ) {}

  ngOnInit(): void {
    this.notificaciones = this.notificacionesService.getNotificaciones();
  }

  elegirNotificacion(notificacion: Notificacion): void {
    this.notificacionElegida = notificacion;
  }

  aniadirNotificacion(): void {
    let ref = this.modalService.open(FormularioNotificacionComponent);
    ref.componentInstance.accion = 'Añadir';
    ref.componentInstance.notificacion = {
      id: 0,
      mensaje: '',
      momentoRealEnvio: '',
    };
    ref.result.then(
      (notificacion: Notificacion) => {
        this.notificacionesService.addNotificacion(notificacion);
        this.notificaciones = this.notificacionesService.getNotificaciones();
      },
      (reason) => {}
    );
  }
  notificacionEditada(notificacion: Notificacion): void {
    this.notificacionesService.editarNotificacion(notificacion);
    this.notificaciones = this.notificacionesService.getNotificaciones();
    this.notificacionElegida = this.notificaciones.find((c) => c.id == notificacion.id);
  }

  eliminarNotificacion(id: number): void {
    this.notificacionesService.eliminarNotificacion(id);
    this.notificaciones = this.notificacionesService.getNotificaciones();
    this.notificacionElegida = undefined;
  }

  borrarPendientes(): void {
    let pendientes = []
    for(var i = 0; i < this.notificaciones.length; i++){
      if(this.notificaciones[i].estado === "PENDIENTE")
        pendientes.push(this.notificaciones[i]);
    }

    for(var i = 0; i < pendientes.length; i++){
      this.notificacionesService.eliminarNotificacion(pendientes[i].id)
    }

    this.notificaciones = this.notificacionesService.getNotificaciones();
    this.notificacionElegida = undefined;
  }
}
