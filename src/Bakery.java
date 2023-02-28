class Bread {
        private int breadCount = 0;

        public synchronized void getBread(){
            while (breadCount < 1){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            breadCount--;
            System.out.println("Get one bread");
            System.out.println(breadCount + " bread remains");
            notify();
        }


        public synchronized void  putBread(){
            while (breadCount >= 5){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            breadCount++;
            System.out.println("Put one bread");
            System.out.println(breadCount + " bread remains");
            notify();
        }
    }

    class Producer implements  Runnable{
        Bread bread;

        Producer(Bread bread){
            this.bread = bread;
        }
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                bread.putBread();
            }
        }
    }

    class Consumer implements Runnable{
        Bread bread;

        Consumer(Bread bread){
            this.bread = bread;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                bread.getBread();
            }
        }
    }

    public class Bakery{
        public static void main(String[] args) {
            Bread bread = new Bread();
            Producer producer = new Producer(bread);
            Consumer consumer = new Consumer(bread);
            Thread thread1 = new Thread(producer);
            Thread thread2 = new Thread(consumer);

            thread1.start();
            thread2.start();

        }
    }

