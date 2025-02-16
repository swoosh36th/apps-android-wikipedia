package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.anyOf
import org.hamcrest.TypeSafeMatcher
import org.wikipedia.homeworks.homework06.Colour.BLACK
import org.wikipedia.homeworks.homework06.Colour.BLUE
import org.wikipedia.homeworks.homework06.Colour.GREEN
import org.wikipedia.homeworks.homework06.Colour.RED
import org.wikipedia.homeworks.homework06.Colour.WHITE
import org.wikipedia.homeworks.homework06.Colour.YELLOW
import kotlin.Int.Companion.MAX_VALUE


enum class Colour {
  RED, BLUE, GREEN, YELLOW, BLACK, WHITE
}

data class Shape(val sideLength: Float, val sideNumber: Int, val colour: Colour)

class SideLengthInRangeMatcher(private val minLength: Float, private val maxLength: Float) :
  TypeSafeMatcher<Shape>() {
  override fun describeTo(description: Description) {
    description.appendText("Side length of shape should be between [$minLength] and [$maxLength]")
  }

  override fun matchesSafely(figure: Shape): Boolean {
    return figure.sideLength in minLength..maxLength
  }
}

class AngleNumberMatcher : TypeSafeMatcher<Shape>() {
  override fun describeTo(description: Description) {
    description.appendText("Angle number of shape should be correct")
  }

  override fun matchesSafely(figure: Shape): Boolean {
    return when {
      figure.sideNumber in 1..2 -> calculateAngleNumber(figure) == 0
      else -> calculateAngleNumber(figure) == figure.sideNumber
    }
  }

  private fun calculateAngleNumber(figure: Shape): Int {
    return when (val sideNumber = figure.sideNumber) {
      in 3..MAX_VALUE -> sideNumber
      else -> 0
    }
  }
}

class EvenSideNumberMatcher : TypeSafeMatcher<Shape>() {
  override fun describeTo(description: Description) {
    description.appendText("Side number of shape should be even")
  }

  override fun matchesSafely(figure: Shape): Boolean {
    return figure.sideNumber % 2 == 0
  }
}

class ColourFigureMatcher(private val colour: Colour) : TypeSafeMatcher<Shape>() {
  override fun describeTo(description: Description) {
    description.appendText("Colour of shape should be [$colour]")
  }

  override fun matchesSafely(figure: Shape): Boolean {
    return figure.colour == colour
  }
}

class NegativeSideLengthMatcher : TypeSafeMatcher<Shape>() {
  override fun describeTo(description: Description) {
    description.appendText("Side length of shape should be positive")
  }

  override fun matchesSafely(figure: Shape): Boolean {
    return figure.sideLength > 0
  }
}

class NegativeSideNumberMatcher : TypeSafeMatcher<Shape>() {
  override fun describeTo(description: Description) {
    description.appendText("Side number of shape should be positive")
  }

  override fun matchesSafely(figure: Shape): Boolean {
    return figure.sideNumber > 0
  }
}

class MatcherBuilder {
  private val matcherList: MutableList<Matcher<Shape>> = mutableListOf()

  operator fun invoke(function: MatcherBuilder.() -> Unit) = function()

  fun sideLengthInRange(minLength: Float, maxLength: Float) =
    matcherList.add(SideLengthInRangeMatcher(minLength, maxLength))

  fun angleNumber() = matcherList.add(AngleNumberMatcher())

  fun evenSideNumber() = matcherList.add(EvenSideNumberMatcher())

  fun colourFigure(colour: Colour) = matcherList.add(ColourFigureMatcher(colour))

  fun negativeSideLength() = matcherList.add(NegativeSideLengthMatcher())

  fun negativeSideNumber() = matcherList.add(NegativeSideNumberMatcher())

  fun getMatcherList(): Matcher<Shape> = anyOf(matcherList)
}

fun main() {
  val shapes = listOf(
    Shape(10f, 3, RED),
    Shape(5f, 4, BLUE),
    Shape(7f, 2, GREEN),
    Shape(0.5f, 1, YELLOW),
    Shape(-3f, 5, BLACK),
    Shape(8f, -2, WHITE),
    Shape(12f, 6, RED),
    Shape(15f, 8, BLUE),
    Shape(20f, 4, GREEN),
    Shape(9f, 5, YELLOW),
    Shape(2f, 3, BLACK),
    Shape(11f, 7, WHITE),
    Shape(6f, 10, RED),
    Shape(3f, 2, BLUE),
    Shape(4f, 1, GREEN),
    Shape(25f, 12, YELLOW),
    Shape(30f, 14, BLACK),
    Shape(35f, 16, WHITE),
    Shape(40f, 18, RED),
    Shape(50f, 20, BLUE)
  )
  val matchersBuilder = MatcherBuilder()

  matchersBuilder {
    sideLengthInRange(minLength = 4f, maxLength = 12f)
    angleNumber()
    evenSideNumber()
    colourFigure(colour = BLACK)
    negativeSideLength()
    negativeSideNumber()
  }

  val result = shapes.filter { matchersBuilder.getMatcherList().matches(it) }

  println(result)

  assertThat("Quality of shape", Shape(-3f, 5, BLUE), matchersBuilder.getMatcherList())
}