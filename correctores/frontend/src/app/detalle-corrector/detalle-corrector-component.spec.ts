import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetalleCorrectorComponent } from './detalle-corrector.component';

describe('DetalleCorrectorComponent', () => {
  let component: DetalleCorrectorComponent;
  let fixture: ComponentFixture<DetalleCorrectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [DetalleCorrectorComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetalleCorrectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('Debe mostrar el atributo de la materia debajo de corrector ', () => {
    component.corrector = {
      id: 0,
      nombre: 'Pepe',
      apellido: 'avaf',
      correoElectronico: 'dawd',
      telefono: 'dawdaw',
      maxExamCorregir: 3,
      identificadorUsuario: 35232,
      materia: {
        id: 1,
        nombre: 'Lengua',
        anio: 2020,
        idConvocatoria: 2,
      },
    };
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;

    expect(compiled.querySelector('#nombreMateria')).not.toBeNull();
    expect(compiled.querySelector('#anio')).not.toBeNull();
    expect(compiled.querySelector('#idConvocatoria')).not.toBeNull();
  });

  it('should emit correctorEliminado event when eliminarCorrector is called', () => {
    spyOn(component.correctorEliminado, 'emit');

    // Llamar al método eliminarCorrector
    component.eliminarCorrector();

    // Verificar que se haya emitido el evento con el ID correcto del corrector
    expect(component.correctorEliminado.emit).toHaveBeenCalledWith(
      component.corrector?.id
    );
  });
});
