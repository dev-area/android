package com.example.cpptest;

import java.nio.ByteBuffer;

import android.util.Log;

public class FibLib {
    private static final String TAG = "FibLib";

    public static void printToLog(long val)
    {
    	Log.d("tag", "fib res:"+val);
    }
    
    private static long fib(long n) {
        return n <= 0 ? 0 : n == 1 ? 1 : fib(n - 1) + fib(n - 2);
    }

    // Recursive Java implementation of the Fibonacci algorithm 
    // (included for comparison only)
    public static long fibJR(long n) {
        Log.d(TAG, "fibJR(" + n + ")");
        return fib(n);
    }

    // Function prototype for future native recursive implementation 
    // of the Fibonacci algorithm
    public static native long fibNR(long n);
    public static native ByteBuffer getBuf();
    public native static long fibNI(long n);

    // Iterative Java implementation of the Fibonacci algorithm 
    // (included for comparison only)
    public static long fibJI(long n) {
        Log.d(TAG, "fibJI(" + n + ")");
        long previous = -1;
        long result = 1;
        for (long i = 0; i <= n; i++) {
            long sum = result + previous;
            previous = result;
            result = sum;
        }
        return result;
    }

    // Function prototype for future iterative recursive implementation 
    // of the Fibonacci algorithm

    static {
        // as defined by LOCAL_MODULE in Android.mk
        System.loadLibrary("cpptest");
    }
}
