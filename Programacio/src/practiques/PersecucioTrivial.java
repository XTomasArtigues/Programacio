package practiques;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Xesac Tomás - TIC
 */
public class PersecucioTrivial {

    public static void main(String[] args) {

        String[] jugadors;
        boolean[][] categoriesGuanyades;
        int jugadorActual = 0; //Controlador del jugador que actualment està jugant
        boolean finalitzada = false;

        boolean guanyador = true; //Controlador del guanaydor

        int preguntaActualA = 0; //Controlador de preguntes A
        int preguntaActualB = 0; //Controlador de preguntes B
        int preguntaActualC = 0; //Controlador de preguntes C
        int preguntaActualD = 0; //Controlador de preguntes D
        int preguntaActualE = 0; //Controlador de preguntes E

        Scanner dades = new Scanner(System.in);

        System.out.println("********************************");
        System.out.println("********************************");
        System.out.println("*********TRIVAL PURSUIT*********");
        System.out.println("********************************");
        System.out.println("********************************");

        System.out.println("       COMENÇAM LA PARTIDA      ");

        System.out.println("\nQuants jugadors sou?");

        int nombreJugadors = dades.nextInt();

        jugadors = new String[nombreJugadors];

        categoriesGuanyades = new boolean[nombreJugadors][5]; //Inicialitzem array a fals

        dades.nextLine(); //Netejar buffer

        int i = 0;

        //Afegim els noms dels jugadors a l'array de noms
        while (i < jugadors.length) {

            System.out.println("\nNom del jugador " + (i + 1));

            jugadors[i] = dades.nextLine();

            i++;

        }

        //Avis de l'ordre dels jugadors en la partida
        System.out.println("\nEls jugadors jugaran en l'ordre en que s'han afegit.");

        Random dau = new Random();
        int valorDau;

        while (!finalitzada) {

            System.out.println("\nJugador " + jugadors[jugadorActual] + " vols tirar el dau? (SI o NO)");

            if (dades.next().equals("SI")) {

                valorDau = dau.nextInt(5) + 1; //Tiram dau

                switch (valorDau) {

                    case 1:

                        System.out.println("\nCategoria A");

                        String[] preguntesA = {"A", "B"};

                        String[][] respostesA = {
                            {"a", "b", "c", "d"},
                            {"a", "b", "c", "d"}
                        };

                        int[] respostesCorrectesA = {3, 0};

                        System.out.println(preguntesA[preguntaActualA]);

                        System.out.println("\nQuina és la resposta correcta?(Selecciona el número)");

                        //Mostrem respostes
                        for (int j = 1; j <= respostesA[preguntaActualA].length; j++) {

                            System.out.println("\n" + j + " - " + respostesA[preguntaActualA][j - 1]);

                        }
                        
                        int resposta = dades.nextInt();
                        //Comprovem que la resposta sigui la correcta
                        if (resposta == respostesCorrectesA[preguntaActualA]) { //Resposta correcta...
                            
                            System.out.println("Log: "+resposta+" - "+respostesCorrectesA[preguntaActualA]);
                            
                            categoriesGuanyades[jugadorActual][0] = true; //Afegim verdader a la categoria A

                            //Comprovem si ha guanyat la partida
                            for (int j = 0; j < categoriesGuanyades[jugadorActual].length && guanyador; j++) {

                                if (categoriesGuanyades[jugadorActual][i] == false) {
                                    guanyador = false;

                                    System.out.println("\nLa resposta és correcta. Continues jugant " + jugadors[jugadorActual]);
                                }

                            }

                            if (guanyador) { //És guanyador

                                System.out.println("\nEnhorabona " + jugadors[jugadorActual] + " ets el guanyador!!!!");

                                System.out.println("\n********************************");
                                System.out.println("********************************");
                                System.out.println("*********GAME OVER**************");
                                System.out.println("********************************");
                                System.out.println("********************************");

                                finalitzada = true;

                            }

                        } else { //Resposta incorrecta

                            jugadorActual++; //Passem el torn al següent jugador

                            if (jugadorActual == jugadors.length) {

                                jugadorActual = 0; //Tornem a començar la ronda de jugadors

                            }

                            System.out.println("\nLa resposta no és correcta. Et toca " + jugadors[jugadorActual]);
                        }

                        preguntaActualA++; //Passem a la següent pregunta

                        if (preguntaActualA == preguntesA.length) {

                            preguntaActualA = 0; //Tornem a iniciar les preguntes

                        }

                        break;

                    case 2:

                        System.out.println("\nCategoria B");

                        String[] preguntesB = {"C", "D"};

                        String[][] respostesB = {
                            {"a", "b", "c", "d"},
                            {"a", "b", "c", "d"}
                        };

                        int[] respostesCorrectesB = {3, 0};

                        System.out.println(preguntesB[preguntaActualB]);

                        System.out.println("\nQuina és la resposta correcta?(Selecciona el número)");

                        //Mostrem respostes
                        for (int j = 1; j <= respostesB[preguntaActualB].length; j++) {

                            System.out.println("\n" + j + " - " + respostesB[preguntaActualB][j - 1]);

                        }

                        //Comprovem que la resposta sigui la correcta
                        if (dades.nextInt() == respostesCorrectesB[preguntaActualB]) { //Resposta correcta...
                            categoriesGuanyades[jugadorActual][1] = true; //Afegim verdader a la categoria B

                            //Comprovem si ha guanyat la partida
                            for (int j = 0; j < categoriesGuanyades[jugadorActual].length && guanyador; j++) {

                                if (categoriesGuanyades[jugadorActual][i] == false) {
                                    guanyador = false;

                                    System.out.println("\nLa resposta és correcta. Continues jugant " + jugadors[jugadorActual]);
                                }

                            }

                            if (guanyador) { //És guanyador

                                System.out.println("\nEnhorabona " + jugadors[jugadorActual] + " ets el guanyador!!!!");

                                System.out.println("\n********************************");
                                System.out.println("********************************");
                                System.out.println("*********GAME OVER**************");
                                System.out.println("********************************");
                                System.out.println("********************************");

                                finalitzada = true;

                            }

                        } else { //Resposta incorrecta

                            jugadorActual++; //Passem el torn al següent jugador

                            if (jugadorActual == jugadors.length) {

                                jugadorActual = 0; //Tornem a començar la ronda de jugadors

                            }

                            System.out.println("\nLa resposta no és correcta. Et toca " + jugadors[jugadorActual]);
                        }

                        preguntaActualB++; //Passem a la següent pregunta

                        if (preguntaActualB == preguntesB.length) {

                            preguntaActualB = 0; //Tornem a iniciar les preguntes

                        }

                        break;

                    case 3:

                        System.out.println("\nCategoria C");

                        String[] preguntesC = {"E", "F"};

                        String[][] respostesC = {
                            {"a", "b", "c", "d"},
                            {"a", "b", "c", "d"}
                        };

                        int[] respostesCorrectesC = {3, 0};

                        System.out.println(preguntesC[preguntaActualC]);

                        System.out.println("\nQuina és la resposta correcta?(Selecciona el número)");

                        //Mostrem respostes
                        for (int j = 1; j <= respostesC[preguntaActualC].length; j++) {

                            System.out.println("\n" + j + " - " + respostesC[preguntaActualC][j - 1]);

                        }

                        //Comprovem que la resposta sigui la correcta
                        if (dades.nextInt() == respostesCorrectesC[preguntaActualC]) { //Resposta correcta...
                            categoriesGuanyades[jugadorActual][2] = true; //Afegim verdader a la categoria C

                            //Comprovem si ha guanyat la partida
                            for (int j = 0; j < categoriesGuanyades[jugadorActual].length && guanyador; j++) {

                                if (categoriesGuanyades[jugadorActual][i] == false) {
                                    guanyador = false;

                                    System.out.println("\nLa resposta és correcta. Continues jugant " + jugadors[jugadorActual]);
                                }

                            }

                            if (guanyador) { //És guanyador

                                System.out.println("\nEnhorabona " + jugadors[jugadorActual] + " ets el guanyador!!!!");

                                System.out.println("\n********************************");
                                System.out.println("********************************");
                                System.out.println("*********GAME OVER**************");
                                System.out.println("********************************");
                                System.out.println("********************************");

                                finalitzada = true;

                            }

                        } else { //Resposta incorrecta

                            jugadorActual++; //Passem el torn al següent jugador

                            if (jugadorActual == jugadors.length) {

                                jugadorActual = 0; //Tornem a començar la ronda de jugadors

                            }

                            System.out.println("\nLa resposta no és correcta. Et toca " + jugadors[jugadorActual]);
                        }

                        preguntaActualC++; //Passem a la següent pregunta

                        if (preguntaActualC == preguntesC.length) {

                            preguntaActualC = 0; //Tornem a iniciar les preguntes

                        }

                        break;

                    case 4:

                        System.out.println("\nCategoria D");

                        String[] preguntesD = {"G", "H"};

                        String[][] respostesD = {
                            {"a", "b", "c", "d"},
                            {"a", "b", "c", "d"}
                        };

                        int[] respostesCorrectesD = {3, 0};

                        System.out.println(preguntesD[preguntaActualD]);

                        System.out.println("\nQuina és la resposta correcta?(Selecciona el número)");

                        //Mostrem respostes
                        for (int j = 1; j <= respostesD[preguntaActualD].length; j++) {

                            System.out.println("\n" + j + " - " + respostesD[preguntaActualD][j - 1]);

                        }

                        //Comprovem que la resposta sigui la correcta
                        if (dades.nextInt() == respostesCorrectesD[preguntaActualD]) { //Resposta correcta...
                            categoriesGuanyades[jugadorActual][3] = true; //Afegim verdader a la categoria D

                            //Comprovem si ha guanyat la partida
                            for (int j = 0; j < categoriesGuanyades[jugadorActual].length && guanyador; j++) {

                                if (categoriesGuanyades[jugadorActual][i] == false) {
                                    guanyador = false;

                                    System.out.println("\nLa resposta és correcta. Continues jugant " + jugadors[jugadorActual]);
                                }

                            }

                            if (guanyador) { //És guanyador

                                System.out.println("\nEnhorabona " + jugadors[jugadorActual] + " ets el guanyador!!!!");

                                System.out.println("\n********************************");
                                System.out.println("********************************");
                                System.out.println("*********GAME OVER**************");
                                System.out.println("********************************");
                                System.out.println("********************************");

                                finalitzada = true;

                            }

                        } else { //Resposta incorrecta

                            jugadorActual++; //Passem el torn al següent jugador

                            if (jugadorActual == jugadors.length) {

                                jugadorActual = 0; //Tornem a començar la ronda de jugadors

                            }

                            System.out.println("\nLa resposta no és correcta. Et toca " + jugadors[jugadorActual]);
                        }

                        preguntaActualD++; //Passem a la següent pregunta

                        if (preguntaActualD == preguntesD.length) {

                            preguntaActualD = 0; //Tornem a iniciar les preguntes

                        }

                        break;

                    default: //valor = 5

                        System.out.println("\nCategoria E");

                        String[] preguntesE = {"I", "J"};

                        String[][] respostesE = {
                            {"a", "b", "c", "d"},
                            {"a", "b", "c", "d"}
                        };

                        int[] respostesCorrectesE = {3, 0};

                        System.out.println(preguntesE[preguntaActualE]);

                        System.out.println("\nQuina és la resposta correcta?(Selecciona el número)");

                        //Mostrem respostes
                        for (int j = 1; j <= respostesE[preguntaActualE].length; j++) {

                            System.out.println("\n" + j + " - " + respostesE[preguntaActualE][j - 1]);

                        }

                        //Comprovem que la resposta sigui la correcta
                        if (dades.nextInt() == respostesCorrectesE[preguntaActualE]) { //Resposta correcta...
                            categoriesGuanyades[jugadorActual][4] = true; //Afegim verdader a la categoria E

                            //Comprovem si ha guanyat la partida
                            for (int j = 0; j < categoriesGuanyades[jugadorActual].length && guanyador; j++) {

                                if (categoriesGuanyades[jugadorActual][i] == false) {
                                    guanyador = false;

                                    System.out.println("\nLa resposta és correcta. Continues jugant " + jugadors[jugadorActual]);
                                }

                            }

                            if (guanyador) { //És guanyador

                                System.out.println("\nEnhorabona " + jugadors[jugadorActual] + " ets el guanyador!!!!");

                                System.out.println("\n********************************");
                                System.out.println("********************************");
                                System.out.println("*********GAME OVER**************");
                                System.out.println("********************************");
                                System.out.println("********************************");

                                finalitzada = true;

                            }

                        } else { //Resposta incorrecta

                            jugadorActual++; //Passem el torn al següent jugador

                            if (jugadorActual == jugadors.length) {

                                jugadorActual = 0; //Tornem a començar la ronda de jugadors

                            }

                            System.out.println("\nLa resposta no és correcta. Et toca " + jugadors[jugadorActual]);

                        }

                        preguntaActualE++; //Passem a la següent pregunta

                        if (preguntaActualE == preguntesE.length) {

                            preguntaActualE = 0; //Tornem a iniciar les preguntes

                        }

                        break;

                }

            } else {

                System.out.println("\nNo voleu jugar més");

                System.out.println("\n********************************");
                System.out.println("********************************");
                System.out.println("*********FINS AVIAT!**************");
                System.out.println("********************************");
                System.out.println("********************************");

                finalitzada = true;

            }

        }

    }

}
