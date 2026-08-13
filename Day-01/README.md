# Day 01 — Frog Jump

## Problem

Given an array of heights, a frog starts at index `0` and needs to reach the last index.

The frog can jump either:

- 1 step
- 2 steps

The cost of a jump from index `i` to index `j` is:

`|height[i] - height[j]|`

Find the minimum cost required to reach the last index.

---

## Approach — Recursion

At every index, the frog has two possible choices:

1. Jump 1 step
2. Jump 2 steps

For each choice, we recursively calculate the remaining minimum cost and take the minimum of both choices.

### Recursive State

`solve(i)` represents:

> The minimum cost required to reach the last index starting from index `i`.

### Recurrence

```text
solve(i) = min(
    |height[i] - height[i+1]| + solve(i+1),
    |height[i] - height[i+2]| + solve(i+2)
)