import java.lang.Math;
import java.util.Scanner;
import java.util.Random;

public class Character {
    //Default values START
    private String name = "Default";
    private int damage = 100;
    private double attackspeed = 1.0;
    private int life = 500;
    private int maxlife = 500;
    private boolean forcesensitive = false;
    private double tempattackdamage = 0;
    private int finalattackdamage = 0; //Muss 0 sein, falls man sich heilt, dann darf man ja kein Schaden abziehen. UPDATE: Klappt wohl trotzdem nicht, huh. Egal, setze einfach den finalattackdamage bei dem Typen selber auf 0
    private double hitchance = Math.random() * 100;
    private String tier = "TIER1";
    
    Attack ADefault = new Attack("Default", "Damage");
    
    private Attack attack1 = ADefault;
    private Attack attack2 = ADefault;
    private Attack attack3 = ADefault;
    private Attack attack4 = ADefault;
    private Attack[] attacks = {attack1, attack2, attack3, attack4};
    
    Item IDefault = new Item("Default", "Damage");
    
    private Item item1 = IDefault;
    private Item item2 = IDefault;
    private Item item3 = IDefault;
    private Item item4 = IDefault;
    private Item[] items = {item1, item2, item3, item4};
    
    private int item1maxuse = 2;
    private int item2maxuse = 2;
    private int item3maxuse = 2;
    private int item4maxuse = 2;
    private int[] itemmaxuses = {item1maxuse, item2maxuse, item3maxuse, item4maxuse};
    
    private int item1tempuse = item1maxuse;
    private int item2tempuse = item2maxuse;
    private int item3tempuse = item3maxuse;
    private int item4tempuse = item4maxuse;
    private int[] itemtempuses = {item1tempuse, item2tempuse, item3tempuse, item4tempuse};
    
    private int attack = 0;
    private int item = 0;
    private int BurnCounter = 0;
    private boolean isProtected = false;
    private boolean isCurrent = false;
    private boolean usedStun = false;
    //Default values STOP
    
    
    //Getter START
    public String getName() {
        return name;
    }
    
    public int getLife() {
        return life;
    }
    
