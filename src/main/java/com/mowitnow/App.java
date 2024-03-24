package com.mowitnow;

import com.mowitnow.command.AvancerCommand;
import com.mowitnow.command.Command;
import com.mowitnow.command.PivoterDroiteCommand;
import com.mowitnow.command.PivoterGaucheCommand;
import com.mowitnow.model.Pelouse;
import com.mowitnow.model.Orientation;
import com.mowitnow.model.Tondeuse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *  Author : CAPO-CHICHI Luigi
 * Classe principal de lancement de la tondeuse automatique
 *
 *
 */
public class App 
{
    public static void main( String[] args ) {
        if (args.length != 1) {
            System.out.println("Veuillez fournir le chemin d'un seul fichier en argument.");
            return;
        }
        String cheminFichier = args[0];
        traiterFichier(cheminFichier);
    }

    static void traiterFichier(String cheminFichier){
        if (!Files.exists(Paths.get(cheminFichier))) {
            System.out.println("Le fichier spécifié n'existe pas: " + cheminFichier);
            return;
        }
        try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne = lecteur.readLine();
            ligne = ligne.replace(" ","");
            Pelouse pelouse = new Pelouse(Character.getNumericValue(ligne.charAt(0)),
                    Character.getNumericValue(ligne.charAt(1)));
            List<String> tondeuseActionLignes = new ArrayList<>();
            while ((ligne = lecteur.readLine()) != null) {
                tondeuseActionLignes.add(ligne.replace(" ",""));
                if(tondeuseActionLignes.size()==2){
                    traitementTondeuse(tondeuseActionLignes, pelouse);
                    tondeuseActionLignes.clear();
                }

            }
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de la lecture du fichier: " + e.getMessage());
        }

    }

    private static void traitementTondeuse(List<String> tondeuseActionLignes, Pelouse pelouse){
        Tondeuse tondeuse = new Tondeuse(pelouse);
        String tondeuseCreationLigne = tondeuseActionLignes.get(0);
        String tondeuseActionLigne = tondeuseActionLignes.get(1);
        List<Command> commands = new ArrayList<>();

        tondeuse.setPelouse(pelouse);
        tondeuse.setX(Character.getNumericValue(tondeuseCreationLigne.charAt(0)));
        tondeuse.setY(Character.getNumericValue(tondeuseCreationLigne.charAt(1)));
        tondeuse.setOrientation(
                Orientation.findOrientationFromId(
                        String.valueOf(
                                tondeuseCreationLigne.charAt(2)).toUpperCase()));

        for (char command : tondeuseActionLigne.toCharArray()) {
            switch (command) {
                case 'A':
                    new AvancerCommand(tondeuse).execute();
                    break;
                case 'G':
                    new PivoterGaucheCommand(tondeuse).execute();
                    break;
                case 'D':
                    new PivoterDroiteCommand(tondeuse).execute();
                    break;
                default:
                    System.out.println("Commande inattendue reçue: " + command + ". Elle sera ignorée.");
                    break;
            }
        }
        System.out.println(tondeuse);
    }
}
