 package Main;
import java.time.LocalDateTime;
/**
 *
 * @author Elijah
 */
public class Transacao {
    //Váriaveis da transação, Valor da transação, Tempo atual em milisegundos que a transação foi feita (usada para comparar com outra transação), Data e horario apra classificar a transação
    private double _valor;
    private long _tempo;
    private String _dataHorario;
    
    public Transacao(double valor)
    {
            
    this._valor = valor;
    this._tempo = System.currentTimeMillis();
    
    
    LocalDateTime localDate = LocalDateTime.now();
    this._dataHorario = localDate.toString();
    
    }
    
    //Método GET criado para poder saber qual o valor da transação
    public double getValor()
    {
      return _valor;
    }
    
    //Método GET criado para poder ter a medida de tempo 
     public long getTempo()
    {
      return _tempo;
    }
     
     //Método GET criado para poder ter uma identificação da transação para classifica-lá como suspeita ou não
    public String getHorario()
    {
      return _dataHorario;
    }
    
}
