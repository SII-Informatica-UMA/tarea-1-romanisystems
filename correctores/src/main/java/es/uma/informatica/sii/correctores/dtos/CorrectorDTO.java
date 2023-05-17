/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.sii.correctores.dtos;

import es.uma.informatica.sii.correctores.entidades.Corrector;
import es.uma.informatica.sii.correctores.entidades.Materia;
import java.util.Arrays;
import java.util.List;
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

public class CorrectorDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Long identificadorUsuario;
    private String telefono;
    private int maximasCorrecciones;
    private List<Materia> materias;

    public static CorrectorDTO fromCorrector(Corrector corrector) {
        CorrectorDTO dto = new CorrectorDTO();
        dto.setId(corrector.getId());
        dto.setIdentificadorUsuario(corrector.getIdentificadorUsuario());
        dto.setTelefono(corrector.getTelefono());
        dto.setMaximasCorrecciones(corrector.getMaxExamCorregir());
        dto.setMaterias(Arrays.asList(corrector.getMateria()));
        dto.setApellido(corrector.getApellidos());
        dto.setNombre(corrector.getNombre());

        return dto;
    }

}
