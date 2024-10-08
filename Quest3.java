import java.util.ArrayList;
import java.util.List;

public class Quest3 {
	    
	    public static void main(String[] args) {
	        // Vetor de faturamento diário, considerando que há dias sem faturamento (ex: finais de semana)
	        double[] faturamentoDiario = {0, 150, 0, 200, 300, 0, 0, 100, 250, 0, 350, 0, 400, 0, 0};
	        
	        // Filtra os dias com faturamento válido
	        List<Double> faturamentoValido = filtrarFaturamentoValido(faturamentoDiario);
	        
	        if (faturamentoValido.isEmpty()) {
	            System.out.println("Não há valores de faturamento válidos.");
	            return;
	        }

	        // Calcula o menor, maior e a média de faturamento
	        double menorFaturamento = calcularMenorFaturamento(faturamentoValido);
	        double maiorFaturamento = calcularMaiorFaturamento(faturamentoValido);
	        double mediaAnual = calcularMediaAnual(faturamentoValido);
	        
	        // Conta o número de dias com faturamento acima da média
	        int diasAcimaDaMedia = contarDiasAcimaDaMedia(faturamentoValido, mediaAnual);
	        
	        // Exibe os resultados
	        System.out.println("Menor valor de faturamento: " + menorFaturamento);
	        System.out.println("Maior valor de faturamento: " + maiorFaturamento);
	        System.out.println("Número de dias com faturamento acima da média: " + diasAcimaDaMedia);
	    }

	    // Método para filtrar os valores de faturamento válidos (não nulos)
	    private static List<Double> filtrarFaturamentoValido(double[] faturamentoDiario) {
	        List<Double> faturamentoValido = new ArrayList<>();
	        for (double valor : faturamentoDiario) {
	            if (valor > 0) {
	                faturamentoValido.add(valor);
	            }
	        }
	        return faturamentoValido;
	    }

	    // Método para calcular o menor valor de faturamento
	    private static double calcularMenorFaturamento(List<Double> faturamentoValido) {
	        return faturamentoValido.stream().min(Double::compare).orElse(0.0);
	    }

	    // Método para calcular o maior valor de faturamento
	    private static double calcularMaiorFaturamento(List<Double> faturamentoValido) {
	        return faturamentoValido.stream().max(Double::compare).orElse(0.0);
	    }

	    // Método para calcular a média anual de faturamento
	    private static double calcularMediaAnual(List<Double> faturamentoValido) {
	        double soma = faturamentoValido.stream().mapToDouble(Double::doubleValue).sum();
	        return soma / faturamentoValido.size();
	    }

	    // Método para contar o número de dias com faturamento acima da média
	    private static int contarDiasAcimaDaMedia(List<Double> faturamentoValido, double mediaAnual) {
	        return (int) faturamentoValido.stream().filter(valor -> valor > mediaAnual).count();
	    }
}
