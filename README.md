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
Checkout the 'outputs' folder for the implementation of the app.
