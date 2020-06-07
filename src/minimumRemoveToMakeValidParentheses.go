package src

import (
	"fmt"
	"strings"
	"testing"
)

/**
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

----------
Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
----------
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
----------
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
----------
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"

----------
Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
 */


func minRemoveToMakeValid(s string) string {
	if len(s) == 0 {
		return s
	}
	result := []byte(s)
	fromLeft := 0
	fromRight := len(s) - 1
	for true {
		if fromLeft >= fromRight ||
			result[fromLeft] == '(' && result[fromRight] == ')' {
			break
		}
		if result[fromLeft] != '(' {
			if result[fromLeft] == ')' {
				result[fromLeft] = 0
			}
			fromLeft++
		}
		if result[fromRight] != ')' {
			if result[fromRight] == '(' {
				result[fromRight] = 0
			}
			fromRight--
		}
	}

	var char byte
	openCount := 0
	for i := fromLeft; i <= fromRight; i++ {
		char = result[i]
		if char != '(' && char != ')' {
			continue
		}
		if char == '(' {
			openCount++
			continue
		}
		if openCount == 0 {
			result[i] = 0
			continue
		}
		openCount--
	}

	for i := fromRight; i >= 0 && openCount > 0; i-- {
		if result[i] == '(' {
			result[i] = 0
			openCount--
		}
	}

	var b strings.Builder
	b.Grow(len(s))
	for i := 0; i < len(s); i++ {
		if result[i] != 0 {
			b.WriteByte(result[i])
		}
	}
	return b.String()
}

func Test(t *testing.T) {
	tests := []struct {
		name  string
		input string
	}{
		{
			"0",
			"())()(((",
		},
		{
			"1",
			"lee(t(c)o)de)",
		},
		{
			"2",
			"a)b(c)d",
		},
		{
			"3",
			"))((",
		},
		{
			"4",
			"(a(b(c)d)",
		},
		{
			"5",
			"((a(a)(b))",
		},
		{
			"6",
			")i()()((fm(((()",
		},
	}
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			fmt.Printf("%s --> %s\n", test.input, minRemoveToMakeValid(test.input))
		})
	}
}
