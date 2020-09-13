package kafaka.utils.timer

import java.util.concurrent.ThreadLocalRandom

import kafka.utils.timer.{SystemTimer, TimerTask}

object TestMain {

  def main(args: Array[String]): Unit = {
    val systemTimer = new SystemTimer("great timer");

    while (true) {
      systemTimer.add(new TimerTask {
        override val delayMs: Long = ThreadLocalRandom.current().nextLong(1000)

        override def run(): Unit = println(" executing " + System.currentTimeMillis())
      })

      systemTimer.advanceClock(200)
    }
  }
}
