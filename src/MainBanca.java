import java.util.Scanner;

public class MainBanca {
    public static void main(String[] args) {
        GestioneBanca banca = new GestioneBanca();
        Scanner KB = new Scanner(System.in);
        int selezione = 0;

        do{
            Utility.selezione();
            selezione = KB.nextInt();
            KB.nextLine();
            switch (selezione) {
            	case 1:
                    banca.addContoCorrente();
            		break;
                case 2:
                    banca.visualizzaGenerale();
                    break;
                case 3:
                    banca.visualizzaSingolo();
                    break;
                case 4:
                    banca.versamento();
                    break;
                case 5:
                    banca.prelievo();
                    break;
                case 6:
                    banca.trasferimento();
                    break;
                case 7:
                    banca.eliminazione();
                    break;
                case 9:
                    System.out.println("Fine programma");
                    break;
            	default:
                    System.out.println("Selezione non valida");
            		break;
            }

        }while(selezione!=9);



    }
}