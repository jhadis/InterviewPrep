package com.hadisj.misc.translator;

/**
 * Created by Jonathan on 1/26/2016.
 * Build an application that converts a whole number to its English equivalent.
 * This should cover all integers from 1 to 1000000
 * Example- input: 14, output: "Fourteen"
 * Example- input: 14231, output: "Fourteen-thousand two-hundred thirty-one"
 */
public class NumberTranslator {

    String[] numberDictionary = new String[1000001];

    public NumberTranslator() {
        initializeDictionary();
    }

    private void initializeDictionary() {
        numberDictionary[1] = "One";
        numberDictionary[2] = "Two";
        numberDictionary[3] = "Three";
        numberDictionary[4] = "Four";
        numberDictionary[5] = "Five";
        numberDictionary[6] = "Six";
        numberDictionary[7] = "Seven";
        numberDictionary[8] = "Eight";
        numberDictionary[9] = "Nine";
        numberDictionary[10] = "Ten";
        numberDictionary[11] = "Eleven";
        numberDictionary[12] = "Twelve";
        numberDictionary[13] = "Thirteen";
        numberDictionary[14] = "Fourteen";
        numberDictionary[15] = "Fifteen";
        numberDictionary[16] = "Sixteen";
        numberDictionary[17] = "Seventeen";
        numberDictionary[18] = "Eighteen";
        numberDictionary[19] = "Nineteen";
        numberDictionary[20] = "Twenty";
        numberDictionary[30] = "Thirty";
        numberDictionary[40] = "Forty";
        numberDictionary[50] = "Fifty";
        numberDictionary[60] = "Sixty";
        numberDictionary[70] = "Seventy";
        numberDictionary[80] = "Eighty";
        numberDictionary[90] = "Ninety";
        numberDictionary[100] = "-Hundred";
        numberDictionary[1000] = "-Thousand";
        numberDictionary[1000000] = "-Million";
    }

    /*
    String translate(int numberToTranslate) {
        String result = null;
        //First figure out how many digits the number has.
        int numberOfDigits = 0;
        int temp = numberToTranslate;
        while (temp > 0) {
            temp = temp / 10;
            numberOfDigits++;
        }

        //Get first digit's value
        int leadingDigit = numberToTranslate / (10 ^ (numberOfDigits-1));
        int lastDigit = numberToTranslate % 10;

        if (numberOfDigits == 1 || (numberOfDigits == 2 && leadingDigit == 1)) {
            result = numberDictionary[numberToTranslate];
        } else if (numberOfDigits == 2 && leadingDigit > 1) {
            //Check if number ends in 0 or non-zero
            if (numberToTranslate / 10 == 0) {
                result = numberDictionary[numberToTranslate];
            } else {
                int t = leadingDigit * 10;
                result = numberDictionary[t] + "-" + numberDictionary[lastDigit];
            }
        } //Add logic for numbers > 99
        else if (numberToTranslate >= 100 && numberToTranslate < 1000) {
            result = numberDictionary[leadingDigit]+ "-" +numberDictionary[100];

        } else if (numberToTranslate >= 1000 && numberToTranslate < 10000) {

        } else if (numberToTranslate >= 10000 && numberToTranslate < 100000) {

        } else if (numberToTranslate >= 100000 && numberToTranslate < 1000000) {

        }

        return result;
    }*/

