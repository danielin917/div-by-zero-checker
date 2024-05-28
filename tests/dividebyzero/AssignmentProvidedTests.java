import org.checkerframework.checker.dividebyzero.qual.*;

// A simple test case for your divide-by-zero checker.
// The file contains "// ::" comments to indicate expected
// errors and warnings.
//
// Passing this test does not guarantee a perfect grade on this assignment,
// but it is an important start. You should always write your own test cases,
// in addition to using those provided to you.
class AssignmentProvidedTests {

  public static void f() {
    int one = 1;
    int zero = 0;
    // :: error: divide.by.zero
    int x = one / zero;
    int y = zero / one;
    // :: error: divide.by.zero
    int z = x / y;
    String s = "hello";
  }

  public static void g(int y) {
    if (y == 0) {
      // :: error: divide.by.zero
      int x = 1 / y;
    } else {
      int x = 1 / y;
    }

    if (y != 0) {
      int x = 1 / y;
    } else {
      // :: error: divide.by.zero
      int x = 1 / y;
    }

    if (!(y == 0)) {
      int x = 1 / y;
    } else {
      // :: error: divide.by.zero
      int x = 1 / y;
    }

    if (!(y != 0)) {
      // :: error: divide.by.zero
      int x = 1 / y;
    } else {
      int x = 1 / y;
    }

    if (y < 0) {
      int x = 1 / y;
    }

    if (y <= 0) {
      // :: error: divide.by.zero
      int x = 1 / y;
    }

    if (y > 0) {
      int x = 1 / y;
    }

    if (y >= 0) {
      // :: error: divide.by.zero
      int x = 1 / y;
    }
  }

  public static void h() {
    int zero_the_hard_way = 0 + 0 - 0 * 0;
    // :: error: divide.by.zero
    int x = 1 / zero_the_hard_way;

    int one_the_hard_way = 0 * 1 + 1;
    int y = 1 / one_the_hard_way;
  }

  public static void l() {
    // :: error: divide.by.zero
    int a = 1 / (1 - 1);
    int y = 1;
    // :: error: divide.by.zero
    int x = 1 / (y - y);
    int z = y - y;
    // :: error: divide.by.zero
    int k = 1 / z;
  }

  public static void myTests() {
    int a = -1;
    int b = 1;

    // c is top().
    int c = a+b;
    if (c != 0) {
      // Nonzero all should pass.
      int yy = 0;
      yy  = a / c;
      yy  = b / c;
      yy  = c / c;
      yy  = a / b;
      yy  = a / a;
      yy  = b / b;
      yy  = b / a;
      yy  = a % c;
      yy  = b % c;
      yy  = c % c;
      yy  = a % b;
      yy  = a % a;
      yy  = b % b;
      yy  = b % a;
    }

    // :: error: divide.by.zero
    int x = a/c;

    if ( c < 0) {
      // Nonzero all should pass.
      int yy  = 0;
      yy  = a / c;
      yy  = b / c;
      yy  = c / c;
      yy  = a / b;
      yy  = a / a;
      yy  = b / b;
      yy  = b / a;
      yy  = a % c;
      yy  = b % c;
      yy  = c % c;
      yy  = a % b;
      yy  = a % a;
      yy  = b % b;
      yy  = b % a;
    }

    if ( c <= a) {
      // Nonzero all should pass.
      int yy  = 0;
      yy  = a / c;
      yy  = b / c;
      yy  = c / c;
      yy  = a / b;
      yy  = a / a;
      yy  = b / b;
      yy  = b / a;
      yy  = a % c;
      yy  = b % c;
      yy  = c % c;
      yy  = a % b;
      yy  = a % a;
      yy  = b % b;
      yy  = b % a;
    }

    if ( c > 0) {
      // Nonzero all should pass.
      int yy  = 0;
      yy  = a / c;
      yy  = b / c;
      yy  = c / c;
      yy  = a / b;
      yy  = a / a;
      yy  = b / b;
      yy  = b / a;
      yy  = a % c;
      yy  = b % c;
      yy  = c % c;
      yy  = a % b;
      yy  = a % a;
      yy  = b % b;
      yy  = b % a;
    }

    if ( c >= b) {
      // Nonzero all should pass.
      int yy  = 0;
      c  = a / c;
      c  = b / c;
      c  = c / c;
      c  = a / b;
      c  = a / a;
      c  = b / b;
      c  = b / a;
      c  = a % c;
      c  = b % c;
      c  = c % c;
      c  = a % b;
      c  = a % a;
      c  = b % b;
      c  = b % a;
    }

    if (c >= 0) {

      if (c > 0) {
        // We good.
        int r = a/c;
      }

      if (c <= 0) {
        // C must be zero.
        // :: error: divide.by.zero
        int r = a/c;

        // :: error: divide.by.zero
        r = b/c;
      }
    }

    int f = -5;
    int y = 0;
    f = y*f;


    // :: error: divide.by.zero
    c = c/f;

    // Adding to zero is great.
    int q = b + f;
    c = c/b;
    c = c%b;

    int gg = -5;
    int zz = y + gg;
    c = c%zz;
  }

  public static void myTests2() {
    int a = -1;
    int b = 1;

    // c is top().
    int c = a+b;
    if (c != 0) {
      // c is safe now.
      c = c*-1;

      // Still safe.
      int tt = a / c;
      if (c < 0) {
        // Still safe.
        tt = a / c;

        int x = a + c;
        // x is negative.

        a = a / x;

        // Now a is positive.
        int r = 5 / (a * 5);
        int rr = 5 / (a + 5);

        // Now top.
        int z = a + -5;

        // :: error: divide.by.zero
        c = c/ z;
      }
    }
  }
}
