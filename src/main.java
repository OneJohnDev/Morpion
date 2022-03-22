import java.util.Scanner;


public class main {
	

	/**
	 * @param args
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
	    
	    public static void Rejouer(){
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Voulez vous rejouer ? Oui ou Non");
	    	String reponse= sc.nextLine();
	    	if(reponse.equals("Oui")){
	    		Initialisation();
	    	}else{
	    		System.out.println("Merci à bientôt");
	    		System.exit(0);
	    	}
	    	
	    }
 
	    
	    public static void TourJoueur(String[][] tab, int i, String nom){
	        /* Permet au Joueur O de jouer */
	        String    coordonneeX= "";
	        String    separateur = "";
	        String    coordonneeY= "";
	        do{
	            System.out.println("Au tour de joueur "+nom+" !");
	            System.out.println("Veuillez Saisir les coordonnées où vous voulez jouer. Format lignes;colonne");
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
	        
	        tab[Integer.parseInt(coordonneeX)-1][Integer.parseInt(coordonneeY)-1]=nom;
	        i++;
	        ControleVictoire(tab, i);
	    }
	    
	   
	    
	    public static void AnnonceVictoire(String str){
	    	System.out.println("Victoire du joueur "+str);
	    }
	    
	    public static void ControleVictoire(String[][] tab, int i){
	        /*Permet de savoir l'etat du jeu(=Ã  qui de jouer ? Ã©galitÃ© ?) et agir en consÃ©quence.*/
	        AfficherTerrain(tab);
	        
	        // conditions de victoires
	        
	        if((tab[0][0]== tab[0][1] && tab[0][2]== tab[0][0])&& tab[0][0] != "_"){
	            AnnonceVictoire(tab[0][0]);
	            Rejouer();
	        
	        }
	        
	        if((tab[1][0]== tab[1][1] && tab[1][2]== tab[1][0]) && tab[1][0] != "_"){
	        	AnnonceVictoire(tab[1][0]);
	            Rejouer();
	        }
	        
	        if((tab[2][0]== tab[2][1] && tab[2][2]== tab[2][0]) && tab[2][0] != "_"){
	        	AnnonceVictoire(tab[2][0]);
	            Rejouer();
	        }
	        
	        if((tab[0][0]== tab[1][1] && tab[2][2]== tab[0][0]) && tab[0][0] != "_") {
	        	AnnonceVictoire(tab[0][0]);
	            Rejouer();
	        }
	        
	        if((tab[0][0]== tab[1][0] && tab[2][0]== tab[0][0]) && tab[0][0] != "_"){
	        	AnnonceVictoire(tab[0][0]);
	            Rejouer();
	        }
	        
	        if((tab[0][1]== tab[1][1] && tab[2][1]== tab[0][1]) && tab[1][0] != "_"){
	        	AnnonceVictoire(tab[1][0]);
	            Rejouer();
	        }
	        
	        if((tab[0][2]== tab[1][2] && tab[2][2]== tab[0][2]) && tab[2][0]!= "_"){
	        	AnnonceVictoire(tab[2][0]);
	            Rejouer();
	        }
	       
	        
	        if((tab[0][2]== tab[1][1] && tab[2][0]== tab[0][2]) && tab[0][2] != "_"){
	        	AnnonceVictoire(tab[0][2]);
	            Rejouer();
	        }
	        
	        if(i==9){
	            System.out.println("Egalité !!!");
	            Rejouer();
	        }
	        
	        if(i%2==0){
	            TourJoueur(tab,i,"O");
	        }
	        else{
	            TourJoueur(tab,i,"X");
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
		// TODO Auto-generated method stub
		int i = 0;
		while (true){
		Initialisation();
		i++;
		}

	}

}
