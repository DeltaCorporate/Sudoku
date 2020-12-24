import java.util.*;

public class utils {
    /*
    * Permet de lire un array simple
    * */
    public static void lireArraySimple(int[] array){
        for(int value : array){
            System.out.print(value + "\t");
        }
        System.out.println();
    }
    /*
     * Affichage du tableau
     * */



    /*
     * Permet de lire un array double
     * */
    public static void lireArrayDouble(int[][] array){
        for(int ligne = 0; ligne < array.length; ligne++){
            for(int colonne = 0; colonne<array[ligne].length; colonne++){
                System.out.print(array[ligne][colonne] + "\t");
            }
            System.out.println();
        }
    }


    /*
    *
    * verifie si l'entrée est un nombre
    *
    * */

    public static boolean estUnNombre(String entree){
        boolean valid;
        try {
            Integer resultat = Integer.valueOf(entree);
             valid =true;
        }catch (NumberFormatException e){
            valid = false;
        }
        return valid;
    }
    /*
     *
     * recupere un string et donne la valeur correspondante
     *
     * */
    public static int nombre(String entree){

            Integer result = Integer.valueOf(entree);

        return result;
    }


    /*

    * prendre les valeurs a entrer et les vérifier
    *
    * */

    public static int recupNombre(String element, int min, int max){
        Scanner saisie = new Scanner(System.in);
        String valeur;
        System.out.println("Quelle est la "+element + " :");
        valeur = saisie.next();
        boolean estUnNombreValeur;
        boolean valeurNonValide;
        estUnNombreValeur = utils.estUnNombre(valeur);
        while(!estUnNombreValeur){
            System.out.println("Saisir un nombre compris entre "+min+" et "+max+":");
            valeur = saisie.next();
            estUnNombreValeur = utils.estUnNombre(valeur);
        }
        valeurNonValide = (utils.nombre(valeur)>max || utils.nombre(valeur)<min);
        while(valeurNonValide){
            System.out.println("Saisir un nombre compris entre "+min+" et "+max+":");
            valeur = saisie.next();
            valeurNonValide = (utils.nombre(valeur)>max || utils.nombre(valeur)<min);
        }
        return utils.nombre(valeur);
    }

    public static int[] infosValeur(){
        int[] tabValeursInfos= new  int[3];
        int valeur = utils.recupNombre("valeur", 1, 9);
        tabValeursInfos[0] = valeur;
        int ligne = utils.recupNombre("ligne", 1, 9);
        tabValeursInfos[1] = ligne-1;
        int colonne = utils.recupNombre("colonne", 1, 9);
        tabValeursInfos[2] = colonne-1;
        return tabValeursInfos;
    }








}

