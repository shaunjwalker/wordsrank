# WordsRank: Recursive Word Segmentation Using Hashing
A project for CIS 320: Data Structures practicing implementing hash tables and recursion

This project was completed as part of a homework assignment for Data Structures my sophomore year of college. It demonstrates implemtiations of recursion and hash tables to solve a problem.

## Project Overview
This project implements a solution to identify the most likely segmentation of a given string into real dictionary words. For example, the string "SUNFLOWERSINTHEGARDEN" is determined to have a most likely segmentation of "SUNFLOWERS IN THE GARDEN". The average runtime over three runs of the algorithm is also calculated, deriving the overall average time taken to find the most likely segmentation of each word.  
This program utilizes 
- a method, checkDict, to determine whether a token in a segmentation is a real, dictionary word
- a method, rank, to determine how "good" a segmentation is based upon the number of real dictionary word in it
- a recursive method, split, to generate every possible segmentation of an input string

The checkDict method searches through a hash table, created from the words contained in the "wordsLarge.txt" dictionary file, returning true if the word is found in the hash table, and false otherwise in otder to determine the authenticity of a word.    
The rank method updates the best found segmentation so far by comparing the quality of each new segmentation to the current best segmentation   
The split method generates every possible segmentation of a string, with its base case being that, when an input string has one or fewer characters, no segmentations occur. The recursive case is then that, when a string has more than one character, the string is recursively split at every possible point.


## How to Run

This program requires Java 5 or later to compile and run.

The driver class of this prject is wordsRank.java. In compiling and running this file, the user is prompted to enter a string to be segmented. Once inputted, the most likely segmentation of this input string is computed.  

## Note

Please note that, as this project was completed as part of a homework assignment, not all of the content was written by me. The object classes utilized are from Data Structures and Algorithms in Java, Sixth Edition Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser John Wiley & Sons, 2014. The wordsLarge.txt dictionary, as well as parts of some methods in WordsRank.java were provided by my professor. The methods provided by my professor were the rank, checkDict, and storeDict methods.
