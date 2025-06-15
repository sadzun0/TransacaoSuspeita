package Main;
import java.util.*;
import java.util.Scanner;
/**
 * @author Elijah
 */
public class Main {

    public static void main(String[] args) {
        
        //Set da Conta e do Cliente com nomes e informações ficticias
        Cliente clienteTest = new Cliente();
        clienteTest.setClienteNome("Roberto Bolanhos");
        clienteTest.setCpfCliente("15652012641");
        Conta contaTest = new Conta();
        contaTest.setNumeroConta(1479);
        contaTest.setDigitoConta(5);
        contaTest.setAgencia(999);
        contaTest.setSenhaConta(0306);
        clienteTest.setContaCliente(contaTest);
        
        //Criação da Lista de Transações que o usuário irá fazer agora
        List<Transacao> transacoesRecentes = new ArrayList<>();
                     
     //Inicialização da classe Scanner
     Scanner sc = new Scanner(System.in); 
     
      //Inicialização do sistema
     System.out.println("Bem Vindo ao Banco YMoney " + clienteTest.getNomeCliente());
     System.out.println("Qual ação deseja fazer? ");
     System.out.println("1. Consultar suas informações | 2. Ver histórico de transações | 3.Realizar uma transação | 4.Sair");
     
     int alternativa = sc.nextInt();
     
     //Sistema de escolha de alternativas
     while(alternativa != 4) {
         
         if(alternativa == 1) 
         {
          System.out.println("Nome: " + clienteTest.getNomeCliente());
          System.out.println("CPF: " + clienteTest.getCpfCliente());
          System.out.println("Conta: " + clienteTest.getContaCliente().getNumeroConta() + "-" + clienteTest.getContaCliente().getDigitoConta());
          System.out.println("Agência: " + clienteTest.getContaCliente().getAgencia());
          System.out.println("Senha: " + clienteTest.getContaCliente().getSenha());
          System.out.println("");
          System.out.println("Essas são suas informações bancárias, não divulgue para ninguem");
          System.out.println("");
          System.out.println("Digite qual ação você deseja fazer:");
          System.out.println("1. Consultar suas informações | 2. Ver histórico de transações | 3.Realizar uma transação | 4.Sair");
         }
         
         else if(alternativa == 2) 
         {
            //Inicialização da variável se há transações suspeitas
            boolean hasSuspeita = false;
            
            //Display das transações do cliente
            System.out.println("Essas são suas transações: ");
             for (int i = 0; i < clienteTest.getContaCliente().getTransacoes().size(); i++) 
             {
                Transacao t = clienteTest.getContaCliente().getTransacoes().get(i);
                System.out.println("Transação: " + (i+1) + " no valor R$" + t.getValor() + " em " + t.getHorario());
             }
             
             //Verificador de suspeitas na conta
             hasSuspeita = AnalisadorDeFraudes.isSuspeitas(clienteTest.getContaCliente().getTransacoes());
             if(hasSuspeita)
             {
               System.out.println("CUIDADO: Há transações suspeitas na sua conta!!");
             }
             
             //Finalização da opção e mostrando as opções do sistema
          System.out.println("");
          System.out.println("Digite qual ação você deseja fazer:");
          System.out.println("1. Consultar suas informações | 2. Ver histórico de transações | 3.Realizar uma transação | 4.Sair");
         
         }
         
         else if(alternativa == 3) 
         {
             //Inicialização do sistema de transação
            System.out.println("Qual valor da transação que você deseja fazer?");
            double valorParaTransacao = sc.nextDouble();
            
            //Colocando a atual transação em uma lista de transações recentes
            Transacao novaTransacao = new Transacao(valorParaTransacao);           
            transacoesRecentes.add(novaTransacao);
            
            //Verificação das transações recentes para saber se há algo errado na transação atual
            boolean suspeita = AnalisadorDeFraudes.isSuspeitas(transacoesRecentes);

                if (suspeita) {
                    //Clear para resetar a detecção de transações recentes.
                   transacoesRecentes.clear();
                   System.out.println("Esta transação foi considerada SUSPEITA. Deseja continuar?");
                   System.out.println("Digite 1 para CONFIRMAR ou 2 para CANCELAR:");
                   int decisao = sc.nextInt();
                       if (decisao == 1) {
                          clienteTest.getContaCliente().adicionarTransacao(novaTransacao);
                          System.out.println("Transação de R$" + valorParaTransacao + " realizada com sucesso.");
    } 
                       else {
        System.out.println("Transação cancelada pelo usuário.");
    }
}    
                else {
    // Se não é suspeita, adiciona direto
    clienteTest.getContaCliente().adicionarTransacao(novaTransacao);
    System.out.println("Você realizou uma transação de R$" + valorParaTransacao);
}

System.out.println();
System.out.println("Digite qual ação você deseja fazer:");
System.out.println("1. Consultar suas informações | 2. Ver histórico de transações | 3. Realizar uma transação | 4. Sair");
      
         }
            
                         
      alternativa = sc.nextInt();
        }
    }
    
}
