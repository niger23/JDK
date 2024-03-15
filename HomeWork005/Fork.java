package HomeWork005;

public class Fork {
    private boolean free;
    public Fork() {
        this.free = true;
    }

    public boolean isFree() {
        return free;
    }
    public void takeFork() {
        free = false;
    }
    public void putFork() {
        free = true;
    }

}
