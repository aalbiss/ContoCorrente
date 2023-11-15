import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GestioneBanca {

    private ArrayList<ContoCorrente> banca;
    private int contiInseriti;
    private ArrayList<String> nCC;

    public GestioneBanca() {
        banca = new ArrayList<ContoCorrente>(5);
        contiInseriti = 0;
        nCC = new ArrayList<String>();
    }

    public double getSaldo() {
        Scanner KB = new Scanner(System.in);

        System.out.println("Inserire numero del conto corrente per vedere il saldo: ");
        String cc=KB.nextLine();

        for (ContoCorrente contoCorrente : banca) {
            if(cc.equalsIgnoreCase(contoCorrente.getNumCC())){
                return contoCorrente.getSaldo();
            }
        }
        return 0;
    }

    public String getCognome(){
        Scanner KB = new Scanner(System.in);

        System.out.println("Inserire numero del conto corrente per vedere il cognome del cliente: ");
        String cc=KB.nextLine();

        for (ContoCorrente contoCorrente : banca) {
            if(cc.equalsIgnoreCase(contoCorrente.getNumCC())){
                return contoCorrente.getCognome();
            }
        }
        return "Nessun cliente con questo conto corrente";
    }

    public String getNome(){
        Scanner KB = new Scanner(System.in);

        System.out.println("Inserire numero del conto corrente per vedere il nome del cliente: ");
        String cc=KB.nextLine();

        for (ContoCorrente contoCorrente : banca) {
            if(cc.equalsIgnoreCase(contoCorrente.getNumCC())){
                return contoCorrente.getNome();
            }
        }
        return "Nessun cliente con questo conto corrente";
    }

    public int getNumeroCC(){
        return contiInseriti;
    }

    public void addContoCorrente(){
        ContoCorrente conto  = new ContoCorrente();

        conto.inserimento();
        for (ContoCorrente contoCorrente : banca) {
            while(conto.getNome().equalsIgnoreCase(contoCorrente.getNome()) && conto.getCognome().equalsIgnoreCase(contoCorrente.getCognome())){
                System.out.println("Il cliente ha già un conto");
                contoCorrente.inserimento();
            }
        }

        do{
            conto.calcoloConto();
        }while(nCC.contains(conto.getNumCC()) );
        nCC.add(conto.getNumCC());

        System.out.println("Il numero del tuo conto corrente è " + conto.getNumCC());
        banca.add(conto);
    }

    public void versamento(){
        if(!banca.isEmpty()) {
            Scanner KB = new Scanner(System.in);
            boolean versati = false;
            String cc = "";
            System.out.print("Inserire numero del conto corrente dove si vuole versare: ");
            do {
                cc = KB.nextLine();
                if (!nCC.contains(cc))
                    System.out.print("Non esiste nessun conto con questo numero \nReinserire: ");
            } while (!nCC.contains(cc));

            for (ContoCorrente contoCorrente : banca) {
                if (cc.equalsIgnoreCase(contoCorrente.getNumCC())) {
                    contoCorrente.versamento();
                    versati = true;
                }
            }
            if (versati) {
                System.out.println("I soldi sono stati versati nel conto");
            }
        }
        else
            System.out.println("Nessun conto presente");
    }

    public void prelievo(){
        if(!banca.isEmpty()) {
            Scanner KB = new Scanner(System.in);
            boolean prelevati = false;
            String cc = "";
            double soldi;

            System.out.print("Inserire numero del conto corrente dove si vuole prelevare: ");
            do {
                cc = KB.nextLine();
                if (!nCC.contains(cc))
                    System.out.print("Non esiste nessun conto con questo numero \nReinserire: ");
            } while (!nCC.contains(cc));

            for (ContoCorrente contoCorrente : banca) {
                if ((cc.equalsIgnoreCase(contoCorrente.getNumCC()) && contoCorrente.getSaldo() < 0))
                    System.out.println("Non ci sono soldi in questo conto corrente");
            }

            for (ContoCorrente contoCorrente : banca) {
                if (cc.equalsIgnoreCase(contoCorrente.getNumCC()) && contoCorrente.getSaldo() > 0) {
                    System.out.print("Inserisci i soldi da prelevare: ");
                    do {
                        soldi = KB.nextDouble();
                        KB.nextLine();
                        if (soldi < 0 || soldi > contoCorrente.getSaldo()) {
                            System.out.print("I soldi che si vogliono prelevare sono maggiori ai soldi nel conto corrente \nReinserisci la somma: ");
                        }
                    } while (soldi < 0 || soldi > contoCorrente.getSaldo());
                    contoCorrente.prelievo(soldi);
                    if(soldi != 0)
                        prelevati = true;
                }
            }
            if (prelevati)
                System.out.println("I soldi sono stati prelevati");
            else
                System.out.println("Non è stato prelevato alcun soldo");
        }
        else
            System.out.println("Nessun conto presente");
    }

    public void visualizzaGenerale() {
        if(!banca.isEmpty())
            for (ContoCorrente contoCorrente : banca) {
                contoCorrente.visualizza();
                System.out.println();
            }
        else
            System.out.println("Nessun conto presente");
    }

    public void visualizzaSingolo(){
        Scanner KB = new Scanner(System.in);
        if(!banca.isEmpty()) {
            System.out.println("Inserire nome e cognome del cliente per vedere le informazioni del conto: ");
            String nome = KB.next();
            String cognome = KB.next();

            for (ContoCorrente contoCorrente : banca) {
                if (nome.equalsIgnoreCase(contoCorrente.getNome()) && cognome.equalsIgnoreCase(contoCorrente.getCognome())) {
                    contoCorrente.visualizza();
                }
            }
        }
        else
            System.out.println("Nessun conto presente");
    }

    public void eliminazione() {
        Scanner KB = new Scanner(System.in);
        if (!banca.isEmpty()) {
            int i = 0;
            int indexCC = 0;
            System.out.println("Inserire nome del cliente per eliminare il conto: ");
            String nome = KB.nextLine();
            System.out.println("Inserire cognome del cliente per eliminare il conto: ");
            String cognome = KB.next();

            for (ContoCorrente contoCorrente : banca) {
                if (nome.equalsIgnoreCase(contoCorrente.getNome()) && cognome.equalsIgnoreCase(contoCorrente.getCognome())) {
                    indexCC = i;
                    break;
                }
                i++;
            }

            banca.remove(indexCC);
            System.out.println("Cliente rimosso");

        } else
            System.out.println("Nessun conto presente");
    }

    public void trasferimento(){
        if(!banca.isEmpty()) {
            Scanner KB = new Scanner(System.in);
            double saldo1 = 0;
            double saldo2 = 0;
            boolean trasferiti = false;
            double somma = 0;
            String cc2 = "";
            System.out.println("Inserire numero del conto corrente da cui prelevare la somma di denaro: ");
            String cc1 = KB.nextLine();
            System.out.println("Inserire numero del conto corrente in cui versare la somma di denaro: ");
            do {
                cc2 = KB.nextLine();
                if (cc2.equalsIgnoreCase(cc1))
                    System.out.println("Inserire un conto corrente differente");
            } while (cc2.equalsIgnoreCase(cc1));

            for (ContoCorrente contoCorrente : banca) {
                if ((cc1.equalsIgnoreCase(contoCorrente.getNumCC()) && contoCorrente.getSaldo() < 0))
                    System.out.println("Non ci sono soldi in questo conto corrente");
            }

            for (ContoCorrente contoCorrente : banca) {
                if ((cc1.equalsIgnoreCase(contoCorrente.getNumCC()) && contoCorrente.getSaldo() > 0)) {
                    System.out.println("Inserire la somma di denaro da trasferire: ");
                    do {

                        somma = KB.nextDouble();
                        KB.nextLine();
                        if (somma < 0 || somma > contoCorrente.getSaldo()) {
                            System.out.print("I soldi che si vogliono trasferire sono maggiori ai soldi nel conto corrente \nReinserisci la somma: ");
                        }
                    } while (somma < 0 || somma > contoCorrente.getSaldo());
                }
            }

            int k = 0;

            for (ContoCorrente contoCorrente : banca) {
                if (cc1.equalsIgnoreCase(contoCorrente.getNumCC())) {
                    saldo1 = contoCorrente.getSaldo();
                } else if (cc2.equalsIgnoreCase(contoCorrente.getNumCC())) {
                    saldo2 = contoCorrente.getSaldo();
                }
                k++;
            }

            saldo1 -= somma;
            saldo2 += somma;

            for (ContoCorrente contoCorrente : banca) {
                if (cc1.equalsIgnoreCase(contoCorrente.getNumCC())) {
                    contoCorrente.setSaldo(saldo1);
                } else if (cc2.equalsIgnoreCase(contoCorrente.getNumCC())) {
                    contoCorrente.setSaldo(saldo2);
                }
                trasferiti = true;
            }

            if (trasferiti)
                System.out.println("Sono stati trasferiti " + somma + "€" + " dal conto " + cc1 + " al conto " + cc2);
            else
                System.out.println("Non è stato trasferito alcun soldo");
        }
        else
            System.out.println("Nessun conto presente");
    }

}
