package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();

    // code starting point
    int rated_Capacity=120;
    for(int present_Capacity:presentCapacities){
      double soh=(present_Capacity/(double) rated_Capacity)*100;

      if(soh>80){
        counts.healthy++;
        
      }
      else if(soh>=62 && soh<=80){
        counts.exchange++;
      }
      else{
        counts.failed++;
      }
        
      
    }

    
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
