import java.util.Random;

public class quicksort {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};
        for (int tamanho : tamanhos) {
            long seed = 69;
            Random random = new Random(seed);
            int[] randomArray = new int[tamanho];

            for (int i = 0; i < tamanho; i++) {
                randomArray[i] = random.nextInt(10000) + 1;
            }

            long inicio = System.currentTimeMillis();
            int numIteracoes = quickSort(randomArray, 0, tamanho - 1);
            long fim = System.currentTimeMillis();

            System.out.println("Tempo levado para ordenar: " + (fim - inicio) + " milisegundos");
            System.out.println("Número de trocas e iterações realizadas: " + numIteracoes);
        }
    }    

    public static int quickSort(int[] vetor, int inicio, int fim) {
        if (fim > inicio) {
            int id = dividir(vetor, inicio, fim);
            int iteracoesEsquerda = quickSort(vetor, inicio, id - 1);
            int iteracoesDireita = quickSort(vetor, id + 1, fim);
            return 1 + iteracoesEsquerda + iteracoesDireita;
        }
        return 0;
    }

    public static int dividir(int[] vetor, int esquerda, int direita) {
        int id = vetor[esquerda + (direita - esquerda) / 2]; 
        int i = esquerda;
        int j = direita;
        int iteracoes = 0; 

        while (i <= j) {
            while (vetor[i] < id) {
                i++;
            }
            while (vetor[j] > id) {
                j--;
            }
            if (i <= j) {
                int temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
                i++;
                j--;
                iteracoes++;
            }
        }
        return i - 1;
    }
}