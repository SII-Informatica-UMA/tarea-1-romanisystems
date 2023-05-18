import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioNotificacionComponent } from './formulario-notificacion.component';

describe('FormularioNotificacionComponent', () => {
  let component: FormularioNotificacionComponent;
  let fixture: ComponentFixture<FormularioNotificacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FormularioNotificacionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(FormularioNotificacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
