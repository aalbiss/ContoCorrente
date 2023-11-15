import java.util.Scanner;

public class ContoCorrente {

    private String numCC;
    private double saldo;
    private String nome,cognome;

    public ContoCorrente() {
        numCC="";
        saldo = 0;
        nome = "";
        cognome = " ";
    }

    public ContoCorrente(String numCC, double saldo, String nome, String cognome) {
        this.numCC = numCC;
        this.saldo = saldo;
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNumCC() {
        return numCC;
    }

    public void setNumCC(String numCC) {
        this.numCC = numCC;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void inserimento(){
        Scanner KB = new Scanner(System.in);

        System.out.println("Inserisci il nome");
        String nome=KB.nextLine();
        setNome(nome);
        System.out.println("Inserisci il cognome");
        String cognome=KB.nextLine();
        setCognome(cognome);

//        calcoloConto();

    }

    public void versamento(){
        Scanner KB = new Scanner(System.in);
        int soldi;
        double totale = saldo;

        System.out.print("Inserisci i soldi da versare: ");

        do{
            soldi = KB.nextInt();
        }while(soldi<=0);
        KB.nextLine();
        totale+=soldi;

        setSaldo(totale);
    }

    public void prelievo(double soldi){
        Scanner KB = new Scanner(System.in);
        double totale = saldo;
        totale-=soldi;
        setSaldo(totale);
    }

    public void visualizza() {
        System.out.println("---------------------------------");
        System.out.println("  Nome: " + nome);
        System.out.println("  Cognome: " + cognome);
        System.out.println("  Numero conto corrente: " + numCC);
        System.out.println("  Saldo: " + saldo);
        System.out.println("---------------------------------");
    }

    public void calcoloConto(){
        final int MIN = 48;     //0
        final int MAX = 56;     //9 56
        String nCC = "";
        for (int i = 0; i < 12; i++) {
            nCC += String.valueOf((char) ((Math.random() * (MAX - MIN+1) + MIN)));
        }
        setNumCC(nCC);
    }

    @Override
    public String toString() {
        return "ContoCorrente{" +
                "numCC=" + numCC +
                ", saldo=" + saldo +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
