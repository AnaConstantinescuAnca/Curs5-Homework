import java.util.Random;
import java.util.Arrays;


public class Exercises {
    public static void main(String[] args) {

        int[] sirNumereIntregi = {0, 200, 26788, 9000, 44, 333};
        int altnumarInterg = 55;
        int target = 10000;
        int nrMaxDonatii = 10;
        String fraza = "Exercitiul 6. Am scris o functie care primeste un string cu o fraza. Adica, mai multe propozitii despartite prin punct. Se printeaza fiecare propozitie pe o linie noua.";

        System.out.println("Ex.1: Suma numerelor intregi din sir este: " + sumNumereIntregi(sirNumereIntregi));
        System.out.println("Ex.2: Numarul de elemente impare din sir este: " + nrElementeImpare(sirNumereIntregi));

        System.out.println(("Ex.3: Rezolvarea mea; Numerele mai mari decat nr primit sunt: " + Arrays.toString(nrNumereMaiMari(sirNumereIntregi, altnumarInterg))));
        System.out.println("Ex.3: rezolvarea din clasa" + Arrays.toString(intNrMaiMari(sirNumereIntregi, altnumarInterg)));

        System.out.println("Ex4.: ");
        targetDonatii(target);
        System.out.println("Ex.5: ");
        targetCuMaximNumarDonatii(target, nrMaxDonatii);
        System.out.println("Ex.6: ");
        printarePeMaiMulteLinii(fraza);
    }


    //1.scrieti o functie care primeste un sir de numere intregi si returneaza suma lor
    public static int sumNumereIntregi(int[] sirNumereIntregi) {
        int sumNumere = 0;
        for (int numarIntreg : sirNumereIntregi) {
            //sumNumere = sumNumere + numarIntreg;
            sumNumere += numarIntreg;
        }
        return sumNumere;
    }

    //2) scrieti o functie care primeste un sir de numere intregi si returneaza numarul de elemente impare
    public static int nrElementeImpare(int[] sirNumereIntregi) {
        int countNumere = 0;
        for (int numar : sirNumereIntregi) {
            if (numar % 2 != 0) {
                countNumere++;
            }
        }
        return countNumere;
    }

    //3) scrieti o functie care primeste un sir de numere intregi si un alt numar intreg.
    // Returnati toate numerele mai mari decat numarul primit

    public static int[] intNrMaiMari(int[] sirNumereIntregi, int altNumarIntreg) {
        int[] rezultat = new int[sirNumereIntregi.length];

        int counter = 0;

        for (int n : sirNumereIntregi) {
            if (n > altNumarIntreg) {
                rezultat[counter++] = n;
            }
        }

        int[] rezultatActual = new int[counter];
        for (int i = 0; i < counter; i++) {
            rezultatActual[i] = rezultat[i];
        }
        return rezultatActual;
    }

    public static String[] nrNumereMaiMari(int[] sirNumereIntregi, int altnumarInterg) {
        String rezultat = "";

        int i = 0;
        while (i < sirNumereIntregi.length) {

            if (sirNumereIntregi[i] > altnumarInterg) {
                rezultat = rezultat.concat(String.valueOf(sirNumereIntregi[i])).concat(",");
            }
            i++;
        }
        return rezultat.split(",");
        //????!!de ce String-ul rezultat care stim ca este imutabil isi schimba valoarea prin
        // rezultat = rezultat.concat(String.valueOf(sirNumereIntregi[i])).concat(",");???!!!

        //if (rezultat.lastIndexOf(",", rezultat.length() - 1) == rezultat.length() - 1) {
        //    rezultat = rezultat.substring(0, rezultat.length() - 1);
        //}

        // String[] rezultatArray = rezultat.split(",");
        // return rezultatArray;

    }

    //4) scrieti o functie care primeste un numar intreg reprezentand targetul de donatii.
    // Donatiile se vor face cu ajutorul obiectului Random.
    // Primim donatii pana cand ajungem la suma dorita.
    // Cand ajungem la suma dorita afisam un mesaj de succes.
    public static void targetDonatii(int target) {
        Random random = new Random();
        int sumaDonata;//= 0;
        int sumaObtinuta = 0;

        do {
            sumaDonata = random.nextInt(target);
            System.out.println("Suma donata random este: " + sumaDonata);

            sumaObtinuta += sumaDonata;

            if (sumaObtinuta == target) {
                System.out.println("Donatia s-a incheiat cu succes. S-a atins targetul de donatii de: " + sumaObtinuta);
            } else if (sumaObtinuta > target) {
                System.out.println("Donatia s-a incheiat cu succes. S-a depasit targetul de: " + target + " cu: " + (sumaObtinuta - target));
            }
        } while (sumaObtinuta < target);
    }


    //5) rescrieti functia de la 4 cu urmatoarea modificare: functia va primi si un numar maxim de donatii.
    // Cand acesta se termina, campania se va incheia

    public static void targetCuMaximNumarDonatii(int target, int nrMaxDonatii) {
        Random random = new Random();
        int sumaDonata;  // = 0;
        int sumaObtinuta = 0;
        int numarDonatii = 0;

        do {
            sumaDonata = random.nextInt(target);
            sumaObtinuta += sumaDonata;
            numarDonatii++;
            // System.out.println("Suma donata: " + sumaDonata + " suma obtinuta " + sumaObtinuta);
            if (sumaObtinuta == target) {
                System.out.println("Targetul a fost atins! Campania de donatii continua!");
            } else if (sumaObtinuta > target) {
                System.out.println("Targetul a fost depasit cu: " + (sumaObtinuta - target) + "! Campania continua!");
            }
        } while (numarDonatii <= nrMaxDonatii);
        if (sumaObtinuta < target) {
            System.out.println("Campania s-a incheiat! Pentru a atinge targetul mai era nevoie de: " + (target - sumaObtinuta));
        } else {
            System.out.println("Campania s-a incheiat! Targetul a fost atins!");
        }

    }

    //6) scrieti o functie care primeste un string cu o fraza (mai multe propozitii despartite prin punct).
    // Printati fiecare propozitie pe o linie noua
    public static void printarePeMaiMulteLinii(String fraza) {
        String[] propozitii = fraza.split("[.]");
        for (int i = 0; i < propozitii.length; i++) {
            System.out.println(propozitii[i].trim().concat("."));
        }
    }


}


