import java.util.Random;

public class Call {
    public static void main(String[] args) {
      Call call = new Call();
      ViberCall viberCall = new ViberCall(101,call);
      WhatsAppCall whatsAppCall = new WhatsAppCall(102, call);
      SkypeCall skypeCall = new SkypeCall(103, call);
    }
}

class ViberCall extends Thread{
    int number;
    Call call;
    ViberCall(int number, Call call){
        this.number = number;
        this.call = call;
        start();
    }

    @Override
    public void run() {
        synchronized (call) {
            Random random = new Random();
            System.out.println("Waiting for response... " + number);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Viber call started");
            try {
                sleep(random.nextInt((5000) + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Viber call ended");
        }
    }
}

class WhatsAppCall extends Thread{
    int number;
    Call call;
    WhatsAppCall(int number, Call call){
        this.call = call;
        this.number = number;
        start();
    }

    @Override
    public void run() {
        synchronized (call) {
            Random random = new Random();
            System.out.println("Waiting for response... " + number);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("What`s App call started");
            try {
                sleep(random.nextInt((5000) + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("What`s App call ended");
        }
    }
}

class SkypeCall extends Thread{
    int number;
    Call call;
    SkypeCall(int number, Call call){
        this.call = call;
        this.number = number;
        start();
    }

    @Override
    public void run() {
        synchronized (call) {
            Random random = new Random();
            System.out.println("Waiting for response... " + number);
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call started");
            try {
                sleep(random.nextInt((5000) + 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Skype call ended");
        }
    }
}
