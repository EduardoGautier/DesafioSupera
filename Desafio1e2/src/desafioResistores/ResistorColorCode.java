package desafioResistores;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ResistorColorCode {

    private static final Map<Integer, String> colorMap = new HashMap<>();
    static {
        colorMap.put(0, "preto");
        colorMap.put(1, "marrom");
        colorMap.put(2, "vermelho");
        colorMap.put(3, "laranja");
        colorMap.put(4, "amarelo");
        colorMap.put(5, "verde");
        colorMap.put(6, "azul");
        colorMap.put(7, "violeta");
        colorMap.put(8, "cinza");
        colorMap.put(9, "branco");
    }

    public static String getResistorColorCode(String input) {
        try {
            double ohms = parseOhmsValue(input);
            return calculateColorCode(ohms);
        } catch (NumberFormatException e) {
            return "Entrada inválida, formato numérico incorreto.";
        } catch (IllegalArgumentException e) {
            return "Entrada inválida: " + e.getMessage();
        }
    }

    private static double parseOhmsValue(String input) {
        input = input.toLowerCase().replace(" ohms", "").trim();

        if (input.endsWith("k")) {
            return Double.parseDouble(input.replace("k", "")) * 1000;
        } else if (input.endsWith("m")) {
            return Double.parseDouble(input.replace("m", "")) * 1_000_000;
        } else {
            return Double.parseDouble(input);
        }
    }

    private static String calculateColorCode(double ohms) {
        int intValue = (int) ohms;

        if (intValue < 10 || intValue >= 1_000_000_000) {
            throw new IllegalArgumentException("Valor fora do intervalo permitido.");
        }

        String valueStr = String.valueOf(intValue);
        int firstDigit = Character.getNumericValue(valueStr.charAt(0));
        int secondDigit = Character.getNumericValue(valueStr.charAt(1));
        int multiplier = valueStr.length() - 2;

        String firstColor = colorMap.get(firstDigit);
        String secondColor = colorMap.get(secondDigit);
        String multiplierColor = colorMap.get(multiplier);

        return firstColor + " " + secondColor + " " + multiplierColor + " dourado";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo ao sistema de conversão de código de cores de resistores!");
            System.out.println("Digite o valor do resistor (ex: '47 ohms', '4.7k ohms', '1M ohms'):");
            System.out.println("Ou digite 'sair' para encerrar o programa.");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("sair")) {
                break;
            }

            String result = getResistorColorCode(input);
            System.out.println("Resultado: " + result);
            System.out.println();
        }

        System.out.println("Programa encerrado.");
        scanner.close();
    }
}
