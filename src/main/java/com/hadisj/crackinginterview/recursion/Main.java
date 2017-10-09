package com.hadisj.crackinginterview.recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * All problems are from Cracking the Coding Interview - 6th Edition
 */
public class Main {

    /*
    Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps,
    or 3 steps at a time.  Implement a method to count how many possible ways the child can run up the
    stairs.
    2 interpretations:
    * Fixed: number of hops is provided and the function returns how many times the child hops to cover the staircase
    * Random: number of hops is random (1 - 3) and the function returns how many times the child hops to cover the staircase.  This
    * would require using a random method to determine how many times the child hops each time.  This doesn't appear to be the correct
    * interpretation on re-reading the problem.
     */

    public static void tripleStep(int steps) {
        int hops = 1;
        int hop1result = tripleStepWithHopCount(steps, hops);
        System.out.println("Number of hops for " +steps+ " steps when child takes " +hops+ " hops: " +hop1result);
        hops = 2;
        int hop2result = tripleStepWithHopCount(steps, hops);
        System.out.println("Number of hops for " +steps+ " steps when child takes " +hops+ " hops: " +hop2result);
        hops = 3;
        int hop3result = tripleStepWithHopCount(steps, hops);
        System.out.println("Number of hops for " +steps+ " steps when child takes " +hops+ " hops: " +hop3result);
    }

    /**
     * Add one hop for every time that the kid hops until he gets to the top of the staircase
     * Base case would be to stop counting and return 0 once he's reached the top
     * @param steps
     * @param hopCount
     * @return
     */
    public static int tripleStepWithHopCount(int steps, int hopCount) {
        int stepsLeft = steps - hopCount;
        if (steps <= 0) {
            return 0;
        }
        else {
            return 1 + tripleStepWithHopCount(stepsLeft, hopCount);
        }
    }

    /**
     * Recursive Multiply: Write a recursive function to multiply two numbers without the * operator.  You can
     * use addition, subtraction, and bit shifting, but you should minimize the number of those operations.
     * Strategy: Add x to itself y times.  Decrement y on each call of the recursive function until you hit 0.
     * Base case: y is 0 and the function should return 0.
     */
    public static int recursiveMultiply(int x, int y, int tempResult) {
        if (y == 0) {
            return tempResult;
        }

        tempResult = tempResult + x;
        y--;
        return recursiveMultiply(x, y, tempResult);
    }

    public static int recursiveMultiply2(int x, int y) {

        if (y == 0) {
            return 0;
        }

        y--;

        int t = x + recursiveMultiply2(x, y);

        return t;
    }


    /**
     * Towers of Hanoi: In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different sizes
     * which can slide onto any tower.  The puzzle starts with disks sorted in ascending order of size from top to bottom
     * (i.e. each disks sits on top of an even larger one).
     * The third tower is empty at the beginning.  Need to move things back and forth with push and pop.
     * You have the following constraints:
     * (1) Only one disk can be moved at a time.
     * (2) A disk is slid off the top of one tower onto the next tower.
     * (3) a disk can only be placed on top of a larger disk.
     * Write program to move the disks from the first tower to the last using stacks.
     *
     */
    /**
     *
     * @param sourceStackIndex Position in list of towers that the source tower is in
     * @param sizeSourceStack The size of the source tower
     * @param sourceDiskIndex The position of the source disk (the one we want to move from source tower)
     * @param sizeSourceDisk The size of the source disk
     * @param targetDiskIndex The current position in the target tower (this will increment until we find
     *                        the right position.  The right position is either above a disk with greater size or the bottom of the tower
     * @param sizeTargetStack The size of the target tower
     * @param towers List of towers
     */
    void moveDisk(int sourceStackIndex, int sizeSourceStack, int sourceDiskIndex, int sizeSourceDisk
        , int targetDiskIndex, int sizeTargetStack, List<LinkedList<Disk>> towers) {

        if (sizeSourceStack == 0) {
            return;
        }

        //The last tower can't be a source of disks, so we exit
        if (sourceStackIndex  == 2) {
            return;
        }

        //Check if we've emptied the current source tower and need to move on to the next tower
        if (sourceDiskIndex > sizeSourceStack - 1) {
            //Determine size of next target stack
            sizeSourceDisk = (towers.get(sourceStackIndex+1)).size();
            //Move on to next tower as a source; may want to consider doing a stack.pop() call to take disk from source tower
            moveDisk(sourceStackIndex + 1, sizeSourceStack, 0, -1, 0, -1, towers);
        }

        //We're still working with the same source tower
        if (sizeSourceStack == -1) {
            sizeSourceStack = towers.get(sourceStackIndex).size();
            /*
            if (sizeSourceStack == 0) {
                return;
            }
            */
        }

        if (sizeSourceDisk == -1) {
            if (sizeSourceStack > 0)
                if (sourceStackIndex < towers.size() - 2)
                    sizeSourceDisk = (towers.get(sourceStackIndex)).get(sourceDiskIndex).getSize();
                //sizeSourceDisk = (towers.get(sourceStackIndex)).get(sourceDiskIndex).getSize();

        }

        //Get target tower
        LinkedList<Disk> targetTower = towers.get(sourceStackIndex+1);

        //get size of target disk
        int sizeTargetDisk = targetTower.get(targetDiskIndex).getSize();
        //See if disk can be moved from tower to this position in target tower; or clause covers case
        //where target tower is empty
        if (sizeSourceDisk <= sizeTargetDisk || targetTower.peek() == null) {
            System.out.println("Source stack index: " +sourceStackIndex+ "; sourceDiskIndex: " +sourceDiskIndex+ "; sizeSourceDisk: " +sizeSourceDisk);
            Disk diskToMove = towers.get(sourceStackIndex).pop();
            targetTower.add(targetDiskIndex, diskToMove);
            //Adjust stack sizes
            sizeSourceStack--;
            sizeTargetStack++;
            sourceDiskIndex--;
            if (sourceDiskIndex < 0) {
                sourceDiskIndex = 0;
                sizeSourceStack = towers.get(sourceStackIndex).size();
            }

            moveDisk(sourceStackIndex, sizeSourceStack, sourceDiskIndex, -1, targetDiskIndex+1, sizeTargetStack, towers);
        } else {
            //Keep trying to find the right position in the target tower
            targetDiskIndex++;
            moveDisk(sourceStackIndex, sizeSourceStack, sourceDiskIndex, sizeSourceDisk, targetDiskIndex, sizeTargetStack, towers);
        }
    }

