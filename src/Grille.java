
public class Grille {
    /*
     * Permet d'afficher la grille
     * */
    public static void afficheGrille(int[][] array){
        for(int ligne = 0; ligne < array.length; ligne++){
            System.out.println("+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
            System.out.print("|");
            for(int colonne = 0; colonne<array[ligne].length; colonne++){
                System.out.print("\t"+ array[ligne][colonne] + "\t|");
            }
            System.out.println();
            if(ligne == 9){
                System.out.println("+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");
            }



        }
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+---+");

    }
    /*
     * Permet de creer la grille
     * */
    public static int[][] cloneGrille(int[][] tab){
        int [][] grille = new int[9][9];
        for(int ligne = 0; ligne<tab.length; ligne++){
            for(int colonne = 0 ; colonne<tab[ligne].length; colonne++){
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
    public static boolean ligneOK(int[][] grille, int[] valeurAinserer){
        boolean present = true;
            for(int colonne =0; colonne<grille[0].length && present; colonne++){
                if(grille[valeurAinserer[1]][colonne] == valeurAinserer[0]){
                    present = false;
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
    public static boolean colonneOK(int[][] tab1 , int[] tab2){
        boolean present = true;
        for (int ligne = 0;ligne<tab1.length && present;ligne++){
                if(tab1[ligne][tab2[2]] == tab2[0]){
                    present = false;
            }
        }
        return present;
    }



    /*
    *
    * verifie si case remplissable
    *
    * */
    public static boolean caseOK(int[][] grille , int[] ValAInserer){
        boolean valide = true;

                if(grille[ValAInserer[1]][ValAInserer[2]] != 0){
                    valide = false;
                }
     return valide;
    }

    public static boolean quatreVerifEnUn(int[][] tab1 , int[] tab2){
        boolean insertionValide = true;
        if(!caseOK(tab1,tab2) || !ligneOK(tab1,tab2) || !colonneOK(tab1,tab2)){
            insertionValide =false;
        }
        return insertionValide;
    }


}
