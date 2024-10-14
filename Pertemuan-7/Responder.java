import java.util.HashMap;
import java.util.Random;

public class Responder {
    private HashMap<String, String> responses;
    private Random random;

    public Responder() {
        responses = new HashMap<>();
        random = new Random();
        initializeResponses();
    }

    private void initializeResponses() {
        responses.put("slow", "Have you tried restarting your device?");
        responses.put("error", "Please check for software updates and reinstall the application.");
        responses.put("crashes", "It seems there may be a compatibility issue. Try reinstalling.");
        responses.put("network", "Please check your internet connection.");
        responses.put("freezing", "Try force-closing the application and reopening it.");
        responses.put("password", "Try resetting your password from the login screen.");
        responses.put("update", "Updates can sometimes cause issues. Try rolling back to a previous version.");
    }

    public String generateResponse(String input) {
        for(String keyword : responses.keySet()) {
            if(input.contains(keyword)) {
                return responses.get(keyword);
            }
        }
        return defaultResponse();
    }

    private String defaultResponse() {
        String[] genericResponses = {
            "That sounds interesting. Tell me more...",
            "Could you give more details?",
            "I'm here to help. What exactly seems to be the issue?",
            "Let's get to the bottom of this. Could you clarify your problem?"
        };
        return genericResponses[random.nextInt(genericResponses.length)];
    }
}