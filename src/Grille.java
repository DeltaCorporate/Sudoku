
public class Grille {
    /*
     * Permet d'afficher la grille
     * */
    public static void afficheGrille(int[][] array) {
        for (int ligne = 0; ligne < array.length; ligne++) {
            System.out.println("+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
            System.out.print("|");
            for (int colonne = 0; colonne < array[ligne].length; colonne++) {
                System.out.print("\t" + array[ligne][colonne] + "\t|");
            }
            System.out.println();
            if (ligne == 9) {
                System.out.println("+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
            }


        }
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");

    }

    /*
     * Permet de creer la grille
     * */
    public static int[][] cloneGrille(int[][] tab) {
        int[][] grille = new int[9][9];
        for (int ligne = 0; ligne < tab.length; ligne++) {
            for (int colonne = 0; colonne < tab[ligne].length; colonne++) {
                grille[ligne][colonne] = tab[ligne][colonne];
            }
        }
        return grille;
    }

    /*
     *
     * verifie si valeur pas présente en ligne
     *
     * */
    public static boolean ligneOK(int[][] grille, int[] valeurAinserer) {
        boolean present = true;
        if(valeurAinserer[0] !=0){
            for (int colonne = 0; colonne < grille[0].length && present; colonne++) {
                if (grille[valeurAinserer[1]][colonne] == valeurAinserer[0]) {
                    present = false;

                }
            }
        }
        return present;
    }

    /*
     *
     * verifie si valeur pas présente en ligne
     *
     *
     * */
    public static boolean colonneOK(int[][] grille, int[] valAInserer) {
        boolean present = true;
        if(valAInserer[0] != 0){
            for (int ligne = 0; ligne < grille.length && present; ligne++) {
                if (grille[ligne][valAInserer[2]] == valAInserer[0]) {
                    present = false;
                }
            }
        }
        return present;
    }


    /*
     *
     * verifie si case remplissable depuis le tableau d'origine, cela me permet de remettre zero dans les case déjà rempli par le joueur et qu'il veut supprimer
     *
     * */
    public static boolean caseOK(int[][] grille, int[] ValAInserer) {
        boolean valide = true;

        if (grille[ValAInserer[1]][ValAInserer[2]] != 0) {
            valide = false;
        }
        return valide;
    }

    public static boolean blocOK(int[][] grille, int[] valAInserer) {
        boolean valid = true;
        if(valAInserer[0] !=0){
            int minX,maxX,minY,maxY;
            minX = 0;
            maxX = 0;
            minY = 0;
            maxY = 0;
            int blocX = valAInserer[1] %3;
            int blocY = valAInserer[2] %3;
            if(blocX == 0){
                minX = valAInserer[1];
                maxX = valAInserer[1]+2;
            } else if(blocX == 1){
                minX = valAInserer[1]-1;
                maxX = valAInserer[1]+1;
            } else if(blocX == 2){
                minX = valAInserer[1]-2;
                maxX = valAInserer[1];
            }
            if(blocY == 0){
                minY = valAInserer[2];
                maxY = valAInserer[2]+2;
            } else if(blocY == 1){
                minY = valAInserer[2]-1;
                maxY = valAInserer[2]+1;
            } else if(blocY == 2){
                minY = valAInserer[2]-2;
                maxY = valAInserer[2];
            }

            for (int ligne = minX;ligne<=maxX; ligne++){
                for(int colonne = minY; colonne<=maxY;colonne++){
                    if(grille[ligne][colonne] == valAInserer[0]){
                        valid = false;
                    }
                }
            }
        }

       return valid;
    }



    /*
     * Je fais toute les verifs en une
     * */

    public static boolean quatreVerifEnUn(int[][] grille, int[] valAinserer,int[][] grilleOrigine) {
        boolean insertionValide = true;
        if (!caseOK(grilleOrigine, valAinserer) || !ligneOK(grille, valAinserer) || !colonneOK(grille, valAinserer) || !blocOK(grille, valAinserer)) {
            insertionValide = false;
            System.out.println("Cette valeur est invalide à cet endroit!");
        }
        return insertionValide;
    }


}
