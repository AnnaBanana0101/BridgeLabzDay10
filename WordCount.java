import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws Exception {
        System.out.println("WordCount");

        String text = "To be or not to be";
        String[] words = format(text);

        HashMap<String, Integer> map = new HashMap<>();

        for(String word: words)
        {
            map.put(word, map.getOrDefault(word,0)+1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            System.out.println("Key: " + entry.getKey() + " Value:" + entry.getValue());
        }

    }

    public static String[] format(String text)
    {
        String[] result = text.replace(".", "")
        .toLowerCase()
            .split(" ");

        return result;
    }
}
