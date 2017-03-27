/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.os;

import static libcore.io.OsConstants.S_IRWXG;
import static libcore.io.OsConstants.S_IRWXO;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.LocalServerSocket;
import android.opengl.EGL14;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.os.SystemProperties;
import android.os.Trace;
import android.util.EventLog;
import android.util.Log;

import dalvik.system.VMRuntime;
import dalvik.system.Zygote;

import libcore.io.IoUtils;
import libcore.io.Libcore;
import libcore.io.OsConstants;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import android.app.*;
import android.content.*;
import android.os.*;

public class TestJava {


    public static void main(String argv[]) {
	    IActivityManager am = ActivityManagerNative.getDefault();
            Log.i("tag", "test java code");
      // You can create intent
      // Intent in = new Intent("name");
	    // and use the ActivityManager to start service, activity, broadcast ...
}
