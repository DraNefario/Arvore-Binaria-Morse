public class No {
    private char simbolo;
    private No esquerdo;
    private No direito;

    public No(char simbolo) {
        this.simbolo = simbolo;
        this.esquerdo = null;
        this.direito = null;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public No getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(No esquerdo) {
        this.esquerdo = esquerdo;
    }

    public No getDireito() {
        return direito;
    }

    public void setDireito(No direito) {
        this.direito = direito;
    }
}
