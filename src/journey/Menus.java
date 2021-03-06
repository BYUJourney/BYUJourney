package journey;

import java.util.Scanner;
import journey.characters.Characters;
import journey.game.Game;
import journey.game.dialogs.Dialog;

public class Menus {
    
    private static int choice;
  
     public static void MainMenu(){
        Dialog.dialog1();       
        Scanner inFile;
        inFile= new Scanner(System.in);
        choice= inFile.nextInt();
        while(choice !=1 && choice !=2 && choice !=3){
        Dialog.dialog2();
        inFile= new Scanner(System.in);
        choice= inFile.nextInt();
        }
        
        switch (choice){
           
            case 1:                     
                Dialog.humanChoice();
                break;
            case 2:
                Dialog.elfChoice();
                break;
            case 3:
                Dialog.wizardChoice();
                break;            
        }
        areYouSure();
                
    }
     
     public static void areYouSure(){
        Scanner inFile;
        int answer;
        inFile= new Scanner(System.in);
        answer= inFile.nextInt();
        while(answer !=1 && answer !=2){
            Dialog.youSure();
            inFile= new Scanner(System.in);
            answer= inFile.nextInt();
        }
        if(answer==1){
         Dialog.asterisk();
         Characters c;
         if(choice==1){
         c= new Characters(100,0,"Human",1);
         }
         else if(choice==2){
         c= new Characters(150,0,"Elf",2);
         }
         else{
         c= new Characters(80,0,"Wizard",3);
         }  
         Dialog.printInformation(c);
         Game.begin(c);
                 }
        else{
        MainMenu();
        }
     }
    
}

