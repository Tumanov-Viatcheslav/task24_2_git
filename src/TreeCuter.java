import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TreeCuter {
    public static void main(String[] args) {
        int nAll, mRest, chopped, numberOfChoices = 0;
        String buffer = "";
        String[] inputValues;

        // https://stackoverflow.com/questions/5868369/how-can-i-read-a-large-text-file-line-by-line-using-java
        try(BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while((line = input.readLine()) != null) {
                buffer += line;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        inputValues = buffer.split(" ");
        nAll = Integer.parseInt(inputValues[0]);
        mRest = Integer.parseInt(inputValues[1]);
        if (mRest > nAll) {
            System.out.println("aaaaaaa");
        }
        else if (mRest < 2) {
            if (mRest == 0) {
                numberOfChoices = 1;
            }
            else {
                numberOfChoices = nAll;
            }
        }
        else {
            chopped = nAll - mRest;
            for (int numberInBetween = chopped / (mRest - 1); numberInBetween >= 0; numberInBetween--) {
                int notDistributed = chopped - numberInBetween * (mRest - 1);
                numberOfChoices += notDistributed + 1;
            }
        }

        try(FileWriter output = new FileWriter("output.txt")) {
            output.write(String.valueOf(numberOfChoices));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
