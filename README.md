
# Tondeuse – MowItNOw

La société MowItNow a décidé de développer une tondeuse à gazon automatique, 
destinée aux surfaces rectangulaires. La tondeuse peut être programmée pour parcourir l'intégralité de la surface. La position de la tondeuse est représentée par une combinaison de coordonnées (x,y) 
et d'une lettre indiquant l'orientation selon la notation cardinale anglaise (N,E,W,S). 



# Installation

Afin de pouvoir utiliser l’application, il faut d’abord cloner le repository .
```bash
  git clone https://github.com/luigcapo/tondeuse-mowitnow.git
```
Ensuite ouvrir le terminal et se positionner sur le répertoire du projet tondeuse-MowItNow.
```bash
  cd tondeuse-mowitnow/
```
Pour lancer l'ensemble des tests utilisés :

```bash
  mvn test
```

Pour lancer l'application de manière autonome avec un fichier de test, executer dans le terminal:

```bash
  mvn -q exec:java -Dexec.args="/home/Documents/kata"
```


## Demo

Pour un fichier  
5 5 
1 2 N 
GAGAGAGAA 
3 3 E 
AADAADADDAAA

On aura comme resultat 
1 3 N
5 1 E

## Notes
Le projet a été réalisé en utilisant la version 21 de java. 
Une exception de type IllegalArgumentException est levée lorsqu’on tente de positionner la tondeuse sur une position hors de la pelouse




## Authors

- [@luigcapo](https://www.github.com/luigcapo)

