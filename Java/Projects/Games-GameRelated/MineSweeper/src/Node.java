public class Node {
    private boolean isClicked, isMine, shift;
    private int minesTouched=0;

    public Node(boolean isClicked, boolean isMine){
        this.isClicked = isClicked;
        this.isMine = isMine;
    }

    public boolean getIsClicked(){
        return this.isClicked;
    }

    public void setIsClicked(boolean c){
        isClicked = c;
    }

    public boolean getIsMine(){
        return this.isMine;
    }

    public void setShift(boolean s){
        this.shift = s;
    }

    public boolean getShift(){
        return this.shift;
    }

    public void setMinesTouched(int n){
        this.minesTouched = n;
    }

    public int getMinesTouched(){
        return this.minesTouched;
    }

    public String toString(){
        return isClicked+" "+isMine;
    }
}
