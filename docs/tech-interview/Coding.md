# Coding Interview

- [Picking a Language](#picking-a-language)
  - [Some languages are more suited for interviews](#some-languages-are-more-suited-for-interviews)
  - [Use a language you are familiar with](#use-a-language-you-are-familiar-with)
  - [The exception to the norm](#the-exception-to-the-norm)
- [Study and Practice](#study-and-practice)
  - [Recap CS fundamentals](#recap-csfundamentals)
  - [Mastery through practice](#mastery-through-practice)
    - [Practice coding questions](#practice-coding-questions)
    - [Complexities](#complexities)
    - [Practice good coding style](#practice-good-coding-style)
    - [Internalize the pitfalls](#internalize-the-pitfalls)
- [During the Coding Interview](#during-the-coding-interview)
- [References](#references)

Coding interviews are tough, but the most important part for software engineer hiring. There's a tried and proven method to get better at them. With a combination of studying, practicing questions and doing mock interviews, getting that dream job can become a reality.

## Picking a Language

Before anything else, you need to pick a programming language to do your interviews in. Most companies will let you code in any language you want, the only exception I know being Google, where they only allow candidates to pick from Java, C++, JavaScript or Python for their algorithmic coding interviews.

### Some languages are more suited for interviews

There are some languages which are more suitable than others for coding interviews and some languages you absolutely want to avoid. From my experience as an interviewer, most candidates pick Python or Java. Other commonly seen languages include JavaScript, Ruby and C++. I would absolutely avoid lower level languages like **C** or **Go**, simply because they lack many standard library functions and data structures and some may require manual memory management.

Personally, Python is my de facto choice for algorithm coding interviews because it is succinct and has a pretty huge library of functions and data structures available. One of my top reasons for recommending Python is that it uses consistent APIs that operate on different data structures, such as len(), for ... in ... and slicing notation on sequences (strings/lists/tuples). Getting the last element in a sequence is arr[-1] and reversing it is simply arr[::-1]. You can achieve a lot with minimal syntax in Python.

Java is a decent choice too but having to constantly declare types in your code means extra keystrokes which results in slower coding/typing speed. This issue will be more apparent when you have to write on a whiteboard during on-site interviews. The reasons for choosing/not choosing C++ are similar to Java. Ultimately, **Python**, **Java** and **C++** are decent choices of languages.

### Use a language you are familiar with

Most of the time, it is recommended that you use a language that you are extremely familiar with rather than picking up a new language just for doing interviews because the company uses that language heavily or just because you want to show that you are trendy.

If you are under time constraints, picking up a new language just for interviewing is hardly a good idea. Languages take time to master and if you are already spending most of your time and effort on mastering algorithms, there is barely spare effort left for mastering a new language. If you are familiar with using one of the mainstream languages, there isn't a strong reason to learn a new language just for interviewing.

If you have been using Java at work for a while now and do not have time to be comfortably familiar with another language, I would recommend just sticking to Java instead of picking up Python from scratch just for the sake of interviews. Doing so, you can avoid having to context switch between languages during work vs interviews. Most of the time, the bottleneck is in the thinking and not the writing. It takes some getting used to before one becomes fluent in a language and be able to wield it with ease.

### The exception to the norm

One exception to the convention of allowing you to "pick any programming language you want" is when you are interviewing for a domain-specific position, such as Front End/iOS/Android Engineer roles, in which you would need to be familiar with coding in JavaScript, Objective-C/Swift and Java respectively. If you need to use a data structure that the language does not support, such as a Queue or Heap in JavaScript, perhaps try asking the interviewer whether you can assume that you have a data structure that implements certain methods with specified time complexities. If the implementation of that data structure is not crucial to solving the problem, the interviewer will usually allow this. In reality, being aware of existing data structures and selecting the appropriate ones to tackle the problem at hand is more important than knowing the intricate implementation details.

## Study and Practice

### Recap CS fundamentals

If you have been out of college for a while, it is highly advisable to review CS fundamentals — Algorithms and Data Structures. Personally, I prefer to review as I practice, so I scan through my college notes and review the various algorithms as I work on algorithm problems from [LeetCode](https://leetcode.com/) and [Cracking the Coding Interview](http://www.crackingthecodinginterview.com/).

### Mastery through practice

Next, gain familiarity and mastery of the algorithms and data structures in your chosen programming language.

#### Practice coding questions

Practice coding algorithms using your chosen language. While [Cracking the Coding Interview](http://www.crackingthecodinginterview.com/) is a good resource for practice, I prefer being able to type code, run it and get instant feedback. There are various Online Judges such as [LeetCode](https://leetcode.com/), [HackerRank](https://www.hackerrank.com/) and [CodeForces](https://codeforces.com/) for you to practice questions online and get used to the language. From experience, LeetCode questions are the most similar to the kind of questions being asked in interviews whereas HackerRank and CodeForces questions resemble competitive programming questions.

#### Complexities

Learn and understand the time and space complexities of the common operations in your chosen language. After completing a question on LeetCode, I usually add the time and space complexities of the written code as comments above the function body to remind myself to analyze the algorithm after I am done with the implementation.

#### Practice good coding style

Read up on the recommended coding style for your language and stick to it. If you have chosen Python, refer to the PEP 8 Style Guide. If you have chosen Java, refer to Google's Java Style Guide.

#### Internalize the pitfalls

Find out and be familiar with the common pitfalls and caveats of the language. If you point them out during the interview and intelligently avoid falling into them, you will usually impress the interviewer and that results in bonus points for your feedback, regardless of whether the interviewer is familiar with the language or not.

## During the Coding Interview

In a real coding interview, you will be given a technical question by the interviewer, write code in a real-time collaborative editor (phone screen) or on a whiteboard (on-site) to solve the problem within 30–45 minutes. This is where the real fun begins!

## References

- <https://yangshun.github.io/tech-interview-handbook/picking-a-language>
