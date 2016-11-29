package com.smarterama.nrybak.anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Application that reverses all the words of input text:
	  E.g. "abcd efgh" => "dcba hgfe"
	All non-letter symbols stays on the same places:
	  E.g. "a1bcd efg!h" => "d1cba hgf!e"
	Used Latin alphabet only.*/

public class AnagramString {
	
	public String makeAnagramString(String string) {
		
		if (string == null) {
			return null;
		} else if (string.length() == 0) {
			return string;
		} else if (string.contains(" ")) {
			
			String[] words = string.split(" ");
			String[] anagramWords = makeAnagramWords(words);
			List<Integer> spaceIndexes = getSpaceIndexes(string);
			StringBuffer result = new StringBuffer(concatenateWords(anagramWords));
			
			for (int i = 0; i < spaceIndexes.size(); i++) {
				result.insert(spaceIndexes.get(i), " ");
			}
			
			return result.toString();
			
		} else {
			return makeAnagramWord(string);
		}
	}
	
	private Set<Character> generateLatinAlphabet() {
		
		Set<Character> latinAlphabet = new HashSet<>();
		
		latinAlphabet.add('A');
		latinAlphabet.add('a');
		latinAlphabet.add('В');
		latinAlphabet.add('b');
		latinAlphabet.add('C');
		latinAlphabet.add('c');
		latinAlphabet.add('D');
		latinAlphabet.add('d');
		latinAlphabet.add('E');
		latinAlphabet.add('e');
		latinAlphabet.add('F');
		latinAlphabet.add('f');
		latinAlphabet.add('G');
		latinAlphabet.add('g');
		latinAlphabet.add('H');
		latinAlphabet.add('h');
		latinAlphabet.add('I');
		latinAlphabet.add('i');
		latinAlphabet.add('J');
		latinAlphabet.add('j');
		latinAlphabet.add('K');
		latinAlphabet.add('k');
		latinAlphabet.add('L');
		latinAlphabet.add('l');
		latinAlphabet.add('M');
		latinAlphabet.add('m');
		latinAlphabet.add('N');
		latinAlphabet.add('n');
		latinAlphabet.add('O');
		latinAlphabet.add('o');
		latinAlphabet.add('P');
		latinAlphabet.add('p');
		latinAlphabet.add('Q');
		latinAlphabet.add('q');
		latinAlphabet.add('R');
		latinAlphabet.add('r');
		latinAlphabet.add('S');
		latinAlphabet.add('s');
		latinAlphabet.add('T');
		latinAlphabet.add('t');
		latinAlphabet.add('U');
		latinAlphabet.add('u');
		latinAlphabet.add('V');
		latinAlphabet.add('v');
		latinAlphabet.add('X');
		latinAlphabet.add('x');
		latinAlphabet.add('Y');
		latinAlphabet.add('y');
		latinAlphabet.add('Z');
		latinAlphabet.add('z');
		
		return latinAlphabet;
	}
	
	private String makeAnagramWord(String word) {
		
		char [] chars = word.toCharArray();
		List<Character> list = toList(chars);
		List<Character> resultChars = new ArrayList<>(list);
		Collections.reverse(resultChars);
		Set<Character> latinAlphabet = generateLatinAlphabet();
		
		for (int i = 0; i < chars.length; i++) {
			Character currentChar = resultChars.get(i);
			if (!latinAlphabet.contains(currentChar)) {
				resultChars.remove(currentChar);
				resultChars.add(list.indexOf(currentChar), currentChar);
			}
		}
		chars = toArray(resultChars);
		return new String(chars);
	}
	
	private List<Character> toList(char[] chars) {
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < chars.length; i++) {
			list.add(chars[i]);
		}
		
		return list;
	}
	
	private char[] toArray(List<Character> list) {
		char[] chars = new char[list.size()];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = list.get(i);
		}
		
		return chars;
	}
	
	private List<Integer> getSpaceIndexes(String string){
		char[] chars = string.toCharArray();
		List<Integer> spaceIndexes = new ArrayList<>();
		
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				spaceIndexes.add(i);
			}
		}
		
		return spaceIndexes;
	}
	
	private String[] makeAnagramWords(String[] words){
		
		String[] resultWords = new String[words.length];
		
		for (int i = 0; i < words.length; i++) {
			resultWords[i] = makeAnagramWord(words[i]);
		}
		
		return resultWords;
	}
	
	private String concatenateWords(String[] anagramWords) {
		
		String result = "";
		
		for (String word : anagramWords) {
			result += word; 
		}
		
		return result;
	}
	
}























