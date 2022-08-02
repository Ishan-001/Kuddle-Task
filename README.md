# Kuddle-Task

## Objectives

1. Classes can be of multiple types - yoga, gym, dance.
2. Each class has a capacity. This refers to the maximum number of users that can attend
the class.
3. Users can book a class if the capacity is not yet reached.
4. If a class is already at capacity, the system should maintain a waiting list of interested
users.
5. Users can cancel the slot upto 30 mins before the class starts. When a user cancels their
booking, allocate the canceled slot to the first user from the waitlist.

## Description:

The app contains two files : 

- `Book.java` contains the bussiness logic of the app
- `Classes.java` contains the main class for storing classes and their attributes like ``currentUsers``, ``currentSlots``, etc.

The `Classes.java` contains methods to check if user can cancel a class, join a class, check if a class is full, update the queue, etc.

## Implementation

- To add a class, input the class details like ``Name``, ``totalSlots``, etc.

<img src="https://github.com/Ishan-001/Kuddle-Task/blob/main/outputs/add-class.PNG">

- To join a class, input your ``userName`` and the ``className`` you want to join.

<img src="https://github.com/Ishan-001/Kuddle-Task/blob/main/outputs/join-class.PNG">

- If the class is full, the user is added to a `queue` and the error message and queue is displayed.

<img src="https://github.com/Ishan-001/Kuddle-Task/blob/main/outputs/queue.PNG">

## Note to recruiters:

- I haven't made an extra class for `User` as we were allowed to use just names for the app functioning.
- The code might feel less modular due to time constraint, otherwise I would have seperated the database operations from ``Book.java`` altogether.
- I have used a simple array for storing the queue of users, could have used ``Queue`` data structure.
