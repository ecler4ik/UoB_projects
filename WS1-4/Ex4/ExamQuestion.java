

/**
 * In the following we create class ExamQuestion with constructor, getters,
 * setters and toString method. ExamQuestion is the superclass
 * 
 * @author Valeriya Yashina, ID 1603690
 * @version Date 15/11/2016
 *
 */
public class ExamQuestion {
	/**
	 * class ExamQiestion is the superclass that contains information about
	 * the question and maximal mark for the correct answer
	 */
	private String questionText;
	private int maximalMark;

	/**
	 * Constructor of the class ExamQuestion with parameters questionText,
	 * maximalMark
	 * 
	 * @param questionText contains the question
	 * @param maximalMark contains value of maximal mark
	 */
	public ExamQuestion(String questionText, int maximalMark) {
		this.questionText = questionText;
		this.maximalMark = maximalMark;
	}

	/**
	 * Getter for the question text
	 * 
	 * @return questionText
	 */
	public String getQuestionText() {
		return questionText;
	}

	/**
	 * Setter for questionText
	 * 
	 * @param questionText sets new value to the variable
	 */
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	/**
	 * Getter for maximalMark
	 * 
	 * @return maximalMark - max mark for the right question
	 */
	public int getMaximalMark() {
		return maximalMark;
	}

	/**
	 * Setter for maximalMark
	 * 
	 * @param maximalMark sets new value in variable
	 */
	public void setMaximalMark(int maximalMark) {
		this.maximalMark = maximalMark;
	}

	/**
	 * method toString defines how to print information
	 */
	public String toString() {
		return "Question (maximal mark: " + getMaximalMark() + "): " + getQuestionText();
	}
}
