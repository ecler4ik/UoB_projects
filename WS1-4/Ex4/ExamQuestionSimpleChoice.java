

import java.util.ArrayList;
import java.util.Arrays;

/**
 * In the following we create class ExamQuestionSimpleChoice in which the answer
 * is supposed to be from the list. ExamQuestionSimpleChoice is the subclass
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 15/11/2016
 *
 */
public class ExamQuestionSimpleChoice extends ExamQuestion {

	/**
	 * The class ExamQuestionSimpleChoice is subclass of the superclass ExamQuestion
	 */
	ArrayList<String> possibleAnswers;
	int correctAnswer;

	/**
	 * The constructor for the class ExamQuestionSimpleChoice with two inherited
	 * variable from the superclass and two new variables
	 * 
	 * @param questionText contains the question
	 * @param maximalMark contains value of maximal mark
	 * @param possibleAnswers - the provided answers to choose between them
	 * @param correctAnswer represents the position of the correct answer (start counting from 1)
	 */
	public ExamQuestionSimpleChoice(String questionText, int maximalMark, ArrayList<String> possibleAnswers,
			int correctAnswer) {
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswer = correctAnswer;
	}

	/**
	 * Getter for the correctAnswer
	 * 
	 * @return correctAnswer
	 */
	public int getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * This method return full marks if the answer is correct and 0 otherwise
	 * 
	 * @param value - the given answer that is compared to correctAnswer
	 * @return the result of the type int
	 */
	public int mark(int value) {
		try {
			if (value == getCorrectAnswer()) {
				return 10;
			}
		} catch (NumberFormatException e) {
			System.out.println("Will throw Exception");
		}
		return 0;
	}

	/**
	 * This method defines how to print out information
	 */
	 @Override //this toString method overrides toString method from the superclass
	    public String toString() {
	        return super.toString() +
	                "\nPossible answers are: " + Arrays.toString(possibleAnswers.toArray()) +
	                "\nCorrect answer is: " + possibleAnswers.get(correctAnswer - 1);
	 				}

}
