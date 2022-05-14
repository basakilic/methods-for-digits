/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
public class digits {

    public static void Menu(){
        System.out.println("- - - - - - - - - - - - - -");
        System.out.println("Digits Library Menu: ");
        System.out.println("- - - - - - - - - - - - - -");
        System.out.println("1. Least significant digit");
        System.out.println("2. ith digit");
        System.out.println("3. Sum of digits with limit");
        System.out.println("4. Count digits");
        System.out.println("5. Remove digitK");
        System.out.println("6. Remove digit with value");
        System.out.println("7. Generate random number");
        System.out.println("8. Reverse digits");
        System.out.println("9. Check palindrome");
        System.out.println("10. CharDigitSum");
        System.out.println("11. Quit");
        System.out.println("- - - - - - - - - - - - - -");
    }

    public static int digitZero1(int integer) {
        return integer % 10;
    }

    public static int digiti2(int integer, int digit) {
        int result = 0;
        if (digit == 0) {
            result = (integer % 10);
        } else if (digit == 1) {
            result = (integer / 10 % 10);
        } else if (digit == 2) {
            result = (integer / 100 % 10);
        } else if (digit == 3) {
            result = (integer / 1000 % 10);
        } else if (digit == 4) {
            result = (integer / 10000 % 10);
        } else if (digit == 5) {
            result = (integer / 100000 % 10);
        } else if (digit == 6) {
            result = (integer / 1000000 % 10);
        } else if (digit == 7) {
            result = (integer / 10000000 % 10);
        } else if (digit == 8) {
            result = (integer / 100000000 % 10);
        } else if (digit == 9) {
            result = (integer / 1000000000);
        } else {
            System.out.println("Entered number is not an integer !! ");
        }
        return result;
    }

    public static int digitLimitSum3(int integer, int limit){
        int sum = 0;
        while (integer != 0) {
            int checkDigit = integer % 10;
            if (limit < checkDigit)
                sum = sum + checkDigit;
            integer = integer / 10;
        }
        return sum;
    }

    public static int digitCount4(int integer,int howManyNumber){
        int count = 0;
        while (integer != 0) {
            int checkDigit = integer % 10;
            if(checkDigit == howManyNumber)
                count ++;
            integer = integer / 10;
        }
        return count;
    }

    public static int digitRemoveK5(int integer, int removingDigit){
        int newNumber = 0;
        int powIndex = 0;

        int a = integer;
        int digitCount=0;
        while (a > 0) {
            digitCount += 1;
            a = a / 10;
        }

        for (int i = 0; i <= digitCount ; i++) {
            if (i != removingDigit) {
                int remain = integer % 10;
                int pow = 1;
                for (int j = 0; j < powIndex; j++) {
                    pow *= 10;
                }
                powIndex++;

                newNumber += remain * pow;

            }
            integer /= 10;
        }

        return newNumber;
    }

    public static String digitRemove6(String integer, String removingNumber) {
        String newNumber = "";
        char testChar = removingNumber.charAt(0);
        for (int i = 0; i < integer.length(); i++) {
            if (integer.charAt(i) != testChar) {
                newNumber = newNumber + integer.charAt(i);
            }
        }
        return newNumber;
    }

    public static int randomNumber7(int digit) {
            int max = ((int) Math.pow(10, digit)) - 1;
            int min = (int) Math.pow(10, digit - 1);
            int generateRandom = (int) ((Math.random() * (max - min) + min));
            return generateRandom;
        }

    public static int reverse8(int integer){
        int rvs = 0;
        while(integer != 0) {
            rvs = rvs * 10;
            rvs = rvs + integer%10;
            integer = integer/10;
        }
        return rvs;
    }

    public static boolean isPalindrome9(int integer) {
        int newNumber = 0;
        int check = integer;
        while (integer != 0) {
            newNumber = newNumber * 10;
            newNumber = newNumber + integer % 10;
            integer = integer / 10;
        }
        if (newNumber == check) {
            return true;
        }else
            return false;
    }

    public static int CharDigitSum10(String str) {
        int sumOfLetters = 0;
        for (int i = 0; i < str.length(); i++){
            sumOfLetters =  sumOfLetters + (int)str.charAt(i) ;
            System.out.println((int)str.charAt(i) + "("+str.charAt(i)+")"); // just for testing
        }
        return sumOfLetters;
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;
        do {
        Menu();
        System.out.print("Choose action to perform : ");
        option = input.nextInt();

        // below part for taking options
        if(option==1){
            System.out.print("Enter an integer: ");
            int integer = input.nextInt();
            System.out.println("The least significant digit of " + integer+
                    " is " + digitZero1(integer)+ ".");

        }else if(option == 2){
            System.out.print("Enter an integer: ");
            int integer = input.nextInt();
            System.out.print("Enter digit (which you want to see):  ");
            int digit = input.nextInt();
            System.out.println(digit + "th digit of " + integer +
                    " is " + digiti2(integer,digit)+ ".");

        }else if (option == 3){
            System.out.print("Enter an integer: ");
            int integer = input.nextInt();
            System.out.print("Enter limit: ");
            int limit = input.nextInt();
            System.out.println("Sum of the digits : " +
                    digitLimitSum3(integer,limit) + " (bigger than " + limit + ")");

        }else if (option == 4){
            System.out.print("Enter a number: ");
            int integer = input.nextInt();
            System.out.print("Enter a number which you want to count: ");
            int howManyNumber = input.nextInt();
            System.out.println("There are '" + digitCount4(integer,howManyNumber)+
                    "' " + howManyNumber + " in " + integer + ".");

        }else if(option == 5) {
            System.out.print("Enter an integer: ");
            int integer = input.nextInt();
            System.out.print("Enter a digit which you want to remove: ");
            int remove = input.nextInt();
            System.out.println(digitRemoveK5(integer, remove));

        }else if (option == 6) {
            System.out.print("Enter an integer: ");
            String integer = input.next();
            System.out.print("Enter an number which you want to remove: ");
            String remove = input.next();
            System.out.println(digitRemove6(integer, remove));

        }else if( option == 7){
            System.out.print("Enter a digit: ");
            int digit = input.nextInt();
            System.out.println(randomNumber7(digit));


        }else if(option == 8){
            System.out.print("Enter a integer: ");
            int integer = input.nextInt();
            System.out.println(reverse8(integer));

        } else if (option == 9) {
            System.out.print("Enter a number to check palindrome or not: ");
            int integer = input.nextInt();
            if (isPalindrome9(integer))
                System.out.println(integer + " is a palindrome number. --> " + isPalindrome9(integer));
            if (!isPalindrome9(integer))
                System.out.println(integer + " is NOT a palindrome number. --> " + isPalindrome9(integer));

        }else if (option == 10){
            System.out.print("Enter a string: ");
            String str = input.next();
            System.out.println("The sum of characters is: "+ CharDigitSum10(str)+".");

        }else if (option!=11)
            System.out.println("Invalid option ! Please choose a valid option...");

        }while (option != 11);
        System.out.println("You choose 11 to exit, good bye. ");
    }
}