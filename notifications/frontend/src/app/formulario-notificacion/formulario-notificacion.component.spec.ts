import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioNotificacionComponent } from './formulario-notificacion.component';
import { FormsModule } from '@angular/forms';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

describe('FormularioNotificacionComponent', () => {
  let component: FormularioNotificacionComponent;

  let fixture: ComponentFixture<FormularioNotificacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [FormularioNotificacionComponent],
      providers: [NgbActiveModal],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioNotificacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('debe crear componente formulario', () => {
    expect(component).toBeTruthy();
  });

  it('debe cerrar el modal al guardar la notificacion', () => {
    spyOn(component.modal, 'close');
    component.guardarNotifica();
    expect(component.modal.close).toHaveBeenCalled();
  });

  it('debe emitir el notificacion al guardarNotificacion', () => {
    spyOn(component.modal, 'close');
    const mockNotificacion = {
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
    component.notificacion = mockNotificacion;
    component.guardarNotifica();
    expect(component.modal.close).toHaveBeenCalledWith(mockNotificacion);
  });
});
