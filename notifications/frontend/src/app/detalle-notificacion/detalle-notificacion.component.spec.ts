import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleNotificacionComponent } from './detalle-notificacion.component';

describe('DetalleNotificacionComponent', () => {
  let component: DetalleNotificacionComponent;
  let fixture: ComponentFixture<DetalleNotificacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetalleNotificacionComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleNotificacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('Debe mostrar el atributo de la programacion envio debajo de email ', () => {
    component.notificacion = {
      id: 5,
      mensaje: 'Time to drink!',
      momentoRealEnvio: '2018-03-17',
      tipo: 'ANUNCIO_NOTA_ESTUDIANTE',
      destinatario: 'c.gabriele.info@gmail.com',
      estado: 'PENDIENTE',
      sms: true,
      email: false,
      programacionEnvio: '2020-05-10',
    };

    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;

    expect(compiled.querySelector('#programacionEnvio')).not.toBeNull();
  });

  it('should emit correctorEliminado event when eliminarNotificacion is called', () => {
    spyOn(component.notificacionEliminada, 'emit');

    // Llamar al método eliminarCorrector
    component.eliminarNotificacion();

    // Verificar que se haya emitido el evento con el ID correcto del corrector
    expect(component.notificacionEliminada.emit).toHaveBeenCalledWith(
      component.notificacion?.id
    );
  });

  it('should emit notificacionEditada event when editanotificacion is called', () => {
    spyOn(component.notificacionEditada, 'emit');

    // Llamar al métodonotificacion
    component.editarNotificacion();

    // Verificar que se haya emitido el evento con el ID correcto del notificacion
    expect(component.notificacionEditada.emit).toHaveBeenCalledWith(
      component.notificacion
    );
  });
});
