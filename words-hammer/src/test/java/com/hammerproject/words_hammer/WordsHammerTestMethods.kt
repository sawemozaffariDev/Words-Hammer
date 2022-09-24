package com.hammerproject.words_hammer

class WordsHammerTestMethods {

    var breakWords = WordsHammer()


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
    fun runTestCaseGenerateMultiLineWords(): Boolean {
        var result = breakWords.generateMultiLineWords("FullNameIsSamir")
        return result.compareTo("Full\nName\nIs\nSamir") == 0
    }

    fun runTestCaseGenerateMultiLineWords(text: String, returnValue: String): Boolean {
        var result = breakWords.generateMultiLineWords(text)
        val isEqual = result.compareTo(returnValue) == 0
        return isEqual
    }

    /*  base texts list*/
    val listOfInputTextMultiLineWords = ArrayList(
        listOf(
            "FullNameIsSamir",
            "FullNameIsSamirMzfInSanayCompany",
            "SuspHistorySearch",
            "SearchByIMEI",
            "GetIPDR",
            "getIPPull",
            "IVR"
        )
    )

    val expectedResultMultiLineWords = ArrayList(
        listOf(
            "Full\nName\nIs\nSamir",
            "Full\nName\nIs\nSamir\nMzf\nIn\nSanay\nCompany",
            "Susp\nHistory\nSearch",
            "Search\nBy\nI\nM\nE\nI",
            "Get\nI\nP\nD\nR",
            "get\nI\nP\nPull",
            "I\nV\n\nR"
        )
    )
    /* .......................................................................................... */

    /* .......................................................................................... */
    /**
     * example  text = FullNameIsSamir   charactersPerLine =  10
     *
     * @Result FullNameIs
     *         Samir
     * **/
    fun runTestCaseGenerateMultiLineWordsWithTheLimitOfTheNumberOfCharactersPerLine(): Boolean {
        var result = breakWords.generateMultiLineWordsWithTheLimitOfTheNumberOfCharactersPerLine(
            "FullNameIsSamir",
            10
        )
        return result.compareTo("FullNameIs\nSamir") == 0
    }

    fun runTestCaseGenerateMultiLineWordsWithTheLimitOfTheNumberOfCharactersPerLine(
        text: String,
        charactersPerLineCount: Int,
        returnValue: String
    ): Boolean {
        var result = breakWords.generateMultiLineWordsWithTheLimitOfTheNumberOfCharactersPerLine(
            text,
            charactersPerLineCount
        )
        val isEqual = result.compareTo(returnValue) == 0
        return isEqual
    }


    /*  base texts list*/
    val listOfInputTextLimitCharactersPerLine = ArrayList(
        listOf(
            "FullNameIsSamir",
            "FullNameIsSamirMzfInSanayCompany",
            "SuspHistorySearch",
            "SearchByIMEI",
            "GetIPDR",
            "getIPPull",
            "IVR"
        )
    )

    val expectedResultLimitCharactersPerLine = ArrayList(
        listOf(
            "FullNameIs\nSamir",
            "FullNameIs\nSamirMzfIn\nSanay\nCompany",
            "Susp\nHistory\nSearch",
            "SearchByIM\nEI",
            "GetIPDR",
            "getIPPull",
            "IVR"
        )
    ) //result by charactersPerLine =  10
    /* .......................................................................................... */


}