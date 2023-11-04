import java.util.Random;

public class bubblesort {
    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};

        for (int tamanho : tamanhos) {
            long inicio, fim;
            Random random = new Random(69);
            int[] randomArray = new int[tamanho];

            for (int i = 0; i < tamanho; i++) {
                randomArray[i] = random.nextInt(10000) + 1;
            }

            System.out.println("Testando array de tamanho: " + tamanho);


            inicio = System.currentTimeMillis();
            int trocaContador = bubbleSort(randomArray, tamanho);
            fim = System.currentTimeMillis();

            System.out.println("tempo levado para ordenar: " + (fim - inicio) + " milisegundos");
            System.out.println("Numero de trocas: " + trocaContador);


            int[] randomArray2 = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                randomArray2[i] = random.nextInt(10000) + 1;
            }
            int iteracaoContador = bubbleSortIteracao(randomArray2, tamanho);;

            System.out.println("Numero de iteracoes: " + iteracaoContador + "\n");
        }

    }


    static int bubbleSort(int[] vetor, int tamanho) {
        int temp;
        int trocaContador = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 1; j < tamanho - i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    temp = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = temp;
                    trocaContador++;
                }                
            }
        }
        return trocaContador;
    }

    static int bubbleSortIteracao(int[] vetor, int tamanho) {
        int temp;
        int iteracaoContador = 0;
        for (int i = 0; i < tamanho; i++) {
            for (int j = 1; j < tamanho - i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    temp = vetor[j - 1];
                    vetor[j - 1] = vetor[j];
                    vetor[j] = temp;
                }        
                iteracaoContador++;        
            }
        }
        return iteracaoContador;
    }
}
