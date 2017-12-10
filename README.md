# java-exercises

1) Deadlock
Found one Java-level deadlock:
=============================
"Thread-1":
  waiting to lock monitor 0x00007ffe8c82b2a8 (object 0x000000076ada7fb0, a java.lang.Object),
  which is held by "Thread-0"
"Thread-0":
  waiting to lock monitor 0x00007ffe8e811e08 (object 0x000000076ada7fc0, a java.lang.Object),
  which is held by "Thread-1"

Java stack information for the threads listed above:
===================================================
"Thread-1":
	at concurrency.deadlock.DeadLockSimulator.third(DeadLockSimulator.java:24)
	- waiting to lock <0x000000076ada7fb0> (a java.lang.Object)
	at concurrency.deadlock.DeadLockSimulator.second(DeadLockSimulator.java:18)
	- locked <0x000000076ada7fc0> (a java.lang.Object)
	at concurrency.deadlock.App.lambda$main$1(App.java:10)
	at concurrency.deadlock.App$$Lambda$2/2129789493.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:745)
"Thread-0":
	at concurrency.deadlock.DeadLockSimulator.second(DeadLockSimulator.java:17)
	- waiting to lock <0x000000076ada7fc0> (a java.lang.Object)
	at concurrency.deadlock.DeadLockSimulator.first(DeadLockSimulator.java:11)
	- locked <0x000000076ada7fb0> (a java.lang.Object)
	at concurrency.deadlock.App.lambda$main$0(App.java:9)
	at concurrency.deadlock.App$$Lambda$1/764977973.run(Unknown Source)
	at java.lang.Thread.run(Thread.java:745)

Found 1 deadlock.
