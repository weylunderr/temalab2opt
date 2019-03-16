import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;

public class Main {
    // program simplu de cerere  a unei parole cunoscute passwordus, care la un numar de 3 incercari se va opri
    // la cererea corecta va intra intr-un joc Numguess

    // jocul Numguess
    // presupun ca e un joc care ghiceste numarul la care te gandesti


    // functie de clear screen care nu se gaseste in java
    // dupa putina documentatie am observat ca nu e prea posibila importarea functiei cls in intellij
    // asa ca se face un fake clear screen by pushing the text up;

    public static void clearScreen (){
        for (int i = 30; i > 0 ; i-- ){System.out.println();}
    }            // asta

    // functie care citeste din fisierul logo linie cu linie logo-ul
    // initial era o functie mai complicata care schimba foarte mult culorile din logo
    // aparent treaba asta ia foarte mult timp
    // asa ca ramane la demo
    public static void readText( File mmkay) throws FileNotFoundException, InterruptedException {
        Scanner scan = new Scanner(mmkay);
        // markers for LE PICTURE MODE
        int row=0;
        int col=0;


        while(scan.hasNextLine()){
            row++;
            col=0;
            String line = scan.nextLine();
            //Here you can manipulate the string the way you want
            Thread.sleep(150);
            // System.out.println("\033[93m"+line);
            String linus[] = line.split("");
            for (int down=0; down < linus.length; down ++){    // down counter for each in
                //if (!s.equals("")){
                col++;
/*                int count=0;
                int count1=0;
                if (down ==linus.length-1){
                    count1=1;
                }
                int count2=0;
                if (((!linus[down].equals(" ")))){
                    count =1;
                }*/
                if ((row<10 && col <33)||((col>22  && col <32)&& (row<14 && row >9) ) ){

/*                        if (((count==1))&&((count1==0))) {
                            System.out.print("\033[103m" );
                        }*/
                    System.out.print("\033[91m"+linus[down]);
                }
                else{
                    System.out.print("\033[34m"+linus[down]);
                }
                //}


            }
            System.out.println();
        }

    }

    /// functia de mai sus refacuta in asa  fel incat sa prelucreze 11 fisiere text



    //asta
    // ca sa nu scriu de prea multe ori Thread.sleep l-am bagat in functie
    public static void wiet(int i) throws InterruptedException{
        Thread.sleep(i);
    }


    // voia sa afiseze "logo-ul" companiei, dar caracter cu caracter
    // acum cu orice string
    public static void flytext(String myString)throws InterruptedException{

        for (char c : myString.toCharArray()) {
            System.out.print(c);
            Thread.sleep(250);
        }
        //clearScreen();
        System.out.println();

    }                            //asta

    // transforma orice text in culori pentru consola folosind ansi
    // mie cel putin imi merge
    //trebuia sa fac altfel, asta e doar string merge ayyyyyy
    // pls no comment
    public static void Colorinho(String linus,String colorus){
/*        String linu[] = linus.split("");
        for (int down=0; down < linu.length; down ++){
            System.out.print(colorus + linu[down]);
        }*/

    // mai sus am facut o prostioara si m-am speriat cum ca n-ar lua deloc culorile pentru string
    // asa ca le-am fortat caracter cu caracter, ca sa vad apoi ca merg corect
        // level of smart
            System.out.println( colorus+ linus);
        }

        //intro dialog pentru joc
    public static void introscr()throws InterruptedException{
        Colorinho(" GameNumGuess Corp (r) (tm)","\033[34m\033[100m");
        wiet(125);
        Colorinho("        Welcome to NumGuess","\033[94m");
        wiet(125);
        Colorinho("                  by GameNumGuess Corp (r) (tm)","\033[95m");
        wiet(125);
        Colorinho("The game where we will guess... ","\033[94m");
        wiet(125);
        Colorinho("           A number!!!!","\033[94m");
        wiet(125);
        Colorinho("                You think of!!!","\033[94m");
        wiet(125);
        Colorinho("            Now please think of a number....","\033[94m");
        wiet(125);
        Colorinho ("            ... Between 1 and 10000!!!!   ","\033[94m");
        wiet(125);
        Colorinho( "           ....Take your time.... ","\033[94m");
        wiet(125);
        wiet(4000);
    }                                        //asta

    // verifica daca insertul este corect de la tastatura

    // wat nu merge lmfao
    // presupun ca din cauza ca i-am tot dat sccanner
    // normal ca nu merge

