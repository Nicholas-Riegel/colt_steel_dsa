to run:
javac -d bin *.java && java -cp bin j09_hash_tables.Main
-------------
Hash tables are used to store key-value pairs.

They are like arrays, but the keys are not ordered.

Unlike arrays, hash tables are fast for all of the following operations: finding values, adding new values, and removing values!

Python has Dictionaries

JS has Objects and Maps*

Java, Go, & Scala have Maps

Ruby has...Hashes

To implement a hash table, we'll be using an array.

In order to look up values by key, we need a way to convert keys into valid array indices.

A function that performs this task is called a hash function.

WHAT MAKES A GOOD HASH?
Fast (i.e. constant time)
Doesn't cluster outputs at specific indices, but distributes uniformly
Deterministic (same input yields same output)