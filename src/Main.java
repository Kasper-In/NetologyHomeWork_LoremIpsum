import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final String LOREMINPUT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore"
            + "et dolore magna aliqua. Ut enim ad minim veniam, quis - nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. "
            + "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat "
            + "cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    //Метод возвращает максимальное среди количества раз
    public static int maxCountChar(Map<Character, Integer> map){
        int maxCount = -1;
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() > maxCount){
                maxCount = kv.getValue();
            }
        }
        return maxCount;
    }

    //Метод возвращает минимальное среди количества раз
    public static int minCountChar(Map<Character, Integer> map){
        int minCount = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> kv : map.entrySet()) {
            if (kv.getValue() < minCount){
                minCount = kv.getValue();
            }
        }
        return minCount;
    }

    public static void main(String[] args) {

        Map<Character, Integer> mapChar = new HashMap<>();

        //удаление пробелов и знаков припенания
        String lr = LOREMINPUT.replaceAll("[ -.,!?:;\'\"]", "");
        //привидение к общему регистру (нижнему)
        lr = lr.toLowerCase();

        //Составление Map: символ <-> количество раз
        for (int i = 0; i < lr.length(); i++) {
            char ch = lr.charAt(i);
            if (mapChar.containsKey(ch)){
                int count = mapChar.get(ch);
                count++;
                mapChar.put(ch,count);
            } else {
                mapChar.put(ch,1);
            }
        }

        //System.out.println(mapChar);

        int maxCount = maxCountChar(mapChar);
        int minCount = minCountChar(mapChar);

        //Поиск ключа (символа) по значению минимального (мксимального), вывод, если таких несколько

        System.out.print("Встречаются чаще всего: ");
        for (Map.Entry<Character, Integer> kv : mapChar.entrySet()){
            if (kv.getValue() == maxCount){
                System.out.print(kv.getKey() + " ");
            }
        }
        System.out.println();
        System.out.print("Встречаются реже всего: ");
        for (Map.Entry<Character, Integer> kv : mapChar.entrySet()){
            if (kv.getValue() == minCount){
                System.out.print(kv.getKey() + " ");
            }
        }

    }
}
