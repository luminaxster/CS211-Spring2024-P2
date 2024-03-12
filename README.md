# Project 2: Deus Ex Machina

###  CS 211: Object Oriented Programming - Spring 2024 

The purpose of this assignment is to familiarize you with generics through the use of `ArrayList` within a package. Your task involves creating a set of types for the `sublime` package, necessitating a grasp of generics, interfaces, exceptions, enumerations, and two types from the Java `collections` framework, as well as the `westworld` package. To do so, you will become familiar with reading Java docs. The test class `DoloresTest.java` is provided for you to include your test cases. Scripts for compiling your code and executing your tests are also provided.

## Prelude

As you embark on Project 2 (P2), you're building upon the foundation laid in Project 1 (P1), with reduced complexity, where you've already started working with JSON-like strings to represent parts of a `Machine` within Exercise 2's (E2) `Robot`.

In P2, you will be tasked with extending and implementing logic in new classes, interfaces, and a test class that you'll have to implement to specification.

To guide you through this project, we included the easter eggs in P1. The aim is to ensure that the instructions are clear and the level of difficulty is manageable. The primary focus will be on structuring your code correctly, which will account for 50% of the project. The remaining 50% will involve algorithmic challenges within `NarrativeLoop`.

Remember, the goal here is not just to complete the task but to understand and apply Java constructs effectively. Take this opportunity to solidify your understanding and showcase your problem-solving skills in a structured and logical manner.

## ChangeLog

- None yet.

## Rules
0. **This project is an individual effort; the Honor Code applies.**
1. [**Download the source code**](). Do not modify the structure of the directories nor the code for the package `westworld`. 
2. You may import the following types from `java.util`: `ArrayList`, `List`; `westworld`: all. Other imports are not allowed.
3. The `main` method is no longer recommended; you will now required to put the "main" logic in unit tests.
4. Comment your code, especially any parts that are not obvious what you're doing. Consider explaining your loops and methods. 
5. Class fields should not in general be visible to other classes (unless otherwise specified). Create getter methods instead.
6. You may add your own helper methods or data fields, but they must be declared `private`.

