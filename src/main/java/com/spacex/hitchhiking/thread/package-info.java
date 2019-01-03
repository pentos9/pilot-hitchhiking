package com.spacex.hitchhiking.thread;

/*
*
* Deadlock:
*
* All threads are blocked, the program hangs forever.
*
* Livelock:
*
* No threads blocked but they run into infinite loops.
* The program is still running but unable to make further progress.
*
* Starvation:
*
* Only one thread is running, and other threads are waiting forever.
*
* */