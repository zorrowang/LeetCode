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
  - [Before the interview (remote)](#before-the-interview-remote)
  - [Upon receiving the question](#upon-receiving-the-question)
  - [Question definition and clarification](#question-definition-and-clarification)
    - [What the API takes](#what-the–api-takes)
    - [What the API does](#what-the-api-does)
    - [What the API returns](#what-the-api-returns)
  - [Communication after clarifying the question](#communication-after-clarifying-the-question)
  - [What to do when getting stuck](#what-to-do-when-getting-stuck)
  - [When writing code](#when-writing-code)
  - [After finishing coding](#after-finishing-coding)
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

In a real coding interview, you will be given a technical question by the interviewer, write code in a real-time collaborative editor (phone screen) or on a whiteboard (on-site) to solve the problem within 30–45 minutes.

Coding interview on whiteboard is tough, and does not always find good candidates ([Max Howell interviewing at Google](https://www.quora.com/Whats-the-logic-behind-Google-rejecting-Max-Howell-the-author-of-Homebrew-for-not-being-able-to-invert-a-binary-tree)). However, it is a well-defined and fair method to filter out "non-qualified" engineers. With more studying and practicing, we can be better on it.

### Before the interview (remote)

For phone screens or remote interviews, prepare paper and pen to jot down and visualize stuff. If you are given a question on trees and graphs, it usually helps if you draw out some examples of the data structure given in the question.

Use earphones and make sure you are in a quiet environment. You definitely do not want to be holding a phone in one hand and only be able to type with the other. Try avoiding using speakers because if the echo is bad, communication is harder and repeating of words will just result in loss of valuable time.

### Before the interview (onsite)

Some companies, such as Uber, allow candidates to bring their laptop. You need to make sure the IDE and development environment are well setup.

### Communication

As an interviewer, she is looking out for the approvals that you meet requirements of the role, and it is up to you to show the fitness. Initially it may feel weird to be talking while you are coding as most programmers do not have the habit of explaining out loud as they are typing code. However, it is hard for the interviewer to know what you are thinking just by looking at the code that you type. If you communicate your approach to the interviewer before you start coding, you can validate your approach with them and the both of you can agree upon an acceptable approach.

### Upon receiving the question

Many candidates jump into coding the moment they hear the question. That is usually a big mistake. Take a moment to repeat the question back at the interviewer and make sure that you understand exactly what they are asking. Rephrasing the question will reduce chances of miscommunication and misunderstanding.

Always seek clarification about the question upon hearing it even if it you think it is clear to you. You might discover something that you have missed out and it also leaves an impression to the interviewer that you are a careful person who pays attention to details. Some interviewers deliberately omit important details to see if you ask the right questions.

### Question definition and clarification

The question of coding interview is commonly abstracted and formatted as

- A set of inputs, which could include array, matrix, integers and etc.
- A set of calculation rules, such as medium of an unsorted array.
- A return value (it is rare to return a set of values with various formats)

As the result, the solution is essentially to define a public API, which takes some input and returns the desired results. The list needs to be clarified is

- What the API takes - the input of API
- What the API does - the functionality of API
- What the API returns - the output of API

#### What the API takes

- How big is the size of the input?
- Does the input fit into the memory?
- How big is the range of input value?
- What kind of values are there?
  - Is the input nullable?
  - Could the input empty?
  - Are there negative numbers?
  - Are there Floating points?
- Are there duplicates within the input?
- Should the input value be kept?
- What are some extreme cases of the input?
  - Max or min value if the input is 32bit integer

#### What the API does

- Clarify the requirement for the time and space complexity
- List all functional requirements and each of them would be one method

#### What the API returns

- Can the input be modified as output?
- Should the API return or display the result?

### Communication after clarifying the question

After you have sufficiently clarified the scope and intention of the problem, explain your high level approach to the interviewer even if it is a naive solution. If you are stuck, consider various approaches and explain out loud why it will or will not work. Sometimes your interviewer might drop hints and lead you towards the right path.

Start with a brute force approach, communicate it to the interviewer, explain the time and space complexity and why it is bad. It is unlikely that the brute force approach will be one that you will be coding. Only start coding after you and your interviewer have agreed on an approach and they have given you the green light.

### What to do when getting stuck

Getting stuck during coding interviews is extremely common. But do not worry, that is part of the process and is a test of your problem solving abilities. Here are some tips to try out when you are stuck:

- Talk through what you initially thought might work and explain why it doesn't
  - This can help guide you on the right track by avoiding the pitfalls
- Come up with more test cases and write them down
  - A pattern may emerge
- Think about how you would solve it without a program
  - You may spot a pattern and come up with a general algorithm for it
- Recall past questions related to the topic, what similar questions in the past have you encountered and what techniques did you use?
- Enumerate through the common data structures and whether they can be applied to the question
  - Dictionaries/maps are extremely common in making algorithms more efficient
- Look out for repeated work and determine if you can cache those computations
  - Trade off memory for speed

### When writing code

The goal in the middle of coding is to make the interviewer fully understand it. So you should

- Write your code with good coding style
  - Use meaningful variable and function names, but not extremely verbose
  - Avoid single letter names
  - Abbreviations with oral explanation is good enough
- Always think aloud
  - Explain what you are currently writing to the interviewer
- Copy a large chunk of code usually means you need to do a refactor

### After finishing coding

After you have finished coding, do not immediately announce to the interviewer that you are done. In most cases, your code is usually not perfect and contains some bugs or syntax errors. What you need to do now is to review your code.

- Go through the code
  - Fix any syntax errors
  - Make some small refactoring to make the code cleaner
- Write down some test cases and dry-run the code
  - Use this step as unit testing to debug the code
- Proactively give the time and space complexity of the function and explain why it is so

If your interviewer is happy with the solution, the interview usually ends here. It is also not uncommon that the interviewer asks you extension questions, such as how you would handle the problem if the whole input is too large to fit into memory, or if the input arrives as a stream. This is a common follow-up question at Google where they care a lot about scale. The answer is usually a divide-and-conquer approach — perform distributed processing of the data and only read certain chunks of the input from disk into memory, write the output back to disk, and combine them later on.

## References

- <https://yangshun.github.io/tech-interview-handbook/picking-a-language>
