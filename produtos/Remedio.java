public class Remedio extends Produto {

    static {
        getMapDePrecos().put("NEOSALDINA", 22.90);
        getMapDePrecos().put("ENGOV", 19.75);
        getMapDePrecos().put("DORIL", 39.90);
        getMapDePrecos().put("DIPIRONA", 12.10);
        getMapDePrecos().put("RIVOTRIL", 14.70);
        getMapDePrecos().put("NEOSORO", 6.70);
        getMapDePrecos().put("HISTAMIN", 8.70);
        getMapDePrecos().put("LOSARTANA ", 32.70);
    }
        public Remedio(String nome) {
            super(nome);
    }

}