    public int getMaxLife() {
        return maxlife;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public Attack[] getAttacks() {
        return attacks;
    }
    
    public Item[] getItems() {
        return items;
    }
    
    public int[] getItemMaxUses() {
        return itemmaxuses;
    }
    
    public int[] getItemTempUses() {
        return itemtempuses;
    }
    
    public double getTempAttackDamage() {
        return tempattackdamage;
    }
    
    public int getFinalAttackDamage() {
        return finalattackdamage;
    }
    
    public double getAttackSpeed() {
        return attackspeed;
    }
    
    public boolean getForceSensitive() {
        return forcesensitive;
    }
    
    public int getBurnCounter() {
        return BurnCounter;
    }

    public boolean getIsProtected() {
        return isProtected;
    }
    
    public boolean getIsCurrent() {
        return isCurrent;
    }
    
    public boolean getUsedStun() {
        return usedStun;
    }
    
    public String getTier() {
        return tier;
    }
    //Getter STOP
    
    
    public void printStats() { //Printet Character Stats
        System.out.println("\nName: " + getName() + "\nCharacter Tier: " + getTier() + "\nLife: " + getLife() + "\nDamage: " + getDamage() + "\nAttack speed: " + getAttackSpeed() + "\nForce sensitive: " + getForceSensitive());
    }
    
    
    
    //Setters START
    public void setStats(String name, String tier, boolean forcesensitive) {
        this.name = name;
        this.forcesensitive = forcesensitive;
        this.tier = tier;
        if(tier.equals("TIER1")) {
            this.life = 850 + (int)(Math.random() * ((1100 - 850) + 1)); //Danke für die Random Idee, Jan! :D
            this.maxlife = this.life;
            this.damage = 200 + (int)(Math.random() * ((350 - 200) + 1));
            this.attackspeed = 1.0 + (Math.random() * (1.35-1.0));
        }
        else if(tier.equals("TIER2")) {
            this.life = 1000 + (int)(Math.random() * ((2100 - 1000) + 1));
            this.maxlife = this.life;
            this.damage = 350 + (int)(Math.random() * ((500 - 350) + 1));
            this.attackspeed = 1.15 + (Math.random() * (1.6-1.15));
        }
        else if(tier.equals("TIER3")) {
            this.life = 1900 + (int)(Math.random() * ((2800 - 1900) + 1));
            this.maxlife = this.life;
            this.damage = 500 + (int)(Math.random() * ((750 - 500) + 1));
            this.attackspeed = 1.45 + (Math.random() * (2-1.45));
        }

        else {
            this.life = life;
            this.damage = damage;
            this.attackspeed = attackspeed;
        }
    }
    
    public void setLife(int life) { //Wird benötigt für die Attacken
        this.life = life;
    }
    
    //Attack Section
    
    public void setAttacks(Attack attack1, Attack attack2, Attack attack3, Attack attack4) {
        this.attacks[0] = attack1;
        this.attacks[1] = attack2;
        this.attacks[2] = attack3;
        this.attacks[3] = attack4;
    }
    
    public void setItems(Item item1, int item1maxuse, Item item2, int item2maxuse, Item item3, int item3maxuse, Item item4, int item4maxuse) {
        this.items[0] = item1;
        this.items[1] = item2;
        this.items[2] = item3;
        this.items[3] = item4;
    
        this.itemmaxuses[0] = item1maxuse;
        this.itemmaxuses[1] = item2maxuse;
        this.itemmaxuses[2] = item3maxuse;
        this.itemmaxuses[3] = item4maxuse;
        
        this.itemtempuses[0] = item1maxuse;
        this.itemtempuses[1] = item2maxuse;
        this.itemtempuses[2] = item3maxuse;
        this.itemtempuses[3] = item4maxuse;
    }
    
    public void setItem(int id, Item item) {
        this.items[id] = item;
    }

    public void setCurrentAttack(int attack) {
        this.attack = attack;
    }
    
    public void setCurrentItem(int item) {
        this.item = item;
    }
    
    public void setFinalAttackDamage(int finalattackdamage) {
        this.finalattackdamage = finalattackdamage;
    }
    
    public void setIsProtected(boolean isProtected) {
        this.isProtected = isProtected;
    }
    
    public void setIsCurrent(boolean isCurrent) {
        this.isCurrent = isCurrent;
    }
    
    public void setUsedStun(boolean usedStun) {
        this.usedStun = usedStun;
    }
    
    public void setBurnCounter(int BurnCounter) {
        this.BurnCounter = BurnCounter;
    }

    public void setItemTempUses(int itemtempuses) {
        this.itemtempuses[item-1] = itemtempuses;
    }
    
    public void setItemDevTempUses(int id, int tempuses) {
        itemtempuses[id] = tempuses;
    }
    
    public void setItemDevMaxUses(int id, int maxuses) {
        itemmaxuses[id] = maxuses;
    }
    //Setters STOP
    


    public void Attacks() {
        if(attack>4 || attack<=0) {
            return;
        }
        hitchance = Math.random() * 100; //generiert random hitchance pro Angriff
        System.out.println("\n" + getName() + " benutzt " + getAttacks()[attack-1].name);
        if(getAttacks()[attack-1].name.equals("Lichtschwert Angriff")) { //Again, muss -1 sein, da es ein Array ist. Wird pro Runde neu generiert, da Attacks() in der Schleife neu ausgeführt wird
            tempattackdamage = damage * 1.0;
            finalattackdamage = (int)tempattackdamage;
        }
        else if(getAttacks()[attack-1].type.equals("Heal")) {
            setLife(getLife()+250);
            setFinalAttackDamage(0); //Wenn dies nicht der Fall ist, dann fügt der Spieler Schaden hinzu. Zu OP
        }
        else if(getAttacks()[attack-1].type.equals("Shield")) {
            setFinalAttackDamage(0); //Wenn dies nicht der Fall ist, dann fügt der Spieler Schaden hinzu. Zu OP
            isProtected = true;
        }
        else if(getAttacks()[attack-1].type.equals("Burn")) {
            BurnCounter = 4;
            tempattackdamage = damage * 1.0;
            finalattackdamage = (int)tempattackdamage;
        }
        else if(getAttacks()[attack-1].type.equals("Stun")) {
            usedStun = true;
        }
        else { //Ist immer nur mal 1
            double rndm = 0.8 + (Math.random() * (1.2-0.8));
            tempattackdamage = damage * rndm;
            finalattackdamage = (int)tempattackdamage;
        }
        
        switch(tier) { //je nach Tier ist die chance nicht zu hitten größer
            case "TIER1":
                if(hitchance<20 && getAttacks()[attack-1].type.equals("Damage")) {
                    finalattackdamage = 0;
                    System.out.println("\nDie Attacke von " + getName() + " ging daneben!");
                }
                break;
            case "TIER2":
                if(hitchance<15 && getAttacks()[attack-1].type.equals("Damage")) {
                    finalattackdamage = 0;
                    System.out.println("\nDie Attacke von " + getName() + " ging daneben!");
                }
                break;
            case "TIER3":
                if(hitchance<10 && getAttacks()[attack-1].type.equals("Damage")) {
                    finalattackdamage = 0;
                    System.out.println("\nDie Attacke von " + getName() + " ging daneben!");
                }
                break;
            }
    }
    
    Scanner iteminput = new Scanner(System.in);
    public void ItemUse(boolean isAI) {
        while(true) {
            if(!isAI) {
                for(int i = 0; i<getItems().length; i++) { //Je nach Anzahl der Items, meist 4
                    System.out.println((i+1) + ") " + "(" + getItemTempUses()[i] + "/" + getItemMaxUses()[i] + ") " + getItems()[i].name); //Printet z.b. 1) Placeholder
                }
                int iteminput;
                setCurrentItem(iteminput = this.iteminput.nextInt());
            }
            else {
                int aiCItem = checkforHealItem();
                if(checkforHealItem()>0) {
                    setCurrentItem(aiCItem+1);
                }
                else {
                    System.out.println("ERROR! RETURNING!" );
                    return;
                }
            }
            
            if(getItemTempUses()[item-1]>0) {
                setItemTempUses(getItemTempUses()[item-1]-1);
                
                switch(getItems()[item-1].type) {
                    case "Heal":
                        setLife(getLife()+250);
                        System.out.println("\n" + getName() + " hat 250 Leben geheilt! " + getName() + " hat jetzt " + getLife() + " Leben, davor " + (getLife()-250));
                        break;
                    case "Damage":
                        System.out.println("Item: Es hat nichts gebracht");
                        break;
                    default:
                        System.out.println(getItems()[item-1].name + " has no type!");
                        break;
                }
            
                System.out.println("\n" + getName() + " benutzt das Item " + getItems()[item-1].name + "! " + "Noch " + getItemTempUses()[item-1] + " mal kann das Item verwendet werden."); //Literally der gleiche Scheiß wie in Attacks()
                break;
            }
            else {
                System.out.println("\nDas Item kann nicht mehr verwendet werden! Wähle nochmal!");
                continue;
            }
        }
    }
    
    public int checkforHealAttack() {
        int healExists = 0;
        for(int i=0; i<getAttacks().length; i++) {
            if(getAttacks()[i].type.equals("Heal")) {
                healExists = i;   
            }
        }
        return healExists;
    }
    
    public int checkforHealItem() {
        int healExists = 0;
        for(int i=0; i<getItems().length; i++) {
            if(getItems()[i].type.equals("Heal") && getItemTempUses()[i]>0) {
                healExists = i;
            }
        }
        return healExists;
    }
    
    public int chooseAttack() {
        Random random = new Random();
        int rndmattack = random.nextInt(4)+1;
        while(getAttacks()[rndmattack-1].type.equals("Heal")) {
            rndmattack = random.nextInt(4);
        }
        return rndmattack;
    }
}