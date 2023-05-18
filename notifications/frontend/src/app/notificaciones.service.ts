import { Injectable } from '@angular/core';
import { Notificacion } from './notificacion';

@Injectable({
  providedIn: 'root'
})
export class NotificacionesService {
  private notificaciones: Notificacion [] = [
    {id: 1, mensaje: 'Time to drink!', momentoRealEnvio: "2018-03-17"  },
    {id: 1, mensaje: 'Usage is up 20% this week', momentoRealEnvio: "2018-03-17"  },
    {id: 1, mensaje: '1 Message', momentoRealEnvio: "2018-03-17"  },
  ];

  constructor() { }

  // private baseURI: string = 'http://localhost:8080/notificaciones';
  // constructor(private http: HttpClient) { }

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
