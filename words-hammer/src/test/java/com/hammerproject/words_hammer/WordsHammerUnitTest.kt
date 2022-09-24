package com.hammerproject.words_hammer

import org.junit.Assert
import org.junit.Test

class WordsHammerUnitTest {

    var wordsHammerTestMethods = WordsHammerTestMethods()
    /* .......................................................................................... */
    /**
     * example  FullNameIsSamir
     * attention :: "F"ull"N"ame"I"s"S"amir , any words started by capital case character
     *
     * @result Full
     *         Name
     *         Is
     *         Samir
     * */
    @Test
    fun split_words_in_multi_line_with_one_word() {
        var expected = wordsHammerTestMethods.runTestCaseGenerateMultiLineWords();
        Assert.assertTrue(expected)
    }
    /* .......................................................................................... */


    /* .......................................................................................... */
    /**
     * example  text = FullNameIsSamir   charactersPerLine =  10
     *
     * @Result FullNameIs
     *         Samir
     * **/
    @Test
    fun split_words_in_multi_line_with_limited_line_with_one_word() {
        var expected =
            wordsHammerTestMethods.runTestCaseGenerateMultiLineWordsWithTheLimitOfTheNumberOfCharactersPerLine()
        Assert.assertTrue(expected)
    }

    @Test
    fun split_words_in_multi_line_Per_Line_with_several_words() {
        var expected = true;
        for (index in wordsHammerTestMethods.listOfInputTextLimitCharactersPerLine.indices){
            var itsOk = wordsHammerTestMethods.runTestCaseGenerateMultiLineWordsWithTheLimitOfTheNumberOfCharactersPerLine(
                wordsHammerTestMethods.listOfInputTextLimitCharactersPerLine[index],
                10,
                wordsHammerTestMethods.expectedResultLimitCharactersPerLine[index]
            )
            if (!itsOk)
                expected = false
        }
        Assert.assertTrue(expected)
    }
    /* .......................................................................................... */
}