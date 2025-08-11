# WordsRank: Recursive Word Segmentation Using Hashing
A project practicing implementing hash tables and recursion

This project was completed as part of a homework assignment for my CIS 320: Data Structures class my sophomore year of college. It demonstrates:
- Implementation of hash tables for fast dictionary lookups
- Use of recursion to explore all possible string segmentations
- Performance measurement with runtime averaging

## Project Overview
This project implements a solution to identify the most likely segmentation of a given string into valid dictionary words. For example, the string "SUNFLOWERSINTHEGARDEN" is determined to have a most likely segmentation of "SUNFLOWERS IN THE GARDEN". The average runtime over three runs of the algorithm is also calculated, deriving the overall average time taken to find the most likely segmentation of each word.  

This program utilizes the following methods:
- `checkDict`, to determine whether a token in a segmentation is a valid dictionary word
- `rank`, to determine how "good" a segmentation is based upon the number of valid dictionary words in it
- a recursive method, `split`, to generate every possible segmentation of an input string

Algorithm outline:
1. Load dictionary into a hash table (storeDict method)
2. Recursively split the string at all possible positions
3. Score each segmentation, keeping the best result found so far
4. Output the best segmentation and average runtime

## Requirements
- <b>Java 5</b> or later  

## Usage
1. Compile and Run
   ```
   javac WordsRank.java
   java WordsRank
   ```
3. Enter a string when prompted
4. View the most likely segmentation and average runtime  

## Acknowledgments
This project includes resources provided by my professor:
- wordsLarge.txt dictionary file
- Portions of the `rank`, `checkDict`, and `storeDict` methods
- Base object classes from Data Structures and Algorithms in Java, Sixth Edition by Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
