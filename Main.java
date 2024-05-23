/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/*DO NOT CHANGE ANYTHING ABOVE THIS LINE*/
/*You may add any imports here, if you wish, but only from the standard library */
/*Do not add a namespace declaration */
public class Main {
    public static List<String> processData(ArrayList<String> lines) {
        Map<String, Map<String, Integer>> athleteBestTimes = new HashMap<>();
        Map<String, Set<String>> athleteEvents = new HashMap<>();

        for (String line : lines) {
            String[] fields = line.split(", ");
            String athleteId = fields[0];
            String name = fields[1];
            String eventName = fields[2];
            int time = Integer.parseInt(fields[3]);
            int points = Integer.parseInt(fields[4]);

            athleteBestTimes.putIfAbsent(athleteId, new HashMap<>());
            athleteEvents.putIfAbsent(athleteId, new HashSet<>());

            athleteBestTimes.get(athleteId).put(eventName,
                    Math.min(athleteBestTimes.get(athleteId).getOrDefault(eventName, Integer.MAX_VALUE), time));

            athleteEvents.get(athleteId).add(eventName);
        }

        Map<String, Integer> eventBestTimes = new HashMap<>();

        for (Map<String, Integer> times : athleteBestTimes.values()) {
            for (Map.Entry<String, Integer> entry : times.entrySet()) {
                String event = entry.getKey();
                int time = entry.getValue();
                eventBestTimes.put(event, Math.min(eventBestTimes.getOrDefault(event, Integer.MAX_VALUE), time));
            }
        }

        Set<String> fastestAthletes = new HashSet<>();

        for (String athleteId : athleteBestTimes.keySet()) {
            Map<String, Integer> times = athleteBestTimes.get(athleteId);
            boolean isFastest = true;
            for (String event : athleteEvents.get(athleteId)) {
                if (!times.get(event).equals(eventBestTimes.get(event))) {
                    isFastest = false;
                    break;
                }
            }
            if (isFastest) {
                fastestAthletes.add(athleteId);
            }
        }

        List<String> result = new ArrayList<>();
        Set<String> addedNames = new HashSet<>();

        // Collect the names of the fastest athletes
        for (String athleteId : fastestAthletes) {
            for (String line : lines) {
                if (line.startsWith(athleteId + ", ")) {
                    String name = line.split(", ")[1];
                    if (!addedNames.contains(name)) {
                        result.add(name);
                        addedNames.add(name);
                    }
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> inputData = new ArrayList<>(Arrays.asList(
                "2451, Mansi Sharma, Pune Womens 100m, 12750, 907",
                "2561, Hargun Sandhu, Delhi Womens 100m, 13890, 746",
                "2611, Sayeda Zeba, Pune Womens 100m, 13230, 713",
                "4936, Nikita Tiwari, Delhi Womens 100m, 12010, 973",
                "2768, Sohini Nair, Kolkata Womens 100m, 14230, 684",
                "2451, Mansi Sharma, Delhi Womens 100m, 13280, 810",
                "2451, Mansi Sharma, Indore Womens 100m, 13060, 850",
                "3292, Anjali Joshi, Pune Womens 100m, 12750, 882",
                "2768, Sohini Nair, Indore Womens 100m, 13060, 850",
                "4936, Nikita Tiwari, Indore Womens 100m, 13060, 850"
        ));

        List<String> retVal = processData(inputData);
        PrintWriter output = new PrintWriter(System.out);
        for (String str : retVal) {
            output.println(str);
        }
        output.close();
    }
}
