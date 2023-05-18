import { Component, Input, Output, EventEmitter } from '@angular/core';
import {Corrector } from '../corrector';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {FormularioCorrectorComponent} from '../formulario-corrector/formulario-corrector.component'
import { CorrectoresService } from '../correctores.service';

@Component({
  selector: 'app-detalle-corrector',
  templateUrl: './detalle-corrector.component.html',
  styleUrls: ['./detalle-corrector.component.css']
})
export class DetalleCorrectorComponent {
  @Input() corrector?: Corrector;
  @Output() correctorEditado = new EventEmitter<Corrector>();
  @Output() correctorEliminado = new EventEmitter<number>();

  constructor(private correctoresService: CorrectoresService, private modalService: NgbModal) { }

  editarCorrector(): void {
    let ref = this.modalService.open(FormularioCorrectorComponent);
    ref.componentInstance.accion = "Editar";
    ref.componentInstance.corrector = {...this.corrector};
    ref.result.then((corrector: Corrector) => {
      this.correctorEditado.emit(corrector);
    }, (reason) => {});
  }

  eliminarCorrector(): void {
    this.correctorEliminado.emit(this.corrector?.id);
  }
}
