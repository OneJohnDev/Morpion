/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morpion;

import java.util.Scanner;

/**
 *
 * @author stagiaire
 */
public class Morpion {
    

    /**
     * @param args the command line arguments
     */
    
    public static void AfficherTerrain(String[][] tab){
        /* Permet d'afficher le terrain de jeu */
        System.out.println("Le plateau");
        for(int i=0;i<tab.length;i++){
            System.out.print("[");
            for(int j = 0; j<tab.length;j++){
                if(j==tab.length-1){
                    System.out.print(tab[i][j]);
                }
                else{
                  System.out.print(tab[i][j]+"|");
                }
          
            }
            System.out.println("]");
        }
    }
    
    
    public static void TourJoueurO(String[][] tab, int i){
        /* Permet au Joueur O de jouer */
        String    coordonneeX= "";
        String    separateur = "";
        String    coordonneeY= "";
        do{
            System.out.println("Au tour de joueur O !");
            System.out.println("Veuillez Saisir les coordonées où vous voulez jouer. Format lignes;colonne");
            Scanner sc = new Scanner(System.in); /* Obliger de faire un scanner sc ici ? et pas dans le global main */
            String coordonnees = sc.next();

            coordonneeX= coordonnees.substring(0,1);
            separateur = coordonnees.substring(1,2);
            coordonneeY= coordonnees.substring(2,3);

            if(tab[Integer.parseInt(coordonneeX)-1][Integer.parseInt(coordonneeY)-1]=="_"){
                continue;
            }
            else{
                System.out.println("Déjà un pion sur cette case.");
            }
        }while(tab[Integer.parseInt(coordonneeX)-1][Integer.parseInt(coordonneeY)-1] != "_");
        
        tab[Integer.parseInt(coordonneeX)-1][Integer.parseInt(coordonneeY)-1]="O";
        i++;
        ControleVictoire(tab, i);
    }  
    
    public static void TourJoueurX(String[][] tab, int i){
        /* Permet au Joueur X de jouer */
        String    coordonneeX= "";
        String    separateur = "";
        String    coordonneeY= "";
        do{
            System.out.println("Au tour de joueur X !");
            System.out.println("Veuillez Saisir les coordonées où vous voulez jouer. Format x;y");
            Scanner sc = new Scanner(System.in); /* Obliger de faire un scanner sc ici ? et pas dans le global main */
            String coordonnees = sc.next();

            coordonneeX= coordonnees.substring(0,1);
            separateur = coordonnees.substring(1,2);
            coordonneeY= coordonnees.substring(2,3);

            if(tab[Integer.parseInt(coordonneeX)-1][Integer.parseInt(coordonneeY)-1]=="_"){
                continue;
            }
            else{
                System.out.println("Déjà un pion sur cette case.");
            }
        }while(tab[Integer.parseInt(coordonneeX)-1][Integer.parseInt(coordonneeY)-1] != "_");
        
        tab[Integer.parseInt(coordonneeX)-1][Integer.parseInt(coordonneeY)-1]="X";
        i++;
        ControleVictoire(tab, i);
    }
    
    public static void ControleVictoire(String[][] tab, int i){
        /*Permet de savoir l'etat du jeu(=à qui de jouer ? égalité ?) et agir en conséquence.*/
        AfficherTerrain(tab);
        
        // conditions de victoires
        
        if((tab[0][0]== tab[0][1] && tab[0][2]== tab[0][0])&& tab[0][0] != "_"){
            System.out.println("Victoire du joueur "+ tab[0][0]);
            System.exit(0);
        
        }
        
        if((tab[1][0]== tab[1][1] && tab[1][2]== tab[1][0]) && tab[1][0] != "_"){
            System.out.println("Victoire du joueur "+ tab[1][0]);
            System.exit(0);
        }
        
        if((tab[2][0]== tab[2][1] && tab[2][2]== tab[2][0]) && tab[2][0] != "_"){
            System.out.println("Victoire du joueur "+ tab[2][0]);
            System.exit(0);
        }
        
        if((tab[0][0]== tab[1][1] && tab[2][2]== tab[0][0]) && tab[0][0] != "_") {
            System.out.println("Victoire du joueur "+ tab[0][0]);
            System.exit(0);
        }
        
        if((tab[0][0]== tab[1][0] && tab[2][0]== tab[0][0]) && tab[0][0] != "_"){
            System.out.println("Victoire du joueur "+ tab[0][0]);
            System.exit(0);
        }
        
        if((tab[1][0]== tab[1][1] && tab[1][2]== tab[1][0]) && tab[1][0] != "_"){
            System.out.println("Victoire du joueur "+ tab[1][0]);
            System.exit(0);
        }
        
        if((tab[2][0]== tab[2][1] && tab[2][2]== tab[2][0]) && tab[2][0]!= "_"){
            System.out.println("Victoire du joueur "+ tab[2][0]);
            System.exit(0);
        }
        
        if((tab[0][1]== tab[1][1] && tab[2][1]== tab[0][1]) && tab[0][1] != "_"){
            System.out.println("Victoire du joueur "+ tab[0][1]);
            System.exit(0);
        }
        
        if((tab[0][2]== tab[1][2] && tab[2][2]== tab[0][2]) && tab[0][2] != "_"){
            System.out.println("Victoire du joueur "+ tab[0][2]);
            System.exit(0);
        }
        
        if(i==9){
            System.out.println("Egalité !!!");
            System.exit(0);
        }
        
        if(i%2==0){
            TourJoueurO(tab,i);
        }
        else{
            TourJoueurX(tab,i);
        }
        
        
    }
    
    public static void Initialisation(){
        /* Initialise le terrrain de jeu */
        int tailleCarre=3;
        int compteurTour=0;
        String[][] tab = new String[tailleCarre][tailleCarre];
        for(int i=0;i<tab.length;i++){
            for(int j=0; j<tab.length;j++){
                tab[i][j]="_";
            }
        }
        ControleVictoire(tab,compteurTour);
        
    }
    
    
    public static void main(String[] args) {
        
           
        Initialisation();
               
        
        
    }
    
}
