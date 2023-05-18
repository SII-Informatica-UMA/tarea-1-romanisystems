import { Materia } from "./materia";

export interface Corrector {
  id: number;
  nombre: string;
  apellido:string;
  correoElectronico: string;
  telefono: string;
  maxExamCorregir: number;
  identificadorUsuario: number;
  materia: Materia;
}