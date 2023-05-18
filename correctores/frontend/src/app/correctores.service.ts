import { Injectable } from '@angular/core';
import { Notificacion } from './notificacion';

@Injectable({
  providedIn: 'root'
})
export class CorrectoresService {
  private notificaciones: Notificacion [] = [
    {id: 1, nombre: 'Paco', apellidos: 'Perez', correoElectronico: 'jpidsfipsf@gmail.com', telefono: '987564321', maxExamCorregir: 1, identificadorUsuario: 1  },
    {id: 2, nombre: 'Luca', apellidos: 'Sanchez', correoElectronico: 'ajfhka@gmail.com', telefono: '987654321', maxExamCorregir: 1, identificadorUsuario: 2  },
    {id: 0, nombre: 'Juan', apellidos: 'Jimenez', correoElectronico: 'hdshiuf@gmail.com', telefono: '912345678', maxExamCorregir: 2, identificadorUsuario: 0  },
  ];

  constructor() { }

  // Método para obtener todas las notificaciones
  public getCorrectores(): Corrector[] {
    return this.correctores;
  }
  
  addCorrector(corrector: Corrector) {
    corrector.id = this.correctores.length + 1;
    this.correctores.push(corrector);
  }

  editarCorrector(corrector: Corrector) {
    let indice = this.correctores.findIndex(c => c.id == notificacion.id);
    this.correctores[indice] = corrector;
  }

  eliminarCorrector(id: number) {
    let indice = this.correctores.findIndex(c => c.id == id);
    this.correctores.splice(indice, 1);
  }
}
