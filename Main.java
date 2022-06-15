import java.util.Scanner;

public class Main{ //MEINE MAIN METHODE WAR MAL SO SCHÖN :( 
    public static void main() {
        CharacterCreation Creation = new CharacterCreation(); //Hier passiert die Charaktererstellung, so wie auch das kämpfen.
        Scanner input = new Scanner(System.in); //Scanner
        
        
        String[] chars = {"Luke Skywalker", "Darth Vader", "Emperor Palpatine", "General Rahm Kota", "Leia Organa", "Han Solo", "Chewbacca", "Boba Fett", "Stormtrooper", "Rebel Soldier", "Kota Militia Soldier"};
        
        int p1;
        int p2;
        System.out.println("Willkommen zum Spiel! \nSpieler 1, wähle deinen Charakter!");
        for(int i=0; i<chars.length; i++) { //Listet alle Charaktere im String "chars"
            System.out.println((i+1) + ") " + chars[i]);
        }
        while(true) { //Wiederholt sich, bis eine richtige Zahl eingegeben wurde.
            p1 = input.nextInt();
            if((p1-1)<0 ) { //p1 muss -1 sein da der user nicht weiß, dass arrays mit 0 anfangen
            System.out.println("Error; Zahl zu klein!");
            }
            else {
            System.out.println("Spieler 1 spielt jetzt als: " + chars[(p1-1)]);
            break;
            }
        }
        System.out.println("Spieler 2, wähle deinen Charakter!");
        while(true) { //Wiederholt sich, bis eine richtige Zahl eingegeben wurde.
            p2 = input.nextInt();
            if((p2-1)<0) {
            System.out.println("Error; Zahl zu klein!");
            }
            else {
            System.out.println("Spieler 2 spielt jetzt als: " + chars[(p2-1)]);
            break;
            }
        }
        
        Creation.setPlayers(p1, p2); //Alter ich bringe mich noch um wenn es mir noch einmal sagt die sind undeclared
    }
}