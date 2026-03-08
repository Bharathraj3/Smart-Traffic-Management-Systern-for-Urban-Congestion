<!DOCTYPE html>
<html>
<body>
 <h1>Smart Traffic Management</h1>
 <div id="trafficLights">
 <div>Lane 1: <span id="lane1">RED (30s)</span></div>
 <div>Lane 2: <span id="lane2">RED (30s)</span></div>
 </div>

 <script>
 let lane1 = { status: "RED", timer: 30 };
 let lane2 = { status: "RED", timer: 30 };

 setInterval(() => {
 updateLights();
 }, 1000);

 function updateLights() {
 lane1.timer--;
 lane2.timer--;
 document.getElementById("lane1").textContent = `${lane1.status} (${lane1.timer}s)`;
 document.getElementById("lane2").textContent = `${lane2.status} (${lane2.timer}s)`;

 if (lane1.timer <= 0) updateLane(lane1);
 if (lane2.timer <= 0) updateLane(lane2);
 }

 function updateLane(lane) {
 if (lane.status === "RED") {
 lane.status = "GREEN";
 lane.timer = 30;
 } else if (lane.status === "GREEN") {
 lane.status = "YELLOW";
 lane.timer = 5;
 } else {
 lane.status = "RED";
 lane.timer = 30;
 }
 }
 </script>
</body>
</html>
