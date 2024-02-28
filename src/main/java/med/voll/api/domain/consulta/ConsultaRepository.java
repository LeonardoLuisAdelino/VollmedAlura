package med.voll.api.domain.consulta;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {


    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

//    boolean existisByPaciente_IdAndDataBetween(Long paciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

    @Query("select (count(c) > 0) from Consulta c where c.paciente.id = ?1 and c.data between ?2 and ?3")
    boolean existisByPaciente_IdAndDataBetween(Long id, LocalDateTime dataStart, LocalDateTime dataEnd);

    boolean existsByMedicoIdAndDataAndMotivoCancelamentoIsNull(Long idMedico, LocalDateTime data);
}
