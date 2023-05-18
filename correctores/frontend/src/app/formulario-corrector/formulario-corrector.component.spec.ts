import { ComponentFixture, TestBed } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { FormularioCorrectorComponent } from './formulario-corrector.component';
import { FormsModule } from '@angular/forms';

describe('FormularioCorrectorComponent', () => {
  let component: FormularioCorrectorComponent;
  let fixture: ComponentFixture<FormularioCorrectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormsModule],
      declarations: [FormularioCorrectorComponent],
      providers: [NgbActiveModal],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioCorrectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('debe crear componente formulario', () => {
    expect(component).toBeTruthy();
  });

  it('debe cerrar el modal al guardar el corrector', () => {
    spyOn(component.modal, 'close');
    component.guardarCorrector();
    expect(component.modal.close).toHaveBeenCalled();
  });

  it('debe emitir el corrector al guardarCorrector', () => {
    spyOn(component.modal, 'close');
    const mockCorrector = {
      id: 1,
      nombre: 'Gabry',
      apellido: 'Aguilar',
      correoElectronico: 'paquitoelchocolatero@example.com',
      telefono: '123456789',
      maxExamCorregir: 0,
      identificadorUsuario: 0,
      materia: { id: 0, nombre: '', anio: 0, idConvocatoria: 0 },
    };
    component.corrector = mockCorrector;
    component.guardarCorrector();
    expect(component.modal.close).toHaveBeenCalledWith(mockCorrector);
  });
});
