public class Buy {
    public static void main(String[] args) {

    }
}
class Buyer extends Thread{
    int queue;

    public Buyer(int queue) {
        this.queue = queue;
        start();
    }

    @Override
    public void run() {

    }
}


