package model;

public class ChallengeResponse {

    private String actualPIN;
    private PinMapper mapper;       // randomized mapping

    public ChallengeResponse(String pin, PinMapper mapper) {
        this.actualPIN = pin;
        this.mapper = mapper;
    }

    // Convert actual PIN (e.g., 12345) → mapped numbers (e.g., 23113)
    public String getExpectedResponse() {
        int[] map = mapper.getMapping();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < actualPIN.length(); i++) {
            int digit = actualPIN.charAt(i) - '0';
            sb.append(map[digit]);
        }

        return sb.toString();
    }

    // Check if user entered correct response
    public boolean authenticate(String userInput) {
        return userInput.equals(getExpectedResponse());
    }
}