    /*  public static boolean insertinho(String yesus,String noes, Scanner scannner){
        while (true){
            if (noes.equals(scannner.nextLine()) ) {
                return false;
            }else {
                if (yesus.equals(scannner.nextLine())) {
                    return true;
                } else {
                    System.out.println("Try again: ");
                    scannner = new Scanner(System.in);
                }
            }
        }
    }
    */

//jocul in sine
    public static void NumGuess() throws InterruptedException{

        int numberinho;


        int i=5000;
        int pars=5000;
        while ((i<=10000) && (i>=0)){

        flytext("Is your number "+i+" ?");
        Colorinho("Please answer yes or no (yes/no)", "\033[94m ");
        Scanner ultrascan = new Scanner(System.in);
        String confirm = ultrascan.nextLine();
        // APARENT scannerele NU POT FI CHEMATE DECAT O DATA, ALTFEL SE CREEAZA O INSTANTA PENTRU FIECARE SCANNER IN PARTE
            // KEK LMAO
            // DACA cineva pune cate un scanner in fiecare IF e GG


        if (confirm.equals("yes")){
            Colorinho("Congratulations your number is "+i+" !!!!!","\033[92m");
            flytext("Congratulations your number is "+i+" !!!!!");
            Colorinho("Congratulations your number is "+i+" !!!!!","\033[92m");
            break;
        }
        else
            if (confirm.equals("no")) {
                Colorinho("Is your number higher than" + i + " ?", "\033[94m");
                Colorinho("Please answer yes or no (y/n)", "\033[94m");
                confirm = ultrascan.nextLine();
                if (confirm.equals("yes")) {
                    if (i >= pars){
                        pars=pars -pars/2;
                    i = i+pars;
                  }
                } else {
                    if (confirm.equals("no")) {
                        i = i - pars/2;
                        pars = pars/2;
                    }
                    else{
                        System.out.println("Please be sure you entered just yes or just no. Try again.");
                    }
                }
            }
        }

        }



    // verificarea parolei
    // acum si cu CHEATCODE


    public static boolean passwordinha(String password0) throws InterruptedException, FileNotFoundException {

        System.out.println(" NumGuess ");
        // initalizam cererea parolei



        String password1 = "";
        int in = 3;
        // in va fi numarul de incercari
        boolean okus = false;

        while (!password1.equals(password0)) {
            // atata timp cat parolele sunt diferite vom cere parola


            System.out.println("\n" + "Please enter password");
            Scanner scannus = new Scanner(System.in);
            password1 = scannus.next();
            // din cauza ca am folosit nextLine vs next am avut problema ca toate parolele aveau "\n" la sfarsit
            // omg lol
            // sau nu
            // lololol
            // aparent am pierdut aproximativ o ora pana sa aflu ca

            // EQUALS() TREBUIE FOLOSITA NEAPARAT  PENTRU STRINGS

            // == MERGE DOAR LA INTEGERURI, ALTFEL VERIFICA ADRESA WTF!!!


            // initalizam parola 1
            // aceasta va fi verificata de conditia din while si nu va mai fi nevoie de inca o incercare
            // de asemenea daca parola este corecta vom printa un mesaj pe ecran
            if (password1.equals("CHEATCODE")){
                flytext("---ADRIAN RUSCAU---");
                flytext("-----PRESENTS------");
                flytext("OMG LUL U CHEAT");
                readText(new File("out/production/temalab2opt/logo.txt"));
                System.out.println("You WON!");
                okus=false;
                break;

            }
            if (password1.equals(password0)) {
                System.out.println("\n Your password is correct. ");
                okus=true;
                break;
            } else {
                // daca nu este corecta vom printa mesaje de eroare
                if (in != 0) {
                    System.out.println("\n TRY AGAIN");
                    System.out.println(" \n \n You have " + in + " more guesses.");
                    in = in - 1;
                    // de fiecare data can parola este gresita vom afisa numarul de incercari disponibil
                } else {
                    // cand numarul de incercari nu mai este disponibil programul va iesi automat
                    System.out.println(" \n You forgot your own password. Nice! ");
                    break;
                }
            }


        }
    return okus;
    }


    // mica functie continue

    public static boolean continuu()throws InterruptedException{
        System.out.println("Do you wish to start again? (yes/no)");
        Scanner scan = new Scanner(System.in);
        String ofcor= scan.nextLine();
        boolean okus= true;
        if (ofcor.equals("yes")){
            System.out.println("Here we go.... ");
        }else
        if (ofcor.equals("no")){
            flytext("Thank you for your time. ");
           okus = false;
        }
        return okus;
    }


    // main
    public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
        //System.out.println("Hello World!");
       // String myString = " GameNumGuess Corp (r) (tm) ";
        //flytext(myString);
        // parola initiala va fi passwordus


       boolean okie=true;
        while (okie) {
            String password01 = "passwordus";
            if (passwordinha(password01)) {
                flytext("---ADRIAN RUSCAU---");
                flytext("-----PRESENTS------");
                readText(new File("out/production/temalab2opt/logo.txt"));
                introscr();
                NumGuess();
                okie=continuu();

            } else {
                flytext("Game Over");
                flytext("Please restart the game");
                okie=continuu();
            }
        }


   }


}