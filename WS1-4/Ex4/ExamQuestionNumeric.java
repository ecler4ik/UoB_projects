

/**
 * In the following we create class ExamQuestionNumeric in which it's supposed
 * to receive answer if the type int. Class ExamQuestionNumeric is subclass of
 * the superclass ExamQuestion
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 15/11/2016
 *
 */
public class ExamQuestionNumeric extends ExamQuestion {

	/**
	 * Class ExamQuestionNumeric is subclass of the superclass ExamQuestion
	 */
	private static int correctAnswer;

	/**
	 * Constructor of the class ExamQuestionNumeric with two variable inherited
	 * from superclass (questionTex, maximalMark) and one new variable correctAnswer
	 * 
	 * @param questionText contains the question
	 * @param maximalMark contains value of maximal mark
	 * @param correctAnswer stands for right answer
	 */
	public ExamQuestionNumeric(String questionText, int maximalMark, int correctAnswer) {
		super(questionText, maximalMark);
		ExamQuestionNumeric.correctAnswer = correctAnswer;
	}

	/**
	 * Getter for the correctAnswer
	 * @return correctAnswer
	 */
	public static int getCorrectAnswer() {
		return correctAnswer;
	}

	/**
	 * This method is used to return full marks if answer is correct and 0 otherwise 
	 * 
	 * @param value the given answer that is compared to correctAnswer
	 * @return the result of the type int
	 */
	public int mark(int value) {

		if (value == getCorrectAnswer()) {
			super.setMaximalMark(10);
		} else {
			super.setMaximalMark(0);
		}
		return super.getMaximalMark();
	}

	/**
	 * Method toString defines how to print out information
	 */
	@Override 
	public String toString() {
		return super.toString() + "Correct answer is  " + getCorrectAnswer() + ". ";
	}
}

	

