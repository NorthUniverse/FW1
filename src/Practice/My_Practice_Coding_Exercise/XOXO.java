package Practice.My_Practice_Coding_Exercise;

public class XOXO {
    public static void main(String[] args) {
        callMethod(4,3);
    }

    public static void callMethod(int x, int y) {
        for(int i = 0; i < x; i++) {

            if(i%2 == 0) {
                for(int j = 0; j < y; j++) {
                    if(j%2 == 0) {
                        System.out.print("X");
                    }
                    else {
                        System.out.print("O");
                    }
                }
            } else if (i%2 != 0) {
                for(int j = 0; j < y; j++) {
                    if(j%2 == 0) {
                        System.out.print("O");
                    }
                    else {
                        System.out.print("X");
                    }
                }
            }

            System.out.println("");
        }
    }
}
