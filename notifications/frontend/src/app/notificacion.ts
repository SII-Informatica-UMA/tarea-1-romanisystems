export interface Notificacion {
  id: number;
  mensaje: string;
  momentoRealEnvio: string;
  tipo: string;
  destinatario: string;
  estado: string;
  sms: boolean;
  email: boolean;
  programacionEnvio: string;
}
