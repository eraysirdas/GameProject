package OyunProjesi.Game;

import OyunProjesi.Locations.*;

import java.util.Scanner;

public class Game {
    Scanner in=new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz !!");
        System.out.println("Lütfen bir isim giriniz: ");
        //String playerName=in.nextLine();

        Player player = new Player("eray");
        System.out.println("Sevgili " + player.getName() + " bu karanlık ve sisli adaya hoşgeldin ! Burada yaşanılanlar gerçek hikayelerden uyarlanmıştır....");
        System.out.println("Oyuna başlamak için karakter seçin !!");
        System.out.println("-----------------------------------------------------------------------------------------");
        player.selectChar();

        Location location=null;
        while (true){
            player.printInfo();
            System.out.println(" ");
            System.out.println("##################Bölgeler########################\n");

            Location[] loclist ={new SafeHouse(player),new ToolStore(player)};
            for (Location loc:loclist) {
                System.out.print(loc.getId());
                switch (loc.getLocName()) {
                    case "Güvenli Ev" ->
                        System.out.println(" "+loc.getLocName()+" --> Burası sizin için güvenli bir yer,düşman yoktur !");
                    case "Eşya Dükkanı"-> System.out.println(" "+loc.getLocName()+" --> Silah veya Zırh satın alabilirsiniz !!");
                }
            }
            System.out.println("\n3 - Mağara --> <Yemek> , dikkatli ol zombi çıkabilir");
            System.out.println("4 - Orman --> <Odun> , dikkatli ol vampir çıkabilir");
            System.out.println("5 - Nehir --> <Su> , dikkatli ol ayı çıkabilir");

            System.out.println("\n0 - Çıkış Yap --> Oyunu sonlandır.\n");


            System.out.print("lütfen gitmek istedğiniz bölgeyi seçin: ");
             int  selectloc=in.nextInt();
            switch (selectloc){
                case 0 :
                    location=null;
                    break;
                case 1 :
                    location=new SafeHouse(player);
                    break;
                case 2 :
                    location=new ToolStore(player);
                    break;
                case 3 :

                    location=new Cave(player);
                    break;
                case 4 :
                    location=new Forest(player);
                    break;
                case 5 :
                    location=new River(player);
                    break;
                default:
                    System.out.println("Gecerli bir bölge seçemediğiniz için güvenli eve yönlendirildiniz !!");
                    location = new SafeHouse(player);

            }
            if(location==null){
                System.out.println("\nBu karanlık ve sisli yolculuktan hemen vazgeçtin :(");
                break;
            }
            if(!location.onLocation()){
                System.out.println("OYUN BİTTİ");
                break;
            }

        }




    }







}
