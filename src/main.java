public class main {
    public static void main(String[] args) {
        int[][] niv = utils.menu();
        int[][] grille = Grille.cloneGrille(niv);
        int caseAremplir = utils.nbrDeCaseAremplir(grille);
        if(caseAremplir != 81){
            Grille.afficheGrille(grille);
            while(caseAremplir !=0){
                int[] response;
                response = utils.infosValeur();
                boolean entreeValide;
                entreeValide = Grille.quatreVerifEnUn(grille, response,niv);
                while(!entreeValide){
                    Grille.afficheGrille(grille);
                    response = utils.infosValeur();
                    entreeValide = Grille.quatreVerifEnUn(grille, response,niv);
                }
                utils.caseAremplir(grille,response);
                if(response[0] != 0){
                    caseAremplir--;
                }
                Grille.afficheGrille(grille);

            }
            System.out.println("Bravo vous avez fini la grille");
        } else {
            return;
        }


    }
}
