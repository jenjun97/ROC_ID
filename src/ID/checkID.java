package ID;

import java.util.ArrayList;
import java.util.HashMap;

public class checkID {

    boolean correct; // 檢核是否正確
    String[] strArray; // 輸入字串
    String str; // 原輸入值
    String message; // 返回顯示的內容
    int countTotal = 0; // 計算值
    HashMap<String, Integer> firstWord = new HashMap(); // 英文代號

    public checkID() { // 建構子，並建立所有英文代號
        firstWord.put("A", 10);
        firstWord.put("B", 11);
        firstWord.put("C", 12);
        firstWord.put("D", 13);
        firstWord.put("E", 14);
        firstWord.put("F", 15);
        firstWord.put("G", 16);
        firstWord.put("H", 17);
        firstWord.put("I", 34);
        firstWord.put("J", 18);
        firstWord.put("K", 19);
        firstWord.put("L", 20);
        firstWord.put("M", 21);
        firstWord.put("N", 22);
        firstWord.put("O", 35);
        firstWord.put("P", 23);
        firstWord.put("Q", 24);
        firstWord.put("R", 25);
        firstWord.put("S", 26);
        firstWord.put("T", 27);
        firstWord.put("U", 28);
        firstWord.put("V", 29);
        firstWord.put("W", 32);
        firstWord.put("X", 30);
        firstWord.put("Y", 31);
        firstWord.put("Z", 33);
    }

    public void setStr(String str) { // 將字串轉陣列
        this.str = str;
        this.strArray = str.split(""); // 字串轉陣列
        checkStr(); // 執行檢查字串陣列
    }

    void checkStr() { // 檢查字串陣列
        correct = true;
        char c = strArray[0].charAt(0); // 第一位是否為英文
        if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
            correct = false;
            message = str + " 第一碼英文輸入錯誤";
        }

        if (correct) {
            for (int i = 1; i < strArray.length; i++) { // 2-10碼是否為數字
                if (!Character.isDigit(strArray[i].charAt(0))) {
                    System.out.println("error" + strArray[i]);
                    correct = false;
                    message = str + " 錯誤，2-10碼需為數字";
                    break;
                }
            }
        }

        if (correct) {
            countID(); // 計算id值
        }

    }

    void countID() { // 計算id值
        firstWord(); // 計算英文
        otherNumerical(); // 計算數字
        checkCountTotal(); // 檢核檢查碼
    }

    void firstWord() { // 計算英文
        // 英文轉成的數字, 個位數乘9再加上十位數
        int Singles, Ten;
        Singles = firstWord.get(strArray[0].toUpperCase()) % 10 * 9;
        Ten = firstWord.get(strArray[0].toUpperCase()) / 10;
        countTotal = Singles + Ten;

    }

    void otherNumerical() { // 計算數字
        for (int i = 1; i < 9; i++) {
            countTotal = countTotal + Integer.parseInt(strArray[i]) * (9 - i);
        }
    }

    void checkCountTotal() { // 檢核檢查碼
        // 總和除10後之餘數,用10減該餘數,結果就是檢查碼
        int lastNumerical;
        lastNumerical = countTotal % 10;
        lastNumerical = 10 - lastNumerical;
        if (lastNumerical == Integer.parseInt(strArray[9])) {
            message = str + " 檢核正確";
        } else {
            message = str + " 錯誤，檢查碼應為" + lastNumerical;
        }
    }

}
