package OyunProjesi.Locations;


import OyunProjesi.WeaponAndArmor.Armor;
import OyunProjesi.Game.Player;
import OyunProjesi.WeaponAndArmor.Gun;
import OyunProjesi.WeaponAndArmor.Rifle;
import OyunProjesi.WeaponAndArmor.Sword;
import OyunProjesi.WeaponAndArmor.Weapon;

public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(2,player,"Eşya Dükkanı");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Eşya Dükkanına Hoşgeldiniz !!\n");
        System.out.println("""
                1- Silahlar
                2- Zırhlar
                3- Çıkış
                """);
        System.out.print("Yapmak istediğiniz işlemi seçin : ");
        int selectCase=input.nextInt();
        while(selectCase<1 || selectCase>3){
            System.out.print("Geçersiz bir seçim yaptınız, tekrar girin : ");
            selectCase=input.nextInt();
        }
        switch (selectCase){
            case 1 : 
                printWeapon();
                buyWeapon();
                break;
            case 2 :
                printArmor();
                buyArmor();
                break;
            case 3 :
                System.out.println("\nSonraki sefere kadar görüşmek üzere...");
                return true;
            default:
                printWeapon();
        }
        return true;
    }

    private void buyArmor() {
        System.out.print("Zırhınızı seçin : ");
        int selectArmorId = input.nextInt();
        while (selectArmorId < 1 || selectArmorId > Weapon.weapons().length+1) {
            System.out.println("Hatalı bir seçim yaptınız");
            selectArmorId = input.nextInt();
        }

        Armor selectedArmor = Armor.getWeaponObjById(selectArmorId);
        if(Armor.armors().length +1==selectArmorId){
            onLocation();
        }
        else {

            if (selectedArmor != null) {
                if (selectedArmor.getArmorMoney() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır !");
                    onLocation();
                } else {
                    System.out.println(selectedArmor.getArmorName() + " zırhı satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getArmorMoney();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());

                    //System.out.println("Önceki Zırhınız : "+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    onLocation();
                    //System.out.println("Yeni Zırhınız : "+this.getPlayer().getInventory().getWeapon().getName());
                }

            }
        }

    }

    private void printArmor() {
        System.out.println("-----------------------Zırhlar-------------------------");
        for (Armor i:Armor.armors()) {
            System.out.println("ID :"+i.getArmorId()+
                    "\t\tZırh : "+i.getArmorName()+
                    "\t\tEngelleme : "+i.getBlock()+
                    "\t\tPara : "+i.getArmorMoney()
            );
        }
        System.out.println(Armor.armors().length +1 +"  Çıkış yap");
    }

    private void printWeapon() {
        System.out.println("-------------------------Silahlar----------------------");
        Weapon[] weapons = {new Gun(),new Sword(),new Rifle()};
        for (Weapon i:weapons) {
            System.out.println("ID :"+i.getId()+
                    "\t\tSilah : "+i.getName()+
                    "\t\tHasar : "+i.getDamage()+
                    "\t\tPara : "+i.getMoney()
            );
        }
        System.out.println(Armor.armors().length +1 +"  Çıkış yap");

    }

    public void buyWeapon() {

        System.out.print("Silahınızı seçin : ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 1 || selectWeaponId > Weapon.weapons().length+1) {
            System.out.println("Hatalı bir seçim yaptınız");
            selectWeaponId = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);

        if((selectWeaponId==Weapon.weapons().length+1)) {
            onLocation();
        }
        else{

            if (selectedWeapon != null) {
                if (selectedWeapon.getMoney() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli bakiyeniz bulunmamaktadır !");
                    onLocation();
                } else {
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getMoney();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());

                    //System.out.println("Önceki Silahınız : "+this.getPlayer().getInventory().getWeapon().getName());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                    //System.out.println("Yeni Silahınız : "+this.getPlayer().getInventory().getWeapon().getName());
                    onLocation();
                }

            }
        }
    }
                /*switch (selectWeapons){
            case 1 :
                if(control()){
                    weapon=new Gun();
                    initWeapons(weapon);
                }
                break;
            case 2 :
                weapon = new Sword();
                initWeapons(weapon);
                break;
            case 3 :
                weapon= new Rifle();
                initWeapons(weapon);
                break;
            default:
                System.out.println("Silah secmediniz...");

        }
        System.out.println("Silah : "+weapon.getName()+
                "\t\tHasar : "+weapon.getDamage()+
                "\t\tPara : "+weapon.getMoney()
        );

         */


    /*public boolean control(){
        if(weapon.getMoney()>this.getPlayer().getMoney()){
            System.out.println("Yeterli bakiyeniz bulunmamaktadır !");
            return false;
        }
        else {
            System.out.println(weapon.getName()+ " silahını satın aldınız !");
            int balance = this.getPlayer().getMoney()-weapon.getMoney();
            this.getPlayer().setMoney(balance);
            System.out.println("Kalan paranız : "+this.getPlayer().getMoney());
            return true;
        }
    }
    private void initWeapons(Weapon wea) {
        weapon.setId(wea.getId());
        weapon.setName(wea.getName());
        weapon.setDamage(wea.getDamage());
        weapon.setMoney(wea.getMoney());


    }

     */
}
