# Aho-Corasick Algorithm

Suppose I have m sequences each of variable lengths and I have a long query sequence of length n. I want to find how many of the m sequences exist as a substring in my query.

1. Construct a trie

2. Construct Failure Links

3. Consstruct Dictionary Links

To perform a search: Iterate over the query and the trie at the same time.
