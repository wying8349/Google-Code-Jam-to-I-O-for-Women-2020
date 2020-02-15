import java.util.Scanner;

public class SolutionOne {
    private String input;

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        int testNum = Integer.parseInt(inputScanner.nextLine());
        for (int i = 1; i <= testNum; i ++){
            String testCase = inputScanner.nextLine();
            int IONum = calculateIO(testCase);
            System.out.println("Case #" + i + ": " + IONum);
        }
    }

    private static int calculateIO(String s) {
        String A,B,C,D;
        int I = 0,i = 0,O = 0,o = 0;
        int count = 0;
        int flagLength = s.length()/2;
        String[] Iflag; Iflag = new String[flagLength];
        int IflagCount = -1, OflagCount = -1, ioFlag = 0;
        char ch[] = s.toCharArray();
        int k;
        for (k = 0; k < ch.length; k ++) {
            if (ch[k] == 'I'){
                IflagCount ++;
                Iflag[IflagCount] = "I";
            }
            if (ch[k] == 'O' && OflagCount < IflagCount){
                OflagCount ++;
                Iflag[OflagCount] = "IO";
            }
            if (ch[k] == 'i'){
                ioFlag ++;
            }
            if (ch[k] == 'o'){
                if (ioFlag > 0){
                    ioFlag --;
                } else {
                    IflagCount --;
                }
            }
        }
        for (String str : Iflag){
            if (str == "IO"){
                count ++;
            }
        }
        return count;
    }
}
