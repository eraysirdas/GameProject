package OyunProjesi.WeaponAndArmor;

public class Armor {
    private String armorName;
    private int armorId;
    private int block;
    private int armorMoney;

    public Armor(int armorId,String armorName,int block,int armorMoney){
        this.armorId=armorId;
        this.armorName=armorName;
        this.block=block;
        this.armorMoney=armorMoney;
    }

    public static Armor[] armors(){
       Armor[] armorList = new Armor[3];
       armorList[0]= new Armor(1,"Hafif",1,15);
       armorList[1]= new Armor(2,"Orta",3,25);
       armorList[2]= new Armor(3,"Ağır",5,40);
       return  armorList;
    }
    public int getArmorId(){
        return armorId;
    }
    public void setArmorId(int armorId){
        this.armorId=armorId;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getArmorMoney() {
        return armorMoney;
    }

    public void setArmorMoney(int armorMoney) {
        this.armorMoney = armorMoney;
    }

    public static Armor getWeaponObjById(int id) {
        for (Armor a : Armor.armors()){
            if(a.getArmorId()==id){
                return a;
            }
        }
        return null;
    }
}
