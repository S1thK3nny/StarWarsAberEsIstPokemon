import java.util.Scanner;
import java.util.Random;

public class CharacterCreation { //Our work is never over. ~Daft Punk
    static Character input1 = new Character();
    static Character input2 = new Character();
    static Item[] Items;
    public void setPlayers(int p1, int p2, boolean bothAreHuman) {
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
        
        Attack LStrike = new Attack("Lichtschwert Angriff", "Damage");
        Attack Machtschub = new Attack("Machtschub", "Damage");
        Attack Abwehr = new Attack("Abwehr", "Shield");
        Attack Machtheilung = new Attack("Machtheilung", "Heal");
        Attack Machtwuergung = new Attack("Machtwürgung", "Damage");
        Attack LThrow = new Attack("Lichtschwertwurf", "Damage");
        Attack Machtblitz = new Attack("Machtblitz", "Damage");
        Attack Machtwurf = new Attack("Machtwurf", "Damage");
        Attack DAura = new Attack("Dunkle Aura", "Damage");
        Attack MUnterstuetzung = new Attack("Militia Unterstützung", "Damage");
        Attack Machtschild = new Attack("Machtschild", "Shield");
        Attack BlasterSchnellfeuer = new Attack("Blaster Schnellfeuer", "Damage");
        Attack Hoffnung = new Attack("Hoffnung", "Shield");
        Attack Stimpacks = new Attack("Stimpacks", "Heal");
        Attack Sprengsatz = new Attack("Sprengsatz", "Damage");
        Attack ArmbrustSchuss = new Attack("ArmbrustSchuss", "Damage");
        Attack ArmbrustMultiSchuss = new Attack("Armbrust Multi-Schuss", "Damage");
        Attack WookieWut = new Attack("Wookie Wut", "Damage");
        Attack Flammenwerfer = new Attack("Flammenwerfer", "Burn");
        Attack Handgelenkrakete = new Attack("Handgelenkrakete", "Damage");
        Attack Detpack = new Attack("Detpack", "Damage");
        
        Attack BlasterAngriff = new Attack("Blaster Angriff", "Damage");
        Attack TherDet = new Attack("Thermal Detonator", "Damage");
        Attack Schlag = new Attack("Schlag", "Damage");
        Attack Kick = new Attack("Kick", "Damage");
        
        LukeSkywalker.setAttacks(LStrike, Machtschub, Abwehr, Machtheilung);
        DarthVader.setAttacks(LStrike, Machtschub, Machtwuergung, LThrow);
        Palpatine.setAttacks(LStrike, Machtblitz, Machtwurf, DAura);
        RahmKota.setAttacks(LStrike, MUnterstuetzung, Machtschub, Machtschild);
        LeiaOrgana.setAttacks(BlasterAngriff, BlasterSchnellfeuer, Hoffnung, Stimpacks);
        HanSolo.setAttacks(BlasterAngriff, Stimpacks, Sprengsatz, BlasterSchnellfeuer);
        Chewbacca.setAttacks(ArmbrustSchuss, ArmbrustMultiSchuss, WookieWut, TherDet);
        BobaFett.setAttacks(BlasterAngriff, Flammenwerfer, Handgelenkrakete, Detpack);
        Stormtrooper.setAttacks(BlasterAngriff, TherDet, Schlag, Kick);
        RebelSoldier.setAttacks(BlasterAngriff, TherDet, Schlag, Kick);        
        MilitiaSoldier.setAttacks(BlasterAngriff, TherDet, Schlag, Kick);
        
        Item Medpack = new Item("Medpack", "Heal");
        Item Comlink = new Item("Comlink", "Damage");
        Item Default = new Item("Default", "Damage");
        
        Item[] Items = {Medpack,Comlink, Default};
        this.Items = Items;
        LukeSkywalker.setItems(Comlink, 4, Medpack, 0, Medpack, 0, Medpack, 1);
        //Stormtrooper.setItems("Dies", 0, "ist", 0, "ein", 0, "Test!", 1);
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
        int input1healthpercent;
        int input2healthpercent;
        boolean input2isAI = true;
        String spieler1;
        String spieler2;
        
        if(player1.getAttackSpeed()>player2.getAttackSpeed())  {
            input1 = player1;
            input2 = player2;
            input2isAI = true;
            spieler1 = "Spieler 1";
            spieler2 = "Spieler 2";
        }
        else {
            input1 = player2;
            input2 = player1;
            input2isAI = false;
            spieler1 = "Spieler 2";
            spieler2 = "Spieler 1";
        }
        
        new DeveloperConsole(true);
        
        //Kampf an sich START
        fight: while(true) { //benutzt break fight; um die ganze Schleife jetzt zu beenden
            Scanner attackinput = new Scanner(System.in);
            input1healthpercent = (input1.getMaxLife()/100)*30;
            input2healthpercent = (input2.getMaxLife()/100)*30;
            
                checkBurn(input2, input1);
                if(input2isAI || bothAreHuman) { //Wenn input1 der Spieler ist
                    p1: while(true) {
                    System.out.println("\n" + spieler1 + ", wähle aus, was du machen möchtest: \n1) Angreifen \n2) Items benutzen \n3) Fliehen");
                    menuinputp1 = attackinput.nextInt();
                    switch(menuinputp1) {
                        case 1:
                        default: //Wenn der Spieler die Zahl 1 oder irgendwas außer 2 und 3 eingibt, sonst passiert nichts!
                            System.out.println("\n" + spieler1 + ", wähle deine Attacke:");
                            for(int i = 0; i<input1.getAttacks().length; i++) { //Je nach Anzahl der Attacken, meist 4
                                System.out.println((i+1) + ") " + input1.getAttacks()[i].name); //Printet z.b. 1) Melee
                            }
                            input1.setCurrentAttack(p1attack = attackinput.nextInt()); //Geht wieder rüber zu class "Character", setzt input Variable "p1attack" ein.
                            
                            AttackShit(input1, input2, p1attack);
                        
                            if(input2.getLife()<=0) { //Wenn Spieler 2 0 HP hat
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
                                input1.ItemUse(false);
                                break p1;
                            }
                            
                        case 3:
                            System.out.println("\n" + input1.getName() + " ist geflohen! \n" + spieler2 + " gewinnt!");
                            break fight;
                        }
                    }
                }
                else { //Wenn input2 der Spieler ist
                    AITurn(input1, input2, input1healthpercent);
                    if(input2.getLife()<=0) { //Wenn Spieler 2 0 HP hat
                        System.out.println("\nDu hast verloren, " + spieler2 + "!");
                        break fight;
                    }
                }
                input2.setIsProtected(false);
                DeveloperConsole.UpdateWindow();
                
                checkBurn(input1, input2);
                if(!input2isAI || bothAreHuman) { //Wenn input2 der Spieler ist
                    p2: while(true) { //Zweite Spieler brauchen while schleifen um auf diese zurück zu callen wenn alle Items verbraucht wurden
                        System.out.println("\n" + spieler2 + ", wähle aus, was du machen möchtest: \n1) Angreifen \n2) Items benutzen \n3) Fliehen");
                        menuinputp2 = attackinput.nextInt();
                        switch(menuinputp2) {
                            case 1:
                            default:
                                System.out.println("\n" + spieler2 + ", wähle deine Attacke:");
                                for(int i = 0; i<input2.getAttacks().length; i++) {
                                    System.out.println((i+1) + ") " + input2.getAttacks()[i].name);
                                }
                                input2.setCurrentAttack(p2attack = attackinput.nextInt());
                                
                                AttackShit(input2, input1, p2attack);
                        
                                if(input1.getLife()<=0) {
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
                                    input2.ItemUse(false);
                                    break p2;
                                }
                            
                            case 3:
                                System.out.println("\n" + input2.getName() + " ist geflohen! \n" + spieler1 + " gewinnt!");
                                break fight;
                        }
                    }
                }
                else { //Wenn input1 der Spieler ist
                    AITurn(input2, input1, input2healthpercent);
                    if(input1.getLife()<=0) { //Wenn Spieler 2 0 HP hat
                        System.out.println("\nDu hast verloren, " + spieler1 + "!");
                        break fight;
                    }
                }
                input1.setIsProtected(false);
                DeveloperConsole.UpdateWindow();
        }
            
        DeveloperConsole.CloseWindow();
        //Kampf an sich STOP
    }
    
