import java.util.LinkedList;
import java.util.Locale;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        System.out.println(checkForPalindrome("abccba"));
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?"));
        System.out.println(checkForPalindrome("I did, did I?"));
        System.out.println(checkForPalindrome("hello"));
        System.out.println(checkForPalindrome("Don't node"));

        System.out.println("*********");

        System.out.println(convertDecimalToBinary(13));
        System.out.println(convertDecimalToBinary(5));
        System.out.println(convertDecimalToBinary(6));
        System.out.println(convertDecimalToBinary(75));

    }

    public static boolean checkForPalindrome(String text) {

        LinkedList<Character> stack = new LinkedList<>();

        StringBuilder noPolidromeString = new StringBuilder();
        String lowerCase = text.toLowerCase();

        for (int i = 0; i <lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            //just for character
            if (c >= 'a' && c <= 'z'){
                noPolidromeString.append(c);
                stack.push(c);
            }
        }
        StringBuilder reserved = new StringBuilder();
        while (!stack.isEmpty()){
            reserved.append(stack.pop());
        }

        return noPolidromeString.toString().equals(reserved.toString());
    }

    public static boolean checkForPalindromeFIFO(String text) {
        //dad
        //d, a, d
        //d, a, d
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = text.toLowerCase(Locale.ENGLISH);

        for(int i = 0; i < lowerCase.length(); i++){
            char c = lowerCase.charAt(i);
            if(c >= 'a' && c <= 'z'){
                queue.addLast(c);
                stack.push(c);
            }
        }


        if(stack.equals(queue)){
            System.out.println("EQUAL");
        } else{
            System.out.println("NOT EQUAL");
        }

        while(!stack.isEmpty()){
            if(!stack.pop().equals(queue.removeFirst())){
                return false;
            }
        }

        return true;

    }

    public static String convertDecimalToBinary(int num){
        final int base = 2;
        Stack digits = new Stack();

        while(num > 0){
            //[1, 1, 0, 1]
            digits.push(num % base);
            num = num / base;
        }

        String bites = "";
        while (!digits.isEmpty()){
            bites += digits.pop();
        }
        digits.toString();
        return bites;
    }
}

