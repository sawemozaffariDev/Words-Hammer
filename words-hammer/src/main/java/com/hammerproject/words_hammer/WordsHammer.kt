package com.hammerproject.words_hammer

class WordsHammer {

    /**
     * example  FullNameIsSamir
     * attention :: "F"ull"N"ame"I"s"S"amir , any words started by capital case character
     *
     * @result Full
     *         Name
     *         Is
     *         Samir
     * */
    /* bug in on ore 2 word*/
    fun generateMultiLineWords(text: String): String {
        val separated = separatedWord(text)                   /*Full | Name | Is | Samir*/
        var separatedSize = separated.size
        if (separatedSize == 0 || separatedSize == 1) {
            return text
        } else {
            val multiLineTitle = StringBuilder()
            for (i in 0..separatedSize - 1) {
                multiLineTitle.append(separated[i])
                if (i != separatedSize - 1)
                    multiLineTitle.append("\n")             /*return = Full\nName\nIs\n */
            }                                               /*return = Full\nName\nIs\nSamir */
            return multiLineTitle.toString()
        }
    }

    /**
     * example  text = FullNameIsSamir   charactersPerLine =  10
     *
     * @Result FullNameIs
     *         Samir
     * **/
    fun generateMultiLineWordsWithTheLimitOfTheNumberOfCharactersPerLine(
        text: String,
        charactersPerLineCount: Int
    ): String {
        val separated = separatedWord(text)
        var separatedSize = separated.size

        if (separatedSize == 0 || separatedSize == 1) {
            return text
        } else {
            var multiLineTitle = StringBuilder()
            var newWordList: ArrayList<String> = arrayListOf()
            multiLineTitle.append(separated[0])
            for (i in 1..(separatedSize - 1)) {
                var wordsSizeAfterAppend = multiLineTitle.length + separated[i].length
                if (wordsSizeAfterAppend <= charactersPerLineCount) {
                    multiLineTitle.append(separated[i])
                } else {
                    newWordList.add(multiLineTitle.toString())
                    multiLineTitle = StringBuilder()
                    multiLineTitle.append(separated[i])
                }
            }
            var result: String = java.lang.String.join("\n", newWordList)
            if (multiLineTitle.length != 0 && newWordList.size != 0)
                result += "\n" + multiLineTitle.toString()
            if (multiLineTitle.length != 0 && newWordList.size == 0)
                result += multiLineTitle.toString()
            return result
        }
    }




    /* necessary methods      ................................................................... */
    fun separatedWord(text: String): MutableList<String> {
        if (text.isEmpty())
            return mutableListOf()
        val separated: MutableList<String> =
            text.trim().split(Regex("(?=\\p{Upper})")) as MutableList<String>
        if (separated[0].isNullOrBlank())
            separated.removeAt(0)
        return separated
    }

    fun isSpacialWord(baseText: String, spacialWords: ArrayList<String>): Boolean {
        val isWord = spacialWords.find { baseText.contains(it) }
        return (isWord != null && isWord.isNotEmpty() && isWord.isNotBlank())
    }

    fun findSpacialWord(baseText: String, spacialWords: ArrayList<String>): String {
        val spacialWord = spacialWords.find { baseText.contains(it) }
        return if (spacialWord != null && spacialWord.isNotEmpty() && spacialWord.isNotBlank())
            spacialWord
        else
            ""
    }

    /* .......................................................................................... */
    /* .......................................................................................... */


}