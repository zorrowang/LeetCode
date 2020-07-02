# LeetCode

## What is LeetCode

It’s a [website](www.leetcode.com) where people–mostly software engineers–practice their coding skills. There are 1400+ questions (and growing), each with multiple solutions. Questions are ranked by level of difficulty: _easy_, _medium_, and _hard_.

Similar websites include LintCode, HackerRank, Topcoder, InterviewBit, and etc. LeetCode could be the most popular one, because it has more questions and active users.

## Why LeetCode

The primary reason why we use LeetCode is to prepare for the technical portion of a software engineer or manager interview.
The technical interview process has become formulaic for years. Whiteboard coding plays an important role, specially for less experienced engineers.

## How to use LeetCode

The goal of using LeetCode is to scramble your way into a top tech company. The general tips we could get better are

- Consistency is key. You want to start as much in advance as you can, and do it daily. Doing it for one hour a day is better than doing it for seven hours on Sunday only.
- Focus on active improvement. This means that if you're on auto-pilot or if you're not focusing, then it's OK to just stop and come back later.
- Remember that everybody is different and there is no one-size-fits-all. So feel free to deviate from this (or any) guide.

For generalist SWE roles, you should focus on the Algorithms type of problems. Years ago, these were the only problems, but since then, Database, Shell, and Concurrency have been added. So you should view only Algorithms problems in the problem set:

    https://leetcode.com/problemset/algorithms/

This is going to be your "home base", so let's customize it.

- You can click the "Difficulty" header twice to sort it from easiest to hardest. Interesting enough, this also sorts them within each Easy/Medium/Hard category in reverse order by acceptance rate.
- Click the empty header in the first column to sort with the unsolved problems on top.
- Finally, you can optionally run this script in your web browser console to filter out the questions that are locked for non-premium users. Of course, it's a little sketchy to run Javascript you find online in your browser console, but it's pretty simple if you want to understand what it does.

Obviously the best thing you can do it just solve every single problem on LeetCode. If you do that, you're really good to go. But, unfortunately, nobody has unlimited time on their hands, so we're going to have to optimize a little.

- Start from easiest to hardest. You can start skipping questions if you feel like the problems are getting too easy for you.
- Start with problems that have an editorial already written. These are the ones with a little "document page" icon in the "Solution" column of the problem set. As an exercise to the reader, you could re-purpose the script above to filter only for problems that have a per-written editorial.
- Start with problems that have good reviews. While LeetCode is a pretty great platform, not all problems are created equal. If you open a problem, you can see how many people upvoted or downvoted a problem. I'd initially stay away from problems that have a worse than 2:1 ratio of upvotes to downvotes, and problems that have 4:1 or above are usually of fairly high quality. It's much easier to learn from the higher-rated problems.

Eventually, you're going to find a problem that's too hard, and you'll get stuck. That's totally fine. In fact, it's absolutely fine (and perhaps even efficient) to give up on some problems. It's possible that it requires an algorithm or data structure that you haven't seen before, and there's no need for you to pull your hair out trying to re-discover an algorithm or data structure. Here are some tips for how to get un-stuck.

- First, if there is an editorial already written for the problem, start with that. These tend to be fairly high-quality and often include a well-written code solution.
- Second, open the "Discuss" tab for the problem, and read some of the posts. These vary wildly in quality: some people just post a solution; others go into great detail. Your mileage may vary here, but this is also often a helpful resource if you get stuck.
- Finally, you can Google the problem itself, and oftentimes other people will have posted solutions or written about it on third-party sites, like their personal blog or Github repo.

Note, I do think even after you complete the solution and pass the OJ, it is worth to check some most voted solution in "Discuss" section. Mostly, you could find some solutions with better algorithm or data structure.

Once you've gotten into the groove, and you feel mostly confident solving the problems on LeetCode, it's time to refine your skills.

- If you feel weaker in a certain algorithm, you can filter the problem set by "Tag". This is NOT recommended for general practice, since much of the actual problem-solving skill you want to have is the ability to identify the type of algorithm to solve a problem. So, if you have filtered by "Binary Search", you know the solution to the problem is probably going to be binary search.
- Go through some older problems, and make sure that you have found the optimal solution. Oftentimes, the LeetCode online judge will actually accept suboptimal solutions. If an O(N) solution exists, but you submitted an O(N log N) solution, most likely it's going to still pass. The percentiles for runtime/memory are actually a bit misleading so don't worry too much about that. The only time that it kind of helps if there are two very different runtimes, like O(N) vs O(N^2), and the runtime distribution will look bimodal.
- The weekly contests are a great way to see where you stack up against the rest of the community. Plus, they apply some time pressure, and usually give new problems that you haven't seen before.
- This is new and not available several years ago, but the new Mock Interview is actually really good for adding some time pressure. Unfortunately, there is no way to filter out previously solved problems, so you might get repeats of ones you've done before--but you can view this as an opportunity to revisit some of the older problems. Apparently, this can also help you identify areas of weakness.

For algorithmic problem solving skills, in general, the more you practice, the better you would be.

## Drawbacks of LeetCode

- LeetCode OJ is too constraint for _hard_ questions. It sometimes only accepts optimal solution, such as DP.
- LeetCode is lack of online debugging tool, which makes hard to identify bugs. However, the bright side of this is to force you to dry-run through your solution.
- LeetCode is unable to mark different stages in solving a problem (e.g. thought-out, implemented, optimized, on-line judged, summarized).
- LeetCode does not provide stack trace when error happens.

## Why LintCode

LintCode serves as a supplement of LeetCode, specially for the locked question. It also provides great tutorial for some questions.
