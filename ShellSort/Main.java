import java.util.Random;
import java.util.Arrays;

public class Main {
    public static class Result {
        int[] randomArray;
        long iteracoes_shell;
        long trocas_shell;

        public Result(int[] randomArray, long iteracoes_shell, long trocas_shell) {
            this.randomArray = randomArray;
            this.iteracoes_shell = iteracoes_shell;
            this.trocas_shell = trocas_shell;
        }
    }

    public static Result shellSort(int[] randomArray) {
        int tamanhoArray = randomArray.length;
        long iteracoes_shell = 0;
        long trocas_shell = 0;
        boolean ordenado = false;

        int gap = tamanhoArray / 2;

        while (gap > 0 && !ordenado) {
            ordenado = true;

            for (int i = 0; i < tamanhoArray; i++) {
                iteracoes_shell += 1;
                if (i + gap < tamanhoArray && randomArray[i] > randomArray[i + gap]) {
                    int original = randomArray[i];
                    randomArray[i] = randomArray[i + gap];
                    randomArray[i + gap] = original;
                    ordenado = false;
                    trocas_shell += 1;
                }
            }

            if (gap > 1) {
                gap /= 2;
            }
        }

        return new Result(randomArray, iteracoes_shell, trocas_shell);
    }

    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};
        long seed = 69;
        long inicio, fim;

        for (int tamanho : tamanhos) {
            Random random = new Random(seed);
            int[] randomArray = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                randomArray[i] = random.nextInt(1000) + 1;
            }

            System.out.println("Tamanho do vetor: " + tamanho);

            inicio = System.currentTimeMillis();
            Result result = shellSort(randomArray);
            fim = System.currentTimeMillis();

            System.out.println("Tempo levado para ordenar: " + result.iteracoes_shell + " iterações");
            System.out.println("Numero De Trocas: " + result.trocas_shell);
            System.out.println("Tempo levado: " + (fim - inicio) + " ms");
            System.out.println();
        }
    }
}
