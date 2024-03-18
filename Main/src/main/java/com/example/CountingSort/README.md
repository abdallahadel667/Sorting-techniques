# Counting Sort
Counting sort is an algorithm for sorting a collection of objects according to keys that are small integers; that is, it is an integer sorting algorithm. It operates by counting the number of objects that have each distinct key value, and using arithmetic on those counts to determine the positions of each key value in the output sequence. Its running time is linear in the number of items and the difference between the maximum and minimum key values, so it is only suitable for direct use in situations where the variation in keys is not significantly greater than the number of items. However, it is often used as a subroutine in another sorting algorithm, radix sort, that can handle larger keys more efficiently.

## Algorithm
The algorithm works by creating an auxiliary array `count[]` of size `k` (where `k` is the range of the input) and then using it to count the number of occurrences of each distinct element in the input array. The `count[]` array is then modified to store the position of each element in the output array. Finally, the output array is filled by iterating through the input array and using the `count[]` array to place each element at its correct position.
