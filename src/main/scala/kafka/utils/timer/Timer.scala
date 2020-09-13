package kafka.utils.timer

trait Timer {
  /**
   * Add a new task to this executor. It will be executed after the task's delay
   * (beginning from the time of submission)
   *
   * @param timerTask the task to add
   */
  def add(timerTask: TimerTask): Unit

  /**
   * Advance the internal clock, executing any tasks whose expiration has been
   * reached within the duration of the passed timeout.
   *
   * @param timeoutMs
   * @return whether or not any tasks were executed
   */
  def advanceClock(timeoutMs: Long): Boolean

  /**
   * Get the number of tasks pending execution
   *
   * @return the number of tasks
   */
  def size: Int

  /**
   * Shutdown the timer service, leaving pending tasks unexecuted
   */
  def shutdown(): Unit
}