    String translate(int numberToTranslate) {
        String result = null;
        //First figure out how many digits the number has.
        int numberOfDigits = 0;
        int temp = numberToTranslate;
        while (temp > 0) {
            temp = temp / 10;
            numberOfDigits++;
        }

        //Get first digit's value
        //int leadingDigit = numberToTranslate / Math.pow(10.0, numberOfDigits-1);
        double leadingDigitDouble = numberToTranslate / Math.pow(10.0, numberOfDigits-1);
        int leadingDigit = new Double(leadingDigitDouble).intValue();

        int lastDigit = numberToTranslate % 10;

        if (numberOfDigits == 1 || (numberOfDigits == 2 && leadingDigit == 1)) {
            result = numberDictionary[numberToTranslate];
            return result;
        } else if (numberOfDigits == 2 && leadingDigit > 1) {
            //Check if number ends in 0 or non-zero
            if (numberToTranslate / 10 == 0) {
                result = numberDictionary[numberToTranslate];
                return result;
            } else {
                int t = leadingDigit * 10;
                result = numberDictionary[t] + "-" + numberDictionary[lastDigit];
                return result;
            }
        } //Add logic for numbers from 100 to 999
        else if (numberToTranslate >= 100 && numberToTranslate < 1000) {
            result = numberDictionary[leadingDigit]+numberDictionary[100];

            //subtract the value that's been translated
            int t = leadingDigit * 100;
            t = numberToTranslate - t;
            result = result +" " +translate(t);

        } else if (numberToTranslate >= 1000 && numberToTranslate < 99999) {
            result = numberDictionary[leadingDigit]+numberDictionary[1000];

            int t = leadingDigit * 1000;
            t = numberToTranslate - t;
            result = result +" " +translate(t);
        } else if (numberToTranslate >= 10000 && numberToTranslate < 100000) {
            /*
            result = numberDictionary[leadingDigit]+numberDictionary[1000];


            int t = leadingDigit * 1000;
            t = numberToTranslate - t;
            result = result +" " +translate(t);
             */
            double multiplier = Math.pow(10, numberOfDigits);
            int multiplierInt = new Double(multiplier).intValue();
            result = numberDictionary[leadingDigit]+numberDictionary[multiplierInt];

            int t = leadingDigit * multiplierInt;
            t = numberToTranslate - t;
            result = result+ " " +translate(t);
        } else if (numberToTranslate >= 100000 && numberToTranslate < 1000000) {
            result = numberDictionary[leadingDigit]+numberDictionary[1000];

            int t = leadingDigit * 1000;
            t = numberToTranslate - t;
            result = result +" " +translate(t);
        }

        return result;
    }

    String translate3(int numberToTranslate) {
        String result = null;
        //First figure out how many digits the number has.
        int numberOfDigits = 0;
        int temp = numberToTranslate;
        while (temp > 0) {
            temp = temp / 10;
            numberOfDigits++;
        }

        //Get first digit's value
        //int leadingDigit = numberToTranslate / Math.pow(10.0, numberOfDigits-1);
        //Depending on number of digits, we either want the first digit or the first two digits
        int digitsFromBeginning = -1;
        if (numberOfDigits == 5 || numberOfDigits == 8 || numberOfDigits == 11) {
            digitsFromBeginning = -2;
        }
        double leadingDigitsDouble = Math.pow(numberToTranslate, digitsFromBeginning);
        int leadingDigit = new Double(leadingDigitsDouble).intValue();
        /*
        double leadingDigitDouble = numberToTranslate / Math.pow(10.0, numberOfDigits-1);
        int leadingDigit = new Double(leadingDigitDouble).intValue();
        */

        int lastDigit = numberToTranslate % 10;

        result = numberDictionary[leadingDigit];
        if (numberOfDigits < 2)
            return result;

        if (numberOfDigits == 3) {
            result = result+ numberDictionary[100];
        } else if (numberOfDigits >=4 && numberOfDigits <= 6) {
            result = result+ numberDictionary[1000];
        } else if (numberOfDigits >=7 && numberOfDigits <= 9) {
            result = result+ numberDictionary[1000000];
        }

        double tempDouble = numberToTranslate - leadingDigit * Math.pow(10,numberOfDigits-1);
        temp = new Double(tempDouble).intValue();

        result = result + translate3(temp);

    return result;

    }

    public static void main(String[] args) {
        NumberTranslator translator = new NumberTranslator();
        int input = 19901;
        //String translatedNumber = translator.translate(input);
        String translatedNumber = translator.translate3(input);
        System.out.println("Input: " +input+ "; Output: " +translatedNumber);
    }
}
