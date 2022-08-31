package Apresentacao;

/**
 * Classe de Construção visual TUI
 * TUI = Text User Interface
 * É uma visualização para linhas de comando utilizando Unicode
 */
public class Visual {
    private final String acimaEsq = "\u2554";
    private final String abaixoEsq = "\u255A";
    private final String meio = "\u2551";
    private final String caminho = "\u2550";
    private final String acimaDir = "\u2557";
    private final String abaixoDir = "\u255D";
    private final String continuacao = "\u2560";

    public Visual() {}

    /**
     * Quadro TUI de boas vindas ao simulador
     */
    public void quadroApresentacaoSimulador() {
        Colors colors = new Colors();
        System.out.println(colors.BLUE + "\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557" + colors.RESET);
        System.out.println(colors.BLUE + "\u2551            SIMULADOR DE FILAS           \u2551" + colors.RESET);
        System.out.println(colors.BLUE + "\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D" + colors.RESET);
    }

    /**
     * Quadro TUI de finalização da simulação
     */
    public void quadroFinalizacaoSimulacao() {
        Colors colors = new Colors();
        System.out.println(colors.PURPLE_BRIGHT + "\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557" + colors.RESET);
        System.out.println(colors.PURPLE_BRIGHT + "\u2551 SIMULA\u00C7\u00C3O CONCLUIDA!  \u2551" + colors.RESET);
        System.out.println(colors.PURPLE_BRIGHT + "\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255D" + colors.RESET);
    }

    /**
     * Unicode da ponta acima esquerda do quadro TUI
     * @return String
     */
    public String acimaEsquerda() { return acimaEsq; }

    /**
     * Unicode da ponta abaixo esquerda do quadro TUI
     * @return String
     */
    public String abaixoEsquerda() { return abaixoEsq; }

    /**
     * Unicode da parte do meio do quadro TUI
     * @return String
     */
    public String meio() { return meio; }

    /**
     * Unicode do caminho entre as pontas do quadro TUI
     * @return String
     */
    public String caminho() { return caminho; }
    
    /**
     * Unicode da parte acima a direita do quadro TUI
     * @return String
     */
    public String acimaDireita() { return acimaDir; }

    /**
     * Unicode da parte de baixo a direita do quadro TUI
     * @return String
     */
    public String abaixoDireita() { return abaixoDir; }

    /**
     * Unicode da continuação do parte abaixo do quadro TUI
     * @return String
     */
    public String continuacao() { return continuacao; }
}
