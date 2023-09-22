# Discussion

The `Roster` class uses `IndexedList` to store a list of students. The
`Roster.find` implements the binary search algorithm. Which
implementation of the `IndexedList` should be used to implement the
`Roster` class? (It could be one or more of `ArrayIndexedList`,
`LinkedIndexList`, `SparseIndexedList`). And why?
   
--------------- Write your answers below this line ----------------
ArrayIndexedList would be the best IndexedList to implement the Roster class.
This is because it is fastest to retrieve elements at a certain index, which an operation that binary search uses a lot.
In addition, a SparseIndexedList would not be effective as there doesn't exist a "default student" in a Roster (students have unique IDs, names, ect), making it as effective as a LinkedIndexedList.
A LinkedIndexedList would have to traverse the entire list up to an element to retrieve its data, defeating the point of binary search.
