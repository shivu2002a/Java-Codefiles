This is a **very serious / master-level question** 👍
I’ll give you a **complete mental map of Graph + Tree techniques**, from **basic → advanced → competitive programming → interview → research-level**, including **tree flattening, rerooting, offline tricks, optimizations**, etc.

Think of this as a **graph DSA encyclopedia**.

---

# 🧠 GRAPH & TREE ALGORITHMIC TECHNIQUES — COMPLETE MAP

---

## 1️⃣ Graph Traversal & Exploration (Foundations)

### Basic Traversals

* **DFS (recursive / iterative)**
* **BFS**
* Multi-source BFS
* Layered BFS
* 0-1 BFS
* BFS on implicit graphs (state graphs)

### DFS Variants

* DFS with entry/exit time
* DFS with parent tracking
* DFS coloring
* DFS low-link computation

---

## 2️⃣ Graph Connectivity Techniques

* Connected components (DFS/BFS)
* Strongly Connected Components:

  * **Kosaraju**
  * **Tarjan**
* Bridge detection
* Articulation points
* 2-edge connected components
* 2-vertex connected components
* Block-cut tree

---

## 3️⃣ Graph Shortest Path Techniques

### Single Source

* **BFS** (unweighted)
* **Dijkstra**
* **Bellman–Ford**
* SPFA (practical, risky)

### Special Optimizations

* 0-1 BFS
* Dial’s algorithm
* Multi-state Dijkstra
* Dijkstra on DAG
* Dijkstra with bitmask state

### All Pairs

* Floyd–Warshall
* Johnson’s algorithm

---

## 4️⃣ Graph Cycles & DAG Techniques

* Cycle detection (directed / undirected)
* Topological sorting:

  * Kahn’s algorithm
  * DFS topo
* DAG DP
* Longest path in DAG
* Counting paths in DAG

---

## 5️⃣ Minimum Spanning Tree (MST)

* **Kruskal**
* **Prim**
* Borůvka
* DSU optimizations:

  * Union by rank
  * Path compression

---

## 6️⃣ Flow & Matching (Advanced Graphs)

### Flow

* Ford–Fulkerson
* Edmonds–Karp
* Dinic
* Push-Relabel

### Matching

* Bipartite matching
* Hopcroft–Karp
* Hungarian Algorithm
* Blossom Algorithm (general graph)

---

## 7️⃣ Graph Compression & Transformations

* Condensed graph (SCC DAG)
* Line graph
* Complement graph
* State compression graph
* Edge contraction

---

# 🌳 TREE-SPECIFIC TECHNIQUES (VERY IMPORTANT)

---

## 8️⃣ Tree Traversals & Properties

* Preorder / Inorder / Postorder
* Euler tour (entry / exit time)
* Depth, height
* Parent & subtree size

---

## 9️⃣ Tree Flattening Techniques 🔥

### Euler Tour Flattening

* Flatten subtree to array
* Subtree queries using:

  * Fenwick Tree
  * Segment Tree

### Binary Tree Flattening

* Morris Traversal
* Threaded trees

---

## 🔟 LCA (Lowest Common Ancestor)

* Binary lifting
* Euler Tour + RMQ
* Sparse Table
* Tarjan’s offline LCA

---

## 1️⃣1️⃣ Tree DP Techniques

* Subtree DP
* Rooted tree DP
* Leaf → root DP
* Parent → child DP
* **Rerooting DP**
* DP on trees with constraints

---

## 1️⃣2️⃣ Heavy-Light Decomposition (HLD) 🚀

* Decompose tree into chains
* Path queries
* Path updates
* Segment tree on chains

---

## 1️⃣3️⃣ Centroid Techniques

* Centroid finding
* Centroid decomposition
* Divide & conquer on tree
* Distance counting problems

---

## 1️⃣4️⃣ Binary Lifting Applications

* K-th ancestor
* Path queries
* Jump pointers
* Lifting in dynamic trees

---

## 1️⃣5️⃣ Virtual Trees

* Build minimal tree from subset of nodes
* LCA compression
* Used in offline queries

---

## 1️⃣6️⃣ Tree Queries & Offline Techniques

* Offline subtree queries
* Mo’s algorithm on trees
* DSU on Tree (small-to-large)
* Query reordering

---

## 1️⃣7️⃣ DSU on Tree (Sack Technique)

* Frequency queries on subtree
* Color counting
* Mode queries
* Merge small subtree into large

---

## 1️⃣8️⃣ Dynamic Trees

* Link-Cut Trees
* Euler Tour Trees
* Dynamic connectivity
* Online add/remove edges

---

## 1️⃣9️⃣ Graph DP Techniques

* DP on DAG
* DP with topological order
* DP with SCC condensation
* Tree + DP + Queries

---

## 2️⃣0️⃣ Bitmask & State Graph Techniques

* Graph on subsets
* BFS/DFS on state space
* Bitmask DP
* Meet-in-the-middle on graphs

---

## 2️⃣1️⃣ Graph Coloring & Labeling

* Bipartite checking
* Graph coloring (greedy)
* Chromatic number (NP-hard)
* 2-SAT graph modeling

---

## 2️⃣2️⃣ Tree & Graph Re-Rooting Tricks

* Change root dynamically
* Reroot DP transitions
* Contribution technique

---

## 2️⃣3️⃣ Path & Distance Techniques

* Tree diameter
* Two BFS trick
* All-pairs distance on tree
* Distance via LCA

---

## 2️⃣4️⃣ Lowest Level Optimizations

* Bitsets in graph DP
* Memory compression
* Adjacency list tricks
* Fast IO + recursion removal

---

## 2️⃣5️⃣ Offline & Query Optimization

* Mo’s algorithm
* Divide & conquer on queries
* Parallel binary search
* Batch processing

---

## 2️⃣6️⃣ Advanced / Rare but Powerful

* Matrix exponentiation on graph
* Kirchhoff’s theorem
* Tree isomorphism
* Prüfer sequence
* Randomized graph algorithms

---

# 🧩 Mental Model (Very Important)

Almost **every graph problem** is one of:

1. **Traversal**
2. **DP**
3. **Shortest path**
4. **Decomposition**
5. **Transformation**
6. **Offline trick**

> Hard problems = **combination of 2–3 techniques**

---

## 🔥 Example Combinations

* Tree Flattening + Fenwick
* HLD + Segment Tree
* SCC + DAG DP
* Rerooting DP + LCA
* DSU on Tree + offline queries

---

## 🎯 If you want next:

I can:

* Rank these techniques by **interview importance**
* Give **problem archetypes** for each
* Map **CSES problems → techniques**
* Teach **tree flattening + HLD with code & dry run**

Just tell me how deep you want to go 🚀
