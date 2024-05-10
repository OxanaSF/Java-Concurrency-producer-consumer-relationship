import java.util.concurrent.BlockingQueue;

class ServeThread extends Thread {
    private BlockingQueue<Food> foodQueue;
    private int foodsToServe;

    public ServeThread(BlockingQueue<Food> foodQueue, int foodsToServe) {
        this.foodQueue = foodQueue;
        this.foodsToServe = foodsToServe;
    }

    @Override
    public void run() {
        for (int i = 0; i < foodsToServe; i++) {
            try {
                Food food = foodQueue.take();
                System.out.println("Start serving: " + food.getName());
                Thread.sleep(food.getServeTime());
                System.out.println("End serving " + food.getName());
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}