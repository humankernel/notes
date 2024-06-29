
# Queue (FIFO)

![Alt text](queue.webp)

## Complexity

| operation | order |
| :-:       | :-:    |
| Enqueue  | O(1) |
| Dequeue  | O(1) |
| Peeking  | O(1) |
| Contains | O(n) |
| Removal  | O(n) |
| is Empty | O(1) |

* Peaking is view the front value without deleting

## use cases

* waiting line models (like in real live)
* efficiently keep track of the `x` most recently added elements
* web server request (first come first serve)
* BFS

## Example BFS

![Alt text](queue_bfs.webp)
[bfs in python](bfs.py)

## Impl Details

![Alt text](queue.drawio.svg)
[Impl Java](Queue.java)