    /**
     * Used for the Towers of Hanoi problem to initialize the stacks with data (in ascending order)
     * @param numberOfTowers
     * @return
     */
    public List prepTowers(int numberOfTowers) {
        List<LinkedList<Disk>> towers = new ArrayList(3);
        LinkedList tower = new LinkedList();
        for (int i = 20; i < 40; i += 3) {
            Disk d = new Disk(i);
            tower.add(d);
        }
        towers.add(tower);
        tower = new LinkedList();
        for (int i = 10; i < 100; i += 5) {
            Disk d = new Disk(i);
            tower.add(d);
        }
        towers.add(tower);
        tower = new LinkedList();
        for (int i = 1; i < 200; i += 3) {
            Disk d = new Disk(i);
            tower.add(d);
        }
        towers.add(tower);
        System.out.println("Towers have been initialized.  Content of each tower.");
        printTowers(towers);
        return towers;
    }

    public void printTowers(List<LinkedList<Disk>> towers) {
        LinkedList<Disk> tower = null;
        for (int towersIndex = 0; towersIndex < towers.size(); towersIndex++) {
            System.out.print("Tower " + (towersIndex + 1) + ": ");
            tower = towers.get(towersIndex);
            if (tower.size() > 0) {
                for (int i = 0; i < tower.size(); i++) {
                    //System.out.print(((Disk)tower.get(i)).getSize());
                    System.out.print((tower.get(i)).getSize());
                    if (i < tower.size() - 1)
                        System.out.print(", ");
                    else
                        System.out.println();
                }
            } else
                System.out.println("");
        }
    }

    class Disk {
        Disk(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        int size;

    }

    /**
     Given an array, return true if there are any 2 consecutive elements where the 2nd element
     is 10 times the value of the 1st element.
     * @param nums
     * @param index
     * @return
     */
    public boolean array220(int[] nums, int index) {
        boolean result = false;
        if (nums.length == 0 || index > nums.length - 2)
            return result;

        double factor = 0.0;
        double numDbl = nums[index + 1];
        double divisorDbl = nums[index];
        factor = numDbl / divisorDbl;
        if (divisorDbl * 10 == numDbl)
            factor = 10.0;

        if (factor == 10.0)
            result = true;
        else
            result = array220(nums, index + 1);

        return result;
    }

    /**
     * Count the number of times that "hi" is found in a string
     * e.g. lowhihilhi -> word appears 3 times
     * @param str
     * @return
     */
    public int countHi(String str) {
        int result = 0;

        if (str.length() < 2)
            return result;
        if (str.startsWith("hi"))
            result++;
        result = result + countHi(str.substring(1, str.length()));

        return result;
    }

    /**
     * Given a string, change all instances of x to y
     * @param str
     * @return
     */
    public String changeXY(String str) {
        String result = str;
        int pos = str.indexOf("x");
        if (pos < 0)
            return result;

        result = str.substring(0, pos) + "y" + str.substring(pos+1, str.length());
        result = changeXY(result);
        return result;
    }

    /**
     * Given a string, put "*" characters between all characters
     * @param str
     * @return
     */
    public String allStar(String str) {
        if (str.length() < 2)
            return str;
        if (str.charAt(str.length()-2) == '*')
            return str;
        int pos = str.lastIndexOf("*");

        String result;
        result = str.substring(0, pos+2) + "*" + str.substring(pos+2,str.length());
        result = allStar(result);
        return result;
    }

