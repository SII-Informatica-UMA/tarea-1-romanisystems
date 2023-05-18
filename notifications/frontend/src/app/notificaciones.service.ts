import { Injectable } from '@angular/core';
import { Notificacion } from './notificacion';

@Injectable({
  providedIn: 'root'
})
export class NotificacionesService {
  private notificaciones: Notificacion [] = [
    {id: 1, mensaje: 'Un 0', momentoRealEnvio: new Date ("2018-03-17")  },
    {id: 1, mensaje: 'Un 0', momentoRealEnvio: new Date ("2018-03-17")  },
    {id: 1, mensaje: 'Un 0', momentoRealEnvio: new Date ("2018-03-17")  },
  ];

  constructor() { }

  // Método para obtener todas las notificaciones
  public getNotificaciones(): Notificacion[] {
    return this.notificaciones;
  }
  
  addNotificacion(notificacion: Notificacion) {
    notificacion.id = this.notificaciones.length + 1;
    this.notificaciones.push(notificacion);
  }

  editarNotificacion(notificacion: Notificacion) {
    let indice = this.notificaciones.findIndex(c => c.id == notificacion.id);
    this.notificaciones[indice] = notificacion;
  }

  eliminarcNotificacion(id: number) {
    let indice = this.notificaciones.findIndex(c => c.id == id);
    this.notificaciones.splice(indice, 1);
  }
}
