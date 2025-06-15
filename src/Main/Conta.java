package Main;
import java.util.*;
/**
 * @author Elijah
 */
public class Conta{
    
        private int _numeroConta;
        private int _digitoConta;
        private int _agenciaConta;
        private int _senhaConta;
        List<Transacao> transacoes = new ArrayList<>();
        
        
        //Métodos GET da classe Conta
      public int getNumeroConta()
      {
      return this._numeroConta;
      }
      public int getDigitoConta()
      {
      return this._digitoConta;
      }
      public int getAgencia()
      {
      return this._agenciaConta;
      }
      public int getSenha()
      {
      return this._senhaConta;
      }
      public List<Transacao> getTransacoes()
      {
        return transacoes;
      }
      
      //Métodos SET da classe Conta
      public void setNumeroConta(int numeroConta)
      {
      this._numeroConta = numeroConta;
      }
      public void setDigitoConta(int digitoConta)
      {
      this._digitoConta = digitoConta;
      }
      public void setAgencia(int agencia)
      {
      this._agenciaConta = agencia;
      }
      public void setSenhaConta(int _senhaConta)
      {
      this._senhaConta = _senhaConta;
      }
      
      //Método de adicionar uma transação à conta
      public void adicionarTransacao(Transacao t)
      {
        transacoes.add(t);
      }
      
}
