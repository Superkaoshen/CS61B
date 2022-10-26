public class OffByN implements CharacterComparator{
    private int k = 0;
    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == k || x - y == -k){
            return true;
        }
        return false;
    }
    OffByN(int N){
        k = N ;
    }


}