## WestWorld package [DO NOT MODIFY]
Refer to the JavaDoc( located at `westworld/docs/index.html` (Windows: `westworld\docs\ndex.html`) to explore the API; it's unnecessary to review the code to utilize the package. However, if you're interested in potential solutions for P1 and E2, you're encouraged to examine them.

Now, you'll need to employ the `Robot` class for your `sublime` package implementation. While reading the documentation, note that four easter eggs have been incorporated within P1, illustrating how E1's Robot has become extremely powerful, albeit abstractly.

# DO NOT PROCEED WITHOUT READING THE DOCUMENTATION
# MAKE SURE YOUR JAVA VERSION IS AT LEAST 11
# Do not use deprecated types or members


---

## Sublime package [YOUR PROJECT]

Remember to be precise with the names and types in every abstraction you work on. Prefer copying from the description rather than transcribing, and be mindful of naming conventions and case sensitivity.

All your work must be located in the directories matching the `src.main` package. Your test class `DoloresTest.java` in located in `src.test`.

### Realm Enum
This `enum` is integral to a narrative management system, specifically used within the `NarrativeLoop` class to categorize narrative processes.

Enum Details:

  - `EMULATION`: Represents high-fidelity replications of the original system.
  - `SIMULACRA`: Denotes abstracted or distorted representations, not directly tied to the original.
  - `SIMULATION`: Indicates simplified models for exploring system behaviors.

### Abstract NarrativeLoop Class

Implement the `NarrativeLoop` class and include logic for filtering `SystemWhole` parts by kind, then populating the three `ArrayLists` (`emulation`, `simulacra`, `simulation`) based on this filter, we'll focus on the `updateNarrativeLoops` method. This method will execute the core algorithm, effectively making up the crucial 20% that handles the classification and organization of narrative elements. In this class:

### Fields

The `NarrativeLoop` class includes three fields, all `final` and `protected`, `List` of `SystemWhole`s initialized to new `ArrayList`s:

1. **emulation**
2. **simulacra**
3. **simulation**

#### Methods Flow

To implement the `NarrativeLoop` class, follow these steps closely, ensuring each part is executed as described:

##### Step 1: updateNarrativeLoops(SystemWhole[] emulationContext, SystemWhole[] simulacraContext)

- Begin by iterating over each `SystemWhole` in the `emulationContext` array.
  - For each `SystemWhole`, iterate through the `Machines` it contains.
  - Invoke `determineRealm` with the `Machine`'s kind and both context arrays as parameters.
  - If `determineRealm` returns `Realm.EMULATION` and `containsKind` confirms the `emulation` list doesn't already include a `Machine` of this kind, add the `SystemWhole` to `emulation`.
- Repeat the process for the `simulacraContext` array.
  - For `Realm.SIMULACRA`, add unique `Machine` kinds to `simulacra`.
  - For `Realm.SIMULATION`, add unique `Machine` kinds to `simulation`.

#### Step 2: determineRealm(String kind, SystemWhole[] emulationContext, SystemWhole[] simulacraContext)

- Check for the presence of the `Machine` kind in both `emulationContext` and `simulacraContext` using `isInContext`.
- Assign `Realm.SIMULATION` if the kind is found in both contexts.
- Assign `Realm.SIMULACRA` if the kind is found only in `simulacraContext`.
- Default to `Realm.EMULATION` if neither of the above conditions is met.

#### Step 3: isInContext(String kind, SystemWhole[] context)

- Iterate through the `SystemWhole` array provided as `context`.
  - Within each `SystemWhole`, iterate through its `Machines`.
  - Return `true` if any `Machine` matches the specified kind.
- Return `false` if no match is found.

#### Step 4: containsKind(List<SystemWhole> list, String kind)

- Iterate over the provided `list` of `SystemWhole` instances.
  - For each `SystemWhole`, iterate through its `Machines`.
  - Return `true` if any `Machine` within the `SystemWhole` matches the specified kind.
- Return `false` if no matching `Machine` kind is found within any `SystemWhole` in the list.


### MazeLoop Class (inherits from NarrativeLoop)

`MazeLoop` is a subclass of `NarrativeLoop`, designed for narratives centered around `Dolores` alone, It overrides the `wipeNarrativeLoops()` method to implement maze-specific narrative wiping logic, which is just not allow the inherited wipe behavior.

### HostLoop Class (inherits from NarrativeLoop)

`HostLoop` is a subclass of `NarrativeLoop`, designed for narratives centered around `hosts`. It inherits the functionalities of `NarrativeLoop` as is.

### Freezable Interface

### Analyzable Interface

### Wipeable Interface (inherits from Analyzable)

### Dolores Class (inherits from Robot) 4 methods, one liners

### Host Class (inherits from Dolores) 2 methods, one lienrs, one  needs to throws one exception,

## Testing:

You are responsible for ensuring your code functions correctly according to the description provided above. A validation checker will be made available on gradescope which will try to catch errors that would prevent the autograder from running. Passing this validation check does not guarantee that all of the required logic has been implemented correctly. You should write your own tests which exercise all of the required functionality in a variety of different situations in order to verify that your code operates as you expect it to. Code which does not compile or fails any of the validation checks may receive zero credit.

### DoloresTest Class

Your test class `DoloresTest.java` in located in `src.test`. Provided test class template, one test method, with hints.

## Submission:

Submission instructions are as follows (up to **5pts** penalty for not following the below instructions). No exceptions this time (pun intended).

Upload all of your source files (*.java) to the P2 assignment on [Gradescope](https://www.gradescope.com/). Do not include anything else (no .class file, no blank templates, not this file, no .zip files).
At the top of each source file, include the following information in a comment: Name, gmu netID, g#, lecture section, and lab section. Include information for all group members. Here's an example:
```java
/*
* Names: Donald Knuth, Alan Turing
* netID: dknuth, aturin3
* G#: 00123456, 01101001
* Lecture section: 004, 004
* Lab section: 213, 212
*/
```

Verify your submission: Go back to Gradescope, download the files you just submitted, double-check their contents, rerun your tests. If something is wrong, you can resubmit as many times as you want before the deadline expires.
Make a backup of your files on OneDrive (use your mason account).
