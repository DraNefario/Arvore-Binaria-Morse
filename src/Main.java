public class Main {
    public static void main(String[] args) {
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();

        arvore.inserir(".-", 'A');
        arvore.inserir("-...", 'B');
        arvore.inserir("-.-.", 'C');
        arvore.inserir("-..", 'D');
        arvore.inserir(".", 'E');
        arvore.inserir("..-.", 'F');
        arvore.inserir("--.", 'G');
        arvore.inserir("....", 'H');
        arvore.inserir("..", 'I');
        arvore.inserir(".---", 'J');
        arvore.inserir("-.-", 'K');
        arvore.inserir(".-..", 'L');
        arvore.inserir("--", 'M');
        arvore.inserir("-.", 'N');
        arvore.inserir("---", 'O');
        arvore.inserir(".--.", 'P');
        arvore.inserir("--.-", 'Q');
        arvore.inserir(".-.", 'R');
        arvore.inserir("...", 'S');
        arvore.inserir("-", 'T');
        arvore.inserir("..-", 'U');
        arvore.inserir("...-", 'V');
        arvore.inserir(".--", 'W');
        arvore.inserir("-..-", 'X');
        arvore.inserir("-.--", 'Y');
        arvore.inserir("--..", 'Z');

        arvore.inserir("-----", '0');
        arvore.inserir(".----", '1');
        arvore.inserir("..---", '2');
        arvore.inserir("...--", '3');
        arvore.inserir("....-", '4');
        arvore.inserir(".....", '5');
        arvore.inserir("-....", '6');
        arvore.inserir("--...", '7');
        arvore.inserir("---..", '8');
        arvore.inserir("----.", '9');


        System.out.println("Estrutura da arvore:");
        arvore.exibirMorse();

        System.out.println("Estrutura da arvore:");
        arvore.exibirMorse();

        System.out.println("\nBusca individual:");
        System.out.println("----. = " + arvore.buscar("----."));  // 9
        System.out.println("----. = " + arvore.buscar("----."));  // 9
        System.out.println("--... = " + arvore.buscar("--..."));  // 7
        System.out.println("- = " + arvore.buscar("-"));  // T
        System.out.println("..- = " + arvore.buscar("..-"));  // U
        System.out.println(".-. = " + arvore.buscar(".-."));  // R
        System.out.println("-... = " + arvore.buscar("-..."));  // B
        System.out.println("--- = " + arvore.buscar("---"));  // O


        System.out.println("\nMensagem completa:");
        String mensagemMorse = ".--. --- .-. ... -.-. .... .";
        String[] codigo = mensagemMorse.split(" ");
        String resultado = "";

        for (int i = 0; i < codigo.length; i++) {
            resultado = resultado + arvore.buscar(codigo[i]);
        }
        System.out.println(mensagemMorse + " = " + resultado);

        System.out.println("\nnumero com 3 digitos:");
        String numeroMorse = "----. .---- .----";
        String[] numero = numeroMorse.split(" ");
        String numeroResultado = "";

        for (int i = 0; i < numero.length; i++) {
            numeroResultado = numeroResultado + arvore.buscar(numero[i]);
        }
        System.out.println(numeroMorse + " = " + numeroResultado);



        System.out.println("\nRemovendo 'S' (...):");
        arvore.remover("...");
        System.out.println("Buscar ... apos remocao: " + arvore.buscar("..."));
    }
}
