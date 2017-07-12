
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Ex4OwnTests {
	/**
	 * Own junit tests to check if the method mark works properly in all classes
	 * 
	 * @author Valeriya Yashina
	 */
    @Test
    public void examQuestionToStringTest() {
        ExamQuestion examQuestion = new ExamQuestion("What is 2 times 3?", 10);
        Assert.assertEquals("Question (maximal mark: 10): What is 2 times 3?", examQuestion.toString());
    }

    @Test
    public void examQuestionNumericMark1() {
        ExamQuestionNumeric examQuestionNumeric = new ExamQuestionNumeric("2+3 = ?", 10, 5);
        Assert.assertEquals(10, examQuestionNumeric.mark(5));
    }

    @Test
    public void examQuestionNumericMark2() {
        ExamQuestionNumeric examQuestionNumeric = new ExamQuestionNumeric("2+3 = ?", 10, 5);
        Assert.assertEquals(0, examQuestionNumeric.mark(6));
    }

    @Test
    public void examQuestionSimpleChoiceMark1() throws Exception {
        ExamQuestionSimpleChoice examQuestionSimpleChoice;

        ArrayList<String> a = new ArrayList<String>();
        a.add("4");
        a.add("5");
        a.add("10");
        a.add("20");

        examQuestionSimpleChoice = new ExamQuestionSimpleChoice("2+3 = ?", 10, a, 2);
        Assert.assertEquals(10, examQuestionSimpleChoice.mark(2));
    }

    @Test
    public void examQuestionSimpleChoiceMark2() throws Exception {
        ExamQuestionSimpleChoice examQuestionSimpleChoice;

        ArrayList<String> a = new ArrayList<String>();
        a.add("4");
        a.add("5");
        a.add("10");
        a.add("20");

        examQuestionSimpleChoice = new ExamQuestionSimpleChoice("2+3 = ?", 10, a, 2);
        Assert.assertEquals(0, examQuestionSimpleChoice.mark(3));
    }

    @Test
    public void examQuestionMultipleChoiceTestMark1() {

        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("-2");
        possibleAnswers.add("0");
        possibleAnswers.add("2");
        possibleAnswers.add("3");

        ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
        correctAnswers.add(1);
        correctAnswers.add(3);

        ExamQuestionMultipleChoice question = new ExamQuestionMultipleChoice("x*x = 4", 10, possibleAnswers, correctAnswers);
        ArrayList<Integer> givenAnswers = new ArrayList<>(2);
        givenAnswers.add(1);
        givenAnswers.add(3);
        Assert.assertEquals(10, question.mark(givenAnswers));
    }

    @Test
    public void examQuestionMultipleChoiceTestMark2() {
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("-2");
        possibleAnswers.add("0");
        possibleAnswers.add("2");
        possibleAnswers.add("3");

        ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
        correctAnswers.add(1);
        correctAnswers.add(3);

        ExamQuestionMultipleChoice question = new ExamQuestionMultipleChoice("x*x = 4", 10, possibleAnswers, correctAnswers);
        ArrayList<Integer> givenAnswers = new ArrayList<>(1);
        givenAnswers.add(1);
        Assert.assertEquals(5, question.mark(givenAnswers));
    }

    @Test
    public void examQuestionMultipleChoiceTestMark3() {
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("-2");
        possibleAnswers.add("0");
        possibleAnswers.add("2");
        possibleAnswers.add("3");

        ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
        correctAnswers.add(1);
        correctAnswers.add(3);

        ExamQuestionMultipleChoice question = new ExamQuestionMultipleChoice("x*x = 4", 10, possibleAnswers, correctAnswers);
        ArrayList<Integer> givenAnswers = new ArrayList<>(1);
        givenAnswers.add(3);
        Assert.assertEquals(5, question.mark(givenAnswers));
    }

    @Test
    public void examQuestionMultipleChoiceTestMark4() {
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("-2");
        possibleAnswers.add("0");
        possibleAnswers.add("2");
        possibleAnswers.add("3");

        ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
        correctAnswers.add(1);
        correctAnswers.add(3);

        ExamQuestionMultipleChoice question = new ExamQuestionMultipleChoice("x*x = 4", 10, possibleAnswers, correctAnswers);
        ArrayList<Integer> givenAnswers = new ArrayList<>(3);
        givenAnswers.add(1);
        givenAnswers.add(2);
        givenAnswers.add(3);
        Assert.assertEquals(5, question.mark(givenAnswers));
    }

    @Test
    public void examQuestionMultipleChoiceTestMark5() {
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("-2");
        possibleAnswers.add("0");
        possibleAnswers.add("2");
        possibleAnswers.add("3");

        ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
        correctAnswers.add(1);
        correctAnswers.add(3);

        ExamQuestionMultipleChoice question = new ExamQuestionMultipleChoice("x*x = 4", 10, possibleAnswers, correctAnswers);
        ArrayList<Integer> givenAnswers = new ArrayList<>(3);
        givenAnswers.add(1);
        givenAnswers.add(3);
        givenAnswers.add(4);
        Assert.assertEquals(5, question.mark(givenAnswers));
    }

    @Test
    public void examQuestionMultipleChoiceTestMark6() {
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("-2");
        possibleAnswers.add("0");
        possibleAnswers.add("2");
        possibleAnswers.add("3");

        ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
        correctAnswers.add(1);
        correctAnswers.add(3);

        ExamQuestionMultipleChoice question = new ExamQuestionMultipleChoice("x*x = 4", 10, possibleAnswers, correctAnswers);
        ArrayList<Integer> givenAnswers = new ArrayList<>(2);
        givenAnswers.add(1);
        givenAnswers.add(2);
        Assert.assertEquals(0, question.mark(givenAnswers));
    }

    @Test
    public void examQuestionMultipleChoiceTestMark7() {
        ArrayList<String> possibleAnswers = new ArrayList<String>();
        possibleAnswers.add("-2");
        possibleAnswers.add("0");
        possibleAnswers.add("2");
        possibleAnswers.add("3");

        ArrayList<Integer> correctAnswers = new ArrayList<Integer>();
        correctAnswers.add(1);
        correctAnswers.add(3);

        ExamQuestionMultipleChoice question = new ExamQuestionMultipleChoice("x*x = 4", 10, possibleAnswers, correctAnswers);
        ArrayList<Integer> givenAnswers = new ArrayList<>(2);
        givenAnswers.add(1);
        givenAnswers.add(2);
        givenAnswers.add(3);
        givenAnswers.add(4);
        Assert.assertEquals(0, question.mark(givenAnswers));
    }
}
