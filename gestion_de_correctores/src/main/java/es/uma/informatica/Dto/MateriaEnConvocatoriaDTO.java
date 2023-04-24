/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.uma.informatica.Dto;

import es.uma.informatica.entidades.Corrector;
import es.uma.informatica.entidades.Materia;
import java.net.URI;
import java.util.function.Function;
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
public class MateriaEnConvocatoriaDTO {
    
    private Long idMateria;
    private Long idConvocatoria;

    public static MateriaEnConvocatoriaDTO fromMateria(Materia materia) {
        MateriaEnConvocatoriaDTO dto = new MateriaEnConvocatoriaDTO();
        
        dto.setIdMateria(materia.getId());
        dto.setIdConvocatoria(materia.getIdConvocatoria());
    
    
    return dto;
    
}
      public Materia materia() {
        Materia mat = new Materia();
        mat.setId(idMateria);

        return mat;
    }
    
}