package monopoly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Monopoly {
    
	private ArrayList<Carte> cartes;
	private ArrayList<Joueur> joueurs;
	private HashMap<Integer, Carreau> carreaux;
	private int nbMaisons = 32;
	private int nbHotels = 12;
        
	public Monopoly(String dataFilename){
		buildGamePlateau(dataFilename);
	}
	
	private void buildGamePlateau(String dataFilename)
	{
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			
			//TODO: create cases instead of displaying
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("G") == 0){
					System.out.println("Garre :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Companie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
	
	private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}
        
        public void inscrireJoueurs(int NbJoueurs) {
            Scanner sc = new Scanner(System.in);
            Carreau c = getCarreau(0);
            Joueur j;
            for(int i = 0; i <= NbJoueurs; i++){
                System.out.println("Entrez le nom du joueur " + i );
                j = new Joueur(sc.nextLine(), CouleurPropriete.values()[i], this);
                this.addJoueurs(j);
            }
	}

	public void addJoueurs(Joueur jou) {
		this.joueurs.add(jou);
	}

	public Carreau getCarreau(int n) {
            return this.carreaux.get(n);
	}

	public void Jouer() {
            for(Joueur j : this.joueurs){
            j.avancer();
            }
            afficherPositions();
	}

	public void afficherPositions() {
            for(Joueur j : this.joueurs){
            System.out.println("Joueur : " + j.getNomJoueur() + " position : "+ j.getPositionCourante().getNumero());
            }
	}
}
