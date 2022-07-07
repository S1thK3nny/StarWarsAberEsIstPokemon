import java.util.Scanner;

public class Main{ //MEINE MAIN METHODE WAR MAL SO SCHÖN :( 
    public static void main() {
        System.out.print('\u000C');
        CharacterCreation Creation = new CharacterCreation(); //Hier passiert die Charaktererstellung, so wie auch das kämpfen.
        Scanner input = new Scanner(System.in); //Scanner
        
        String[] chars = {"Luke Skywalker", "Darth Vader", "Emperor Palpatine", "General Rahm Kota", "Leia Organa", "Han Solo", "Chewbacca", "Boba Fett", "Stormtrooper", "Rebel Soldier", "Kota Militia Soldier"};
        
        int p1;
        int p2;
        boolean allHumans = true;
        
        System.out.println("Willkommen zum Spiel! Möchtest du gegen eine AI spielen? (J / N)");
        
        while(true) {
            String humanOrAi = input.nextLine();
            if(humanOrAi.equalsIgnoreCase("J") || humanOrAi.equalsIgnoreCase("N")) {
                System.out.print('\u000C');
                if(humanOrAi.equalsIgnoreCase("J")) {
                    allHumans = false;
                }
                break;
            }
            else {
                System.out.println("Dies ging nicht! Versuch es nochmal!");
                continue;
            }
        }
        
        System.out.println("Spieler 1, wähle deinen Charakter!");
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
                try
                {
                    Thread.sleep(1000);
                }
                catch (InterruptedException ie)
                {
                    ie.printStackTrace();
                }
                break;
            }
        }
        System.out.print('\u000C');
        System.out.println("Wähle den Charakter für deinen Gegner!");
        for(int i=0; i<chars.length; i++) { //Listet alle Charaktere im String "chars"
            System.out.println((i+1) + ") " + chars[i]);
        }
        while(true) { //Wiederholt sich, bis eine richtige Zahl eingegeben wurde.
            p2 = input.nextInt();
            if((p2-1)<0) {
            System.out.println("Error; Zahl zu klein!");
            }
            else {
            System.out.println("Spieler 2 spielt jetzt als: " + chars[(p2-1)]);
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
            break;
            }
        }
        System.out.print('\u000C');
        Creation.setPlayers(p1, p2, allHumans); //Alter ich bringe mich noch um wenn es mir noch einmal sagt die sind undeclared
    }
}