package ID;

import java.util.Scanner;

public class Main_dos {

    public static void main(String[] args) {
        checkID checkID = new checkID();

        while (true) {
            System.out.print("請輸入身份證字號共10碼，第一碼為英文 =");
            Scanner sc = new Scanner(System.in);

            String str = sc.nextLine();

            checkID.setStr(str);
            System.out.println("" + checkID.message);
        }
    }

}
