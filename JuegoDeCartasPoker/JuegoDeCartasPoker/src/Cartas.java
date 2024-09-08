public class Cartas {
    private String valor; // El valor que tiene la carta (As, 2, 3, ..., K)
    private String simbolo; // Corazones, Espadas, Tréboles, Diamantes

    // Constructor para inicializar los atributos de la carta
    public Cartas(String valor, String simbolo) {
        this.valor = valor;
        this.simbolo = simbolo;
    }

    // Obtiene el valor de la carta (As, 2, 3, ..., K)
    public String getValor() {
        return valor;
    }

    // Obtiene el símbolo de la carta (Corazones, Espadas, etc.)
    public String getSimbolo() {
        return simbolo;
    }

    // Devuelve el valor numérico de la carta para evaluaciones en póker
    public int getValorNumerico() {
        switch (valor) {
            case "As": // El As puede ser 1 o 11 en algunos casos, aquí 11 por defecto
                return 14; // En póker, As se considera la carta más alta
            case "K":
                return 13;
            case "Q":
                return 12;
            case "J":
                return 11;
            default:
                return Integer.parseInt(valor); // Convertir cartas numéricas a int
        }
    }

    // Devuelve la representación en forma de texto de la carta
    @Override
    public String toString() {
        return valor + " de " + simbolo;
    }
}
