# Recursion

A recursion is a function that keep call itself until the problem is solved

def foo(n):
    if n == 1:
        return 1
    return n + foo(n - 1)

    method call | return Argument | return Value | Argument
    foo 5 | whoever call | 5 + ? | 5
    for 4 | foo 5 | 4 + ? | 4
    foo 3 | foo 4 | 3 + ? | 3
    foo 2 | foo 3 | 2 + ? | 2
    foo 1 | foo 2 | 1 | 1

In this example, we dig deeper in the stack call then go back the stack call

We can see that we can do 3 thing (more on this in tree|graph chapters)

* Pre call
* call
* Post call

2 steps in recursion:

* Base case
* Recurse

## Maze solver

2D Array walk through between start and end

### Complexity

How to compute it ?

For a specific position we have 4 direction to check

-> O(4n) -> O(n)

## When do I use recursion

Can't create loop effectively 

and/or branching factor is very high (example direction)
