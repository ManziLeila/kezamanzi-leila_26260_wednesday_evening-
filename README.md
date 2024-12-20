# kezamanzi-leila_26260_wednesday_evening-
# **Java Exception Handling**

This covers the usage of **exception handling** in Java. It triggers and handles various types of **Checked** and **Unchecked Exceptions** intentionally. It contains examples for each type of exception and shows how those can happen in real-life applications, how they must be properly treated, and handled to maintain program stability.


## **Directory Structure**
 
```dos
|-- src/
    |-- checked/
        |-- IOException.java
        |-- FileNotFoundException.java
|-- checked/
        |-- EOFException.java
        |-- SQLException.java
        |-- ClassNotFoundException.java
    |-- unchecked/
        |-- ArithmeticException.java
        |-- NullPointerException.java
        |-- ArrayIndexOutOfBoundsException.java
        |-- ClassCastException.java
|-- IllegalArgumentException.java
        |-- NumberFormatException.java
|-- README.md
```

---
 
## **Types of Exceptions**

### **Checked Exceptions**

Checked exceptions are those that a well-written application should anticipate and recover from. Checked exceptions must be either declared in a method or constructor's `throws` clause or caught in a `try-catch` block. These exceptions are checked at compile-time.
1. **`IOException`** 

   - **Scenario**: Reading from a non-existent file. 
   - **Purpose**: Illustrates the handling of general input/output errors. 
2. **`FileNotFoundException`**

- **Scenario**: Trying to open a file that does not exist.  
   - **Purpose**: To illustrate the specific subclass of `IOException` for missing files.
3. **`EOFException`**  

   - **Scenario**: Reading past the end of a file.  
   - **Purpose**: To illustrate how to handle the end-of-file condition when reading data.
4. **`SQLException`**

- **Scenario**: Connecting to a non-existent database.  
   - **Purpose**: Highlights how to handle errors related to database access.
5. **`ClassNotFoundException`**  

   - **Scenario**: Attempting to load a class that is not in the classpath.  
   - **Purpose**: Demonstrates proper handling of missing class definitions.
---

### **Unchecked Exceptions**

Unchecked exceptions are exceptions that a well-written application should anticipate and recover from. These are checked only at runtime. Examples include the following: 1. **`ArithmeticException`**  

   - **Scenario**: Dividing a number by zero. 
   - **Purpose**: Handles arithmetic errors like division by zero.
2. **`NullPointerException`** 

   - **Scenario**: Accessing methods or properties on a `null` object reference.
- **Purpose**: Ensures robust code by catching null reference errors.
3. **`ArrayIndexOutOfBoundsException`** 

   - **Scenario**: Accessing an invalid index in an array. 
   - **Purpose**: Avoids crashes caused by invalid array access.
4. **`ClassCastException`** 

   - **Scenario**: Casting an object to an incompatible type. 
   - **Purpose**: Demonstrates handling of invalid typecasting.
5. **`IllegalArgumentException`**

- **Scenario**: Passing invalid arguments to a method.  
   - **Purpose**: Ensures proper validation of method parameters.
6. **`NumberFormatException`**  

   - **Scenario**: Parsing an invalid string into a number.  
   - **Purpose**: Prevents crashes during invalid number conversion.

---

## **Detailed Explanation of Exception Handling**

1. **Throwing the Exception**
Each program has code that is intended to throw an exception. For example, in the ArithmeticException, the program divides a number by zero to create an ArithmeticException. 

2. **Catch the Exception** 
The program uses try-catch blocks to handle the exceptions and allow the program to continue without crashing.

3. **Log and Recover**
- Error messages are printed to the console to inform the user. 
   - Where applicable, fallback mechanisms or alternative flows can be implemented.
---
 
## **Best Practices for Exception Handling**

1. Handle exceptions to ensure that your programs don't crash.

2. Log error messages for debugging and user feedback.

3. Avoid using generic `Exception` in `catch` blocks; catch specific exceptions where possible.
4. Use `finally` blocks for cleanup operations if required (e.g., closing files or database connections).
5. Validate input data to prevent exceptions like `IllegalArgumentException` and `NumberFormatException`.
---


### **Checked Exceptions**

1. **IOException**  
**Scenario**: Attempting to read from a non-existent file.  
```java
import java.io.*;

public class IOException {
    public static void main(String[] args) {
        try {
            // Attempt to create a BufferedReader to read a file that doesn't exist
            BufferedReader reader = new BufferedReader(new FileReader("nonexistent.txt"));
        } catch (IOException e) {
            // IOException is caught when there is an input/output error, such as file not found
            System.out.println("IOException caught: " + e.getMessage());
            // Log the error message and handle it gracefully without crashing the program
        }
    }
}
```

