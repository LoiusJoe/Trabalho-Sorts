import java.util.Random;
import java.util.Arrays;

public class Main {
    public static class Result {
        int[] randomArray;
        int iteracoes_insert;
        int trocas_insert;

        public Result(int[] randomArray, int iteracoes_insert, int trocas_insert) {
            this.randomArray = randomArray;
            this.iteracoes_insert = iteracoes_insert;
            this.trocas_insert = trocas_insert;
        }
    }

    public static Result insertSort(int[] randomArray) {
        int tamanhoArray = randomArray.length;
        int iteracoes_insert = 0;
        int trocas_insert = 0;
        boolean ordenado = false;
      
        while (!ordenado){
          ordenado = true;
          for (int i = 0; i < tamanhoArray; i++) {
              iteracoes_insert += 1;
              if (i > 0 && randomArray[i - 1] > randomArray[i]) {
                  int original = randomArray[i];
                  randomArray[i] = randomArray[i - 1];
                  randomArray[i - 1] = original;
                  i -= 1;
                  ordenado = false;
                  trocas_insert += 1;
              }
          }
        }

        return new Result(randomArray, iteracoes_insert, trocas_insert);
    }

    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000};
        long seed = 69;
        long inicio, fim;

        for (int tamanho : tamanhos) {
            Random random = new Random(seed);
            int[] randomArray = new int[tamanho];
            for (int i = 0; i < tamanho; i++) {
                randomArray[i] = random.nextInt(100) + 1;
            }

            System.out.println("Tamanho do vetor: " + tamanho);

            inicio = System.currentTimeMillis();
            Result result = insertSort(randomArray);
            fim = System.currentTimeMillis();

            System.out.println("Numero De Iterações: " + result.iteracoes_insert);
            System.out.println("Numero De Trocas: " + result.trocas_insert);
            System.out.println("Tempo levado: " + (fim - inicio) + " ms");
            System.out.println();
        }
    }
}