    /**
     * Given a string, replace all consecutive duplicated characters with just one character
     * Example: hhohh -> hoh
     * @param str
     * @return
     */
    public String stringClean(String str) {
        if (str.length() <= 1)
            return str;
        String tmp;
        if (str.charAt(0) == str.charAt(1))
            tmp = str.substring(0,0);
        else
            tmp = str.substring(0,1);

        str = tmp + stringClean(str.substring(1));

        return str;
    }

    /**
     * Given a string, if the substring is spread out in it, give the distance between the first and
     * last char.
     * @param str the given string
     * @param sub the substring that may be embedded in the string
     *            Example: String: "abcoorde", substring: "ode" -> returns 5
     * @return
     */
    public int strDist(String str, String sub) {
      int result = 0;
      if (sub.length() == 0) {
        result = str.length();
        if (str.length() == 0) {
          return 0;
        }
        return result;
      }

      if (sub.length() > 1) {
        int pos = str.indexOf(sub.charAt(0));
        if (pos < 0) {
          str = "";
          sub = "";
        } else {
          //str = str.substring(pos, str.length());
          sub = sub.substring(1,sub.length());
        }
      } else {
        int pos = str.lastIndexOf(sub.charAt(0));
        str = str.substring(0, pos+1);
        sub = "";
      }
      result = result + strDist(str, sub);
      return result;
    }

    public boolean nestParen(String str) {
        boolean result = false;
        if (str.length() == 0)
            return false;

        char start = str.charAt(0);
        char end = str.charAt(str.length()-1);

        if (start == '(') {
            if (end == ')' ) {
                str = str.substring(0,str.length()-2);
                result = true;
            } else {
                result = false;
            }
        }

        if (str.length() > 1)
            str = str.substring(1,str.length()-1);

        return result && nestParen(str);
    }

    public int factorial(int n) {
        if (n == 1)
            return 1;

        return n * factorial(n-1);
    }


    public List<String> concatenateLists(int startIndexList1, int endIndexList1, int startIndexList2, int endIndexList2) {
        ArrayList<String> list1 = new ArrayList<String>();

        //Addition of elements in ArrayList
        list1.add("Steve");
        list1.add("Justin");
        list1.add("Ajeet");
        list1.add("John");
        list1.add("Arnold");
        list1.add("Chaitanya");

        ArrayList<String> list2 = new ArrayList<String>();

        //Addition of elements in ArrayList
        list2.add("Bob");
        list2.add("Bill");
        list2.add("Oneida");

        List<String> newList = new ArrayList<>();
        newList.addAll(list1.subList(startIndexList1, endIndexList1));
        newList.addAll(list2.subList(startIndexList2, endIndexList2));

        return newList;
    }

    public static void main(String[] args) {
        //Triple Step: Problem from book
        tripleStep(3);
        int x = 3;
        int y = 4;

        //Recursive Multiple: Problem from book
        int result = recursiveMultiply(x, y, 0);
        System.out.println(x+ " times " +y+ " is " +result);

        result = recursiveMultiply2(x, y);
        System.out.println(x+ " times " +y+ " is " +result);

        x = 9;
        y = 8;
        result = recursiveMultiply(x, y, 0);
        System.out.println(x+ " times " +y+ " is " +result);

        //Towers of Hanoi with a twist
        Main m = new Main();
        List<LinkedList<Disk>> towers = m.prepTowers(3);
        int sizeSourceStack = towers.get(0).size();
        m.moveDisk(0, sizeSourceStack, 0, -1, 0, -1, towers);
        System.out.println("Contents of towers after moving disks from first tower to last.");
        m.printTowers(towers);

        //Setup for array220 method
        //int nums[] = {1,2,20,4,13};
        int nums[] = {20, 2, 21};
        //int nums[] = {0, 0};
        boolean res = m.array220(nums,0);
        System.out.println("Array220 result: "+ res);
        String countHiInput = "lowLowhiHihihilowhi";
        System.out.println("countHi - number of times that \"hi\" is in " +countHiInput+ " "+
            m.countHi(countHiInput));
        String changeXYinput = "xoloxyyx";
        System.out.println("changeXY - input: "+changeXYinput+ " -> " +m.changeXY(changeXYinput));
        changeXYinput = "ayayaya";
        System.out.println("changeXY - input: "+changeXYinput+ " -> " +m.changeXY(changeXYinput));

        String allStartInput = "hello";
        System.out.println("allStar - input: " +allStartInput+ " -> " +m.allStar(allStartInput));

//        String strDistInputString = "catcowcat";
//        String strDistInputSubstring = "cat";
        String strDistInputString = "abccatcowcatcatxyz";
        String strDistInputSubstring = "cat";
        System.out.println("strDist - input string : " +strDistInputString+ " , substring: " +
                strDistInputSubstring+ " -> " +m.strDist(strDistInputString, strDistInputSubstring));

        System.out.println("Factorial of 4: " +m.factorial(4) );

        System.out.println("Concatenate parts of lists: "+ m.concatenateLists(2, 4, 1, 2));
    }
}
