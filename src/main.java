public class main {
    public static void main(String[] args) {
        /*Grille.afficheGrille(Tableaux.niv1);
        if(Grille.quatreVerifEnUn(Grille.cloneGrille(Tableaux.niv1),utils.infosValeur())){
            System.out.println("oui tu peux");
        } else {
            System.out.println("non tu peux pas");
        }*/
        int[][] niv = utils.menu();
        int[][] grille = Grille.cloneGrille(niv);
        Grille.afficheGrille(grille);
        int caseAremplir = utils.nbrDeCaseAremplir(grille);
        while(caseAremplir !=0){
            int[] response;
            response = utils.infosValeur();
            boolean entreeValide;
            entreeValide = Grille.quatreVerifEnUn(grille, response);
            while(!entreeValide){
                Grille.afficheGrille(grille);
                response = utils.infosValeur();
                entreeValide = Grille.quatreVerifEnUn(grille, response);
            }
            utils.caseAremplir(grille,response);
            caseAremplir--;
            Grille.afficheGrille(grille);

        }


    }
}
