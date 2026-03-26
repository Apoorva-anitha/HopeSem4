package Task5;

import java.util.Scanner;

class BedRoom {
    int br;
    BedRoom(int br){
        this.br = br;
        System.out.print("An Apartment with " + br +" bedroom");
    }
}

class Hall{
    Hall(boolean isHall){
         if(isHall){
             System.out.print(" , with hall");
         }else{
             System.out.print(" , without hall");
         }
    }
}
 class Kitchen {
    int kit;
    Kitchen(int kit){
        this.kit = kit;
        System.out.print(" with " +  kit +" kitchen");
    }
}

class WashRoom {
    boolean isWashRoom;
    WashRoom(boolean isWashRoom){
        this.isWashRoom = isWashRoom;
        if(isWashRoom){
             System.out.print(" , with attached washroom" );   
        }else{
            System.out.print( ", with not  attached washroom" );
        }
    }
}

class Dinning {
    boolean isDinning;
     Dinning( boolean isDinning){
         this.isDinning = isDinning;
         if(isDinning){
             System.out.print(  ", with attached dinning room" );
         }else{
             System.out.print( ", with not attached dinning room" );
         }
    }  
}

 class PlayGround {
    PlayGround(){
        System.out.println(" with public playground " );
    }
}

public class Apartments {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the which type of apartment you want to see");
        int n=sc.nextInt();
        switch(n){
            case 1:
                System.out.println("you have selected 1BHK apartment");
                BedRoom b1 = new BedRoom(1);
                Kitchen k1 = new Kitchen(1);
                WashRoom w1 = new WashRoom(false);
                Dinning d1= new Dinning(false);
                PlayGround p1 = new PlayGround();
                break;
            case 2:
                System.out.println("you have selected 2BHK apartment");
                BedRoom b2 = new BedRoom(2);
                Kitchen k2 = new Kitchen(1);
                WashRoom w2 = new WashRoom(true);
                Dinning d2= new Dinning(true);
                PlayGround p2 = new PlayGround();
                break;
            case 4:
                System.out.println("you have selected 4BHK apartment");
                BedRoom b4 = new BedRoom(4);
                Kitchen k4 = new Kitchen(1);
                WashRoom w4 = new WashRoom(true);
                Dinning d4= new Dinning( true);
                PlayGround p4 = new PlayGround();
                break;
            default:
                System.out.println("invalid input");
        }
        sc.close();

    }

}
