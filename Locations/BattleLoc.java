package OyunProjesi.Locations;

import OyunProjesi.Monsters.Obstacle;
import OyunProjesi.Game.Player;

import java.util.Random;

public class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan Buradasınzı : "+this.getLocName());
        System.out.println("Dikkatli ol !! Burada "+obsNumber+" tane "+this.getObstacle().getObsName()+" yaşıyor");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S") && combat(obsNumber)){
                System.out.println(this.getLocName() + " içindeki tüm düşmanları yendiniz !!");
                return true;
        }
        if(this.getPlayer().getHealthy()<=0){
            System.out.println("Hakkın rahmetinize kavuştunuz ama panik yapmayın bu bir oyun...Yeniden Başlayın");
            return false;
        }
        return true;
    }

    public boolean combat(int obsNumber){
        for(int i =1 ; i<=obsNumber;i++){
            this.getObstacle().setObsHealth(this.getObstacle().getOrjObsHealth());
            playerState();
            obstacleState(i); // kaçıncı canavar oldugunu bilmek için parametre verdik
            while(this.getPlayer().getHealthy()>0 && this.getObstacle().getObsHealth()>0){
                System.out.print("<V>ur ya da <K>aç : ");
                String selectCombat =input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){
                    System.out.println("Siz "+getPlayer().getDamage()+" hasar attınız\n");
                    this.getObstacle().setObsHealth(this.getObstacle().getObsHealth()-this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getObstacle().getObsHealth()>0){
                        System.out.println("Canavar size vurdu ");
                        int obstacleBlockDamage= this.getObstacle().getObsDamage()-this.getPlayer().getInventory().getArmor().getBlock();

                        if(obstacleBlockDamage<0){
                            obstacleBlockDamage=0;//block damage eksi değerlere düşmesin diye
                        }

                        this.getPlayer().setHealthy(this.getPlayer().getHealthy()-obstacleBlockDamage);
                        afterHit();
                    }

                }
                else {
                    return false;
                }
            }
            if(this.getObstacle().getObsHealth()<this.getPlayer().getHealthy()){ //eğer canavar öldü ise
                if(this.getLocName().equals("Mağara")){
                    System.out.println("Tebrikler Cesur Savaşçı Düşmanı Yendin !! ve "+new Cave(getPlayer()).getAward()+" ödülünü aldın");
                    this.getPlayer().getInventory().setFood(this.award);
                    System.out.println(this.getPlayer().getInventory().getFood());
                }
                if(this.getLocName().equals("Orman")){
                    System.out.println("Tebrikler Cesur Savaşçı Düşmanı Yendin !! ve "+new Forest(getPlayer()).getAward()+" ödülünü aldın");
                    this.getPlayer().getInventory().setFireWood(this.award);
                    System.out.println(this.getPlayer().getInventory().getFireWood());
                }
                if(this.getLocName().equals("Nehir")){
                    System.out.println("Tebrikler Cesur Savaşçı Düşmanı Yendin !! ve "+new River(getPlayer()).getAward()+" ödülünü aldın");
                    this.getPlayer().getInventory().setWater(this.award);
                    System.out.println(this.getPlayer().getInventory().getWater());
                }

                System.out.println(this.getObstacle().getObsAward()+" para kazandınız !!");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getObsAward());
                System.out.println("Güncel paranız : "+this.getPlayer().getMoney());
            }
            else {
                return false;

            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız : "+this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getObsName()+" Canı : "+this.getObstacle().getObsHealth());
        System.out.println("---------------");
    }

    public void obstacleState(int howManyZombie) {
        System.out.println();
        System.out.println(howManyZombie+". "+this.getObstacle().getObsName() +" Değerleri");
        System.out.println("------------------------");
        System.out.println("Sağlık : "+this.getObstacle().getObsHealth());
        System.out.println("Hasar : "+this.getObstacle().getObsDamage());
        System.out.println("Para : "+this.getObstacle().getObsAward());
    }

    public void playerState() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("-----------------------");
        System.out.println("Sağlık : "+getPlayer().getHealthy());
        System.out.println("Zırh : "+getPlayer().getInventory().getArmor().getArmorName());
        System.out.println("Bloklama : "+getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Silah : "+getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : "+getPlayer().getTotalDamage());
        System.out.println("Para : "+getPlayer().getMoney());
    }

    public BattleLoc(int id, Player player, String locName,Obstacle obstacle,String award,int maxObstacle) {
        super(id, player, locName);
        this.obstacle=obstacle;
        this.award=award;
        this.maxObstacle=maxObstacle;
    }
    public int randomObstacleNumber(){
        Random rnd = new Random();
        return rnd.nextInt(1,getMaxObstacle()+1);
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