    public void AITurn(Character input1, Character input2, int healthpercent) {
        try
            {
                Thread.sleep(300);
            }
            catch (InterruptedException ie)
            {
                ie.printStackTrace();
            }
        boolean needsHeal = false;
        int test = input1.chooseAttack();
        //System.out.println(test);
        if(input1.getLife()<=healthpercent) {
            needsHeal = true;
        }
        //System.out.println(input1.getName() + " needsHeal: " + needsHeal + " healthpercent " + healthpercent);
        if(needsHeal && checking(input1)) {
            Random random = new Random();
            boolean randomBoolean = random.nextBoolean();
            if(input1.checkforHealAttack()>0 && randomBoolean) {
                int aiCAttack = input1.checkforHealAttack();
                //System.out.println(input1.getName() + " HAS AN ATTACK THAT HEALS! " + input1.getAttacks()[aiCAttack] + "\nRandomboolean: " + randomBoolean);
                input1.setCurrentAttack(aiCAttack+1); //Muss +1 sein, da CurrentAttack automatisch -1 macht
                AttackShit(input1, input2, aiCAttack);
            }
            else if (input1.checkforHealItem()>0) {
                //System.out.println(input1.getName() + " WILL USE HEAL ITEM!" + "\nRandomboolean: " + randomBoolean);
                input1.ItemUse(true);
            }
            else {
                input1.setCurrentAttack(test);
                AttackShit(input1, input2, test);
            }
        }
        else {
            //System.out.println(input1.getName() + " IS ATTACKING");
            input1.setCurrentAttack(test);
            AttackShit(input1, input2, test);
        }
    }
    
