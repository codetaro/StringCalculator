package tddtest;

import org.junit.Test;

import junit.framework.Assert;
import tdd.StringCalculator;

public class StringCalculatorTest {
	/*
	 * Requirement 1: The method can take 0, 1 or 2 numbers separated by comma (,).
	 */
//	@Test(expected = RuntimeException.class)
//	public final void whenMoreThan2NumbersAreUsedThenExceptionIsThrown() {
//		StringCalculator.add("1,2,3");
//	}
	@Test
	public final void when2NumbersAreUsedThenNoExceptionIsThrown() {
		StringCalculator.add("1,2");
		Assert.assertTrue(true);
	}
	@Test(expected = RuntimeException.class)
	public final void whenNonNumberIsUsedThenExceptionIsThrown() {
		StringCalculator.add("1,X");
	}
	/*
	 * Requirement 2: For an empty string the method will return 0
	 */
	@Test
	public final void whenEmptyStringIsUsedThenReturnValueIs0() {
		Assert.assertEquals(0, StringCalculator.add(""));
	}
	/*
	 * Requirement 3: Method will return their sum of numbers
	 */
	@Test
	public final void whenOneNumberIsUsedThenReturnValueIsThatSameNumber() {
		Assert.assertEquals(3, StringCalculator.add("3"));
	}
	@Test
	public final void whenTwoNumbersAreUsedThenReturnValueIsTheirSum() {
		Assert.assertEquals(3+6, StringCalculator.add("3,6"));
	}
	/*
	 * Requirement 4: Allow the Add method to handle an unknown amount of numbers
	 */
	@Test
	public final void whenAnyNumberOfNumbersIsUsedThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15+18+46+33, StringCalculator.add("3,6,15,18,46,33"));
	}
	/*
	 * Requirement 5: Allow the Add method to handle new lines between numbers (instead of commas).
	 */
	@Test
	public final void whenNewLineIsUsedBetweenNumbersThenReturnValuesAreTheirSums() {
		Assert.assertEquals(3+6+15, StringCalculator.add("3,6n15"));
	}
	/*
	 * Requirement 6: Support different delimiters
	 */
	@Test
	public final void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() {
		Assert.assertEquals(3+6+15, StringCalculator.add("//;3;6;15"));
	}
	/*
	 * Requirement 7: Negative numbers will throw an exception
	 */
	@Test(expected = RuntimeException.class)
	public final void whenNegativeNumberIsUsedThenRuntimeExceptionIsThrown() {
		StringCalculator.add("3,-6,15,18,46,33");
	}
	@Test
	public final void whenNegativeNumbersAreUsedThenRuntimeExceptionIsThrown() {
		RuntimeException exception = null;
		try {
			StringCalculator.add("3,-6,15,-18,46,33");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assert.assertNotNull(exception);
		Assert.assertEquals("Negatives not allowed: [-6, -18]", exception.getMessage());
	}
	/*
	 * Requirement 8: Numbers bigger than 1000 should be ignored
	 */
	@Test
	public final void whenOneOrMoreNumbersAreGreaterThan1000IsUsedThenItIsNotIncludedInSum() {
		Assert.assertEquals(3+1000+6, StringCalculator.add("3,1000,1001,6,1234"));
	}
	/*
	 * TODO:
	 * Requirement 9: Delimiters can be of any length
	 * Requirement 10: Allow multiple delimiters
	 * Requirement 11: Make sure you can also handle multiple delimiters with length longer than one char
	 */
}
