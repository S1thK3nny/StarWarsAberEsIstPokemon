import java.util.Scanner;

public class CharacterCreation { //Our work is never over. ~Daft Punk
    static Character input1 = new Character();
    static Character input2 = new Character();
    public void setPlayers(int p1, int p2) {
        //Character Creation START
        Character player1 = new Character();
        Character player2 = new Character();
        
        input1 = new Character();
        input2 = new Character();
        
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
        
        LukeSkywalker.setItems("Dies", 0, "ist", 0, "ein", 0, "Test!", 1);
        Stormtrooper.setItems("Dies", 0, "ist", 0, "ein", 0, "Test!", 1);
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
        String spieler1;
        String spieler2;
        
        if(player1.getAttackSpeed()>player2.getAttackSpeed())  {
            input1 = player1;
            input2 = player2;
            spieler1 = "Spieler 1";
            spieler2 = "Spieler 2";
        }
        else {
            input1 = player2;
            input2 = player1;
            spieler1 = "Spieler 2";
            spieler2 = "Spieler 1";
        }
        
        new DeveloperConsole();
        
        //Kampf an sich START
        fight: while(true) { //benutzt break fight; um die ganze Schleife jetzt zu beenden
            Scanner attackinput = new Scanner(System.in);
                checkBurn(input2, input1, p2attack, p1attack);
                p1: while(true) {
                System.out.println("\n" + spieler1 + ", wähle aus, was du machen möchtest: \n1) Angreifen \n2) Items benutzen \n3) Fliehen");
                menuinputp1 = attackinput.nextInt();
                switch(menuinputp1) {
                    case 1:
                    default: //Wenn der Spieler die Zahl 1 oder irgendwas außer 2 und 3 eingibt, sonst passiert nichts!
                        System.out.println("\n" + spieler1 + ", wähle deine Attacke:");
                        for(int i = 0; i<input1.getAttacks().length; i++) { //Je nach Anzahl der Attacken, meist 4
                            System.out.println((i+1) + ") " + input1.getAttacks()[i]); //Printet z.b. 1) Melee
                        }
                        input1.setCurrentAttack(p1attack = attackinput.nextInt()); //Geht wieder rüber zu class "Character", setzt input Variable "p1attack" ein.
                        input1.Attacks(); //setzt die damage values
                    
                        if(input2.getIsProtected()) { //MUSS VOR SETLIFE SEIN!!! Sonst klappt es nicht. WAG ES JA NICHT WIEDER DEN CODE HIER ZU ZWEIFELN; SONST KRIEGT DER SPIELER SCHADEN
                            input1.setFinalAttackDamage(0);
                        }
                        
                        input2.setLife(input2.getLife()-input1.getFinalAttackDamage()); //Fügt den Schaden hinzu
                        AttackOutput(input1, input2); //Printet ob man sich heilt oder ob man Schaden gemacht hat und wie viel
                    
                        if(input2.getLife()<0) { //Wenn Spieler 2 0 HP hat
                            System.out.println("\nGlückwunsch, " + spieler1 + ", du hast gewonnen!");
                            break fight;
                        }
                        break p1;
                        
                    case 2:
                        if(input1.getItemTempUses()[0]==0 && input1.getItemTempUses()[1]==0 && input1.getItemTempUses()[2]==0 && input1.getItemTempUses()[3]==0) {
                            System.out.println("\nAlle Items verbraucht!");
                            continue;
                        }
                        else {
                            System.out.println("\n" + spieler1 + ", wähle dein Item aus:");
                            input1.ItemUse();
                            break p1;
                        }
                        
                    case 3:
                        System.out.println("\n" + input1.getName() + " ist geflohen! \n" + spieler2 + " gewinnt!");
                        break fight;
                    }
                }
                input2.setIsProtected(false);
                DeveloperConsole.UpdateWindow();
                
                
                checkBurn(input1, input2, p1attack, p2attack);
                p2: while(true) { //Zweite Spieler brauchen while schleifen um auf diese zurück zu callen wenn alle Items verbraucht wurden
                    System.out.println("\n" + spieler2 + ", wähle aus, was du machen möchtest: \n1) Angreifen \n2) Items benutzen \n3) Fliehen");
                    menuinputp2 = attackinput.nextInt();
                    switch(menuinputp2) {
                        case 1:
                        default:
                            System.out.println("\n" + spieler2 + ", wähle deine Attacke:");
                            for(int i = 0; i<input2.getAttacks().length; i++) {
                                System.out.println((i+1) + ") " + input2.getAttacks()[i]);
                            }
                            input2.setCurrentAttack(p2attack = attackinput.nextInt());
                            input2.Attacks();
                    
                             if(input1.getIsProtected()) {
                                input2.setFinalAttackDamage(0);
                            }
                            
                            input1.setLife(input1.getLife()-input2.getFinalAttackDamage());
                            AttackOutput(input2, input1);
                    
                            if(input1.getLife()<0) {
                                System.out.println("\nGlückwunsch, " + spieler2 + ", du hast gewonnen!");
                                break fight;
                            }
                            break p2;
                        
                        case 2:
                            if(input2.getItemTempUses()[0]==0 && input2.getItemTempUses()[1]==0 && input2.getItemTempUses()[2]==0 && input2.getItemTempUses()[3]==0) {
                                System.out.println("\nAlle Items verbraucht!");
                                continue p2;
                            }
                            else {
                                System.out.println("\n" + spieler2 + ", wähle dein Item aus:");
                                input2.ItemUse();
                                break p2;
                            }
                        
                        case 3:
                            System.out.println("\n" + input2.getName() + " ist geflohen! \n" + spieler1 + " gewinnt!");
                            break fight;
                    }
                }
                input1.setIsProtected(false);
                DeveloperConsole.UpdateWindow();
            }
            
        DeveloperConsole.CloseWindow();
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
                DeveloperConsole.UpdateWindow();
            }
        }
        else {
            //Deine Mutter LMAOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        }
    }
}