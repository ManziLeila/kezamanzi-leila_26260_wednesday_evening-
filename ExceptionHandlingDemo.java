import java.io.*;
import java.sql.*;

public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        // Demonstrating various exceptions
        try {
            simulateIOException();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }

        try {
            simulateFileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }

        try {
            simulateEOFException();
        } catch (EOFException e) {
            System.out.println("EOFException caught: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }

        try {
            simulateSQLException();
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }

        try {
            simulateClassNotFoundException();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }

        try {
            simulateArithmeticException();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }

        try {
            simulateNullPointerException();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }

        try {
            simulateArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }

        try {
            simulateClassCastException();
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }

        try {
            simulateIllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }

        try {
            simulateNumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }

    // 1. Simulate IOException
    private static void simulateIOException() throws IOException {
        throw new IOException("Simulated IOException");
    }

    // 2. Simulate FileNotFoundException
    private static void simulateFileNotFoundException() throws FileNotFoundException {
        throw new FileNotFoundException("Simulated FileNotFoundException");
    }

    // 3. Simulate EOFException
    private static void simulateEOFException() throws EOFException {
        throw new EOFException("Simulated EOFException");
    }

    // 4. Simulate SQLException
    private static void simulateSQLException() throws SQLException {
        throw new SQLException("Simulated SQLException");
    }

    // 5. Simulate ClassNotFoundException
    private static void simulateClassNotFoundException() throws ClassNotFoundException {
        throw new ClassNotFoundException("Simulated ClassNotFoundException");
    }

    // 6. Simulate ArithmeticException
    private static void simulateArithmeticException() {
        int result = 10 / 0; // This will cause ArithmeticException
    }

    // 7. Simulate NullPointerException
    private static void simulateNullPointerException() {
        String str = null;
        str.length(); // This will cause NullPointerException
    }

    // 8. Simulate ArrayIndexOutOfBoundsException
    private static void simulateArrayIndexOutOfBoundsException() {
        int[] arr = new int[5];
        int value = arr[10]; // This will cause ArrayIndexOutOfBoundsException
    }

    // 9. Simulate ClassCastException
    private static void simulateClassCastException() {
        Object obj = new Integer(0);
        String str = (String) obj; // This will cause ClassCastException
    }

    // 10. Simulate IllegalArgumentException
    private static void simulateIllegalArgumentException() {
        throw new IllegalArgumentException("Simulated IllegalArgumentException");
    }

    // 11. Simulate NumberFormatException
    private static void simulateNumberFormatException() {
        int num = Integer.parseInt("NotANumber"); // This will cause NumberFormatException
    }
}