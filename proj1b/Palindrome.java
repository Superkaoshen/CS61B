public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++){
            dq.addLast(word.charAt(i));
        }
        return dq;
    }
    public boolean isPalindrome(String word) {
        // aaaiiiaaa
        int count = 0;
        int j = word.length() - 1;
        for (int i = 0; i < word.length()/2; i++){
            if (word.charAt(i) == word.charAt(j--)){
                    count ++;
            }
        }
        if (count == word.length()/2){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        int k = word.length();
        for (int i = 0; i < word.length()/2; i++) {
            if(!cc.equalChars(word.charAt(i),word.charAt(k - i - 1))){
                return false;
            }
        }
        return true;
    }

}
