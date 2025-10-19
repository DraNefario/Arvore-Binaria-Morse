import java.util.Scanner;

public class Main {

    public static void main(String[] argumentos) {
        ArvoreBinariaMorse arvoreBinariaMorse = new ArvoreBinariaMorse();
        Scanner leitor = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Escolha uma opção:");
            System.out.println("1) Traduzir (Morse → Texto ou Texto → Morse)");
            System.out.println("2) Exibir caminho de um código Morse");
            System.out.println("3) Remover um símbolo pelo código Morse");
            System.out.println("4) Exibir árvore (hierárquica)");
            System.out.println("5) Buscar código Morse de uma letra ou número");
            System.out.println("6) Converter palavra/frase (A–Z, 0–9) para Morse");
            System.out.println("0) Sair");
            System.out.print("Opção: ");

            String opcao = leitor.nextLine();

            if (opcao.equals("0")) {
                break;

            } else if (opcao.equals("1")) {
                System.out.println("Digite uma linha (Morse com '.' '-' separados por espaço OU texto A–Z/0–9):");
                String linha = leitor.nextLine();

                if (ehProvavelmenteMorse(linha)) {
                    String texto = arvoreBinariaMorse.traduzirMorseParaTexto(linha);
                    System.out.println("Resultado: " + texto);
                } else {
                    String morse = arvoreBinariaMorse.traduzirTextoParaMorse(linha);
                    System.out.println("Resultado: " + morse);
                }

            } else if (opcao.equals("2")) {
                System.out.print("Informe o código Morse (ex.: .-): ");
                String codigoMorse = leitor.nextLine();
                arvoreBinariaMorse.exibirCaminho(codigoMorse);

            } else if (opcao.equals("3")) {
                System.out.print("Informe o código Morse a remover (ex.: .-): ");
                String codigoMorse = leitor.nextLine();

                String antes = arvoreBinariaMorse.buscarPorMorse(codigoMorse);
                System.out.println("Antes da remoção: \"" + antes + "\"");

                arvoreBinariaMorse.remover(codigoMorse);

                String depois = arvoreBinariaMorse.buscarPorMorse(codigoMorse);
                System.out.println("Depois da remoção: \"" + depois + "\" (vazio significa removido)");

            } else if (opcao.equals("4")) {
                arvoreBinariaMorse.exibir();

            } else if (opcao.equals("5")) {
                System.out.print("Informe uma letra ou número (A–Z ou 0–9): ");
                String entrada = leitor.nextLine();
                String caractere = extrairPrimeiroCaractereNaoEspaco(entrada);
                if (caractere.equals("")) {
                    System.out.println("Entrada inválida.");
                } else {
                    String codigo = arvoreBinariaMorse.buscarPorCaractere(caractere.toUpperCase());
                    if (codigo.equals("")) {
                        System.out.println("Não encontrado para: " + caractere.toUpperCase());
                    } else {
                        System.out.println("Código Morse de '" + caractere.toUpperCase() + "': " + codigo);
                    }
                }

            } else if (opcao.equals("6")) {
                System.out.print("Digite a palavra ou frase (A–Z, 0–9): ");
                String texto = leitor.nextLine();
                String morse = arvoreBinariaMorse.traduzirTextoParaMorse(texto);
                System.out.println("Resultado: " + morse);

            } else {
                System.out.println("Opção inválida.");
            }
        }

        leitor.close();
    }

    private static boolean ehProvavelmenteMorse(String linha) {
        if (linha == null) return false;
        if (linha.length() == 0) return false;

        int indice = 0;
        while (indice < linha.length()) {
            char caractere = linha.charAt(indice);
            if (caractere != '.' && caractere != '-' && caractere != ' ' && caractere != '/') {
                return false;
            }
            indice = indice + 1;
        }
        return true;
    }

    private static String extrairPrimeiroCaractereNaoEspaco(String texto) {
        if (texto == null) return "";
        int indice = 0;
        while (indice < texto.length() && texto.charAt(indice) == ' ') indice = indice + 1;
        if (indice >= texto.length()) return "";
        return String.valueOf(texto.charAt(indice));
    }
}
