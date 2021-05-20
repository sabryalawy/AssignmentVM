import models.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //make instans of SnackMachine and fill it----------------
        SnackMachine snackMachine= InitSnackMachine.initSnackMachine();
        System.out.println("------- the snack machine is ready");

        //--------ScenarioI--------------
//        snackMachine.setKeyPadInput("14");
//        snackMachine.setMoneyInput(1);
//        snackMachine.setKeyPadInput("14");

        //----------ScenarioII--------------
//        snackMachine.setKeyPadInput("24");
//        snackMachine.setMoneyInput(1);
//        snackMachine.makeCancel();

        //---------ScenarioIII-------------
//        snackMachine.insertProduct(new Product(5,1, LocalDateTime.now(),"3kod"));

        //---------ScenarioIIII------------
//        snackMachine.setKeyPadInput("14");
//        snackMachine.setMoneyInput(1);
//        snackMachine.setKeyPadInput("14");
//        snackMachine.setKeyPadInput("14");
//        snackMachine.setMoneyInput(1);
//        snackMachine.setKeyPadInput("14");
//        snackMachine.setKeyPadInput("14");
//        snackMachine.setMoneyInput(1);
//        snackMachine.setKeyPadInput("14");


        liveScenario(snackMachine);


    }

    private static void liveScenario(SnackMachine snackMachine) {
        System.out.println("hello in the snack machine");
        System.out.println("please enter code number");
        for (int i=0;i<snackMachine.getRows().length;i++){
            for (int j=0 ; j<snackMachine.getRows()[i].getColumns().length;j++)
                System.out.print(" - "+i+""+j+" - ");
            System.out.println();
        }
        System.out.println("enter a code ot display the price");
        Scanner sn=new Scanner(System.in);
        snackMachine.setKeyPadInput(sn.next());
        System.out.println("enter Money");
        System.out.println("10- 10 c");
        System.out.println("20- 20 c");
        System.out.println("50- 50 c");
        System.out.println("100- 1 $");
        System.out.println("2000- 20 $");
        System.out.println("5000- 50 $");
        sn=new Scanner(System.in);
        snackMachine.setMoneyInput(sn.nextDouble()/100.0);
        System.out.println("enter the code of the product");
        snackMachine.setKeyPadInput(sn.next());


    }

}
