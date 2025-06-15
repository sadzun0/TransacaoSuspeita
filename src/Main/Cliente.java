package Main;

/**
 *
 * @author Elijah
 */
public class Cliente{
    private String _nome;
    private Conta _conta;
    private String _cpf;
    
    
    //Métodos GET de Cliente
    public String getNomeCliente()
    {
      return this._nome;
    }
    
    public Conta getContaCliente()
    {
      return this._conta;
    }
    
    public String getCpfCliente()
    {
     return this._cpf;
    }
   
    //Métodos SET de Cliente
    public void setClienteNome(String nome)
    {
    this._nome = nome;
    }
    
    public void setContaCliente(Conta conta)
    {
    this._conta = conta;
    }
     
    public void setCpfCliente(String cpf)
    {
    this._cpf = cpf;
    }
    
}
