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
//correspond aux informations de la case à intégrer
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

//compte le nombre de case à remplir par case.

    public static int nbrDeCaseAremplir(int[][] grille){
        int caseAremplir=0;
        for(int ligne =0; ligne<grille.length; ligne++){
            for(int colonne = 0; colonne<grille[ligne].length;colonne++){
                if(grille[ligne][colonne] == 0){
                    caseAremplir++;
                }
            }
        }
        return caseAremplir;
    }
    public static void caseAremplir(int[][] grille, int[] valAInserer){
        for(int ligne =0; ligne<grille.length; ligne++){
            for(int colonne =0; colonne<grille[ligne].length; colonne++){
                grille[valAInserer[1]][valAInserer[2]] = valAInserer[0];
                if(ligne == valAInserer[1] && colonne == valAInserer[2]){
                    System.out.println("\n\n\n\nValeur inséré!");
                }
            }
        }
    }

//affiche le menu
    public static int[][] menu(){
//        tableau vide a retourner par défaut
        int [][] dafaultEmpty = new int[0][0];
        Scanner saisie = new Scanner(System.in);
        String valeur;
        String menu;
        menu="Vous venez de commencer une partie de Sudoku, merci de faire un choix parmi les suivants en tapant le chiffre associé:\n";
        menu+="1:\tGrille de niveau easy\n";
        menu+="2:\tGrille de niveau medium\n";
        menu+="3:\tGrille de niveau difficult\n";
        menu+="4:\tGrille de niveau expert\n";
        menu+="5:\tQuitter\n";

        System.out.println(menu);
        valeur = saisie.next();
        boolean estUnNombreValeur;
        boolean valeurNonValide;
        estUnNombreValeur = utils.estUnNombre(valeur);
        while(!estUnNombreValeur){
            System.out.println("Saisir un nombre compris entre 1 et 5:");
            valeur = saisie.next();
            estUnNombreValeur = utils.estUnNombre(valeur);
        }
        valeurNonValide = (utils.nombre(valeur)>5 || utils.nombre(valeur)<1);
        while(valeurNonValide){
            System.out.println("Saisir un nombre compris entre 1 et 5:");
            valeur = saisie.next();
            valeurNonValide = (utils.nombre(valeur)>5 || utils.nombre(valeur)<1);
        }
        switch (valeur){
            case "1":
                return Tableaux.niv1;
            case "2":
                return Tableaux.niv2;
            case "3":
                return Tableaux.niv3;
            case "4":
                return Tableaux.niv4;
            case "5":
                System.out.println("Vous avez quitté la partie");
                return dafaultEmpty;
        }
        return dafaultEmpty;
    }







}

