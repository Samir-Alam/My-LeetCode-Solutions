<h2><a href="https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/">2522. Partition String Into Substrings With Values at Most K</a></h2><h3>Medium</h3><hr><div><p>You are given a string <code>s</code> consisting of digits from <code>1</code> to <code>9</code> and an integer <code>k</code>.</p>

<p>A partition of a string <code>s</code> is called <strong>good</strong> if:</p>

<ul>
	<li>Each digit of <code>s</code> is part of <strong>exactly</strong> one substring.</li>
	<li>The value of each substring is less than or equal to <code>k</code>.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> number of substrings in a <strong>good</strong> partition of</em> <code>s</code>. If no <strong>good</strong> partition of <code>s</code> exists, return <code>-1</code>.</p>

<p><b>Note</b> that:</p>

<ul>
	<li>The <strong>value</strong> of a string is its result when interpreted as an integer. For example, the value of <code>"123"</code> is <code>123</code> and the value of <code>"1"</code> is <code>1</code>.</li>
	<li>A <strong>substring</strong> is a contiguous sequence of characters within a string.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "165462", k = 60
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can partition the string into substrings "16", "54", "6", and "2". Each substring has a value less than or equal to k = 60.
It can be shown that we cannot partition the string into less than 4 substrings.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "238182", k = 5
<strong>Output:</strong> -1
<strong>Explanation:</strong> There is no good partition for this string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is a digit from <code>'1'</code> to <code>'9'</code>.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<style type="text/css">.spoilerbutton {display:block; border:dashed; padding: 0px 0px; margin:10px 0px; font-size:150%; font-weight: bold; color:#000000; background-color:cyan; outline:0; 
}
.spoiler {overflow:hidden;}
.spoiler > div {-webkit-transition: all 0s ease;-moz-transition: margin 0s ease;-o-transition: all 0s ease;transition: margin 0s ease;}
.spoilerbutton[value="Show Message"] + .spoiler > div {margin-top:-500%;}
.spoilerbutton[value="Hide Message"] + .spoiler {padding:5px;}
</style>
</div>