---

2. **FileNotFoundException**  
**Scenario**: Trying to open a file that doesn’t exist.  
```java
import java.io.*;

public class FileNotFoundException {
    public static void main(String[] args) {
        try {
            // Attempt to open a file that is not available
            FileInputStream file = new FileInputStream("missingfile.txt");
        } catch (FileNotFoundException e) {
            // FileNotFoundException is a subclass of IOException and occurs when the file is missing
            System.out.println("FileNotFoundException caught: " + e.getMessage());
            // Inform the user about the missing file and proceed with the program
        }
    }
}
```

---

3. **EOFException**  
**Scenario**: Attempting to read beyond the file’s content.  
```java
import java.io.*;

public class EOFException {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("testfile.txt"))) {
            while (true) {
                // Continuously read UTF strings from the file
                dis.readUTF(); // Will throw EOFException when end of file is reached
            }
        } catch (EOFException e) {
            // EOFException occurs when trying to read past the end of a file
            System.out.println("EOFException caught: Reached end of file.");
        } catch (IOException e) {
            // Catch other IO-related exceptions that may occur
            System.out.println("IOException caught: " + e.getMessage());
        }
    }
}
```

---

4. **SQLException**  
**Scenario**: Attempting to connect to a non-existent database.  
```java
import java.sql.*;

public class SQLException {
    public static void main(String[] args) {
        try {
            // Try to establish a connection to a database that doesn't exist
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentDB", "user", "password");
        } catch (SQLException e) {
            // SQLException is thrown for database access errors
            System.out.println("SQLException caught: " + e.getMessage());
            // Log the database connection issue and notify the user
        }
    }
}
```

---

5. **ClassNotFoundException**  
**Scenario**: Trying to load a class that does not exist.  
```java
public class ClassNotFoundException {
    public static void main(String[] args) {
        try {
            // Attempt to load a class that is not available in the classpath
            Class.forName("com.unknown.ClassName");
        } catch (ClassNotFoundException e) {
            // ClassNotFoundException is thrown when the specified class cannot be found
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
            // Handle the error gracefully to avoid program termination
        }
    }
}
```

---

### **Unchecked Exceptions**

6. **ArithmeticException**  
**Scenario**: Dividing by zero.  
```java
public class ArithmeticException {
    public static void main(String[] args) {
        try {
            // Perform a division by zero operation
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // ArithmeticException is thrown for invalid arithmetic operations
            System.out.println("ArithmeticException caught: Division by zero is not allowed.");
            // Handle the error to prevent program termination
        }
    }
}
```

---

7. **NullPointerException**  
**Scenario**: Accessing a null reference.  
```java
public class NullPointerException {
    public static void main(String[] args) {
        try {
            // Attempt to access a method on a null object
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            // NullPointerException occurs when trying to use a null object reference
            System.out.println("NullPointerException caught: " + e.getMessage());
            // Provide feedback and ensure program stability
        }
    }
}
```

---

8. **ArrayIndexOutOfBoundsException**  
**Scenario**: Accessing an invalid array index.  
```java
public class ArrayIndexOutOfBoundsException {
    public static void main(String[] args) {
        try {
            // Create an array with three elements
            int[] array = {1, 2, 3};
            // Attempt to access an index outside the valid range
            System.out.println(array[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // ArrayIndexOutOfBoundsException is thrown for invalid array indices
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
            // Prevent program crash by handling the error
        }
    }
}
```

---

9. **ClassCastException**  
**Scenario**: Demonstrating an invalid type cast.  
```java
public class ClassCastException {
    public static void main(String[] args) {
        try {
            // Create an object of Integer type
            Object obj = new Integer(10);
            // Attempt an invalid cast to String type
            String str = (String) obj;
        } catch (ClassCastException e) {
            // ClassCastException is thrown when trying to cast an object to an incompatible type
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }
}
```

---

10. **IllegalArgumentException**  
**Scenario**: Passing an invalid argument to a method.  
```java
public class IllegalArgumentException {
    public static void main(String[] args) {
        try {
            // Attempt to set an invalid thread priority (valid range is 1-10)
            Thread t = new Thread();
            t.setPriority(11); // Invalid priority
        } catch (IllegalArgumentException e) {
            // IllegalArgumentException is thrown for invalid method arguments
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }
}
```

---

11. **NumberFormatException**  
**Scenario**: Attempting to convert an invalid string to a number.  
```java
public class NumberFormatException {
    public static void main(String[] args) {
        try {
            // Attempt to parse a string that is not a valid number
            int num = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            // NumberFormatException occurs when parsing a non-numeric string
            System.out.println("NumberFormatException caught: " + e.getMessage());
            // Ensure the program continues to execute
        }
    }
}
```

---

