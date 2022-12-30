# OOP.Assignment1

## About the project
### _UndobleStringBuilder_
the indoablestringbuilder is a stringbuilder that can use the following methods: 
* delete 
* undo
* append 
* reverse 
* replace 
* insert 
the class is added to the project 

### _Observer_
the observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.

#### uses:
* when an abstraction has two aspects, one dependent on the other
* when you are interested in the state of an object and want to get notified whenever there is any change.
* when changing one object requires changing others, and you don't know how many objects needed to be changed

## The classes 
#### in this project we used the following classes to execute the observer pattern with undoablestringbuilder:

### _Member interface_
The member interface actes as an updating interface for objects from UndoableStringBuilder. <br />
the members that are written as members from the sender interface needs to be implemented in the member interface.

### _Sender interface_ 
The sender interface defines the methods that a sender object should implement, such as 
* register
* unregister 
* insert 
* apeend <br />
Etc. 

### _GroupAdmin class_ 
The GroupAdmin class implement the member interface. <br />
the GroupAdmin class has multiple methods used on an undoablestringbuilder, such as; append ,delete,insert and undo methods all form the UndoableStringBuilder class. <br />
after every operation we used the function notifyAllMembers. this method is going through the list of members and for each member calls the Update method, which is being operated in each member in the ConcreteMember class. 











