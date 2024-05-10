import java.util.List;
import java.util.concurrent.BlockingQueue;

class CookThread extends Thread {
    private List<Food> foodList;
    private BlockingQueue<Food> foodQueue;

    public CookThread(List<Food> foodList, BlockingQueue<Food> foodQueue) {
        this.foodList = foodList;
        this.foodQueue = foodQueue;
    }

    @Override
    public void run() {
        for (Food food : foodList) {
            try {
                System.out.println("Start cooking: " + food.getName());
                Thread.sleep(food.getCookTime());
                System.out.println("End cooking: " + food.getName());
                System.out.println();
                foodQueue.put(food);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}