    public boolean checking(Character input) {
        if(input.checkforHealAttack()>0 || input.checkforHealItem()>0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public void AttackShit(Character input1, Character input2, int attack) {
        input1.Attacks(); //setzt die damage values
        if(input2.getIsProtected()) { //MUSS VOR SETLIFE SEIN!!! Sonst klappt es nicht. WAG ES JA NICHT WIEDER DEN CODE HIER ZU ZWEIFELN; SONST KRIEGT DER SPIELER SCHADEN
            input1.setFinalAttackDamage(0);
        }
        input2.setLife(input2.getLife()-input1.getFinalAttackDamage()); //Fügt den Schaden hinzu
        AttackOutput(input1, input2, attack); //Printet ob man sich heilt oder ob man Schaden gemacht hat und wie viel
    }
    
    public void AttackOutput(Character input1, Character input2, int attack) {
        if(input1.getAttacks()[attack-1].type.equals("Heal")) { //Falls die Attacke eine Heilung war.
                        System.out.println("\n" + input1.getName() + " hat 250 Leben geheilt und hat somit jetzt " + input1.getLife() + " Leben.");
                    }
                else if (input1.getAttacks()[attack-1].type.equals("Shield")) { //Falls die Attacke blockt/abwehrt
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
    
    public void checkBurn(Character input1, Character input2) { //input1 = Brandverursacher, input2 = Opfer
        if(input1.getBurnCounter()>0) { //Wenn der Brandschaden noch aktiv ist
            input1.setBurnCounter(input1.getBurnCounter()-1); //Eins pro Runde runterstellen
            if(input2.getIsProtected()) { //Falls Shield type aktiv ist
                        System.out.println("\n" + input2.getName() + " hat den Brandschaden blockiert. Noch " + input1.getBurnCounter() + " Runden verbleibend bis der Brandschaden aufhört.");
                }
            else {
                input2.setLife(input2.getLife()-50);
                System.out.println("\n" + input2.getName() + " hat 50 Leben an Brandschaden verloren. Noch " + input1.getBurnCounter() + " Runden verbleibend bis der Brandschaden aufhört.");
                DeveloperConsole.UpdateWindow();
            }
        }
    }
}