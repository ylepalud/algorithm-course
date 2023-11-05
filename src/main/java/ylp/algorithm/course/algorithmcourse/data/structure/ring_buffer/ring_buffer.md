# Ring buffer

[ ...   ]

 0       n

It's an offer size array list. You have 2 pointers the head and the tail

Before head, every value is null

After tail, every value is null

This way adding element at the end or at the start is easier and doesn't cost anything

What append if hit index after max length ?

The structure is a ring

Image an arrayBuffer of size 10

Where should I put element of index 12 ?

this.tail % len

Beware you're tail can't reach you're head. In that case you have to resize

However, Resize is very costy 


## Complexity

## Complexity

### Naive

Prepend//append Complexity = o(1)
Insertion middle Complexity = o(n)
Deletion start/end = o(1)
Deletion middle = o(n)
Get head/tail = o(1)
Get middle = o(n)