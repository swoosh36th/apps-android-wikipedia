package org.wikipedia.homeworks.homework04

import org.wikipedia.homeworks.homework04.Days.FRIDAY
import org.wikipedia.homeworks.homework04.Days.MONDAY
import org.wikipedia.homeworks.homework04.Days.SATURDAY
import org.wikipedia.homeworks.homework04.Days.SUNDAY
import org.wikipedia.homeworks.homework04.Days.THURSDAY
import org.wikipedia.homeworks.homework04.Days.TUESDAY
import org.wikipedia.homeworks.homework04.Days.WEDNESDAY
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class ScheduleEntity(val lesson: String, val startTime: LocalTime, val endTime: LocalTime)

enum class Days {
  MONDAY,
  TUESDAY,
  WEDNESDAY,
  THURSDAY,
  FRIDAY,
  SATURDAY,
  SUNDAY
}

class Schedule {
  private val scheduleOfWeek = mutableMapOf<Days, MutableList<ScheduleEntity>>()
  private val timeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm")
  private var presentDay: Days? = null

  override fun toString(): String {
    return scheduleOfWeek.toSortedMap()
      .map { (day, list) ->
        list.sortedBy { it.startTime }
          .joinToString("\n") {
            "%-15s${it.startTime.format(timeFormatter)} - ${
              it.endTime.format(
                timeFormatter
              )
            }".format("\t${it.lesson}:")
          }.let {
            "${day.name.lowercase().replaceFirstChar { day.name[0].uppercase() }}:\n$it"
          }
      }.joinToString("\n\n")
  }

  fun addSchedule(day: Days, scheduleEntity: ScheduleEntity) {
    scheduleOfWeek.getOrPut(day) { mutableListOf() }.add(scheduleEntity)
  }

  private fun addSchedule(day: Days, lesson: String, startTime: LocalTime, endTime: LocalTime) {
    ScheduleEntity(lesson, startTime, endTime).also { scheduleEntity ->
      addSchedule(day, scheduleEntity)
    }
  }

  operator fun invoke(function: Schedule.() -> Unit) = function()

  fun monday(setSchedule: () -> Unit) = setScheduleForPresentDay(MONDAY, setSchedule)

  fun tuesday(setSchedule: () -> Unit) = setScheduleForPresentDay(TUESDAY, setSchedule)

  fun wednesday(setSchedule: () -> Unit) = setScheduleForPresentDay(WEDNESDAY, setSchedule)

  fun thursday(setSchedule: () -> Unit) = setScheduleForPresentDay(THURSDAY, setSchedule)

  fun friday(setSchedule: () -> Unit) = setScheduleForPresentDay(FRIDAY, setSchedule)

  fun saturday(setSchedule: () -> Unit) = setScheduleForPresentDay(SATURDAY, setSchedule)

  fun sunday(setSchedule: () -> Unit) = setScheduleForPresentDay(SUNDAY, setSchedule)

  private fun setScheduleForPresentDay(presentDay: Days, setSchedule: () -> Unit) {
    this.presentDay = presentDay
    setSchedule()
    this.presentDay = null
  }

  operator fun String.rangeTo(endTime: String): Pair<LocalTime, LocalTime> {
    val timePeriod: Pair<String, String> = this to endTime
    return timePeriod.hasRequiredTimeFormat().toLocalTime()
  }

  infix fun Pair<LocalTime, LocalTime>.schedule(lesson: String) {
    presentDay?.let { presentDay -> addSchedule(presentDay, lesson, first, second) }
      ?: error("Current day doesn't set")
  }

  private fun Pair<String, String>.hasRequiredTimeFormat(): Pair<String, String> {
    val timePattern = Regex("""\d{2}:\d{2}""")
    check(first.matches(timePattern).and(second.matches(timePattern))) {
      "Time period doesn't have required time format"
    }
    return this
  }

  private fun Pair<String, String>.toLocalTime(): Pair<LocalTime, LocalTime> {
    val startTime: LocalTime = LocalTime.parse(first)
    val endTime: LocalTime = LocalTime.parse(second)
    check(startTime < endTime) {
      "Start time [$startTime] should be before end time [$endTime]"
    }
    return startTime to endTime
  }
}

fun main() {

  val schedule = Schedule()

  schedule.addSchedule(
    MONDAY,
    ScheduleEntity("Biology", LocalTime.of(10, 30), LocalTime.of(11, 10))
  )
  schedule.addSchedule(
    MONDAY,
    ScheduleEntity("Chemistry", LocalTime.of(11, 15), LocalTime.of(11, 55))
  )

  schedule {

    monday {
      "10:30".."11:10" schedule "Biology"
      "11:15".."11:55" schedule "Chemistry"
      "09:00".."09:40" schedule "Mathematics"
      "09:45".."10:25" schedule "History"
    }

    tuesday {
      "09:00".."09:40" schedule "English"
      "09:45".."10:25" schedule "Geography"
      "11:15".."11:55" schedule "Art"
      "10:30".."11:10" schedule "Physics"
    }

    wednesday {
      "11:15".."11:55" schedule "Biology"
      "09:00".."09:40" schedule "Literature"
      "10:30".."11:10" schedule "History"
      "09:45".."10:25" schedule "Mathematics"
    }

    thursday {
      "11:15".."11:55" schedule "Physics"
      "10:30".."11:10" schedule "Geography"
      "09:00".."09:40" schedule "Chemistry"
      "09:45".."10:25" schedule "English"
    }

    friday {
      "09:45".."10:25" schedule "Literature"
      "11:15".."11:55" schedule "History"
      "09:00".."09:40" schedule "Art"
      "10:30".."11:10" schedule "Mathematics"
    }
  }

  println(schedule.toString())
}