
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

/**
 * Public tests for Worksheet 4, Exercise 4. Eight tests to test different exam questions (numeric, simple, and multiple choice).
 * @author David McDonald
 *
 */
public class Ws4PublicTestsEx4 {
	
	private ExamQuestionNumeric numericQuestion;
	private ExamQuestionSimpleChoice simpleChoiceQuestion;
	private ExamQuestionMultipleChoice multipleChoiceQuestion;
	
	@Before
	public void setup(){
		numericQuestion = new ExamQuestionNumeric("What is 5 times 3?", 10, 15);
		
		ArrayList<String> simpleChoiceAnswers = new ArrayList<String>(Arrays.asList("4","5","10","20"));
		simpleChoiceQuestion = new ExamQuestionSimpleChoice("What is 3 plus 2?", 10, simpleChoiceAnswers, 2);
		
		ArrayList<String> possibleAnswers = new ArrayList<>(Arrays.asList("-2","0","1","2"));
		ArrayList<Integer> correctAnswers = new ArrayList<>(Arrays.asList(1, 4));
		multipleChoiceQuestion = new ExamQuestionMultipleChoice("x * x = 4", 10, possibleAnswers, correctAnswers);
	}

	@Test
	public void ex4PublicTest1() {
		
		int expected = 10;
		int actual = numericQuestion.mark(15);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ex4PublicTest2() {
		
		int expected = 0;
		int actual = numericQuestion.mark(16);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ex4PublicTest3() {
		
		int expected = 10;
		int actual = simpleChoiceQuestion.mark(2);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ex4PublicTest4() {
		
		int expected = 0;
		int actual = simpleChoiceQuestion.mark(3);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ex4PublicTest5() {
		
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 4));
		
		int expected = 10;
		int actual = multipleChoiceQuestion.mark(givenAnswers);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ex4PublicTest6() {
		
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 3));
		
		int expected = 0;
		int actual = multipleChoiceQuestion.mark(givenAnswers);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ex4PublicTest7() {
		
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(1, 3, 4));
		
		int expected = 5;
		int actual = multipleChoiceQuestion.mark(givenAnswers);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void ex4PublicTest8() {
		
		ArrayList<Integer> givenAnswers = new ArrayList<>(Arrays.asList(2, 3));
		
		int expected = 0;
		int actual = multipleChoiceQuestion.mark(givenAnswers);
		
		assertEquals(expected, actual);
	}

}

