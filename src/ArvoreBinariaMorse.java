public class ArvoreBinariaMorse {

    private No raiz;

    public ArvoreBinariaMorse() {
        this.raiz = new No();
        carregarTabelaPadrao();
    }

    public void inserir(String caractere, String codigoMorse) {
        if (caractere == null) return;
        if (codigoMorse == null) return;

        String caractereMaiusculo = caractere.toUpperCase();
        No atual = raiz;

        int indice = 0;
        while (indice < codigoMorse.length()) {
            char simbolo = codigoMorse.charAt(indice);

            if (simbolo == '.') {
                if (atual.esquerdo == null) atual.esquerdo = new No();
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                if (atual.direito == null) atual.direito = new No();
                atual = atual.direito;
            } else {
                return;
            }
            indice = indice + 1;
        }

        atual.valor = caractereMaiusculo;
    }

    public String buscarPorMorse(String codigoMorse) {
        if (codigoMorse == null) return "";
        No atual = raiz;

        int indice = 0;
        while (indice < codigoMorse.length()) {
            char simbolo = codigoMorse.charAt(indice);

            if (simbolo == '.') {
                if (atual.esquerdo == null) return "";
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                if (atual.direito == null) return "";
                atual = atual.direito;
            } else {
                return "";
            }
            indice = indice + 1;
        }
        return atual.valor;
    }

    public String buscarPorCaractere(String caractere) {
        if (caractere == null) return "";
        String alvo = caractere.toUpperCase();
        return buscarPorCaractereProfundidade(raiz, "", alvo);
    }

    public void remover(String codigoMorse) {
        if (codigoMorse == null) return;
        No atual = raiz;

        int indice = 0;
        while (indice < codigoMorse.length()) {
            char simbolo = codigoMorse.charAt(indice);
            if (simbolo == '.') {
                if (atual.esquerdo == null) return;
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                if (atual.direito == null) return;
                atual = atual.direito;
            } else {
                return;
            }
            indice = indice + 1;
        }

        atual.valor = "";
    }

    public void exibir() {
        exibirRecursivo(raiz, 0, "");
    }

    public void exibirCaminho(String codigoMorse) {
        String caractere = buscarPorMorse(codigoMorse);
        System.out.println("Caminho \"" + codigoMorse + "\" → \"" + caractere + "\"");
    }

    public String traduzirMorseParaTexto(String linha) {
        if (linha == null) return "";
        String resultado = "";

        int i = 0;
        while (i < linha.length()) {
            while (i < linha.length() && linha.charAt(i) == ' ') i = i + 1;
            if (i >= linha.length()) break;

            String token = "";
            while (i < linha.length() && linha.charAt(i) != ' ') {
                token = token + linha.charAt(i);
                i = i + 1;
            }

            if (token.equals("/")) {
                if (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) != ' ')
                    resultado = resultado + " ";
            } else {
                String caractere = buscarPorMorse(token);
                if (caractere.equals("")) {
                    resultado = resultado + "?";
                } else {
                    resultado = resultado + caractere;
                }
            }
        }

        return resultado;
    }

    public String traduzirTextoParaMorse(String texto) {
        if (texto == null) return "";
        String resultado = "";

        int i = 0;
        while (i < texto.length()) {
            char c = texto.charAt(i);
            if (c == ' ') {
                if (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) != ' ')
                    resultado = resultado + " ";
                resultado = resultado + "/ ";
            } else {
                String caractere = String.valueOf(c).toUpperCase();
                String morse = buscarPorCaractere(caractere);
                if (morse.equals("")) {
                    if (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) != ' ')
                        resultado = resultado + " ";
                    resultado = resultado + "?";
                    if (i < texto.length() - 1) resultado = resultado + " ";
                } else {
                    if (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) != ' ')
                        resultado = resultado + " ";
                    resultado = resultado + morse;
                    if (i < texto.length() - 1) resultado = resultado + " ";
                }
            }
            i = i + 1;
        }

        while (resultado.length() > 0 && resultado.charAt(resultado.length() - 1) == ' ') {
            resultado = resultado.substring(0, resultado.length() - 1);
        }
        return resultado;
    }

    private void exibirRecursivo(No no, int nivel, String caminho) {
        if (no == null) return;

        String indentacao = "";
        int i = 0;
        while (i < nivel) {
            indentacao = indentacao + "  ";
            i = i + 1;
        }

        String valorMostrado = no.valor.equals("") ? "·" : no.valor;
        System.out.println(indentacao + "[" + caminho + "] " + valorMostrado);

        exibirRecursivo(no.esquerdo, nivel + 1, caminho + ".");
        exibirRecursivo(no.direito,  nivel + 1, caminho + "-");
    }

    private String buscarPorCaractereProfundidade(No no, String caminhoAtual, String alvo) {
        if (no == null) return "";
        if (!no.valor.equals("") && no.valor.equals(alvo)) return caminhoAtual;

        String resultadoEsquerda = buscarPorCaractereProfundidade(no.esquerdo, caminhoAtual + ".", alvo);
        if (!resultadoEsquerda.equals("")) return resultadoEsquerda;

        String resultadoDireita = buscarPorCaractereProfundidade(no.direito, caminhoAtual + "-", alvo);
        return resultadoDireita;
    }

    private void carregarTabelaPadrao() {
        String[][] tabela = new String[][]{
                {"A",".-"},{"B","-..."},{"C","-.-."},{"D","-.."},{"E","."},
                {"F","..-."},{"G","--."},{"H","...."},{"I",".."},{"J",".---"},
                {"K","-.-"},{"L",".-.."},{"M","--"},{"N","-."},{"O","---"},
                {"P",".--."},{"Q","--.-"},{"R",".-."},{"S","..."},{"T","-"},
                {"U","..-"},{"V","...-"},{"W",".--"},{"X","-..-"},{"Y","-.--"},
                {"Z","--.."},
                {"0","-----"},{"1",".----"},{"2","..---"},{"3","...--"},{"4","....-"},
                {"5","....."},{"6","-...."},{"7","--..."},{"8","---.."},{"9","----."}
        };

        int i = 0;
        while (i < tabela.length) {
            String caractere = tabela[i][0];
            String codigo = tabela[i][1];
            inserir(caractere, codigo);
            i = i + 1;
        }
    }
}
