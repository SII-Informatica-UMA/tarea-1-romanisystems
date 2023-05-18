import { Injectable } from '@angular/core';
import { Corrector } from './corrector';

@Injectable({
  providedIn: 'root',
})
export class CorrectoresService {
  private correctores: Corrector[] = [
    {
      id: 1,
      nombre: 'Pedro',
      apellido: 'Cinà',
      correoElectronico: 'cina@gmail.com',
      telefono: '3425490942',
      maxExamCorregir: 3,
      identificadorUsuario: 245242,
      materia: {
        id: 1,
        nombre: 'Sistemas de Informacion para Internet',
        anio: 2024,
        idConvocatoria: 1,
      },
    },
  ];

  constructor() {}

  // private baseURI: string = 'http://localhost:8080/correctores';
  // constructor(private http: HttpClient) { }

  // Método para obtener todas las correctores
  public getCorrectores(): Corrector[] {
    return this.correctores;
  }

  addCorrector(corrector: Corrector) {
    corrector.id = this.correctores.length + 1;
    this.correctores.push(corrector);
  }

  editarCorrector(corrector: Corrector) {
    let indice = this.correctores.findIndex((c) => c.id == corrector.id);
    this.correctores[indice] = corrector;
  }

  eliminarCorrector(id: number) {
    let indice = this.correctores.findIndex((c) => c.id == id);
    this.correctores.splice(indice, 1);
  }
}
