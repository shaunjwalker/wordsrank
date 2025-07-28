# wordsrank
A project for CIS 320: Data Structures practicing implementing hash tables and recursion

This project was completed as part of a homework assignment for Data Structures my sophomore year of college. It demonstrates implemtiations of recursion and hash tables to solve a problem.

## Project Overview
This project demonstrates a solution for determining the most likely intended segmentation of a string. For example, the string "SUNFLOWERSINTHEGARDEN" is determined to have a most likely segmentation of "SUNFLOWERS IN THE GARDEN". The average runtime over three runs of the algorithm is also calculated, deriving the overall average time taken to find the most likely segmentation of each word.  
This program utilizes 
- a method, checkDict, to determine whether a token in a segmentation is a real, dictionary word
- a method, rank, to determine how "good" a segmentation is based upon the number of real dictionary word in it
- a recursive method, split, to generate every possible segmentation of an input string

The checkDict method searches through a hash table, created from the words contained in the "wordsLarge.txt" dictionary file, returning true if the word is found in the hash table, and false otherwise in otder to determine the authenticity of a word.  
The rank method updates the best found segmentation so far by comparing the quality of each new segmentation to the current best segmentation
The split method generates every possible segmentation of a string...
