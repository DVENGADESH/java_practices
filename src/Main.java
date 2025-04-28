import java.util.*;

class Quiz {
    private List<Question> questions = new ArrayList<>();
    private int score = 0;


    public void loadQuestions() {
        questions.add(new Question(
                "What is the capital of India?",
                new String[]{"A. Mumbai", "B. Delhi", "C. Chennai", "D. Kolkata"},
                'B'
        ));

        questions.add(new Question(
                "Which planet is known as the Red Planet?",
                new String[]{"A. Earth", "B. Mars", "C. Jupiter", "D. Venus"},
                'B'
        ));

        questions.add(new Question(
                "Who wrote the play 'Romeo and Juliet'?",
                new String[]{"A. Charles Dickens", "B. Mark Twain", "C. William Shakespeare", "D. Leo Tolstoy"},
                'C'
        ));

        questions.add(new Question(
                "Which is the smallest prime number?",
                new String[]{"A. 0", "B. 1", "C. 2", "D. 3"},
                'C'
        ));

        questions.add(new Question(
                "What is the chemical symbol for water?",
                new String[]{"A. CO2", "B. H2O", "C. O2", "D. NaCl"},
                'B'
        ));
    }



    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Welcome to the Quiz......");

        for (Question question : questions) {
            question.displayQuestion();
            char userAnswer;
            do {
                System.out.print("Enter your answer (A/B/C/D): ");
                String input = scanner.nextLine().toUpperCase();
                if (input.length() == 1 && "ABCD".indexOf(input.charAt(0)) != -1) {
                    userAnswer = input.charAt(0);
                    break;
                } else {
                    System.out.println("Invalid input. Please enter A, B, C, or D only.");
                }
            } while (true);

            if (question.isCorrectAnswer(userAnswer)) {
                System.out.println("Correct !");
                score++;
            } else {
                System.out.println("Wrong! Correct answer is : " + question.getCorrectAnswer() + "\n");
            }
        }
    }


    public void displayResult() {
        System.out.println("----------------------------------");
        System.out.println("QUIZ COMPLETED!");
        System.out.println("Total Questions: " + questions.size());
        System.out.println("Your Score: " + score);

        if (score >= (questions.size() / 2)) {
            System.out.println("Status: PASS");
        } else {
            System.out.println("Status: FAIL");
        }

        System.out.println("----------------------------------");
    }
}

class Question {
    private String questionText;
    private String[] options;
    private char correctAnswer;


    public Question(String questionText, String[] options, char correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }


    public void displayQuestion() {
        System.out.println("\n" + questionText);
        for (String option : options) {
            System.out.println(option);
        }
    }


    public boolean isCorrectAnswer(char answer) {
        return Character.toUpperCase(answer) == correctAnswer;
    }


    public char getCorrectAnswer() {
        return correctAnswer;
    }
}


public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.loadQuestions();
        quiz.startQuiz();
        quiz.displayResult(); 
    }
}

