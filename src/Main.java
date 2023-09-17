import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int MAX_RANDOM_NUMBER = 10;
        int AMOUNT_OF_NUMBERS = 10;
        ArrayList<Integer> randomList = getRandomList(MAX_RANDOM_NUMBER, AMOUNT_OF_NUMBERS);
        HashMap<Integer, Integer> uniqueMap = new HashMap<>();
        getHashMap(randomList, uniqueMap);
        System.out.println(randomList);
        System.out.println(uniqueMap);
//        int highest = findHighestUnique(uniqueMap, MAX_RANDOM_NUMBER);
        int highest = findHighestUniqueForEach(uniqueMap);
        if (highest == -1){
            System.out.println("Det finns inga unika nummer.");
        }else {
            System.out.println("Det största unika numret är " + highest);
        }
    }

    static int findHighestUnique(HashMap<Integer, Integer> map, int max ){
        int highestValue = 0;

        for (int i = max; i >= 0; i--){
            if (map.containsKey(i)){
                if (map.get(i) == 1 )
                    return i;
            }
        }
        return -1;
    }



    static int findHighestUniqueForEach(HashMap<Integer, Integer> map) {
        int highestNum = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int timesSeen = entry.getValue();
//            System.out.println(num + " " + timesSeen + " " + highestNum);
            if (timesSeen == 1 && num > highestNum){
                highestNum = num;
            }
            timesSeen++;
            map.put(num, timesSeen);
        }
        return highestNum;
    }

    static ArrayList<Integer> getRandomList(int max, int amount){
        ArrayList<Integer> randomList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i <= amount; i++){
            randomList.add(rand.nextInt(max) +1);
        }
        return randomList;
    }

    static void getHashMap(ArrayList<Integer> randomList, HashMap<Integer, Integer> uniqueMap){
        for (int num: randomList) {
            if (uniqueMap.containsKey(num)){
                int timesSeen = uniqueMap.get(num);
                timesSeen++;
                uniqueMap.put(num, timesSeen);
            }else {
                uniqueMap.put(num, 1);
            }
        }
    }
}