<h2><a href="https://leetcode.com/problems/stamping-the-sequence/">936. Stamping The Sequence</a></h2><h3>Hard (Solution Down Below 👇🏻)</h3><hr><div><p>You are given two strings <code>stamp</code> and <code>target</code>. Initially, there is a string <code>s</code> of length <code>target.length</code> with all <code>s[i] == '?'</code>.</p>

<p>In one turn, you can place <code>stamp</code> over <code>s</code> and replace every letter in the <code>s</code> with the corresponding letter from <code>stamp</code>.</p>

<ul>
	<li>For example, if <code>stamp = "abc"</code> and <code>target = "abcba"</code>, then <code>s</code> is <code>"?????"</code> initially. In one turn you can:

	<ul>
		<li>place <code>stamp</code> at index <code>0</code> of <code>s</code> to obtain <code>"abc??"</code>,</li>
		<li>place <code>stamp</code> at index <code>1</code> of <code>s</code> to obtain <code>"?abc?"</code>, or</li>
		<li>place <code>stamp</code> at index <code>2</code> of <code>s</code> to obtain <code>"??abc"</code>.</li>
	</ul>
	Note that <code>stamp</code> must be fully contained in the boundaries of <code>s</code> in order to stamp (i.e., you cannot place <code>stamp</code> at index <code>3</code> of <code>s</code>).</li>
</ul>

<p>We want to convert <code>s</code> to <code>target</code> using <strong>at most</strong> <code>10 * target.length</code> turns.</p>

<p>Return <em>an array of the index of the left-most letter being stamped at each turn</em>. If we cannot obtain <code>target</code> from <code>s</code> within <code>10 * target.length</code> turns, return an empty array.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre><strong>Input:</strong> stamp = "abc", target = "ababc"
<strong>Output:</strong> [0,2]
<strong>Explanation:</strong> Initially s = "?????".
- Place stamp at index 0 to get "abc??".
- Place stamp at index 2 to get "ababc".
[1,0,2] would also be accepted as an answer, as well as some other answers.
</pre>

<p><strong>Example 2:</strong></p>

<pre><strong>Input:</strong> stamp = "abca", target = "aabcaca"
<strong>Output:</strong> [3,0,1]
<strong>Explanation:</strong> Initially s = "???????".
- Place stamp at index 3 to get "???abca".
- Place stamp at index 0 to get "abcabca".
- Place stamp at index 1 to get "aabcaca".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= stamp.length &lt;= target.length &lt;= 1000</code></li>
	<li><code>stamp</code> and <code>target</code> consist of lowercase English letters.</li>
</ul>
</div>


# Solution

## Approach 1: Work Backwards

* Intuition

Imagine we stamped the sequence with moves m_1, m_2, ⋯ Now, from the final position target, we will make those moves in reverse order.

Let's call the ith window, a subarray of target of length stamp.length that starts at i. Each move at position i is possible if the ith window matches the stamp. After, every character in the window becomes a wildcard that can match any character in the stamp.

For example, say we have stamp = "abca" and target = "aabcaca". Working backwards, we will reverse stamp at window 1 to get "a????ca", then reverse stamp at window 3 to get "a??????", and finally reverse stamp at position 0 to get "???????".

* Algorithm

Let's keep track of every window. We want to know how many cells initially match the stamp (our "made" list), and which ones don't (our "todo" list). Any windows that are ready (ie. have no todo list), get enqueued.

Specifically, we enqueue the positions of each character. (To save time, we enqueue by character, not by window.) This represents that the character is ready to turn into a "?" in our working target string.

Now, how to process characters in our queue? For each character, let's look at all the windows that intersect it, and update their todo lists. If any todo lists become empty in this manner (window.todo is empty), then we enqueue the characters in window.made that we haven't processed yet.
