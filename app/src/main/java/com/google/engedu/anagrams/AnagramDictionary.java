/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    ArrayList<String> wordList;
    HashSet wordSet;
    HashMap lettersToWord = new HashMap();

    public AnagramDictionary(Reader reader) throws IOException {
        wordList = new ArrayList<>();
        BufferedReader in = new BufferedReader(reader);
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
            wordList.add(word);
            ArrayList<String> temp = new ArrayList<>();
            if(lettersToWord.containsKey(sortLetter(word)))
            {
                temp=(ArrayList<String>)lettersToWord.get(sortLetter(word));
                temp.add(word);
                lettersToWord.put(sortLetter(word),temp);
            }
            else
            {
                temp.add(word);
                lettersToWord.put(sortLetter(word),temp);
            }
        }
    }

    public boolean isGoodWord(String word, String base) {
        return true;
    }

    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        //ye humne likha he
        for(String word : wordList)
        {
            if(word.length()!= targetWord.length())
            {
                continue;
            }
            if(sortLetter(targetWord).equals(sortLetter(word)))
                result.add(word);
        }
        Log.i("AnagramDictionary", result.toString());
        return result;
    }

    public List<String> getAnagramsWithOneMoreLetter(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        return result;
    }

    public String pickGoodStarterWord() {
        return "stop";
    }

    //ye humne likha he
    public String sortLetter(String toSort)
    {
        char[] chars = toSort.toCharArray();
        Arrays.sort(chars);
        return  new String(chars);
    }
}
