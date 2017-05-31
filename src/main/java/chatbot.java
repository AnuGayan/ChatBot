import ai.api.AIConfiguration;
import ai.api.AIDataService;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chatbot {
    private static final String INPUT_PROMPT = "> ";
    /**
     * Default exit code in case of error
     */
    private static final int ERROR_EXIT_CODE = 1;
    private static final String apiKey="e6654945e7f040b2bc73f551f2ecd691";
    public static void main(String[] args){
        AIConfiguration configuration = new AIConfiguration(apiKey);
        AIDataService dataService= new AIDataService(configuration);

        String line;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(INPUT_PROMPT);
            while (null != (line = reader.readLine())) {

                try {
                    AIRequest request = new AIRequest(line);

                    AIResponse response = dataService.request(request);


                    System.out.println(response.getResult().isActionIncomplete());
                    System.out.println(response.getResult().getParameters());



                    if (response.getStatus().getCode() == 200) {
                        if(!response.getResult().isActionIncomplete() && response.getResult().getParameters().size()==3)

                        System.out.println(response.getResult().getFulfillment().getSpeech());

                    } else {
                        System.err.println(response.getStatus().getErrorDetails());
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                System.out.print(INPUT_PROMPT);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("See ya!");
    }


    /**
     * Output application usage information to stdout and exit. No return from function.
     *
     * @param errorMessage Extra error message. Would be printed to stderr if not null and not empty.
     *
     */
    private static void showHelp(String errorMessage, int exitCode) {
        if (errorMessage != null && errorMessage.length() > 0) {
            System.err.println(errorMessage);
            System.err.println();
        }

        System.out.println("Usage: APIKEY");
        System.out.println();
        System.out.println("APIKEY  Your unique application key");
        System.out.println("        See https://docs.api.ai/docs/key-concepts for details");
        System.out.println();
        System.exit(exitCode);
    }
}


