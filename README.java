 import java.util.Timer;
import java.util.TimerTask;

class TrafficLight {
 String status;
 int timer;

 TrafficLight(String status, int timer) {
 this.status = status;
 this.timer = timer;
 }

 void updateLight() {
 System.out.println("Lane: " + status + " (" + timer + "s)");
 if (status.equals("RED")) {
 status = "GREEN";
 timer = 30;
 } else if (status.equals("GREEN")) {
 status = "YELLOW";
 timer = 5;
 } else {
 status = "RED";
 timer = 30;
 }
 }
}

public class SmartTrafficSystem {
 public static void main(String[] args) {
 TrafficLight lane1 = new TrafficLight("RED", 30);
 TrafficLight lane2 = new TrafficLight("RED", 30);

 Timer timer = new Timer();
 timer.scheduleAtFixedRate(new TimerTask() {
 public void run() {
 lane1.timer--;
 lane2.timer--;
 System.out.println("\nTraffic Status:");
 System.out.println("Lane 1: " + lane1.status + " (" + lane1.timer + "s)");
 System.out.println("Lane 2: " + lane2.status + " (" + lane2.timer + "s)");
 
 if (lane1.timer <= 0) lane1.updateLight();
 if (lane2.timer <= 0) lane2.updateLight();
 }
 }, 0, 1000); // 1-second interval
 }
}
