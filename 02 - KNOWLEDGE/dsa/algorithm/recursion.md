
## [[Problems]] - Generating Subsets

generating all subsets of a set of n elements

the subsets of {1, 2, 3} are ∅,{1},{2},{3},{1, 2},{1, 3},{2, 3}, and {1, 2, 3}


## C++ [[std]]: [[next_permutation]]:
```cpp
void next_perm(){
    vector <int> permutation;
    int n = 4;
    FOR(i, 1, n)
        permutation.push_back(i);

    do {
        forv(permutation);
    } while (next_permutation(permutation.begin(), permutation.end()));
}
```