import java.util.ArrayList;

public class prova {

    public static void main(String[] args) {

        ArrayList<ContoCorrente> banca = new ArrayList<ContoCorrente>(10);
        ContoCorrente conto1  = new ContoCorrente();

        conto1.inserimento();
        conto1.calcoloConto();
        conto1.visualizza();
        banca.add(conto1);
//        System.out.println("Il numero del tuo conto corrente è " + conto1.getNumCC());
        ContoCorrente conto  = new ContoCorrente();
        conto.inserimento();
        conto.calcoloConto();

        for (ContoCorrente contoCorrente : banca) {
            if(conto.getNome().equalsIgnoreCase(contoCorrente.getNome()) && conto.getCognome().equalsIgnoreCase(contoCorrente.getCognome()) && conto.getNumCC().equalsIgnoreCase(contoCorrente.getNumCC())){
                do{
                    conto.inserimento();
                }while(conto.getNome().equalsIgnoreCase(contoCorrente.getNome()) && conto.getCognome().equalsIgnoreCase(contoCorrente.getCognome()) && conto.getNumCC().equalsIgnoreCase(contoCorrente.getNumCC()));
            }
            else if(conto.getNumCC().equalsIgnoreCase(contoCorrente.getNumCC())){
                conto.calcoloConto();
            }
        }
        System.out.println("Il numero del tuo conto corrente è " + conto.getNumCC());
        conto.visualizza();
        banca.add(conto);
//        conto.inserimento();

//
//        for (ContoCorrente contoCorrente : banca) {
//            if(conto.getNome().equalsIgnoreCase(contoCorrente.getNome()) && conto.getCognome().equalsIgnoreCase(contoCorrente.getCognome()) && conto.getNumCC().equalsIgnoreCase(contoCorrente.getNumCC())){
//                while( conto.getNome().equalsIgnoreCase(contoCorrente.getNome()) && conto.getCognome().equalsIgnoreCase(contoCorrente.getCognome()) && conto.getNumCC().equalsIgnoreCase(contoCorrente.getNumCC())){
//                    conto.inserimento();
//                    while(conto.getNumCC().equalsIgnoreCase(contoCorrente.getNumCC())){
//                        conto.calcoloConto();
//                    }
//                }
//            }
//            else if (conto.getNumCC().equalsIgnoreCase(contoCorrente.getNumCC())){
//                do{
//                    conto.calcoloConto();
//                }while(conto.getNumCC().equalsIgnoreCase(contoCorrente.getNumCC()));
//            }
//
//        }
//        System.out.println("Il numero del tuo conto corrente è " + conto.getNumCC());
//        banca.add(conto);
    }

}
