import java.util.Scanner;

public class CharacterCreation { //Our work is never over. ~Daft Punk
    public void setPlayers(int p1, int p2) {
        //Character Creation START
        Character player1 = new Character();
        Character player2 = new Character();
        
        Character LukeSkywalker = new Character();
        Character DarthVader = new Character();
        Character Palpatine = new Character();
        Character RahmKota = new Character();
        Character LeiaOrgana = new Character();
        Character HanSolo = new Character();
        Character Chewbacca = new Character();
        Character BobaFett = new Character();
        Character Stormtrooper = new Character();
        Character RebelSoldier = new Character();
        Character MilitiaSoldier = new Character();
        
        Character[] chararr = {LukeSkywalker, DarthVader, Palpatine, RahmKota, LeiaOrgana, HanSolo, Chewbacca, BobaFett, Stormtrooper, RebelSoldier, MilitiaSoldier};
        //Character Creation STOP
        
        
        
        //Character Setters START
        LukeSkywalker.setStats("Luke Skywalker", "TIER3", true); //Name, TIER, forcesensitive
        DarthVader.setStats("Darth Vader", "TIER3", true);
        Palpatine.setStats("Emperor Palpatine", "TIER3", true);
        RahmKota.setStats("General Rahm Kota", "TIER3", true);
        LeiaOrgana.setStats("Leia Organa", "TIER2", false);
        HanSolo.setStats("Han Solo", "TIER2", false);
        Chewbacca.setStats("Chewbacca", "TIER2", false);
        BobaFett.setStats("Boba Fett", "TIER2", false);
        Stormtrooper.setStats("Stormtrooper", "TIER1", false);
        RebelSoldier.setStats("Rebel Soldier", "TIER1", false);
        MilitiaSoldier.setStats("Kota Militia Soldier", "TIER1", false);
        
        LukeSkywalker.setAttacks("Lichtschwert Angriff", "Machtschub", "Abwehr", "Machtheilung");
        DarthVader.setAttacks("Lichtschwert Angriff", "Machtschub", "Machtwürgung", "Lichtschwert Wurf");
        Palpatine.setAttacks("Lichtschwert Angriff", "Machtblitz", "Machtwurf", "Dunkle Aura");
        RahmKota.setAttacks("Lichtschwert Angriff", "Militia Unterstützung", "Machtschub", "Machtschild");
        LeiaOrgana.setAttacks("Blaster Angriff", "Blaster Schnellfeuer", "Hoffnung", "Stimpacks");
        HanSolo.setAttacks("Blaster Angriff", "Genauigkeit", "Sprengsatz", "Scharfschützenschuss");
        Chewbacca.setAttacks("Armbrust Schuss", "Armbrust Multi-Schuss", "Wookie Wut", "Granate");
        BobaFett.setAttacks("Blaster Angriff", "Flammenwerfer", "Handgelenkrakete", "Detpack");
        Stormtrooper.setAttacks("Blaster Angriff", "Thermal Detonator", "Schlag", "Kick");
        RebelSoldier.setAttacks("Blaster Angriff", "Thermal Detonator", "Schlag", "Kick");        
        MilitiaSoldier.setAttacks("Blaster Angriff", "Thermal Detonator", "Schlag", "Kick");
        
        LukeSkywalker.setItems("Dies", "ist", "ein", "Test!");
        //Character Setters STOP
        
        
        
        //Character Zuweisung START
        player1 = chararr[(p1-1)]; //Weist Spieler 1 dem Character im array "arr" hinzu
        player1.printStats();
        
        player2 = chararr[(p2-1)];
        player2.printStats();
        //Character Zuweisung STOP
        
        
        int p1attack = 1; //MUSS AUSSERHALB DER WHILE SCHLEIFE SEIN!!! 
        int p2attack = 1;
        int p1iteminput;
        int p2iteminput;
        int menuinputp1;
        int menuinputp2;
        
        //Kampf an sich START
        fight: while(true) { //benutzt break fight; um die ganze Schleife jetzt zu beenden
            Scanner attackinput = new Scanner(System.in);
            if(player1.getAttackSpeed()>player2.getAttackSpeed()) { //Spieler 1 fängt an
                checkBurn(player2, player1, p2attack, p1attack);
                System.out.println("\nSpieler 1, wähle aus, was du machen möchtest: \n1) Angreifen \n2) Items benutzen \n3) Fliehen");
                menuinputp1 = attackinput.nextInt();
                switch(menuinputp1) {
                    case 1:
                    default: //Wenn der Spieler die Zahl 1 oder irgendwas außer 2 und 3 eingibt, sonst passiert nichts!
                        System.out.println("\nSpieler 1, wähle deine Attacke:");
                        for(int i = 0; i<player1.getAttacks().length; i++) { //Je nach Anzahl der Attacken, meist 4
                            System.out.println((i+1) + ") " + player1.getAttacks()[i]); //Printet z.b. 1) Melee
                        }
                        player1.setCurrentAttack(p1attack = attackinput.nextInt()); //Geht wieder rüber zu class "Character", setzt input Variable "p1attack" ein.
                        player1.Attacks(); //setzt die damage values
                    
                    
                        if(player2.getAttacks()[p2attack-1].contains("schild") || player2.getAttacks()[p2attack-1].equals("Abwehr")) { //MUSS VOR SETLIFE SEIN!!! Sonst klappt es nicht. WAG ES JA NICHT WIEDER DEN CODE HIER ZU ZWEIFELN; SONST KRIEGT DER SPIELER SCHADEN
                            player1.setFinalAttackDamage(0);   
                        }
                    
                    
                        player2.setLife(player2.getLife()-player1.getFinalAttackDamage()); //Fügt den Schaden hinzu
                        AttackOutput(player1, player2); //Printet ob man sich heilt oder ob man Schaden gemacht hat und wie viel
                    
                        if(player2.getLife()<0) { //Wenn Spieler 2 0 HP hat
                            System.out.println("\nGlückwunsch, Spieler 1, du hast gewonnen!");
                            break fight;
                        }
                        break;
                        
                    case 2:
                        System.out.println("\nSpieler 1, wähle dein Item aus:");
                        for(int i = 0; i<player1.getItems().length; i++) { //Je nach Anzahl der Items, meist 4
                            System.out.println((i+1) + ") " + player1.getItems()[i]); //Printet z.b. 1) Placeholder
                        }
                        player1.setCurrentItem(p1iteminput = attackinput.nextInt());
                        player1.ItemUse();
                        break;
                        
                    case 3:
                        System.out.println(player1.getName() + " ist geflohen! \nSpieler 2 gewinnt!");
                        break fight;
                    }

                
                
                checkBurn(player1, player2, p1attack, p2attack);
                System.out.println("\nSpieler 2, wähle aus, was du machen möchtest: \n1) Angreifen \n2) Items benutzen \n3) Fliehen");
                menuinputp2 = attackinput.nextInt();
                switch(menuinputp2) {
                    case 1:
                    default:
                        System.out.println("\nSpieler 2, wähle deine Attacke:");
                        for(int i = 0; i<player2.getAttacks().length; i++) {
                            System.out.println((i+1) + ") " + player2.getAttacks()[i]);
                        }
                        player2.setCurrentAttack(p2attack = attackinput.nextInt());
                        player2.Attacks();
                    
                    
                        if(player1.getAttacks()[p1attack-1].contains("schild") || player1.getAttacks()[p1attack-1].equals("Abwehr")) {
                            player2.setFinalAttackDamage(0);   
                        }
                    
                    
                        player1.setLife(player1.getLife()-player2.getFinalAttackDamage());
                        AttackOutput(player2, player1);
                    
                        if(player1.getLife()<0) {
                            System.out.println("\nGlückwunsch, Spieler 2, du hast gewonnen!");
                            break fight;
                        }
                        break;
                        
                    case 2:
                        System.out.println("\nSpieler 2, wähle dein Item aus:");
                        for(int i = 0; i<player2.getItems().length; i++) {
                            System.out.println((i+1) + ") " + player2.getItems()[i]);
                        }
                        player2.setCurrentItem(p2iteminput = attackinput.nextInt());
                        player2.ItemUse();
                        break;
                        
                    case 3:
                        System.out.println(player2.getName() + " ist geflohen! \nSpieler 1 gewinnt!");
                        break fight;
                    }
                }
                
                
            else {
                checkBurn(player1, player2, p1attack, p2attack);
                System.out.println("\nSpieler 2, wähle aus, was du machen möchtest: \n1) Angreifen \n2) Items benutzen \n3) Fliehen");
                menuinputp2 = attackinput.nextInt();
                switch(menuinputp2) {
                    case 1:
                    default:
                        System.out.println("\nSpieler 2, wähle deine Attacke:");
                        for(int i = 0; i<player2.getAttacks().length; i++) {
                            System.out.println((i+1) + ") " + player2.getAttacks()[i]);
                        }
                        player2.setCurrentAttack(p2attack = attackinput.nextInt());
                        player2.Attacks();
                    
                    
                        if(player1.getAttacks()[p1attack-1].contains("schild") || player1.getAttacks()[p1attack-1].equals("Abwehr")) {
                            player2.setFinalAttackDamage(0);   
                        }
                    
                    
                        player1.setLife(player1.getLife()-player2.getFinalAttackDamage());
                        AttackOutput(player2, player1);
                    
                        if(player1.getLife()<0) {
                            System.out.println("\nGlückwunsch, Spieler 2, du hast gewonnen!");
                            break fight;
                        }
                        break;
                        
                    case 2:
                        System.out.println("\nSpieler 2, wähle dein Item aus:");
                        for(int i = 0; i<player2.getItems().length; i++) {
                            System.out.println((i+1) + ") " + player2.getItems()[i]);
                        }
                        player2.setCurrentItem(p2iteminput = attackinput.nextInt());
                        player2.ItemUse();
                        break;
                        
                    case 3:
                        System.out.println(player2.getName() + " ist geflohen! \nSpieler 1 gewinnt!");
                        break fight;
                    }
                    
                    
                checkBurn(player2, player1, p2attack, p1attack);
                System.out.println("\nSpieler 1, wähle aus, was du machen möchtest: \n1) Angreifen \n2) Items benutzen \n3) Fliehen");
                menuinputp1 = attackinput.nextInt();
                switch(menuinputp1) {
                    case 1:
                    default:
                        System.out.println("\nSpieler 1, wähle deine Attacke:");
                        for(int i = 0; i<player1.getAttacks().length; i++) {
                            System.out.println((i+1) + ") " + player1.getAttacks()[i]);
                        }
                        player1.setCurrentAttack(p1attack = attackinput.nextInt());
                        player1.Attacks();
                    
                    
                        if(player2.getAttacks()[p2attack-1].contains("schild") || player2.getAttacks()[p2attack-1].equals("Abwehr")) {
                            player1.setFinalAttackDamage(0);   
                        }
                    
                    
                        player2.setLife(player2.getLife()-player1.getFinalAttackDamage());
                        AttackOutput(player1, player2);
                    
                        if(player2.getLife()<0) {
                            System.out.println("\nGlückwunsch, Spieler 1, du hast gewonnen!");
                            break fight;
                        }
                        break;
                        
                    case 2:
                        System.out.println("\nSpieler 1, wähle dein Item aus:");
                        for(int i = 0; i<player1.getItems().length; i++) {
                            System.out.println((i+1) + ") " + player1.getItems()[i]);
                        }
                        player1.setCurrentItem(p1iteminput = attackinput.nextInt());
                        player1.ItemUse();
                        break;
                        
                    case 3:
                        System.out.println(player1.getName() + " ist geflohen! \nSpieler 2 gewinnt!");
                        break fight;
                    }
                }
        }
        //Kampf an sich STOP
    }
    
