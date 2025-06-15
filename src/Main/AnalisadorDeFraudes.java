package Main;
import java.util.*;
/**
 *
 * @author Elijah
 */
public class AnalisadorDeFraudes {
    
    //Verificação se as transações são suspeitas baseado em uma lista de transações, já que precisamos analisar as ultimas três transações e a transação atual
    public static boolean isSuspeitas(List<Transacao> transacoes){
    boolean suspeitaPorValor = false;
        boolean suspeitaPorTempo = false;

        //Verifica se alguma transação tem valor acima de R$10.000
        for (Transacao t : transacoes) {
            if (t.getValor() > 10000) {
                System.out.println("Transação " + t.getHorario() + " suspeita pois ultrapassa o valor de R$10000");
                suspeitaPorValor = true;
            }
        }

        //Verificação se há 3 ou mais transações em menos de 5 segundos
        for (int i = 0; i < transacoes.size(); i++) {
            int count = 1;
            long t1 = transacoes.get(i).getTempo();
             //Compara com as proximas transações da lista
            for (int j = i + 1; j < transacoes.size(); j++) {
                long t2 = transacoes.get(j).getTempo();
                //Operação para saber se está em menos de 5 segundos
                if (Math.abs(t2 - t1) <= 5000) {
                    count++;
                }
                //Count adicionando que a transação está fora da regra
                if (count >= 3) {
                    System.out.println("Transação " + transacoes.get(i).getHorario() + " suspeita por mais de três transações em menos de 5 segundos");
                    suspeitaPorTempo = true;
                    break;
                }
            }

            //Se já encontrou uma sequência suspeita, não precisa continuar verificando
            if (suspeitaPorTempo) break;
        }

        //Retorna true se qualquer uma das condições for verdadeira
        return suspeitaPorValor || suspeitaPorTempo;
    }
    
}
