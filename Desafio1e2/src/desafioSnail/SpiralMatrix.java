package desafioSnail;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result; // Retorna uma lista vazia para matriz vazia
        }

        int top = 0; // Limite superior
        int bottom = matrix.length - 1; // Limite inferior
        int left = 0; // Limite esquerdo
        int right = matrix[0].length - 1; // Limite direito

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) { // Da esquerda para a direita
                result.add(matrix[top][i]);
            }
            top++; // Mover limite superior para baixo

            for (int i = top; i <= bottom; i++) { // De cima para baixo
                result.add(matrix[i][right]);
            }
            right--; // Mover limite direito para a esquerda

            if (top <= bottom) {
                for (int i = right; i >= left; i--) { // Da direita para a esquerda
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Mover limite inferior para cima
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) { // De baixo para cima
                    result.add(matrix[i][left]);
                }
                left++; // Mover limite esquerdo para a direita
            }
        }

        return result;
    }

    // Método para validar o tamanho da matriz
    private static int validateMatrixSize(Scanner scanner) {
        int n;
        while (true) {
            System.out.println("Digite o tamanho N da matriz NxN:");
            if (scanner.hasNextInt()) {
                n = scanner.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Tamanho inválido! O tamanho da matriz deve ser maior que 0.");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scanner.next(); // Consumir entrada inválida
            }
        }
        return n;
    }

    // Método para ler a matriz personalizada do usuário
    private static int[][] readCustomMatrix(Scanner scanner, int n) {
        int[][] customMatrix = new int[n][n];
        System.out.println("Digite os elementos da matriz linha por linha:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (true) {
                    if (scanner.hasNextInt()) {
                        customMatrix[i][j] = scanner.nextInt();
                        break;
                    } else {
                        System.out.println("Entrada inválida! Digite um número inteiro.");
                        scanner.next(); // Consumir entrada inválida
                    }
                }
            }
        }
        return customMatrix;
    }

    // Método para exibir o menu e processar as opções do usuário
    private static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo ao programa de percurso de matriz em espiral!");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Testar matriz 3x3 (exemplo 1)");
            System.out.println("2. Testar matriz 3x3 (exemplo 2)");
            System.out.println("3. Inserir uma matriz NxN personalizada");
            System.out.println("4. Sair");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (option) {
                case 1:
                    int[][] matrix1 = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                    };
                    System.out.println(spiralOrder(matrix1)); // Saída esperada: [1, 2, 3, 6, 9, 8, 7, 4, 5]
                    break;
                case 2:
                    int[][] matrix2 = {
                            {1, 2, 3},
                            {4, 10, 12},
                            {6, 7, 33}
                    };
                    System.out.println(spiralOrder(matrix2)); // Saída esperada: [1, 2, 3, 12, 33, 7, 6, 4, 10]
                    break;
                case 3:
                    int n = validateMatrixSize(scanner);
                    int[][] customMatrix = readCustomMatrix(scanner, n);
                    System.out.println("Resultado do percurso em espiral: " + spiralOrder(customMatrix));
                    break;
                case 4:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        displayMenu();
    }
}
