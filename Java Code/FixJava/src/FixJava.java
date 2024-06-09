import java.io.BufferedReader; //BufferedReader for java source file reading
import java.io.FileReader; //Extended file reader
import java.io.IOException; //For handling Exceptions
import java.util.Stack; //A stack for generating misalignments in blocks and braces

public class FixJava {

    //File path for java source file
    private String filePath;
    //Stack for initiating the printed in error checks
    private Stack<BraceInfo> braceStack;
    //Current indent level
    private int currentIndentLevel;

    //FixJava constructor that initiates the stack
    public FixJava(String filePath) {
        this.filePath = filePath;
        this.braceStack = new Stack<>();
        this.currentIndentLevel = 0;
    }

    public void checkForErrors() {
        //Open Reader for reading the java source file
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 0;
            //Checks if the line is null
            while ((line = fileReader.readLine()) != null) {
                lineNumber++;

                // Check for opening and closing braces '{' and '}'
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    if (c == '{') {
                        braceStack.push(new BraceInfo(lineNumber, i));
                        currentIndentLevel++;
                    } else if (c == '}') {
                        if (braceStack.isEmpty()) {
                            System.out.println("Misaligned brace at line " + lineNumber);
                        } else {
                            BraceInfo lastBraceInfo = braceStack.pop();
                            if (!lastBraceInfo.isAligned(i)) {
                                System.out.println("Misaligned brace at line " + lineNumber);
                            }
                            currentIndentLevel--;
                        }
                    }
                }

                // Check indentation within code blocks and specific keywords
                int lineIndentLevel = countIndentationLevel(line);

                // Check indentation for class
                if (line.contains("class")) {
                    if (lineIndentLevel != 0) {
                        System.out.println("Class definition indentation issue at line " + lineNumber);
                    }
                }

                // Check indentation for method definitions
                if (line.matches("\\s*(public|private|protected)?\\s+(static\\s+)?\\w+\\s+\\w+\\s*\\(.*\\)\\s*\\{.*")) {
                    if (lineIndentLevel != 4) {
                        System.out.println("Method definition indentation issue at line " + lineNumber);
                    }
                }

                // Check indentation for inside if, while, for statements
                if (line.contains("if") || line.contains("while") || line.contains("for")) {
                    if (lineIndentLevel % 4 != 0) {
                        System.out.println("Block indentation issue at line " + lineNumber);
                    }
                }
            }

            while (!braceStack.isEmpty()) {
                BraceInfo unmatchedBrace = braceStack.pop();
                System.out.println("Unmatched brace at line " + unmatchedBrace.getLineNumber());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //A count that assumes that count is divisible by 4 (Implemented in CheckForErrors()),
    // to make sure that indentation standards are met
    private int countIndentationLevel(String line) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == ' ') {
                count++;
            } else {
                break;
            }
        }
        return count; // Assuming 4 spaces per level in CheckForErrors()
    }

    //a static BraceInfo defines the lineNumber for reading and position for reading brace info
    private static class BraceInfo {
        private int lineNumber; //LineNumber for BufferedReader
        private int position; //Position of brace


        //Constructor to initiate the line number and position
        public BraceInfo(int lineNumber, int position) {
            this.lineNumber = lineNumber;
            this.position = position;
        }
        //Getter method for lineNumber
        public int getLineNumber() {
            return lineNumber;
        }
        //Checks if the position matches the int of closing position
        public boolean isAligned(int closingPosition) {
              return position == closingPosition;
        }
    }
}
