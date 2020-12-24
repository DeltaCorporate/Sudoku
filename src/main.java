public class main {
    public static void main(String[] args) {
        Grille.afficheGrille(Tableaux.niv1);
        if(Grille.quatreVerifEnUn(Grille.cloneGrille(Tableaux.niv1),utils.infosValeur())){
            System.out.println("oui tu peux");
        } else {
            System.out.println("non tu peux pas");
        }
    }
}
