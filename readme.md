# Task Tracker
A simple command-line interface (CLI) application for managing tasks. You can add, update, delete, mark, and list tasks in the terminal
## Installation
1. **Clone this repo**
```
git clone https://github.com/josefernandosilva2007/task-tracker-cli.git
cd task-tracker/src
```
2. **Compile the source code**
```
javac TaskCli.java
```
3. **Run the application**
```
java TaskCli <command> [arguments]
```

## Usage
````
# Adding a new task
java TaskCLIApp add "Buy groceries"

# Updating a task
java TaskCLIApp update 1 "Buy groceries and cook dinner"

# Deleting a task
java TaskCLIApp delete 1

# Marking a task as in progress
java TaskCLIApp mark-in-progress 1

# Marking a task as done
java TaskCLIApp mark-done 1

# Listing all tasks
java TaskCLIApp list
# Output: List of all tasks

# Listing tasks by status
java TaskCLIApp list todo
java TaskCLIApp list in-progress
java TaskCLIApp list done
````



