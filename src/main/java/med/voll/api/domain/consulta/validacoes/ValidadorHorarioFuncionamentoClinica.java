package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component("ValidadorHorarioAntecedenciaAgendamento")
public class ValidadorHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsultas {

    @Override
    public void validar(DadosAgendamentoConsulta dados){
        var dataCosulta = dados.data();

        var  domingo = dataCosulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataCosulta.getHour() < 7;
        var depoisDaAberturaDaClinica = dataCosulta.getHour() > 18;
        if(domingo || antesDaAberturaDaClinica || depoisDaAberturaDaClinica){
            throw new ValidacaoException("Consulta fora do horario de funcionamento");
        }
    }
}
