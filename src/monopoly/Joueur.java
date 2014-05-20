package monopoly;

import java.util.*;
import java.lang.Math;
        
public class Joueur {

	private Monopoly monopoly;
	private Collection<Compagnie> compagnies;
	private Collection<Gare> gares;
	private Carreau positionCourante;
	private Collection<ProprieteAConstruire> proprietesAConstruire;
	private String nomJoueur;
	private int cash = 1500;
	private CouleurPropriete couleur;

	/**
	 * 
	 * @param nomJoueur
	 * @param couleur
	 * @param mono
	 */
	public Joueur(String nomJoueur, CouleurPropriete couleur, Monopoly mono) {
		this.monopoly = mono;
                this.nomJoueur = nomJoueur;
                this.couleur = couleur;
                this.positionCourante = this.monopoly.getCarreau(0);
	}

	/**
	 * 
	 * @param c
	 */
	public void setpositionCourante(Carreau c) {
            this.positionCourante = c;
	}

	public void avancer() {
            int nouvelleposition = this.getPositionCourante().getNumero() + lancerDé();
            this.setpositionCourante(this.monopoly.getCarreau(nouvelleposition));
	}

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public Carreau getPositionCourante() {
                return this.positionCourante;
        }

    public int lancerDé(){
    return (int)(Math.random() * 5)+1 ;
    }
}