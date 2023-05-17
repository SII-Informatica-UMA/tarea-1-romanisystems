/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.sii.correctores.dtos;

import es.uma.informatica.sii.correctores.entidades.Corrector;
import es.uma.informatica.sii.correctores.entidades.Materia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

/**
 *
 * @author manus
 */
public class CorrectorNuevoDTO {

    private Long id;
    private Long identificadorUsuario;
    private String telefono;
    private int maximasCorrecciones;
    private Materia materia;

    public static CorrectorNuevoDTO fromCorrector(Corrector corrector) {
        CorrectorNuevoDTO dto = new CorrectorNuevoDTO();
        dto.setId(corrector.getId());
        dto.setIdentificadorUsuario(corrector.getIdentificadorUsuario());
        dto.setTelefono(corrector.getTelefono());

        dto.setMaximasCorrecciones(corrector.getMaxExamCorregir());

        dto.setMateria(corrector.getMateria());

        return dto;
    }

}