    public void AttackOutput(Character input1, Character input2) {
        if(input1.getType().equals("Heal")) { //Falls die Attacke eine Heilung war.
                        System.out.println("\n" + input1.getName() + " hat 250 Leben geheilt und hat somit jetzt " + input1.getLife() + " Leben.");
                    }
                else if (input1.getType().equals("Shield")) { //Falls die Attacke blockt/abwehrt
                        System.out.println("\n" + input1.getName() + " ist für die nächste Runde geschützt.");
                }
                else {
                        if(input1.getFinalAttackDamage()>input1.getDamage()) { //Falls es mehr Schaden macht, als dein Character kann (dank der Attacke)
                        System.out.println("\n" + input1.getName() + " greift " + input2.getName() + " an und fügt " + input1.getFinalAttackDamage() + " Schaden hinzu, " + (input1.getFinalAttackDamage()-input1.getDamage()) + " Schaden mehr als es sollte. " + input2.getName() + " hat noch " + input2.getLife() + " Leben übrig.");
                        }
                        else { //Falls es weniger Schaden macht, als dein Character kann ("dank" der Attacke)
                        System.out.println("\n" + input1.getName() + " greift " + input2.getName() + " an und fügt " + input1.getFinalAttackDamage() + " Schaden hinzu, " + (input1.getDamage()-input1.getFinalAttackDamage()) + " Schaden weniger als es sollte. " + input2.getName() + " hat noch " + input2.getLife() + " Leben übrig.");
                        }
                    }
    }
    
    public void checkBurn(Character input1, Character input2, int p1attackinput, int p2attackinput) { //input1 = Brandverursacher, input2 = Opfer, p1attackinput = p1attack, p2attackinput = p2attack
        if(input1.getBurnCounter()>0) { //Wenn der Brandschaden noch aktiv ist
            input1.setBurnCounter(input1.getBurnCounter()-1); //Eins pro Runde runterstellen
            if(input2.getAttacks()[p2attackinput-1].contains("schild") || input2.getAttacks()[p2attackinput-1].equals("Abwehr")) { //Falls Shield type aktiv ist
                        System.out.println("\n" + input2.getName() + " hat den Brandschaden blockiert. Noch " + input1.getBurnCounter() + " Runden verbleibend bis der Brandschaden aufhört.");
                }
            else {
                input2.setLife(input2.getLife()-50);
                System.out.println("\n" + input2.getName() + " hat 50 Leben an Brandschaden verloren. Noch " + input1.getBurnCounter() + " Runden verbleibend bis der Brandschaden aufhört.");
            }
        }
        else {
            //Deine Mutter LMAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        }
    }
}