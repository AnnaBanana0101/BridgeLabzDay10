import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws Exception {
        System.out.println("WordCount");

        String text = "Paranoids are not\r\n" + //
                "paranoid because they are paranoid but\r\n" + //
                "because they keep putting themselves\r\n" + //
                "deliberately into paranoid avoidable\r\n" + //
                "situations";
        String[] words = format(text);

        HashMap<String, Integer> map = new HashMap<>();
        Map<Integer, Integer> wordIndex = indexWords(words);

        for(String word: words)
        {
            map.put(word, map.getOrDefault(word,0)+1);
        }

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            System.out.println("Key: " + entry.getKey() +"\t"+ " Value:" + entry.getValue());
        }

        String searchWord = "avoidable";
        int hash_code = searchWord.hashCode();
        int index;
        if(wordIndex.containsKey(hash_code))
        {
            index = wordIndex.get(hash_code);
            System.out.println(searchWord + ": " + index);
            words[index] = "";
            System.out.println("");

            String newString = String.join(" ", words);
            System.out.println(newString);
        }
        else
        {
            System.out.println("Not found");
        }

    }

    public static String[] format(String text)
    {
        String[] result = text.replace(".", "")
        .replace("?", "")
        .toLowerCase()
            .split("\\s");

        return result;
    }

    public static Map<Integer, Integer> indexWords(String[]words)
    {
        Map<Integer, Integer> wordIndex = new HashMap<>();

        for(int i=0; i<words.length; i++)
        {
            String word = words[i];
            int hash_code = word.hashCode();

            wordIndex.put(hash_code, i);
        }

        return wordIndex;
    }
}
