

import java.util.ArrayList;
import java.util.Arrays;

/**
 * In the following we create class ExamQuestionMultipleChoice in which the
 * answer is supposed to be from the list of possible answers, and positions of
 * the correct answers are contained in another list. The ExamQuestionMultipleChoice is
 * subclass of the superclass ExamQuestion
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 15/11/2016
 *
 */
public class ExamQuestionMultipleChoice extends ExamQuestion {

	/**
	 * The class ExamQuestionMultipleChoice is subclass of the superclass
	 * ExamQuestion
	 */
	ArrayList<String> possibleAnswers;
	ArrayList<Integer> correctAnswers;
	ArrayList<Integer> givenAnswers;

	/**
	 * Constructor of the class ExamQuestionMultipleChoice with two inherited
	 * variable from the superclass and two new variables
	 * 
	 * @param questionText contains the question
	 * @param maximalMark contains value of maximal mark
	 * @param possibleAnswers - the provided answers to choose between them
	 * @param correctAnswer represents the position of the correct answer (start counting from 1)
	 * 
	 */
	public ExamQuestionMultipleChoice(String questionText, int maximalMark, ArrayList<String> possibleAnswers,
			ArrayList<Integer> correctAnswers) {
		super(questionText, maximalMark);
		this.possibleAnswers = possibleAnswers;
		this.correctAnswers = correctAnswers;
	}

	/**
	 * This method computes the points by scaling the difference between the
	 * number of correct answers and the number of incorrect answers to the
	 * maximal point
	 * 
	 * 1.use for loop in order to know how many correct answers are the 
	 * 2.in for loop we compare each provided answer with correct answers 
	 * 3. after sorting out the provided answers we have number of correct answers and
	 * number of incorrect ones. 
	 * 4.use if statement to calculate the grade 
	 * 5. if the number of correct answers is less than number of incorrect answers
	 * then we return 0 
	 * 6. otherwise we calculate grade by multiplication maximal mark to the ratio of 
	 * correct answers minus incorrect divided by total number of correct answers
	 *
	 * @param answersProvided number of given answer to compare with the correct answers
	 * @return the result of the type int
	 */
	public int mark(ArrayList<Integer> answersProvided) {
		int numberOfCorrectAnswers = 0;
		int numberOfIncorrectAnswers = 0;

		for (int i = 0; i < answersProvided.size(); i++) {
			if (correctAnswers.contains(answersProvided.get(i))) {
				numberOfCorrectAnswers++;
			} else {
				numberOfIncorrectAnswers++;
			}
		}

		if ((numberOfCorrectAnswers - numberOfIncorrectAnswers) < 0) {
			return 0;
		}
		int mark = getMaximalMark() * (numberOfCorrectAnswers - numberOfIncorrectAnswers) / correctAnswers.size();
		return mark;
	}

	/**
	 * This method defines how to print out information
	 */
	@Override
	public String toString() {
		return super.toString() + "\nPossible answers are: " + Arrays.toString(possibleAnswers.toArray())
				+ "\nCorrect answer is: " + Arrays.toString(correctAnswers.toArray());
	}
}
